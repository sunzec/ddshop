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
    private String createdDateString;
    private String updatedDateString;
    //创建单位为元的price对象属性changedPrice
    private Long  changedPrice;

    public Long getChangedPrice() {
        return changedPrice;
    }

    public void setChangedPrice(Long changedPrice) {
        this.changedPrice = changedPrice;
    }

    public String getCreatedDateString() {
        return createdDateString;
    }

    public void setCreatedDateString(String createdDateString) {
        this.createdDateString = createdDateString;
    }

    public String getUpdatedDateString() {
        return updatedDateString;
    }

    public void setUpdatedDateString(String updatedDateString) {
        this.updatedDateString = updatedDateString;
    }

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
