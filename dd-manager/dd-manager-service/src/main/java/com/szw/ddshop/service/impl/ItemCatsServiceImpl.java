package com.szw.ddshop.service.impl;

import com.szw.ddshop.common.dto.TreeNode;
import com.szw.ddshop.dao.TbItemCatMapper;
import com.szw.ddshop.pojo.po.TbItemCat;
import com.szw.ddshop.pojo.po.TbItemCatExample;
import com.szw.ddshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Frogzec
 * Date: 2017/11/13
 * Time: 15:53
 * Version:V1.0
 */
@Service
public class ItemCatsServiceImpl implements ItemCatService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemCatMapper tbItemCatDao;

    @Override
    public List<TreeNode> listItemCats(Long parentId) {
        List<TreeNode> treeNodeList = null;
        try {
            //创建查询模板
            TbItemCatExample tbItemCatExample = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            //执行查询
            List<TbItemCat> itemCatList = tbItemCatDao.selectByExample(tbItemCatExample);
            //序列化成json对象
            treeNodeList = new ArrayList<TreeNode>();
            //遍历原有列表生成新列表
            for (int i = 0; i < itemCatList.size(); i++) {
                TbItemCat itemCat = itemCatList.get(i);
                TreeNode treeNode = new TreeNode();
                treeNode.setId(itemCat.getId());
                treeNode.setText(itemCat.getName());
                //判断是否父节点是父节点就关闭,子节点就开启
                 treeNode.setState(itemCat.getIsParent() ? "closed": "open");
                //添加到list
                treeNodeList.add(treeNode);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return treeNodeList;
    }
}
