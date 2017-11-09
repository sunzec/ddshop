package com.szw.ddshop.web;

import com.szw.ddshop.common.dto.Page;
import com.szw.ddshop.common.dto.Result;
import com.szw.ddshop.pojo.po.TbItem;
import com.szw.ddshop.pojo.vo.TbItemCustom;
import com.szw.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    private ItemService itemService;

    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId") Long itemId) {
        System.out.println(itemId);

        TbItem tbItem = itemService.getById(itemId);

        return tbItem;
    }

    /*@ResponseBody
    @RequestMapping("/items")
    public List<TbItem> getAllItems()
    {
        List<TbItem> list = null;

        try {
             list = itemService.getItems();
        }
        catch (Exception e)
        {
              logger.error(e.getMessage(), e);
              e.printStackTrace();
        }

        return list;

    }*/

    /**
     * 商品信息分页查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/items")
    public Result<TbItemCustom> listItemsByPage(Page page) {

        Result<TbItemCustom> list = null;

        try {
            list= itemService.listItemsByPage(page);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return list;

    }

    /**
     * 批量删除
     */

    @ResponseBody
    @RequestMapping(value ="/items/batch", method = RequestMethod.POST)
     public int updateBatch(@RequestParam("ids[]") List<Long> ids)
    {
        int i=0;
        try {
            i=itemService.updateBatch(ids);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 上架
     */

    @ResponseBody
    @RequestMapping(value ="/items/up", method = RequestMethod.POST)
    public int updateStatusUp(@RequestParam("ids[]") List<Long> ids)
    {
        int i=0;
        try {
            i=itemService.updateStatusUp(ids);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 下架
     */

    @ResponseBody
    @RequestMapping(value ="/items/down", method = RequestMethod.POST)
    public int updateStatusDown(@RequestParam("ids[]") List<Long> ids)
    {
        int i=0;
        try {
            i=itemService.updateStatusDown(ids);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

}
