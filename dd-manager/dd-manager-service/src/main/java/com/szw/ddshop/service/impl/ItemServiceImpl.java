package com.szw.ddshop.service.impl;

import com.szw.ddshop.dao.TbItemMapper;
import com.szw.ddshop.pojo.po.TbItem;
import com.szw.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemDao;

    @AutoWired
    private TbItemMapper1 itemDao1;

    @Override
    public TbItem getById(Long id) {

        TbItem tbItem = itemDao.selectByPrimaryKey(id);

        return  tbItem;

    }

    @Override
    public List<TbItem> getAllItems() {


        return itemDao1.selectByExample();
    }
}
