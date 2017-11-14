<%--
  User: Frogzec
  Date: 2017/11/6
  Time: 16:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <!-- 导入easyui的样式表 -->
    <link rel="stylesheet" href="js/jquery-easyui-1.5/themes/bootstrap/easyui.css">
    <link rel="stylesheet" href="js/jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" href="css/common.css">
</head>
<body class="easyui-layout">

<div data-options="region:'north'" style="height:70px;padding-left:20px;">
    <h2>天天小商城后台管理系统</h2>
</div>

<div data-options="region:'south'" style="padding:2px;background:#eee;">
    系统版本：V2.0
</div>

<div data-options="region:'west'" style="width:200px;">
    <div id="menu" class="easyui-accordion">
        <div title="商品管理" data-options="selected:true,iconCls:'icon-tip'" style="padding:10px 0;">
            <ul class="easyui-tree">
                <li data-options="attributes:{'href':'item-add'}">新增商品</li>
                <li data-options="attributes:{'href':'item-list'}">查询商品</li>
                <li data-options="attributes:{'href':'item-param-list'}">规格参数</li>
            </ul>
        </div>
        <div title="网站内容管理" data-options="iconCls:'icon-tip'" style="padding:10px 0;">
            <ul class="easyui-tree">
                <li data-options="attributes:{'href':'content-category'}">内容分类管理</li>
                <li data-options="attributes:{'href':'content'}">内容管理</li>
            </ul>
        </div>
        <div title="索引库管理" data-options="iconCls:'icon-tip'" style="padding:10px 0;">
            <ul class="easyui-tree">
                <li data-options="attributes:{'href':'index-item'}">solr索引库维护</li>
            </ul>
        </div>

    </div>
</div>

<div data-options="region:'center'" style="background:#eee;">
    <div id="tab" class="easyui-tabs" data-options="fit:true">
        <div title="欢迎页面" style="padding:20px;">Hello</div>
    </div>
</div>


<!-- 先导入jquery的包 -->
<script src="js/jquery-easyui-1.5/jquery.min.js"></script>
<!-- jquery easyui -->
<script src="js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<%--语言包--%>
<script src="js/ueditor/ueditor.config.js"></script>
<script src="js/ueditor/ueditor.all.js"></script>
<script src="js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>

<%--引入日期处理库--%>
<script src="js/moment/moment-with-locales.js"></script>
<script>
    moment.locale('zh-cn');
</script>

<script src="js/common.js"></script>

<script>
        ddshop.registerMenuEvent();
</script>
</body>
</html>
