package com.szw.ddshop.pojo.vo;

import com.szw.ddshop.pojo.po.TbItem;

/**
 * User: Frogzec
 * Date: 2017/11/7
 * Time: 17:28
 * Version:V1.0
 */
public class TbItemCustom extends TbItem {

    private String catName;

    private String statusName;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
