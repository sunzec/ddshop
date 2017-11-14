<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="easyui-panel" title="商品规格参数模板详情" data-options="fit:true">

    <form class="form" id="itemParamAddForm" name="itemParamAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">商品类目：</td>
                <td>
                    <input id="cid1" name="cid1" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">规格参数：</td>
                <td>
                    <button class="easyui-linkbutton" onclick="addGroup()" type="button"
                            data-options="iconCls:'icon-add'">添加分组
                    </button>
                    <ul id="item-param-group">

                    </ul>
                    <ul id="item-param-group-template" style="display:none;">
                        <li>
                            <input name="group">
                            <button title="添加参数" class="easyui-linkbutton" onclick="addParam(this)" type="button"
                                    data-options="iconCls:'icon-add'"></button>
                            <button title="删除分组" class="easyui-linkbutton" onclick="delGroup(this)" type="button"
                                    data-options="iconCls:'icon-cancel'"></button>
                            <ul class="item-param">
                                <li>
                                    <input name="param">
                                    <button title="删除参数" class="easyui-linkbutton" onclick="delParam(this)"
                                            type="button" data-options="iconCls:'icon-cancel'"></button>
                                </li>

                            </ul>
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button class="easyui-linkbutton" onclick="submitForm()" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button class="easyui-linkbutton" onclick="clearForm()" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    //初始化类别选择树
    $('#cid1').combotree({
        url: 'itemCats?parentId=0',
        required: true,
        onBeforeExpand: function (node) {
//获取当前被点击的tree
            var $currentTree = $('#cid1').combotree('tree');
//调用easyui tree组件的options方法
            var option = $currentTree.tree('options');
//修改option的url属性
            option.url = 'itemCats?parentId=' + node.id;
        },
        onBeforeSelect: function (node) {

            var isLeaf = $('#cid1').tree('isLeaf', node.target);
            if (!isLeaf) {
                $.messager.alert('警告', '请选择最终类目', 'warning');
                return false;
            }

        }
    });

    //添加分组
    function addGroup() {
        var $templateLi = $('#item-param-group-template li').eq(0).clone();
        $('#item-param-group').append($templateLi)

    }

    //添加参数
    function addParam(ele) {

        var $paramLi = $('#item-param-group-template .item-param li').eq(0).clone();
        $(ele).parent().find('.item-param').append($paramLi);

    }

    //删除参数
    function delParam(ele) {
        $(ele).parent().remove();
    }

    //删除分组
    function delGroup(ele) {
        $(ele).parent().remove();
    }

    //保存
    function submitForm() {

        var groupValues = [];

        //遍历分组
        var $groups = $('#item-param-group [name=group]');
        $groups.each(function (index, ele) {
            //遍历分组项
            var paramValues = [];
            var $params = $(ele).parent().find('.item-param [name=param]')
            $params.each(function (_index, _ele) {
                var _val = $(_ele).val();
                if ($.trim(_val).length > 0) {
                    paramValues.push(_val);
                }
            });

            var val = $(ele).val();
            var o = {};
            o.group = val;
            o.params = paramValues;


            if ($.trim(val).length > 0 && paramValues.length > 0) {
                groupValues.push(o);
            }

        });

       //得到规格参数模板json串
        console.log(groupValues);

        var cid = $('#cid1').combotree('getValue');
        console.log(cid);
        var url = 'itemParams/save/' + cid;
        //转换成json字符串
        var jsonStr = JSON.stringify(groupValues);
        $.post(url, {"paramData": jsonStr}, function (data) {
            //
            console.log(data);
            if(data == 1)
            {
                $.messager.alert('提示',"添加成功");
                 ddshop.addTabs('规格参数','item-param-list');
                $('#tab').tabs('close','新增商品规格模板');
            }

        });
    }

</script>