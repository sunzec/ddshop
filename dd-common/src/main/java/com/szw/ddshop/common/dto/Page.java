package com.szw.ddshop.common.dto;

/**
 * User: Frogzec
 * Date: 2017/11/7
 * Desp:分页类
 * Time: 14:05
 * Version:V1.0
 */
public class Page {

     //当前页
    private int page;
    //每一页的记录数
    private int rows;
//    private int offset;

    public int getOffset() {
        return (page - 1) * rows;
    }

    public int getPage() {
        return page;

    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
