var ddshop = {
    registerMenuEvent: function () {
        var  _this = this;
        $("#menu .easyui-tree").tree({
            onClick: function (node) {
                var href = node.attributes.href;
                var title = node.text;
                //判断是否存在相同的选项卡,如果存在就跳到对应的选项卡
                //如果不存在就创建新的选项卡
                // console.log(_this);
                _this.addTabs(title,href);
            }
        });
    },
    addTabs:function (title,href) {
        var tt= $('#tab').tabs('exists',title);
        if(tt)
        {
            $('#tab').tabs('select',title);

        }
        else
            {
            $('#tab').tabs('add', {
                title: title,
                href: href,
                closable: true
            })
        }
    },
    closeTabs:function(title)
    {
        $('#tab').tabs('close',title);
    }
};
