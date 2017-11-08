<%@ page import="javax.servlet.descriptor.TaglibDescriptor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
商品列表
<table id="dg"></table>

<script>
     //添加工具栏
     /**新增
      * 删除
      * 编辑
      * 上架
      * 下架
      * @type {Array}
      */

     var toolbar = [
         {
             iconCls: 'icon-add',
             text: '新增',
             handler: function(){
                 console.log('add')
             }
         },
         {
            iconCls:'icon-remove',
             text:'删除',
             handler:function(){
               var selections = $('#dg').datagrid('getSelections');
               console.log(selections);
               //判断选择的记录是否为空
                 if(selections.length == 0)
                 {
                     $.messager.alert('提示','至少选中一条记录');
                     return;
                 }
                 $.messager.confirm('确认','确认删除?',function(r){
                     if(r)
                     {
                         var ids = [];
                         //遍历
                         for(var i  in  selections)
                         {
                             ids.push(selections[i].id);
                         }
                         $.post(
                             "items/batch",
                             { 'ids[]': ids},
                             function (data) {

                             },
                             'json'
                         );
                     }

                 })

             }
         },
         {
             iconCls:'icon-edit',
             text:'编辑',
             handler:function(){
                 console.log('编辑')
             }
         },
         {
             iconCls:'icon-up',
             text:'上架',
             handler:function(){
                 console.log('上架')
             }
         },
         {
             iconCls:'icon-down',
             text:'下架',
             handler:function(){
                 console.log('下架')
             }
         }
     ];

    $('#dg').datagrid({

        toolbar: toolbar,
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
        pageSize: 30,
        //分页列表
        pageList: [10,20,30,50,60,100],
        columns:[[
            {field: 'ck', checkbox: true},
            {field:'id',title9:'编号',width:100},
            {field:'title',title:'名称',width:100},
            {field:'sellPoint',title:'卖点',width:100},
            {field:'catName',title:'商品分类',width:100},
            {field:'status',title:'商品状态(前台)',formatter:function (value,row,index) {
                console.group();
                console.log(value);
                console.log(row);
                console.log(index)
                console.groupEnd();
                switch(value)
                {
                    case 1:
                         return  '正常';
                         break;
                    case 2:
                        return  '下架';
                        break;
                    case 3:
                        return  '删除';
                        break;
                    default:
                        return '未知';
                        break;
                }

            }},
            {field:'statusName',title:'状态名',width:100},
            {field:'price',title:'价格',width:100,align:'right'}
        ]]
    });
</script>









