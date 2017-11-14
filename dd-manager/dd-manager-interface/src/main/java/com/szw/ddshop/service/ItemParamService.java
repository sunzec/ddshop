package com.szw.ddshop.service;

import com.szw.ddshop.common.dto.Order;
import com.szw.ddshop.common.dto.Page;
import com.szw.ddshop.common.dto.Result;
import com.szw.ddshop.pojo.po.TbItemParam;
import com.szw.ddshop.pojo.vo.TbItemParamCustom;

import java.util.List;

/**
 * User: Frogzec
 * Date: 2017/11/13
 * Time: 23:16
 * Version:V1.0
 */
public interface ItemParamService {

    Result<TbItemParamCustom> listItemParamByPage(Page page,Order order);

    int saveItemParam(Long cid, TbItemParam itemParam);

    int removeItemParamBatch(List<Long> ids);

    TbItemParam getItemParamByCid(Long cid);
}
