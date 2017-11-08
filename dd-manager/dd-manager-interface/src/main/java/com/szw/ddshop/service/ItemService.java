package com.szw.ddshop.service;

import com.szw.ddshop.common.dto.Page;
import com.szw.ddshop.common.dto.Result;
import com.szw.ddshop.pojo.po.TbItem;
import com.szw.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface ItemService {

    public TbItem getById(Long id);


    public List<TbItem> listItems();

    Result<TbItemCustom>  listItemsByPage(Page page);

    int updateItems(List<Long> ids);
}
