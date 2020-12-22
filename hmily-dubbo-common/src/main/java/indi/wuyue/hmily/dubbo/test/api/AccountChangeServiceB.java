package indi.wuyue.hmily.dubbo.test.api;

import org.dromara.hmily.annotation.Hmily;

public interface AccountChangeServiceB {

    @Hmily
    void accountChange(AccountChangeDTO transferDTO);

}
