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
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/bootstrap.min.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/head.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/monitor.css"/>"/>
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
            <span>管服系统</span>
            <i class="fa fa-angle-right"></i>
            <span>实验室分析</span>
            <i class="fa fa-angle-right"></i>
            <span>实验室详情</span>
        </div>
        <div class="infohead-act1 pull-right">
             <a href="../laboratory/index">返回</a>
        </div>
    </div>
    <div class="labinfo-content">
        <!-- 实验室基本信息 -->
        <div class="info-group marginBottom10">
            <div class="info-head">
                <img src="../skins/assets/images/monitorAlert/icon-1.png" alt="">
                <i>实验室基本信息</i>
                <div class="infohead-act pull-right">
                    <a href="#">信息查看</a>
                </div>
            </div>

            <div class="info-content clearfix">
                <div class="labdetail-wrap clearfix">
                    <div class="lab-pic pull-left">
                        <img src="../skins/assets/images/monitorAlert/lab-pic.png" alt="">
                    </div>
                    <div class="lab-info lab-nes pull-left">
                        <ul class="clearfix">
                            <li class="half-len bgcgrey">
                                <label for="">实验室名称：</label>
                                <span>陕西省石油精细化学品重点实验室</span>
                            </li>
                            <li class="half-len bgcgrey">
                                <label for="">实验室地址：</label>
                                <span>陕西省西安市西延路61号</span>
                            </li>
                            <li class="half-len bgcblue">
                                <label for="">实验室所在区域：</label>
                                <span>陕西省西安市</span>
                            </li>
                            <li class="half-len bgcblue">
                                <label for="">批准时间：</label>
                                <span>2014年1月1号</span>
                            </li>
                            <li class="half-len bgcgrey">
                                <label for="">验收时间：</label>
                                <span>2014年3月1号</span>
                            </li>
                            <li class="half-len bgcgrey">
                                <label for="">实验室主任姓名：</label>
                                <span>胡广发</span>
                            </li>
                            <li class="half-len bgcblue">
                                <label for="">联系人名称：</label>
                                <span>王前进</span>
                            </li>
                            <li class="half-len bgcblue">
                                <label for="">主管部门：</label>
                                <span>陕西省科技厅</span>
                            </li>
                            <li class="half-len bgcgrey">
                                <label for="">依托单位名称：</label>
                                <span>陕西延安石油（集团）有责任公司</span>
                            </li>
                            <li class="half-len bgcgrey">
                                <label for="">学科领域：</label>
                                <span>化学</span>
                            </li>

                        </ul>
                        <ul>
                            <li class="whole-len bgcblue">
                                <label for="">研究方向：</label>
                                <span>（1）油田化学及新型绿色反应技术研究（2）油田采输防护技术（3）石油化工新材料研究（1）油田化学及新型绿色反应技术研究（2）油田采输防护技术（3）石油化工新材料研究</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- 预警分析 -->
        <div class="info-group marginBottom10">
            <div class="alert-anlysis">
                <label for="">
                    <img src="../skins/assets/images/monitorAlert/alert.png" alt="">
                    预警分析:</label>
                <span>该实验室本年
                    <i>人员流动率偏高</i>，项目承担较往年相比有重大提升，人才培养状况较为良好，
                    <i>成果较往年相比产出较少。</i>
                </span>
            </div>

        </div>

        <div class="info-group marginBottom10">
            <div class="info-head clearfix">
                <img src="../skins/assets/images/monitorAlert/icon-2.png" alt="">
                <i>学科投入产出指标</i>
            </div>
            <div class="info-content clearfix">
                <div class="left-pannel pull-left">
                    <div class="num-asc marginBottom10 border">
                        <ul class="clearfix">
                            <li class="bgclightgrey">
                                <label for="">固定研究人员数:</label>
                                <span>8</span>
                                <i class="fa fa-arrow-down"></i>
                            </li>
                            <li class="bgclightgrey">
                                <label for="">固定研究人员:</label>
                                <span>8</span>
                                <i class="fa fa-arrow-down"></i>
                            </li>
                            <li class="bgclightgrey">
                                <label for="">技术人员:</label>
                                <span>9</span>
                                <i class="fa fa-arrow-up"></i>
                            </li>
                            <li>
                                <label for="">研究生培养总数:</label>
                                <span>8</span>
                                <i class="fa fa-arrow-down"></i>
                            </li>
                            <li >
                                <label for="">项目实到经费总额:</label>
                                <span>8</span>
                                <i class="fa fa-arrow-down"></i>
                            </li>
                            <li >
                                <label for="">仪器设备总值:</label>
                                <span>8</span>
                                <i class="fa fa-arrow-down"></i>
                            </li>
                            <li class="bgclightgrey">
                                <label for="">获奖成果总数:</label>
                                <span>9</span>
                                <i class="fa fa-arrow-up"></i>
                            </li>
                            <li class="bgclightgrey">
                                <label for="">论文总数:</label>
                                <span>8</span>
                                <i class="fa fa-arrow-down"></i>
                            </li>
                            <li class="bgclightgrey">
                                <label for="">发明专利授权总数:</label>
                                <span>8</span>
                                <i class="fa fa-arrow-down"></i>
                            </li>
                            <li >
                                <label for="">实验室面积:</label>
                                <span>8</span>
                                <i class="fa fa-arrow-down"></i>
                            </li>
                            <li>
                                <label for="">仪器共享:</label>
                                <span>9</span>
                                <i class="fa fa-arrow-up"></i>
                            </li>
                        </ul>
                    </div>
                    <div class="wholelab-charts-wrap pull-left border">
                        <div class="lab-charts-title">人员流动情况</div>
                        <div id="person-flow">

                        </div>
                    </div>
                </div>
                <div class="right-pannel pull-right">
                    <div class="wholelab-charts-wrap pull-left border marginBottom10">
                        <div class="lab-charts-title">本年度信息填报完成情况</div>
                        <div id="info-fill">

                        </div>
                    </div>
                    <div class="wholelab-charts-wrap pull-left border">
                        <div class="lab-charts-title">人员年龄占比</div>
                        <div id="person-age">

                        </div>
                    </div>
                </div>

            </div>

            <!-- 项目检测图表 -->
            <div class="warn-wrap marginTop10 clearfix border padding">
                <div class="labproject-tab  ">
                    <ul class=clearfix>
                        <li>
                            <span class="labproject-pic">
                                <img src="../skins/assets/images/monitorAlert/03.png" alt="">
                            </span>
                            项目承担
                        </li>
                        <li>
                            <span class="labproject-pic">
                                <img src="../skins/assets/images/monitorAlert/04.png" alt="">
                            </span>
                            项目经费
                        </li>
                        <li>
                            <span class="labproject-pic">
                                <img src="../skins/assets/images/monitorAlert/05.png" alt="">
                            </span>
                            人才培养
                        </li>
                    </ul>
                </div>
                <div class="lab-charts-wrap pull-left border marginTop10">
                    <div class="lab-charts-title"> 历年承担项目、项目经费、人才培养情况</div>
                    <div id="protal-info">

                    </div>
                </div>
                <div class="lab-charts-wrap pull-right border marginTop10">
                    <div class="lab-charts-title">历年获得研究成果情况</div>
                    <div id="fruit-info">

                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/echarts.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/echarts-liquidfill.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/labMonitor.js"/>"></script>

</html>
