package com.szw.ddshop.service.impl;

import com.szw.ddshop.common.dto.Page;
import com.szw.ddshop.common.dto.Result;
import com.szw.ddshop.dao.TbItemCustomMapper;
import com.szw.ddshop.dao.TbItemMapper;
import com.szw.ddshop.pojo.po.TbItem;
import com.szw.ddshop.pojo.vo.TbItemCustom;
import com.szw.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemDao;

    @Autowired
    private TbItemCustomMapper itemCustomDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public TbItem getById(Long id) {

        TbItem tbItem = itemDao.selectByPrimaryKey(id);

        return tbItem;

    }


    /**
     * 查询所有ITEMS
     *
     * @return
     */
    @Override
    public List<TbItem> listItems() {

        List<TbItem> list = null;

        try {

            list = itemDao.selectByExample(null);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 分页查询商品信息
     *
     * @param page
     * @return
     */
    @Override
    public Result<TbItemCustom> listItemsByPage(Page page) {

        Result<TbItemCustom> result = null;
        try {
            result = new Result<TbItemCustom>();

            //设定result<TbItem>中的值
            //设定符合条件的总记录数
            int rows = itemCustomDao.countItems();
            result.setTotal(rows);
            //设置当前页码的记录数
            List<TbItemCustom> list = itemCustomDao.listItemsByPage(page);
            result.setRows(list);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }


}
