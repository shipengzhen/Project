<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/tags/loushang-web" prefix="l" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">
    <meta name="renderer" content="webkit">
    <title>陕西科技PDS管理服务系统</title>
  <link rel="stylesheet" href="<l:asset path="../assets/css/common/bootstrap.min.css"/> " />
  <link rel="stylesheet" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css"/>"/>
  <link rel="stylesheet" href="<l:asset path="../assets/css/head.css"/>"/>
  <link rel="stylesheet" href="<l:asset path="../assets/css/configlibrary.css"/>"/>
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
    <!-- 二级页面头部下方信息 -->
    <div class="page-info clearfix">
      <div class="page-location">
        <i class="fa fa-location"></i>
        <span>指标配置库</span>
      </div>
      <div class="page-userinfo">
        <!-- <span class="user-tips">
          <i class="fa fa-bell"></i>
          <b>8</b>
        </span>
        <span class="user-msg">
          <i class="fa fa-envelope"></i>
          <b>8</b>
        </span>
        <span class="user-todolist">
          <i class="fa fa-list"></i>
          <b>8</b>
        </span> -->
        <span class="user-username">
          <a><img src="../skins/assets/images/userinfo-pic.png">系统管理员<i class="fa fa-caret-down"></i></a>
        </span>
      </div>
    </div>
    <div class="config-wrap">
      <div class="config-con">
        <div class="config-hd"><span>指标配置库</span></div>
        <div class="config-bd clearfix">
          <div class="config-list-item">
            <ul>
              <li class="sel1 active">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li class="sel1 active">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li class="sel1 active">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li class="sel1 active">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>

              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
            </ul>
          </div>
          <div class="config-list-item">
            <ul>
              <li class="sel1 active">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li class="sel1 active">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li class="sel1 active">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li class="sel1 active">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
              <li data-toggle="modal" data-target="#myModal">
                重点实验室学科领域分布监测
                <span></span>
              </li>
            </ul>
          </div>
          <div class="config-list-intro">
            <div class="config-intro-hd">指标说明</div>
            <div class="config-intro-info">
              <p>
                从区域和学科两个视角探究，构建学科重点实验室高质量发展指数-区域类（KLHQI_D）、学科重点实验室高质量发展指数-学科类（KLHQI_S）和学科重点实验室高质量发展指数-区域学科交差类（KLHQI_DS），形成学科类重点实验室创新驱动发展情况的晴雨表。
              </p>
            </div>
            <div class="config-intro-charts" id="config-intro-charts">

            </div>
          </div>

        </div>
        <div class="savebtn1"><a href="../director/configureLinrarry">保存</a></div>
      </div>
    </div>




<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
  <div class="modal-dialog" style="width: 350px; margin: 0 auto;margin-top: 200px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        <h4 class="modal-title" id="myModalLabel">
          温馨提示
        </h4>
      </div>
      <div class="modal-body" style="text-align: center; ">
        最多可选择8个指标，目前已选择8个。
      </div>
      <div class="modal-footer" style="text-align: center;">
        <button type="button" class="btn btn-default" data-dismiss="modal">确定
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal -->
</div>




</body>

<script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/echarts.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/bootstrap.min.js"/>"></script>
<script>
  $(function(){
    $(".sel1").click(function(){
      $(this).toggleClass("active");
      renderLineBarCharts();
    })
    renderLineBarCharts();
  })

  //柱状折线图
  function renderLineBarCharts(){
    var myChart = echarts.init(document.getElementById('config-intro-charts'));
    var category = []; //当前前12个月每月月份
    var lineData = []; //扶贫收益
    var barData = []; //扶贫企业
    var dottedBase = new Date();
    dottedBase.setMonth(dottedBase.getMonth() - 12);
    dottedBase.setDate(dottedBase.getDate() - dottedBase.getDate() + 1);
    var date = dottedBase;
    for (var i = 0; i < 12; i++) {
        date.setMonth(date.getMonth() + 1);
        category.push([date.getFullYear(), date.getMonth() + 1,
            date.getDate()
        ].join('-'));
        var b = Math.random() * 20;
        var d = Math.random() * 20;
        var h = d + b;
        barData.push(b.toFixed(2));
        lineData.push(h.toFixed(2));
    }


    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow',
                label: {
                    show: true,
                    backgroundColor: '#333'
                }
            },
            formatter: '{a0}: {c0}<br />{a1}: {c1}'
        },
        legend: {
            data: ['line', 'bar'],
            textStyle: {
                color: '#ccc'
            }
        },
        xAxis: {
            data: category,
            axisLine: {
                lineStyle: {
                    color: '#ccc'
                }
            }
        },
        yAxis: {
            splitLine: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#ccc'
                }
            }
        },
        series: [{
            name: 'line',
            type: 'line',
            smooth: true,
            showAllSymbol: true,
            symbol: 'emptyCircle',
            symbolSize: 15,
            data: lineData
        }, {
            name: 'bar',
            type: 'bar',
            barWidth: 10,
            itemStyle: {
                normal: {
                    barBorderRadius: 5,
                    color: new echarts.graphic.LinearGradient(0,
                        0, 0, 1, [{
                            offset: 0,
                            color: '#14c8d4'
                        }, {
                            offset: 1,
                            color: '#43eec6'
                        }])
                }
            },
            data: barData
        }, {
            name: 'line',
            type: 'bar',
            barGap: '-100%',
            barWidth: 10,
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0,
                        0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(20,200,212,0.5)'
                        }, {
                            offset: 0.2,
                            color: 'rgba(20,200,212,0.2)'
                        }, {
                            offset: 1,
                            color: 'rgba(20,200,212,0)'
                        }])
                }
            },
            z: -12,
            data: lineData
        }, {
            name: 'dotted',
            type: 'pictorialBar',
            symbol: 'rect',
            itemStyle: {
                normal: {
                    color: '#0f375f'
                }
            },
            symbolRepeat: true,
            symbolSize: [12, 4],
            symbolMargin: 1,
            z: -10,
            data: lineData
        }]
    };
    myChart.setOption(option);
  }
</script>
</html>
