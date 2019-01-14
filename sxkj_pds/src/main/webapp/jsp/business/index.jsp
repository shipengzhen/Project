<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/tags/loushang-web" prefix="l" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>陕西科技PDS管理服务系统</title>
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/init.css"/> ">
    <link rel="stylesheet" href="<l:asset path="../assets/css/head.css"/> ">
    <link rel="stylesheet" href="<l:asset path="../assets/css/index.css"/> ">
    <link rel="stylesheet" href="<l:asset path="../assets/css/index-ywc.css"/> ">
</head>

<body>

<!--  头部-->
<header class="clearfix">
    <div class="header-logo">
        <img src="../skins/assets/images/header-logo.png">
    </div>
    <div class="header-info">
        <span><a href="../director/configureLinrarry" target="black"><i class="fa fa-cogs"></i>指标配置库</a></span>
        <span><a href="#"><i class="fa fa-user"></i>用户中心</a></span>
        <span><a href="../login"><i class="fa fa-sign-out"></i>注销</a></span>
    </div>
</header>
<!-- 主体 -->
<div class="main-content clearfix">
    <!-- 左侧 -->
    <div class="left-content column">
        <div class="info-group portlet">
            <div class="info-head clearfix portlet-header">
                <div class="i-info pull-left">
                    <img src="../skins/assets/images/info-head.png" alt=""><i>成果产出领域分布</i>
                </div>
                <div class="a-link pull-right">
                    <a class="fa fa-angle-double-down portlet-toggle" href="#"></a>
                    <!-- <a class="fa fa-cog" href=""></a> -->
                    <a class="fa fa-times portlet-del" href=""></a>
                </div>
            </div>
            <div class="info-box portlet-content">
                <!-- echarts -->
                <i class="fa fa-search clicknext"></i>
                <div id="xkly2" class="ech-box"></div>
            </div>
        </div>
        <div class="info-group portlet">
            <div class="info-head clearfix portlet-header">
                <div class="i-info pull-left">
                    <img src="../skins/assets/images/info-head.png" alt=""><i>陕西省项目分布</i>
                </div>
                <div class="a-link pull-right">
                    <a class="fa fa-angle-double-down portlet-toggle" href="#"></a>
                    <!-- <a class="fa fa-cog" href=""></a> -->
                    <a class="fa fa-times portlet-del" href=""></a>
                </div>
            </div>
            <div class="info-box portlet-content">
                <!-- echarts -->
                <div id="sysResult2" class="ech-box"></div>
            </div>
        </div>

        <div class="info-group portlet">
            <div class="info-head clearfix portlet-header">
                <div class="i-info pull-left">
                    <img src="../skins/assets/images/info-head.png" alt=""><i>项目经费投入情况</i>
                </div>
                <div class="a-link pull-right">
                    <a class="fa fa-angle-double-down portlet-toggle" href="#"></a>
                    <!-- <a class="fa fa-cog" href=""></a> -->
                    <a class="fa fa-times portlet-del" href=""></a>
                </div>
            </div>
            <div class="info-box portlet-content">
                <!-- echarts -->
                <div id="areaSpend" class="ech-box"></div>
            </div>
        </div>
    </div>
    <!-- 右侧 -->
    <div class="right-content column">
        <div class="info-group portlet portlet-header">
            <div class="info-head clearfix">
                <div class="i-info pull-left">
                    <img src="../skins/assets/images/info-head.png" alt=""><i>科研机构学科领域分布</i>
                </div>
                <div class="a-link pull-right">
                    <a class="fa fa-angle-double-down portlet-toggle" href="#"></a>
                    <!-- <a class="fa fa-cog" href=""></a> -->
                    <a class="fa fa-times portlet-del" href=""></a>
                </div>
            </div>
            <div class="info-box portlet-content">
                <!-- echarts -->
                <div id="sysArea2" class="ech-box"></div>
            </div>
        </div>
        <div class="info-group portlet">
            <div class="info-head clearfix portlet-header">
                <div class="i-info pull-left">
                    <img src="../skins/assets/images/info-head.png" alt=""><i>人员流动分析</i>
                </div>
                <div class="a-link pull-right">
                    <a class="fa fa-angle-double-down portlet-toggle" href="#"></a>
                    <!-- <a class="fa fa-cog" href=""></a> -->
                    <a class="fa fa-times portlet-del" href=""></a>
                </div>
            </div>
            <div class="info-box portlet-content">
                <!-- echarts -->
                <div id="persons" class="ech-box"></div>
            </div>
        </div>
        <div class="info-group portlet">
            <div class="info-head clearfix portlet-header">
                <div class="i-info pull-left">
                    <img src="../skins/assets/images/info-head.png" alt=""><i>设备总值分析</i>
                </div>
                <div class="a-link pull-right">
                    <a class="fa fa-angle-double-down portlet-toggle" href="#"></a>
                    <!-- <a class="fa fa-cog" href=""></a> -->
                    <a class="fa fa-times portlet-del" href=""></a>
                </div>
            </div>
            <div class="info-box portlet-content">
                <!-- echarts -->
                <div id="sbzz2" class="ech-box"></div>
            </div>
        </div>
    </div>
    <!-- 中间 -->
    <div class="map-content">
        <div class="map-group map-title">
            <div class="info-head clearfix">
                <div class="i-info ">
                    <img src="../skins/assets/images/info-head.png" alt=""><i>创新地图</i>
                </div>
            </div>
            <div class="map-box clearfix">
                <div class="map-right ">
                    <ul class="nav nav-tabs">
                        <li><a href="#nav1" data-toggle="tab" class="btn1">7+1平台类</a></li>
                        <li><a href="#nav2" data-toggle="tab" class="btn1">省级重大专项</a></li>
                    </ul><!--
                            <a href="javascript:;" class="btn1">7+1平台类</a>
                            <a href="javascript:;" class="btn1">省级重大专项</a> -->
                    <div id="myTabContent1" class="tab-content">
                        <div class="platform-group clearfix tab-pane active" id="nav1">
                            <div class="left-platform pull-left"><!-- 
                                <div class="platform-head">7+1平台类</div> -->
                                <div class="platform-list platform-bg1">
                                    <div class="list-title">技术创新平台</div>
                                    <ul class="list-ul">
                                        <li>
                                            <a href="../business/wholeAnalysis" target="black">
                                                <span>重点实验室</span>
                                                <i>180</i>
                                                <img src="../skins/assets/images/up.png" alt="">
                                            </a>
                                        </li>
                                        <li>
                                            <span>临床医学研究中心</span>
                                            <i>180</i>
                                        </li>
                                        <li>
                                            <span>创新药物研究中心 </span>
                                            <i>180</i>
                                            <img src="../skins/assets/images/down.png" alt="">
                                        </li>
                                        <li>
                                            <span>工程技术研究中心</span>
                                            <i>180</i>
                                        </li>
                                        <li>
                                            <span>药物植物科技示范基地</span>
                                            <i>180</i>
                                            <img src="../skins/assets/images/up.png" alt="">
                                        </li>
                                    </ul>
                                </div>

                            </div>
                            <div class="right-platform pull-right">
                                <!-- <div class="platform-head">省级重大专项</div> -->
                                <div class="platform-list platform-bg5">
                                    <div class="list-title">园区基地平台</div>
                                    <ul class="list-ul">
                                        <li>
                                            <span>高新区</span>
                                            <i>13</i>

                                        </li>
                                        <li>
                                            <span>可持续发展实验区 </span>
                                            <i>15</i>
                                            <img src="../skins/assets/images/up.png" alt="">
                                        </li>
                                        <li>
                                            <span>农业科技园区 </span>
                                            <i>16</i>
                                        </li>
                                        <li>
                                            <span>工程技术研究中心</span>
                                            <i>180</i>
                                        </li>
                                        <li>
                                            <span>县城科技创新试验示范站 </span>
                                            <i>12</i>
                                            <img src="../skins/assets/images/up.png" alt="">
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="platform-group tab-pane" id="nav2" style="text-align: center;padding: 30px 0">暂无数据
                        </div>
                    </div>
                    <div class="map-info pull-right">
                        <p>2018年度18小类平台总投入<i class="iColor1">22214</i>万元，较2017年新增<i class="iColor1">1242</i>万元，同比增长<i
                                class="iColor2">5</i>%，自2011年投入排名<i class="iColor2">第一</i>，产出SCI论文<i class="iColor1">1513</i>个，EI论文<i
                                class="iColor1">2112</i>个，获得国家发明奖项共计<i class="iColor1">1242</i>个，对外开放20万以上大型仪器共计<i
                                class="iColor1">12424</i>件，累计仪器服务时间为<i class="iColor">1312</i>小时。</p>
                    </div>
                </div>


                <div class="map-left pull-left">
                    <!-- map-echarts -->
                    <div class="map-echarts">
                        <div id="sxMap2" class="ech-box"></div>
                    </div>

                </div>


            </div>
        </div>
        <div class="info-half clearfix">
            <div class="left-half column">
                <div class="info-group portlet">
                    <div class="info-head clearfix portlet-header">
                        <div class="i-info pull-left">
                            <img src="../skins/assets/images/info-head.png" alt=""><i>管理优化分析</i>
                        </div>
                        <div class="a-link pull-right">
                            <a class="fa fa-angle-double-down portlet-toggle" href="#"></a>
                            <!-- <a class="fa fa-cog" href=""></a> -->
                            <a class="fa fa-times portlet-del" href=""></a>
                        </div>
                    </div>
                    <div class="info-box portlet-content">
                        <!-- echarts -->
                        <div id="sysfb2" class="ech-box"></div>
                    </div>
                </div>
            </div>
            <!-- 底部 -->
            <div class="right-half column">
                <div class="info-group portlet">
                    <div class="info-head clearfix portlet-header">
                        <div class="i-info pull-left">
                            <img src="../skins/assets/images/info-head.png" alt=""><i>人才培养监测分析</i>
                        </div>
                        <div class="a-link pull-right">
                            <a class="fa fa-angle-double-down portlet-toggle" href="#"></a>
                            <!-- <a class="fa fa-cog" href=""></a> -->
                            <a class="fa fa-times portlet-del" href=""></a>
                        </div>
                    </div>
                    <div class="info-box portlet-content">
                        <!-- echarts -->
                        <div id="rcpy2" class="ech-box"></div>
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>
<script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/echarts.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-ui.js"/> "></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/bootstrap.min.js"/> "></script>
<script type="text/javascript" src="<l:asset path="../assets/js/drag.js "/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/shanxi.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/index.js"/>"></script>
<script>

    $('#myTab a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })

    $(function () {
        var map = document.getElementById("sxMap2");
        var sys = document.getElementById("sysfb2");
        var rcpy2 = document.getElementById("rcpy2");
        var sbzz2 = document.getElementById("sbzz2");
        var xkly2 = document.getElementById("xkly2")
        var sysArea2 = document.getElementById("sysArea2");
        var sysResult2 = document.getElementById("sysResult2");
        var areaSpend = document.getElementById("areaSpend");
        var persons = document.getElementById("persons");
        //实验室成果分布
        labResults(sysResult2);
        // 地图1
        sxMap(map);
        //实验室学科领域分布
        ambit(xkly2);
        // 实验室分布
        labDist(sysfb2);
        // 人才培养检测
        cultivation(rcpy2);
        // 设备总值分析
        equipment(sbzz2);
        //实验室区域分布
        geographical(sysArea2);
        // 各区域项目经费投入情况趋势
        labSpend(areaSpend);
        //人员流动
        turnover(persons);
    });


</script>
</body>

</html>
