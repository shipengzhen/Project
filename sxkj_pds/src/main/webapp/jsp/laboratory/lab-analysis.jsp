<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/tags/loushang-web" prefix="l" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">
    <meta name="renderer" content="webkit">
    <title>陕西科技PDS管理服务系统</title>
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/head.css"/>"/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/labAnalysis.css"/>"/>
</head>

<body>
<!--  头部-->
<header class="clearfix">
    <div class="header-logo">
        <img src="../skins/assets/images/header-logo.png">
    </div>
    <div class="header-info">
        <span><a href="#"><i class="fa fa-user"></i>用户中心</a></span>
        <span><a href="../login"><i class="fa fa-sign-out"></i>注销</a></span>
    </div>
</header>
<div class="main-content">
    <!-- 报告生成 -->
    <div class="lab-report-show border bgcWhite clearfix marginBottom20">
        <div class="lab-report pull-left">
            本年度平台类投入达到
            <i>2000万元</i> ，
            自2013年以来，投入排名<i>第一</i>，
            其中西安市实验室总投入最多，占全省投入的<i>65%</i>，
            杨凌示范区占总投入<i>1.1%</i>，投入占比较少；实验室内新增科技人才<i>2132名</i>，
            省内共有院士<i>124名</i>，国家百人计划人员<i>24名</i>，三秦学者<i>134名</i>。在实验室项目中，
            产出SCI论文<i>122个</i>，EI论文<i>123个</i>，获得国家发明成果奖<i>131项</i>，
            实验室对外开放20万以上科学仪器共计<i>1213件</i>，累计仪器服务时间为<i>1312小时</i>。
        </div>
        <div class="lab-report-btn pull-right">
            <a href="#">报告生成</a>
        </div>
    </div>
    <!-- 实验室成果列表 -->
    <div class="friuts-list marginBottom20">
        <ul class="clearfix">
            <li>
                <div class="item">
                    <div class="item-title">
                        <img src="../skins/assets/images/labAnalysis/labfruits-icon4.png" alt="">实验室分布分析
                    </div>
                    <div class="item-con">
                        陕西省共有实验室
                            <i>180</i>家，<i>25</i>家国家级重点实验室中，包括学科类<i>12</i>家，企业类<i>12</i>家，省部共建<i>12</i>家；<i>155</i>家省级重点实验室中，包括学科类<i>80</i>家，企业类<i>55</i>家，省市共建<i>20</i>家。
                    </div>
                </div>
                <div class="item-show">
                    <a href="../laboratory/platform"><img src="../skins/assets/images/labAnalysis/labfruits-pic4.png"
                                                          alt=""></a>
                </div>
            </li>
            <li>
                <div class="item">
                    <div class="item-title">
                        <img src="../skins/assets/images/labAnalysis/labfruits-icon1.png" alt="">
                        人员投入
                    </div>
                    <div class="item-con">
                        本年度实验室人员投入
                        共计
                        <i>3321</i>
                        人，其中西安市重点实验室人员投入最多，达到
                        <i>2111</i> 人。
                    </div>
                </div>
                <div class="item-show">
                    <a href="../laboratory/personnel"><img src="../skins/assets/images/labAnalysis/labfruits-pic1.png"
                                                           alt=""></a>
                </div>
            </li>
            <li>
                <div class="item">
                    <div class="item-title">
                        <img src="../skins/assets/images/labAnalysis/labfruits-icon2.png" alt=""> 经费投入
                    </div>
                    <div class="item-con">
                        本年度实验室经费投入
                        共计
                        <i>3321</i>
                        万元，较往年相
                        比增长率达到53%，较去年
                        多投入
                        <i>2111</i> 万元。
                    </div>
                </div>
                <div class="item-show">
                    <img src="../skins/assets/images/labAnalysis/labfruits-pic2.png" alt="">
                </div>
            </li>
            <li>
                <div class="item">
                    <div class="item-title">
                        <img src="../skins/assets/images/labAnalysis/labfruits-icon3.png" alt=""> 仪器设备
                    </div>
                    <div class="item-con">
                        本年度实验室仪器设备
                        新增
                        <i>3321</i>
                        ，较往年相
                        比增长率达到53%，较去年
                        相比新增
                        <i>123</i> 件。
                    </div>
                </div>
                <div class="item-show">
                    <img src="../skins/assets/images/labAnalysis/labfruits-pic3.png" alt="">
                </div>
            </li>
            <li>
                <div class="item">
                    <div class="item-title">
                        <img src="../skins/assets/images/labAnalysis/labfruits-icon5.png" alt=""> 成果交易额
                    </div>
                    <div class="item-con">
                        本年度实验室成果交
                        易额
                        <i>3321</i>
                        万元，同比增
                        长23%，较去年新增
                        <i>1212</i> 万元。
                    </div>
                </div>
                <div class="item-show">
                    <img src="../skins/assets/images/labAnalysis/labfruits-pic5.png" alt="">
                </div>
            </li>
        </ul>
    </div>
    <!-- 搜索条 -->
    <div class="search-wrap marginBottom20 border">
        <select id="lab1">
            <option>请选择</option>
            <option value="laba">国家类</option>
            <option value="labb">省级</option>
        </select>
        <select id="val" class="sel">
        </select>
    </div>
    <!-- 搜索内容 -->
    <div class="search-con clearfix">
        <!-- 每一列 -->
        <div class="col pull-left">
            <div class="col-title">
                <img src="../skins/assets/images/labAnalysis/searchcol-icon1.png" alt="">
                监测预警
            </div>
            <!-- 每个模块 -->
            <div class="module border">
                <div class="module-title">
                    实验室领域数量分布
                </div>
                <div class="module-con" id="module1">

                </div>
            </div>
            <!-- 每个模块 -->
            <div class="module border">
                <div class="module-title">
                    实验室领域数量趋势分布
                </div>
                <div class="module-con" id="module2">

                </div>
            </div>
            <!-- 每个模块 -->
            <div class="module border">
                <div class="module-title">
                    人才总体分布情况
                </div>
                <div class="module-con" id="module3">

                </div>
            </div>
        </div>
        <!-- 每一列 -->
        <div class="col pull-left">
            <div class="col-title">
                <img src="../skins/assets/images/labAnalysis/searchcol-icon2.png" alt="">管理优化
            </div>
            <!-- 每个模块 -->
            <div class="module border">
                <div class="module-title">
                    学科投入指标
                </div>
                <div class="module-con" id="module4">

                </div>
            </div>
            <!-- 每个模块 -->
            <div class="module border">
                <div class="module-title">
                    区域内投入指标
                </div>
                <div class="module-con" id="module5">

                </div>
            </div>
            <!-- 每个模块 -->
            <div class="module border">
                <div class="module-title">
                    学科实验室效率值（学科）
                </div>
                <div class="module-con" id="module6">

                </div>
            </div>
        </div>
        <!-- 每一列 -->
        <div class="col pull-right">
            <div class="col-title">
                <img src="../skins/assets/images/labAnalysis/searchcol-icon3.png" alt=""> 决策支持
            </div>
            <!-- 每个模块 -->
            <div class="module border">
                <div class="module-title">
                    实验室数量
                </div>
                <div class="module-con" id="module7">

                </div>
            </div>
            <!-- 每个模块 -->
            <div class="module border">
                <div class="module-title">
                    学科发展
                </div>
                <div class="module-con" id="module8">

                </div>
            </div>
            <!-- 每个模块 -->
            <div class="module border">
                <div class="module-title">
                    区域学科
                </div>
                <div class="module-con" id="module9">

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
<script type="text/javascript" src="<l:asset path="../assets/js/lab-analysis.js"/>"></script>
<script type="text/javascript">
    var select = document.getElementById("lab1");
    select.onchange = function () {
        var selvalue = select.value;
        var val = document.getElementById("val");
        switch (selvalue) {
            case "laba" :
                val.innerHTML = "<option>学科类</option><option>企业类</option><option>省部共建类</option>";
                break;
            case "labb" :
                val.innerHTML = "<option>学科类</option><option>企业类</option><option>省市共建类</option>";
                break;
            // case "wuguo" : val.innerHTML="<option>孙权</option><option>周瑜</option>";break;
            default :
                alert("erro");
        }
    };
</script>
</html>
