package com.szw.ddshop.web;

import com.szw.ddshop.pojo.po.TbItem;
import com.szw.ddshop.service.ItemService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

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




}
