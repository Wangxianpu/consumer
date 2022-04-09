package com.wxp.mix.dto;

/**
 * @description: 分页相关参数
 * @author: wxp
 * @time: 2022/4/2 14:19
 */
public class PageParam {
    /**
     * 分页-每页大小
     */
    private int pageSize = 20;
    /**
     * 分页-当前页码
     */
    private int pageNum = 0;
    /**
     * 当前数据下标
     */
    private int curIndex = 0;
    /**
     * 分页-总数量
     */
    private int totalSize;

    public PageParam(){
    }

    public PageParam(int pageSize,int pageNum){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.curIndex = pageNum*pageSize;
    }

    public PageParam(int pageNum){
        this.pageNum = pageNum;
        this.curIndex = pageNum*pageSize;
    }

    public int getCurIndex() {
        return curIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        this.curIndex = this.pageNum*pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }
}
