package indi.wuyue.hmily.dubbo.test.api.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {

    @Update("UPDATE xx_hmily_account SET freeze = freeze + #{feeAmount} WHERE id = #{accountId}")
    void updateTryTransfer(@Param("accountId") Long accountId, @Param("feeAmount") Long feeAmount);

    @Update("UPDATE xx_hmily_account SET balance = balance + #{feeAmount}, freeze = freeze - #{feeAmount} WHERE id = #{accountId}")
    void updateConfirmTransfer(@Param("accountId") Long accountId, @Param("feeAmount") Long feeAmount);

    @Update("UPDATE xx_hmily_account SET freeze = freeze - #{feeAmount} WHERE id = #{accountId}")
    void updateCancelTransfer(@Param("accountId") Long accountId, @Param("feeAmount") Long feeAmount);

}
