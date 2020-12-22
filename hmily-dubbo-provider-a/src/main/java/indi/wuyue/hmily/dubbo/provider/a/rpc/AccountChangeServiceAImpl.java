package indi.wuyue.hmily.dubbo.provider.a.rpc;

import com.alibaba.fastjson.JSON;
import indi.wuyue.hmily.dubbo.test.api.AccountChangeDTO;
import indi.wuyue.hmily.dubbo.test.api.AccountChangeServiceA;
import indi.wuyue.hmily.dubbo.test.api.mapper.AccountMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@DubboService(version = "1.0.0", retries = 0, loadbalance = "hmilyConsistentHash")
public class AccountChangeServiceAImpl implements AccountChangeServiceA {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountChangeServiceAImpl.class);

    @Resource
    private AccountMapper accountMapper;

    @HmilyTCC(confirmMethod = "accountChangeConfirm", cancelMethod = "accountChangeCancel")
    @Override
    public void accountChange(AccountChangeDTO transferDTO) {
        LOGGER.info("=====transfer try: {}", JSON.toJSONString(transferDTO));
        accountMapper.updateTryTransfer(transferDTO.getAccountId(), transferDTO.getFeeAmount());
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
