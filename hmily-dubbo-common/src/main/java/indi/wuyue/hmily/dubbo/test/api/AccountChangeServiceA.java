package indi.wuyue.hmily.dubbo.test.api;

import org.dromara.hmily.annotation.Hmily;

public interface AccountChangeServiceA {

    @Hmily
    void accountChange(AccountChangeDTO transferDTO);

}
