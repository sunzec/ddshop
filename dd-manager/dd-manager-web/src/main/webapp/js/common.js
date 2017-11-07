var ddshop = {
    registerMenuEvent: function () {
        $("#menu .easyui-tree").tree({
            onClick: function (node) {
                var href = node.attributes.href;
                var text = node.text;
                //判断是否存在相同的选项卡,如果存在就跳到对应的选项卡
                //如果不存在就创建新的选项卡

                 var tt= $('#tab').tabs('exists',text);
                 if(tt)
                 {
                     $('#tab').tabs('select',text);
                 }
                 else {
                     $('#tab').tabs('add', {
                         title: text,
                         href: href,
                         closable: true
                     })
                 }
            }
        });

    }


};
