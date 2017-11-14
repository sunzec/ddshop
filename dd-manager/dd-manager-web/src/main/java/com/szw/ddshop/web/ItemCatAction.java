package com.szw.ddshop.web;

import com.szw.ddshop.common.dto.TreeNode;
import com.szw.ddshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: Frogzec
 * Date: 2017/11/13
 * Time: 15:04
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemCatAction {

    @Autowired
    private ItemCatService itemCatService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @ResponseBody
    @RequestMapping(value="/itemCats")
    public List<TreeNode> listItemCatsByPid(@RequestParam("parentId") Long parentId) {
        List<TreeNode> treeNodeList = null;
        try {
            treeNodeList = itemCatService.listItemCats(parentId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return treeNodeList;
    }

}
