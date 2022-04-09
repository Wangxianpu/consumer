package com.wxp.mix.dto;

import java.util.Date;

/**
 * @description: 基类dto
 * @author: wxp
 * @time: 2022/3/17 12:19
 */
public class BaseDto extends PageParam {
    private Date createDate;
    private String createdBy;
    private Date updateDate;
    private String updatedBy;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
