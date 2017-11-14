package com.szw.ddshop.service;

import com.szw.ddshop.common.dto.Order;
import com.szw.ddshop.common.dto.Page;
import com.szw.ddshop.common.dto.Result;
import com.szw.ddshop.pojo.po.TbItem;
import com.szw.ddshop.pojo.vo.TbItemCustom;
import com.szw.ddshop.pojo.vo.TbItemQuery;

import java.util.List;

public interface ItemService {

    public TbItem getById(Long id);

    public List<TbItem> listItems();

    Result<TbItemCustom>  listItemsByPage(Page page, Order order, TbItemQuery query);

    int updateBatch(List<Long> ids);

    int updateStatusUp(List<Long> ids);

    int updateStatusDown(List<Long> ids);

    int  saveItem(TbItem tbItem, String content,String  paramData);
}
