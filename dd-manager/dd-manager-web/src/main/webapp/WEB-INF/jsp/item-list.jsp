<%@ page import="javax.servlet.descriptor.TaglibDescriptor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
商品列表
<table class="easyui-datagrid" style="width:400px;height:250px"
       data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true">
    <thead>
    <tr>
        <th data-options="field:'code',width:100">编码</th>
        <th data-options="field:'name',width:100">名称</th>
        <th data-options="field:'price',width:100,align:'right'">价格</th>
    </tr>
    </thead>
</table>










