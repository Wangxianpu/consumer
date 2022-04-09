package com.wxp.mix.dto;

import java.math.BigDecimal;

/**
 * @description: 银行账户DTO
 * @author: wxp
 * @time: 2022/3/17 12:17
 */
public class BankAccountDto extends BaseDto {
    /**
     * 银行账户
     */
    private String bankAccNo;
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 金额
     */
    private BigDecimal amount;

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
