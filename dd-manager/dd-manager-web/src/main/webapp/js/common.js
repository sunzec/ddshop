var ddshop = {
    registerMenuEvent: function () {
        $("#menu .easyui-tree").tree({
            onClick: function (node) {
                var href = node.attributes.href;
                var text = node.text
                ;
                $('#tab').tabs('add', {
                    title: text,
                    href: href,
                    closable: true,
                })
            }
        });

    },
    selectAllItem:function()
    {
        $('#dg').datagrid({
            //不能加 '/'
            url:'items',
            fit:true,

            columns:[[
                {field:'id',title9:'编号',width:100},
                {field:'title',title:'名称',width:100},
                {field:'price',title:'价格',width:100,align:'right'}
            ]]
        });
    }


};
