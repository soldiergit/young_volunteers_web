<%--
  Created by IntelliJ IDEA.
  program: youngvolunteer
  Author: soldier
  Email： 583403411@qq.com
  Date: 6/3/19
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>青年志愿者信息管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="/young_volunteers_web_war/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="/young_volunteers_web_war/css/public.css" media="all" />
    <link rel="stylesheet" href="/young_volunteers_web_war/css/bootstrap.min.css" media="all" />


    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
    <!--<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=xfhhaTThl11qYVrqLZii6w8qE5ggnhrY&__ec_v__=20190126"></script>-->
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>

    <style>
        .container{ width: 500px; margin: 60px auto; }
        .infoBox{ width:100%; height: 630px; overflow: hidden;}
        .list-group{ margin-bottom: 0; border-radius:0;}
        .list-group li{  border-radius:0 !important; }
        .list-group li:last-child{  border-bottom:0 !important; }
    </style>
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote layui-bg-green">
    <div id="nowTime"></div>
</blockquote>
<div class="layui-row layui-col-space10 panel_box">
    <!--<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">-->
    <!--<a href="javascript:;" data-url="http://fly.layui.com/case/u/3198216" target="_blank">-->
    <!--<div class="panel_icon layui-bg-green">-->
    <!--<i class="layui-anim seraph icon-good"></i>-->
    <!--</div>-->
    <!--<div class="panel_word">-->
    <!--<span>为我点赞</span>-->
    <!--<cite>点赞地址链接</cite>-->
    <!--</div>-->
    <!--</a>-->
    <!--</div>-->
    <!--<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">-->
    <!--<a href="javascript:;" data-url="https://github.com/BrotherMa/layuicms2.0" target="_blank">-->
    <!--<div class="panel_icon layui-bg-black">-->
    <!--<i class="layui-anim seraph icon-github"></i>-->
    <!--</div>-->
    <!--<div class="panel_word">-->
    <!--<span>Github</span>-->
    <!--<cite>模版下载链接</cite>-->
    <!--</div>-->
    <!--</a>-->
    <!--</div>-->
    <!--<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">-->
    <!--<a href="javascript:;" data-url="https://gitee.com/layuicms/layuicms2.0" target="_blank">-->
    <!--<div class="panel_icon layui-bg-red">-->
    <!--<i class="layui-anim seraph icon-oschina"></i>-->
    <!--</div>-->
    <!--<div class="panel_word">-->
    <!--<span>码云</span>-->
    <!--<cite>模版下载链接</cite>-->
    <!--</div>-->
    <!--</a>-->
    <!--</div>-->
    <!--<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">-->
    <!--<a href="javascript:;" data-url="page/user/userList.html">-->
    <!--<div class="panel_icon layui-bg-orange">-->
    <!--<i class="layui-anim seraph icon-icon10" data-icon="icon-icon10"></i>-->
    <!--</div>-->
    <!--<div class="panel_word userAll">-->
    <!--<span></span>-->
    <!--<em>用户总数</em>-->
    <!--<cite class="layui-hide">用户中心</cite>-->
    <!--</div>-->
    <!--</a>-->
    <!--</div>-->
    <!--<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">-->
    <!--<a href="javascript:;" data-url="page/systemSetting/icons.html">-->
    <!--<div class="panel_icon layui-bg-cyan">-->
    <!--<i class="layui-anim layui-icon" data-icon="&#xe857;">&#xe857;</i>-->
    <!--</div>-->
    <!--<div class="panel_word outIcons">-->
    <!--<span></span>-->
    <!--<em>外部图标</em>-->
    <!--<cite class="layui-hide">图标管理</cite>-->
    <!--</div>-->
    <!--</a>-->
    <!--&lt;!&ndash;</div>&ndash;&gt;-->
    <!--<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">-->
    <!--<a href="javascript:;">-->
    <!--<div class="panel_icon layui-bg-blue">-->
    <!--<i class="layui-anim seraph icon-clock"></i>-->
    <!--</div>-->
    <!--<div class="panel_word">-->
    <!--<span class="loginTime"></span>-->
    <!--<cite>上次登录时间</cite>-->
    <!--</div>-->
    <!--</a>-->
    <!--</div>-->
</div>
<blockquote class="layui-elem-quote main_btn">
    <!--<p>本模板基于Layui2.*实现，支持除LayIM外所有的Layui组件。<a href="http://layim.layui.com/#getAuth" target="_blank" class="layui-btn layui-btn-xs">获取LayIM授权</a>　layui开发文档地址：<a class="layui-btn layui-btn-xs layui-btn-danger" target="_blank" href="http://www.layui.com/doc">layui文档</a>　千人技术交流QQ群：<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=8b7dd3ea73528c1e46c5d4e522426d60deed355caefdf481c1eacdd1b7b73bfd"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="layui后台管理模版" title="layui后台管理模版"></a>（添加时请注明来源，如：“码云”、“github”等）</p>-->
    <!--<p class="layui-red">郑重提示：本模版作为学习交流免费使用【强烈要求付费或者捐赠的我也就默默的接受了😄】，如需用作商业用途，请联系作者购买【本模版已进行作品版权证明，不管以何种形式获取的源码，请勿进行出售或者上传到任何素材网站，否则将追究相应的责任】</p>-->
    <!--<p>注：本模版未引入任何第三方组件，单纯的layui+js实现的各种功能。网站所有数据均为静态数据，无数据库，除打开的窗口和部分小改动外所有操作刷新后无效，关闭窗口或清除缓存后，所有操作无效，请知悉。</p>-->
    <!--<p class="layui-blue">PS：这只是模版而不是定制开发，不能覆盖升级很正常，请不要因为不能覆盖升级来喷我，我表示很无辜，谢谢大家</p>-->
</blockquote>
<div class="layui-row layui-col-space10">
    <div class="layui-col-lg6 layui-col-md12">
        <!--<blockquote class="layui-elem-quote title">系统基本参数</blockquote>-->
        <!--<table class="layui-table magt0">-->
        <!--<colgroup>-->
        <!--<col width="150">-->
        <!--<col>-->
        <!--</colgroup>-->
        <!--<tbody>-->
        <!--<tr>-->
        <!--<td>当前版本</td>-->
        <!--<td class="version"></td>-->
        <!--</tr>-->
        <!--<tr>-->
        <!--<td>开发作者</td>-->
        <!--<td class="author"></td>-->
        <!--</tr>-->
        <!--<tr>-->
        <!--<td>网站首页</td>-->
        <!--<td class="homePage"></td>-->
        <!--</tr>-->
        <!--<tr>-->
        <!--<td>服务器环境</td>-->
        <!--<td class="server"></td>-->
        <!--</tr>-->
        <!--<tr>-->
        <!--<td>数据库版本</td>-->
        <!--<td class="dataBase"></td>-->
        <!--</tr>-->
        <!--&lt;!&ndash;<tr>&ndash;&gt;-->
        <!--&lt;!&ndash;<td>最大上传限制</td>&ndash;&gt;-->
        <!--&lt;!&ndash;<td class="maxUpload"></td>&ndash;&gt;-->
        <!--&lt;!&ndash;</tr>&ndash;&gt;-->
        <!--<tr>-->
        <!--<td>当前用户权限</td>-->
        <!--<td class="userRights"></td>-->
        <!--</tr>-->
        <!--</tbody>-->
        <!--</table>-->
        <blockquote class="layui-elem-quote title">最新信息
            <!--<i class="layui-icon layui-red">&#xe756;</i>-->
        </blockquote>
        <table class="layui-table mag0" lay-skin="line">
            <!--<colgroup>-->
            <!--<col>-->
            <!--<col width="110">-->
            <!--</colgroup>-->
            <!--<tbody class="history_box" style="overflow: hidden;">-->
            <!--<table id="msgList" lay-filter="msgList"  lay-skin="row" class="layui-body"></table>-->
            <!--<div class="panel panel-default">-->
            <!--<div class="panel-heading">-->
            <!--<div class="panel-title">公告信息</div>-->
            <!--</div>-->
            <!--<div class="panel-body">-->
            <div class="infoBox" id="infoBox">
                <ul class="list-group warn_info_ul" style="font-size: 15px"></ul>
                <!--<table class="list-group warn_info_ul"></table>-->
            </div>
            <!--</div>-->
            <!--</div>-->
            <!--</tbody>-->
        </table>
    </div>
    <div class="layui-col-lg6 layui-col-md12">
        <blockquote class="layui-elem-quote title">数据展示</blockquote>
        <div class="layui-elem-quote layui-quote-nm history_box magb0">
            <div id="container" name="show_video_detail_for_main" class="show_video_detail_for_main" style="height: 100%"></div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/young_volunteers_web_war/layui/layui.js"></script>
<script type="text/javascript" src="/young_volunteers_web_war/js/config.js"></script>
<script type="text/javascript" src="/young_volunteers_web_war/js/tool.js"></script>
<script type="text/javascript" src="/young_volunteers_web_war/js/main.js"></script>

</body>
</html>

