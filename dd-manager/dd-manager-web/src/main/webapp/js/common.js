var ddshop = {
    registerMenuEvent: function () {
        $("#menu .easyui-tree").tree({
            onClick: function (node) {
                var href = node.attributes.href;
                var text = node.text;
                $('#tab').tabs('add', {
                    title: text,
                    href: href,
                    closable: true,
                })
            }
        });

    }


};
