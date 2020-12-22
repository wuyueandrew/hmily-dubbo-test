package indi.wuyue.hmily.dubbo.test.app.controller;

import indi.wuyue.hmily.dubbo.test.api.AccountChangeDTO;
import indi.wuyue.hmily.dubbo.test.api.AccountChangeServiceA;
import indi.wuyue.hmily.dubbo.test.api.AccountChangeServiceB;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class TestController {

    @DubboReference(version = "1.0.0")
    private AccountChangeServiceA accountChangeServiceA;

    @DubboReference(version = "1.0.0")
    private AccountChangeServiceB accountChangeServiceB;

    @HmilyTCC
    @GetMapping(value = "/transfer")
    public String transfer() {
        AccountChangeDTO accountChangeA = new AccountChangeDTO();
        accountChangeA.setAccountId(1L);
        accountChangeA.setFeeAmount(-123L);
        AccountChangeDTO accountChangeB = new AccountChangeDTO();
        accountChangeB.setAccountId(2L);
        accountChangeB.setFeeAmount(123L);
        accountChangeServiceA.accountChange(accountChangeA);
        accountChangeServiceB.accountChange(accountChangeB);
        return "success";
    }

}
