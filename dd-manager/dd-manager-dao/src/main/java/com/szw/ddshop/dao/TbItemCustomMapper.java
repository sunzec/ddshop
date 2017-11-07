package com.szw.ddshop.dao;

import com.szw.ddshop.common.dto.Page;
import com.szw.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface TbItemCustomMapper {
     //符合条件的记录数
     int countItems();
    //当前页的记录集合
    List<TbItemCustom> listItemsByPage(Page page);
}