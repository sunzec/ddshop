package com.szw.ddshop.common.dto;

/**
 * 通用的树节点实体类
 * User: Frogzec
 * Date: 2017/11/13
 * Time: 15:38
 * Version:V1.0
 */
public class TreeNode {
    private Long id;
    private String text;
    private String state; //状态

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
