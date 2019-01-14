<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/tags/loushang-web" prefix="l" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">
    <meta name="renderer" content="webkit">
    <title>陕西科技PDS管理服务系统</title>
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/bootstrap.min.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/swiper.min.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/head.css" />" />
    <link rel="stylesheet" href="<l:asset path="../assets/css/labAnalysis.css"/>" />
    <link rel="stylesheet" href="<l:asset path="../assets/css/wholeAnalysis.css"/> " />
</head>

<body>
    <!--  头部-->
    <header class="clearfix">
        <div class="header-logo">
            <img src="../skins/assets/images/header-logo.png">
        </div>
        <div class="header-info">
            <span>
                <a href="#">
                    <i class="fa fa-user"></i>用户中心</a>
            </span>
            <span>
                <a href="../login">
                    <i class="fa fa-sign-out"></i>注销</a>
            </span>
        </div>
    </header>
     <!-- 二级页面头部下方信息 -->
    <div class="page-info clearfix">
        <div class="page-location">
            <i class="fa fa-location"></i>
            <span>当前位置：</span>
            <i class="fa fa-angle-right"></i>
            <span>首页</span>
            <i class="fa fa-angle-right"></i>
            <span>具体指标查看</span>
        </div>
        <div class="infohead-act1 pull-right">
                    <a href="#" onClick="javascript:history.go(-1);">返回</a>
        </div>
    </div>

    <div class="whanmain-content">
        <div class="lunbo marginBottom20">
            <div class="swiper-container">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <img src="../skins/assets/images/wholeAnalysis/banner1.png" alt="">
                    </div>
                    <div class="swiper-slide">
                        <img src="../skins/assets/images/wholeAnalysis/banner2.png" alt="">
                    </div>
                </div>
            </div>
        </div>
        <!-- 报告生成 -->
        <div class="wholeanalysis-report marginBottom20">
            <!-- 每个模块 -->
                <div class="module border">
                    <div class="module-title">
                        实验室本年度分析报告
                    </div>
                    <div class="wareport-wrap clearfix" >
                        <div class="wareport-con pull-left">
                            本年度实验室共投入资金<i class="col-blue">2000</i>万元，自2013年以来，投入排名<i class="col-red">第一</i>，
                            其中西安市实验室总投入最多，占全省投入的<i class="col-blue">65%</i>，杨凌示范区占总投入<i class="col-blue">1.1%</i>，
                            投入占比较少，实验室内新增科技人才<i class="col-blue">2132</i>名，省内共有院士<i class="col-blue">124</i>名，
                            国家百人计划人员<i class="col-blue">24</i>名，三秦学者<i class="col-blue">134</i>名。在实验室项目中，产出SCI论文<i class="col-blue">122</i>个，
                            EI论文<i class="col-blue">123</i>个，获得国家发明成果奖<i class="col-blue">131</i>项，实验室对外开放20万以上科学仪器共计<i class="col-blue">1213</i>件，
                            累计仪器服务时间为<i class="col-blue">1312</i>小时。
                        </div>
                        <div class="wareport-btn pull-right">
                            <a href="#">报告<br>生成</a>
                        </div>
                    </div>
                </div>
        </div>
        <div class="function-wrap">
            <!-- 每个模块 -->
            <div class="module border">
                <div class="module-title function-title clearfix">
                     功能列表
                     <div class="search-wrap pull-right">
                         <select>
                             <option value="">省重点实验室</option>
                         </select>
                        <select>
                            <option value="">省共建类</option>
                        </select>
                        <a href="#">检索</a>
                     </div>
                </div>
                <div class="function-con">
                    <div class="func-row marginBottom20">
                        <ul class="clearfix">
                            <li class="funcrow-first">
                                <span class="funcrow-pic funcrow-pic1">
                                    <span class="funcrow-text">监测预警</span>
                                </span>
                            </li>
                            <li class="funcrow-module">
                                <!-- 每个模块 -->
                                <div class="module border">
                                    <div class="module-title">
                                         实验室领域数量分布
                                    </div>
                                    <div class="funcrowmodule-con" id="module1">

                                    </div>
                                </div>
                            </li>
                            <li class="funcrow-module">
                                <!-- 每个模块 -->
                                <div class="module border">
                                    <div class="module-title">
                                         实验室领域数量趋势分布
                                    </div>
                                    <div class="funcrowmodule-con" id="module2">

                                    </div>
                                </div>
                            </li>
                            <li class="funcrow-module">
                                <!-- 每个模块 -->
                                <div class="module border">
                                    <div class="module-title">
                                         人才总体分布情况
                                    </div>
                                    <div class="funcrowmodule-con" id="module3">

                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="func-row marginBottom20">
                        <ul class="clearfix">
                            <li class="funcrow-first">
                                <span class="funcrow-pic funcrow-pic2">
                                    <span class="funcrow-text">管理优化</span>
                                </span>
                            </li>
                            <li class="funcrow-module">
                                <!-- 每个模块 -->
                                <div class="module border">
                                    <div class="module-title">
                                         学科投入指标
                                    </div>
                                    <div class="funcrowmodule-con" id="module4">

                                    </div>
                                </div>
                            </li>
                            <li class="funcrow-module">
                                <!-- 每个模块 -->
                                <div class="module border">
                                    <div class="module-title">
                                         区域内投入指标
                                    </div>
                                    <div class="funcrowmodule-con" id="module5">

                                    </div>
                                </div>
                            </li>
                            <li class="funcrow-module">
                                <!-- 每个模块 -->
                                <div class="module border">
                                    <div class="module-title">
                                     学科实验室效率值（学科）
                                    </div>
                                    <div class="funcrowmodule-con" id="module6">

                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="func-row marginBottom20">
                        <ul class="clearfix">
                            <li class="funcrow-first">
                                <span class="funcrow-pic funcrow-pic3">
                                    <span class="funcrow-text">决策支持</span>
                                </span>
                            </li>
                            <li class="funcrow-module">
                                <!-- 每个模块 -->
                                <div class="module border">
                                    <div class="module-title">
                                         实验室数量
                                    </div>
                                    <div class="funcrowmodule-con" id="module7">

                                    </div>
                                </div>
                            </li>
                            <li class="funcrow-module">
                                <!-- 每个模块 -->
                                <div class="module border">
                                    <div class="module-title">
                                         学科发展
                                    </div>
                                    <div class="funcrowmodule-con" id="module8">

                                    </div>
                                </div>
                            </li>
                            <li class="funcrow-module">
                                <!-- 每个模块 -->
                                <div class="module border">
                                    <div class="module-title">
                                         区域学科
                                    </div>
                                    <div class="funcrowmodule-con" id="module9">

                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/echarts.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/swiper.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/wholeAnalysis.js"/>"></script>
<script>
$(function () {
    var mySwiper = new Swiper('.swiper-container', {
        speed:1000,
        autoplay:true,
        loop: true, // 循环模式选项

        // 如果需要分页器
        pagination: {
            el: '.swiper-pagination',
        },

        // 如果需要前进后退按钮
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },

        // 如果需要滚动条
        scrollbar: {
            el: '.swiper-scrollbar',
        },
    })
});

  </script>
</script>
</html>
