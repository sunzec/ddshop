package com.szw.ddshop.common.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序实体类
 * User: Frogzec
 * Date: 2017/11/11
 * Time: 15:01
 * Version:V1.0
 */
public class Order {

       private String sort;
       private String order;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<String> getOrderParams() {
        String[] sorts = this.sort.split(",");//id,title
        String[] orders = this.order.split(",");//asc,desc
        List<String> list = new ArrayList<String>();
        for (int i=0;i<sorts.length;i++){
            String temp = sorts[i] +" "+orders[i];//id asc;title desc
            list.add(temp);//[id asc;title desc]
        }
        return list;
    }
}
