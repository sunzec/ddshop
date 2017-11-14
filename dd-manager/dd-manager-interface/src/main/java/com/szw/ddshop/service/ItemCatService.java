package com.szw.ddshop.service;

import com.szw.ddshop.common.dto.TreeNode;

import java.util.List;

/**
 * User: Frogzec
 * Date: 2017/11/13
 * Time: 19:28
 * Version:V1.0
 */
public interface ItemCatService {

    List<TreeNode> listItemCats(Long parentId);
}
