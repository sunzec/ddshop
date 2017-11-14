<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div id="toolbar1">
    <div>
        <button type="button" onclick="addParam()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button type="button" onclick="editParam()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button type="button" onclick="delParam()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
    </div>
</div>
<table id="dgParamList"></table>

<script>
    //初始化数据表格
    $('#dgParamList').datagrid({
        title: '商品规格模板列表',
        url:'itemParams',
        fit: true,
        rownumbers: true,
        pagination: true,
        pageSize:20,
        toolbar: '#toolbar1',
        columns:[[
            {field:'ck', checkbox: true},
            {field:'id',title:'ID', sortable: true},
            {field:'itemCatName',title:'商品类目'},
            {field:'paramData',title:'规格(只显示分组名称)', formatter:function(value,row,index){

                var json = JSON.parse(value);
                var array=[];
                //JSON的遍历
                $.each(json,function (i,e) {
                    array.push(e.group);
                });
                return array.join(",");
            }},
            {field:'createdView',title:'创建日期', formatter:function(value,row,index){
                return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
            }},
            {field:'updated',title:'更新日期', formatter:function(value,row,index){
                return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
            }}
        ]]
    });

    //删除操作(更改)
    function delParam()
    {
        console.log('deleted');
        //查看是否选中
        var selectRows = $('#dgParamList').datagrid('getSelections');
//      console.log(selectRows);
        if(selectRows.length == 0)
        {
            $.messager.alert('提示','未选中记录','warning');
            return;
        }

        $.messager.confirm('确认','确认是否删除记录?',function(r){
           if(r)
           {
               //获得用户选中的记录
               var ids = [];
               for(var i = 0 ; i<selectRows.length;i++)
               {
                   ids.push(selectRows[i].id);
               }

               //异步提交给后台
               $.post(
                   "itemParam/removeBatch",
                   {'ids[]':ids},
                   function(data)
                   {
                       $('#dgParamList').datagrid('reload')
                   }

               );

           }
        });
    }

    function addParam(){
        ddshop.addTabs('新增商品规格模板', 'item-param-add');
    }
    function edit(){

    }


</script>