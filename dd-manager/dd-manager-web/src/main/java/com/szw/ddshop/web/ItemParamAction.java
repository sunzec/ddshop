package com.szw.ddshop.web;

import com.szw.ddshop.common.dto.Order;
import com.szw.ddshop.common.dto.Page;
import com.szw.ddshop.common.dto.Result;
import com.szw.ddshop.pojo.po.TbItemParam;
import com.szw.ddshop.pojo.vo.TbItemParamCustom;
import com.szw.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: Frogzec
 * Date: 2017/11/13
 * Time: 23:09
 * Version:V1.0
 */
@Controller
public class ItemParamAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemParamService itemParamService;

    /**
     * 显示规格信息
     * @param page
     * @return
     */
    //Todo
    @ResponseBody
    @RequestMapping(value="itemParams",method = RequestMethod.POST)
    public Result<TbItemParamCustom> listItemParamByPage(Page page,Order order)
    {
        Result<TbItemParamCustom>   result=null;
        try {

                result = itemParamService.listItemParamByPage(page,order);
        }catch (Exception e)
        {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return  result;
    }

    @ResponseBody
    @RequestMapping(value="itemParams/save/{cid}",method = RequestMethod.POST)
    public  int saveItemParam(@PathVariable("cid") Long cid, TbItemParam itemParam)
    {
        int i = 0;
        try {
             i = itemParamService.saveItemParam(cid,itemParam);

        }catch(Exception e)
        {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }


        return i;
    }

    /**
     * Todo
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/itemParam/removeBatch",method=RequestMethod.POST)
    public int removeItemParamBatch(@RequestParam("ids[]") List<Long> ids)
    {
           int i =0;
           try{
              i = itemParamService.removeItemParamBatch(ids);

           }catch (Exception e)
           {
               logger.error(e.getMessage(),e);
               e.printStackTrace();
           }

           return  i;
    }


}
