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
    <link rel="stylesheet" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="<l:asset path=" ../assets/css/common/jquery-ui.min.css"/>" />
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/init.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/head.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/index.css"/> ">
</head>

<body>

    <!--  头部-->
    <header class="clearfix">
            <div class="header-logo">
              <img src="../skins/assets/images/header-logo.png">
            </div>
            <div class="header-info">
                <span><a href="../director/director_analysis" target="black"><i class="fa fa-cogs"></i>具体分析</a></span>
              <span><a href="../director/configureLinrarry" target="black"><i class="fa fa-cogs"></i>指标配置库</a></span>
              <span><a href="#"><i class="fa fa-user"></i>用户中心</a></span>
              <span><a href="../login"><i class="fa fa-sign-out"></i>注销</a></span>
            </div>
          </header>
    <!-- 主体 -->
    <div class="main-content clearfix">
        <!-- 左侧 -->
        <div class="left-content column" id="sortable1">
        <div class="info-group portlet">
                <div class="info-head clearfix portlet-header">
                    <div class="i-info pull-left">
                        <img src="../skins/assets/images/info-head.png" alt=""><i>成果产出领域分布</i>
                    </div>
                    <div class="a-link pull-right">
                        <a class="fa fa-angle-double-down portlet-toggle" href="javascript:;"></a>
                        <!-- <a class="fa fa-cog" href=""></a> -->
                        <a class="fa fa-times portlet-del" href="javascript:;"></a>
                    </div>
                </div>
                <div class="info-box portlet-content">
                    <!-- echarts -->
                    <i class="fa fa-search clicknext"></i>
                    <div id="xkly" class="ech-box"></div>
                </div>
            </div>
            <div class="info-group portlet">
                <div class="info-head clearfix portlet-header">
                    <div class="i-info pull-left">
                        <img src="../skins/assets/images/info-head.png" alt=""><i>陕西省项目分布</i>
                    </div>
                    <div class="a-link pull-right">
                        <a class="fa fa-angle-double-down portlet-toggle" href="javascript:;"></a>
                        <!-- <a class="fa fa-cog" href=""></a> -->
                        <a class="fa fa-times portlet-del" href="javascript:;" ></a>
                    </div>
                </div>
                <div class="info-box portlet-content">
                    <!-- echarts -->
                    <div id="sysResult" class="ech-box"></div>
                </div>
            </div>
            
            <div class="info-group portlet">
                <div class="info-head clearfix portlet-header">
                    <div class="i-info pull-left">
                        <img src="../skins/assets/images/info-head.png" alt=""><i>管理优化分析</i>
                    </div>
                    <div class="a-link pull-right">
                        <a class="fa fa-angle-double-down portlet-toggle" href="javascript:;"></a>
                        <!-- <a class="fa fa-cog" href=""></a> -->
                        <a class="fa fa-times portlet-del" href="javascript:;"></a>
                    </div>
                </div>
                <div class="info-box portlet-content">
                    <!-- echarts -->
                    <div id="labAlarm" class="ech-box"></div>
                </div>
            </div>
        </div>
        <!-- 右侧 -->
        <div class="right-content column" id="sortable2">
            <div class="info-group portlet">
                <div class="info-head clearfix portlet-header">
                    <div class="i-info pull-left">
                        <img src="../skins/assets/images/info-head.png" alt=""><i>经费投入占比分布</i>
                    </div>
                    <div class="a-link pull-right">
                        <a class="fa fa-angle-double-down portlet-toggle" href="javascript:;"></a>
                        <!-- <a class="fa fa-cog" href=""></a> -->
                        <a class="fa fa-times portlet-del" href="javascript:;"></a>
                    </div>
                </div>
                <div class="info-box portlet-content">
                    <!-- echarts -->
                    <div id="sysArea" class="ech-box"></div>
                </div>
            </div>
            <div class="info-group portlet">
                <div class="info-head clearfix portlet-header">
                    <div class="i-info pull-left">
                        <img src="../skins/assets/images/info-head.png" alt=""><i>人才分布情况</i>
                    </div>
                    <div class="a-link pull-right">
                        <a class="fa fa-angle-double-down portlet-toggle" href="javascript:;"></a>
                        <!-- <a class="fa fa-cog" href=""></a> -->
                        <a class="fa fa-times portlet-del" href="javascript:;"></a>
                    </div>
                </div>
                <div class="info-box portlet-content">
                    <!-- echarts -->
                    <div id="projectArea" class="ech-box"></div>
                </div>
            </div>
            <div class="info-group portlet">
                <div class="info-head clearfix portlet-header">
                    <div class="i-info pull-left">
                        <img src="../skins/assets/images/info-head.png" alt=""><i>设备总值分析</i>
                    </div>
                    <div class="a-link pull-right">
                        <a class="fa fa-angle-double-down portlet-toggle" href="javascript:;"></a>
                        <!-- <a class="fa fa-cog" href=""></a> -->
                        <a class="fa fa-times portlet-del" href="javascript:;"></a>
                    </div>
                </div>
                <div class="info-box portlet-content">
                    <!-- echarts -->
                    <div id="sbzz" class="ech-box"></div>
                </div>
            </div>
        </div>
        <!-- 中间 -->
        <div class="map-content ">
            <div class="map-group">
                <div class="info-head clearfix">
                    <div class="i-info ">
                        <img src="../skins/assets/images/info-head.png" alt=""><i>创新地图</i>
                    </div>
                </div>
                <div class="map-box clearfix">
                    <div class="map-right pull-right">
                            <ul class="nav nav-tabs">
                                <li><a href="#nav1" data-toggle="tab" class="btn1">7+1平台类</a></li>
                                <li><a href="#nav2" data-toggle="tab" class="btn1">省级重大专项</a></li>
                            </ul>


                    <div id="myTabContent1" class="tab-content">
                        <div class="platform-group clearfix tab-pane active" id="nav1">

                            <!-- <div class="">7+1平台类</div>
                            <div class="">省级重大专项</div> -->
                            <div class="left-platform pull-left">
                                <div class="platform-list platform-bg1">
                                    <div class="list-title">技术创新平台</div>
                                    <ul class="list-ul">

                                        <li>
                                            <a href="../laboratory/lab_analysis" target="black">
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
                                <div class="platform-list platform-bg2">
                                    <div class="list-title">资源共享平台</div>
                                    <ul class="list-ul">
                                        <li>
                                            <span>科技资源开放共享平台</span>
                                            <i>180</i>
                                            <img src="../skins/assets/images/up.png" alt="">
                                        </li>
                                    </ul>
                                </div>
                                <div class="platform-list platform-bg3">
                                    <div class="list-title">创新创业平台</div>
                                    <ul class="list-ul">
                                        <li class="br-li">
                                            <span>科技企业孵化器、<br>众创空间</span>
                                            <i>13</i>
                                            <img src="../skins/assets/images/down.png" alt="">
                                        </li>
                                        <li>
                                            <span>星创天地 </span>
                                            <i>180</i>
                                        </li>
                                    </ul>
                                </div>
                                <div class="platform-list platform-bg4">
                                    <div class="list-title">技术转移平台</div>
                                    <ul class="list-ul">
                                        <li>
                                            <span>校企共建新型研发平台 </span>
                                            <i>17</i>
                                            <img src="../skins/assets/images/down.png" alt="">
                                        </li>
                                        <li>
                                            <span>技术转移示范机构</span>
                                            <i>15</i>
                                            <img src="../skins/assets/images/up.png" alt="">
                                        </li>
                                        <li>
                                            <span>技术合同认定登记机构 </span>
                                            <i>15</i>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="right-platform pull-right">
                                
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
                                <div class="platform-list platform-bg6">
                                    <div class="list-title">创新服务平台</div>
                                    <ul class="list-ul">
                                        <li>
                                            <span>省软科学研究基地 </span>
                                            <i>16</i>
                                            <img src="../skins/assets/images/down.png" alt="">
                                        </li>
                                    </ul>
                                </div>
                                <div class="platform-list platform-bg7">
                                    <div class="list-title">科技金融平台</div>
                                    <ul class="list-ul">
                                        <li class="br-li">
                                            <span>科技成果转化引导<br>
                                                基金管理服务平台 </span>
                                            <i>180</i>
                                            <img src="../skins/assets/images/up.png" alt="">
                                        </li>
                                        <li class="noneli"></li>
                                    </ul>
                                </div>
                                <div class="platform-list platform-bg8">
                                    <div class="list-title">科技合作平台</div>
                                    <ul class="list-ul">

                                        <li>
                                            <span>国际科技合作基地 </span>
                                            <i>14</i>
                                            <img src="../skins/assets/images/up.png" alt="">
                                        </li>
                                        <li class="noneli"></li>
                                        <li class="noneli"></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="platform-group tab-pane" id="nav2" style="text-align: center;padding: 30px 0">暂无数据</div>
                    </div>
                    </div>
                    <div class="map-left">
                        <!-- map-echarts -->
                        <div class="map-echarts">
                            <div id="sxMap" class="ech-box"></div>
                        </div>
                        <div class="map-info" style="width: 37%;position: absolute;left: 16px;bottom: 20px;">
                            <p>2018年度18小类平台总投入<i class="iColor1">22214</i>万元，较2017年新增<i class="iColor1">1242</i>万元，同比增长<i
                                    class="iColor2">5</i>%，自2011年投入排名<i class="iColor2">第一</i>，产出SCI论文<i class="iColor1">1513</i>个，EI论文<i
                                    class="iColor1">2112</i>个，获得国家发明奖项共计<i class="iColor1">1242</i>个，对外开放20万以上大型仪器共计<i
                                    class="iColor1">12424</i>件，累计仪器服务时间为<i class="iColor">1312</i>小时。</p>
                        </div>
                    </div>
                    
                </div>
            </div>
            <div class="info-half clearfix ">
                <div class="left-half column" id="sortable3">
                    <div class="info-group portlet">
                        <div class="info-head clearfix portlet-header">
                            <div class="i-info pull-left">
                                <img src="../skins/assets/images/info-head.png" alt=""><i>监测预警分析</i>
                            </div>
                            <div class="a-link pull-right">
                                <a class="fa fa-angle-double-down" href="#"></a>
                                <!-- <a class="fa fa-cog" href=""></a> -->
                                <a class="fa fa-times" href=""></a>
                            </div>
                        </div>
                        <div class="info-box portlet-content">
                            <!-- echarts -->
                            <div id="sysfb" class="ech-box"></div>
                        </div>
                    </div>
                </div>
                <!-- 底部 -->
                <div class="right-half column" id="sortable4">
                    <div class="info-group portlet">
                        <div class="info-head clearfix portlet-header">
                            <div class="i-info pull-left ">
                                <img src="../skins/assets/images/info-head.png" alt=""><i>人才培养监测分析</i>
                            </div>
                            <div class="a-link pull-right">
                                <a class="fa fa-angle-double-down" href="#"></a>
                                <!-- <a class="fa fa-cog" href=""></a> -->
                                <a class="fa fa-times" href=""></a>
                            </div>
                        </div>
                        <div class="info-box portlet-content">
                            <!-- echarts -->
                            <div id="rcpy" class="ech-box"></div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-1.9.1.min.js"/>"></script>
    <script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-ui.js"/>"></script>
    <script type="text/javascript" src="<l:asset path="../assets/js/drag.js"/>"></script>
    <script type="text/javascript" src="<l:asset path="../assets/js/common/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<l:asset path="../assets/js/common/echarts.min.js"/>"></script>
    <script type="text/javascript" src="<l:asset path="../assets/js/shanxi.js"/>"></script>
    <script type="text/javascript" src="<l:asset path="../assets/js/index.js"/>"></script>
    <script>

$('#myTab a').click(function (e) {
  e.preventDefault()
  $(this).tab('show')
});


        $(function () {
            var map =document.getElementById("sxMap");
            var sys =document.getElementById("sysfb");
            var rcpy = document.getElementById("rcpy");
            var sbzz = document.getElementById("sbzz");
            var xkly =document.getElementById("xkly")
            var sysArea =document.getElementById("sysArea");
            var sysResult =document.getElementById("sysResult");
            var labAlarm = document.getElementById("labAlarm");
            var pjArea = document.getElementById("projectArea");

            //实验室成果分布
            labResults(sysResult);
            // 地图
            sxMap(map);
            //实验室学科领域分布
            ambit(xkly);
            // 实验室分布
            labDist(sysfb);
            // 人才培养检测
            cultivation(rcpy);
            // 设备总值分析
            equipment(sbzz);
            //实验室区域分布
            geographical(sysArea);
            //实验室优化预警
            labAlarming(labAlarm);
            //项目领域
            expertise(pjArea);
          });
    </script>
</body>

</html>
