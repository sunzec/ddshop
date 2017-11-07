<%@ page import="javax.servlet.descriptor.TaglibDescriptor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
商品列表
<table id="dg"></table>

<script>

    $('#dg').datagrid({
        //请求远程服务器上的URL http://localhost:8080/ddshop/items
        url:'items',
        //隔行变色
        striped:true,
        //添加分页工具栏
        pagination: true,
        //每行的前面显示行号
        rownumbers: true,
        //使得数据表格自适应填充父容器
        fit:true,
        //默认显示10条，这样的话就显示20条
        pageSize: 20,
        //分页列表
        pageList: [10,20,30,50,60,100],
        columns:[[
            {field: 'ck', checkbox: true},
            {field:'id',title9:'编号',width:100},
            {field:'title',title:'名称',width:100},
            {field:'sellPoint',title:'卖点',width:100},
            {field:'catName',title:'商品分类',width:100},
            {field:'price',title:'价格',width:100,align:'right'}
        ]]
    });
</script>









