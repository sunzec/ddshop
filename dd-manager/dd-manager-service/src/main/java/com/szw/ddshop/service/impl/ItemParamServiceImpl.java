package com.szw.ddshop.service.impl;

import com.szw.ddshop.common.dto.Order;
import com.szw.ddshop.common.dto.Page;
import com.szw.ddshop.common.dto.Result;
import com.szw.ddshop.dao.TbItemParamCustomerMapper;
import com.szw.ddshop.dao.TbItemParamMapper;
import com.szw.ddshop.pojo.po.TbItemParam;
import com.szw.ddshop.pojo.po.TbItemParamExample;
import com.szw.ddshop.pojo.vo.TbItemParamCustom;
import com.szw.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Frogzec
 * Date: 2017/11/13
 * Time: 23:17
 * Version:V1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemParamCustomerMapper itemParamCustomDao;

    @Autowired
    private TbItemParamMapper   itemParamDao;



    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int removeItemParamBatch(List<Long> ids) {

        int i = 0;
        try {
            //创建模板
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);

            //删除
            i = itemParamDao.deleteByExample(example);
         }catch (Exception e)
        {
            logger.error(e.getMessage(),e);
            e.printStackTrace();

        }

        return i;
    }

    /**
     * 根据cid查询
     * @param cid
     * @return
     */
    @Override
    public TbItemParam getItemParamByCid(Long cid) {

        TbItemParam tbItemParam = null;

        try {
            //创建模板
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andItemCatIdEqualTo(cid);
            //查询
            List<TbItemParam> list = itemParamDao.selectByExampleWithBLOBs(example);

            if(list != null && list.size() >0 )
            {
                tbItemParam=list.get(0);
            }


        }catch(Exception e)
        {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return tbItemParam;
    }

    /**
     * 分页查询
     * @param page
     * @param order
     * @return
     */
    @Override
    public Result<TbItemParamCustom> listItemParamByPage(Page page,Order order) {

        Result<TbItemParamCustom> result = null;
        try {
              Map<String,Object> map = new HashMap<String,Object>();

              map.put("page",page);
              map.put("order",order);
              int count = itemParamCustomDao.countItemParams();
               List<TbItemParamCustom> list = itemParamCustomDao.listItemParamByPage(map);
               result = new Result<TbItemParamCustom>();
               result.setTotal(count);
               result.setRows(list);


        }catch(Exception e)
        {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 添加规格信息
     * @param cid
     * @param itemParam
     * @return
     */
    @Override
    public int saveItemParam(Long cid, TbItemParam itemParam) {

        int i = 0;
        try {
            itemParam.setItemCatId(cid);
            itemParam.setCreated(new Date());
            itemParam.setUpdated(new Date());
            i = itemParamDao.insertSelective(itemParam);

        }catch (Exception e)
        {
                logger.error(e.getMessage(),e);
                e.printStackTrace();

        }

        return i;
    }
}
