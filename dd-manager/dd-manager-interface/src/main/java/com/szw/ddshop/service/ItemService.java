package com.szw.ddshop.service;

import com.szw.ddshop.pojo.po.TbItem;

import java.util.List;

public interface ItemService {

    public TbItem getById(Long id);


    List<TbItem> getAllItems();

}
