package indi.wuyue.hmily.dubbo.test.api;

import java.io.Serializable;

public class AccountChangeDTO implements Serializable {

    private Long accountId;

    private Long feeAmount;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

}
