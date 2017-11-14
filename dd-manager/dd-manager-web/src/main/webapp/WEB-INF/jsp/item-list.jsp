<%@ page import="javax.servlet.descriptor.TaglibDescriptor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="toolbar">
    <div>商品列表</div>
    <div style="padding: 0px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" style="width: 60px;" panelHeight="auto">
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
        <%--<a onclick="searchForm()" class="easyui-linkbutton"></a>--%>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>


<table id="dg"></table>

<script>

     //添加工具栏
     function searchForm()
     {
         $('#dg').datagrid('load',{
             title:$('#title').val(),
             status:$('#status').combobox('getValue')
         })
     }

     function add()
     {
        ddshop.addTabs("新增商品","item-add")
     }

     function edit()
     {
         console.log('edit');
     }

     function remove()
     {
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
                     //url:"'
                     "items/batch",
                     //data:从前台提交哪些数据到后台。相当于data:Object
                     { 'ids[]': ids},
                     //后台处理成功的回调函数
                     function (data) {
                         $('#dg').datagrid('reload')
                     },
                     //dataType:返回数据类型
                     'json'
                 );
             }

         })
     }

     function up()
     {
         //选择是否已经上架
         var selections = $('#dg').datagrid('getSelections');
         console.log(selections);
         //判断选择的记录是否为空
         if(selections.length == 0)
         {
             $.messager.alert('提示','至少选中一条记录');
             return;
         }

         for(var i in selections)
         {
             if(selections[i].statusName =='正常')
             {
                 $.messager.alert('提示',"选择商品中有存在已经上架商品")
                 return;
             }
         }

         $.messager.confirm('确认','确认上架?',function(r){
             if(r)
             {
                 var ids = [];
                 //遍历
                 for(var i  in  selections)
                 {
                     ids.push(selections[i].id);
                 }
                 $.post(
                     //url:"'
                     "items/up",
                     //data:从前台提交哪些数据到后台。相当于data:Object
                     { 'ids[]': ids},
                     //后台处理成功的回调函数
                     function (data) {
                         $('#dg').datagrid('reload')
                     },
                     //dataType:返回数据类型
                     'json'
                 );
             }

         })
     }

     function down()
     {
         //选择是否已经上架
         var selections = $('#dg').datagrid('getSelections');
         console.log(selections);
         //判断选择的记录是否为空
         if(selections.length == 0)
         {
             $.messager.alert('提示','至少选中一条记录');
             return;
         }
         //遍历selections,查看是否存在已经下架的产品
         for(var i in selections)
         {
             if(selections[i].statusName =='下架')
             {
                $.messager.alert('提示',"选择商品中有存在已经下架商品")
                 return;
             }
         }

         $.messager.confirm('确认','确认下架?',function(r){
             if(r)
             {
                 var ids = [];
                 //遍历
                 for(var i  in  selections)
                 {
                     ids.push(selections[i].id);
                 }
                 $.post(
                     //url:"'
                     "items/down",
                     //data:从前台提交哪些数据到后台。相当于data:Object
                     { 'ids[]': ids},
                     //后台处理成功的回调函数
                     function (data) {
                         $('#dg').datagrid('reload')
                     },
                     //dataType:返回数据类型
                     'json'
                 );
             }

         })
     }

    $('#dg').datagrid({

        toolbar: '#toolbar',
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
        //是否多列排序
        multiSort:true,
        //默认显示10条，这样的话就显示20条
        pageSize: 30,
        //分页列表
        pageList: [20,30,50,60,100],
        columns:[[
            {field: 'ck', checkbox: true},
            {field:'id',title:'编号',width:100,sortable:true},
            {field:'title',title:'名称',width:100,sortable:true},
            {field:'sellPoint',title:'卖点',width:100},
            {field:'catName',title:'商品分类(后台)',width:100},
            {field:'statusName',title:'状态名',width:100},
            {field:'price',title:'价格(分)',width:100,align:'right',sortable:true},
            {field:'changedPrice',title:'价格(RMB)',width:100,align:'right'},
            {field:'created',title:'创建时间',width:100,align:'right',sortable:true,formatter:function(value,row,index){

                return moment(value).format("LL");

            }},
            {field:'updated',title:'更新时间',width:100,align:'right',sortable:true,formatter:function (value,row,index) {

                return moment(value).format("LL")

            }},
          /*  {field:'createdDateString',title:'创建时间',width:100},
            {field:'updatedDateString',title:'更改时间',width:100},*/

        ]]
    });
</script>









