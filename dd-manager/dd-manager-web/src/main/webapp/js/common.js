var ddshop = {
    registerMenuEvent: function () {

        $("#menu .easyui-tree").tree({
            onClick: function (node) {
                console.log(node);
                var href = node.attributes.href;
                $('#tab').tabs('close', 1);
                $('#tab').tabs('add', {
                    title: node.text,
                    href: href,
                    closable: true
                })
            }
        });

    }


};
