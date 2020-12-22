package indi.wuyue.hmily.dubbo.provider.b.rpc;

import com.alibaba.fastjson.JSON;
import indi.wuyue.hmily.dubbo.test.api.AccountChangeDTO;
import indi.wuyue.hmily.dubbo.test.api.AccountChangeServiceB;
import indi.wuyue.hmily.dubbo.test.api.mapper.AccountMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicBoolean;

@DubboService(version = "1.0.0", retries = 0, loadbalance = "hmilyConsistentHash")
public class AccountChangeServiceBImpl implements AccountChangeServiceB {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountChangeServiceBImpl.class);

    @Resource
    private AccountMapper accountMapper;

    private AtomicBoolean randomException = new AtomicBoolean(false);

    @HmilyTCC(confirmMethod = "accountChangeConfirm", cancelMethod = "accountChangeCancel")
    @Transactional
    @Override
    public void accountChange(AccountChangeDTO transferDTO) {
        LOGGER.info("=====transfer try: {}", JSON.toJSONString(transferDTO));
        accountMapper.updateTryTransfer(transferDTO.getAccountId(), transferDTO.getFeeAmount());
        boolean isExcep = randomException.get();
        randomException.compareAndSet(isExcep, !isExcep);
        if (isExcep) {
            throw new RuntimeException("test exception");
        }
    }

    public void accountChangeConfirm(AccountChangeDTO transferDTO) {
        LOGGER.info("=====transfer confirm: {}", JSON.toJSONString(transferDTO));
        accountMapper.updateConfirmTransfer(transferDTO.getAccountId(), transferDTO.getFeeAmount());
    }

    public void accountChangeCancel(AccountChangeDTO transferDTO) {
        LOGGER.info("=====transfer cancel: {}", JSON.toJSONString(transferDTO));
        accountMapper.updateCancelTransfer(transferDTO.getAccountId(), transferDTO.getFeeAmount());
    }

}
