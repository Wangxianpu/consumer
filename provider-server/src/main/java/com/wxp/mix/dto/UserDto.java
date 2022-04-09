package com.wxp.mix.dto;

/**
 * 用户dto
 */
public class UserDto extends BaseDto {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 年龄
     */
    private int age;
    /**
     * 银行卡账号
     */
    private String bankAccNo;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }
}
