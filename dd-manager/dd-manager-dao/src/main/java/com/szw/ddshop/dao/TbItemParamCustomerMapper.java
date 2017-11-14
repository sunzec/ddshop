package com.szw.ddshop.dao;

import com.szw.ddshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map; /**
 * User: Frogzec
 * Date: 2017/11/13
 * Time: 23:29
 * Version:V1.0
 */
public interface TbItemParamCustomerMapper {
    int countItemParams();

    List<TbItemParamCustom> listItemParamByPage(Map<String, Object> map);
}
