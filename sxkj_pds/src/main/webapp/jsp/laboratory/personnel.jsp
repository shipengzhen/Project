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
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/bootstrap.min.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/lab_common.css"/> " />
</head>
<body>
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
        <span>实验室分析</span>
        <i class="fa fa-angle-right"></i>
        <span>陕西省各地市人员投入情况分析</span>
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

    <div class="content clearfix">

<!-- 左侧导航 -->
    <div class="nav-left pull-left">
        <div class="nav">
            <div class="nav-top">
                <img src="../skins/assets/images/nav-pos3.png">
                地市
            </div>
            <div class="nav-list">
                <ul>
                    <li class="menu total">
                        <a href="#" >
                        <i class="fa fa-cube"></i>
                        全部
                        </a>
                    </li>
                    <li class="menu active">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        西安
                        </a>
                    </li>
                    <li class="menu">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        铜川
                        </a>
                    </li>

                    <li class="menu">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        宝鸡
                        </a>
                    </li>

                    <li class="menu">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        咸阳
                        </a>
                    </li>

                    <li class="menu">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        渭南
                        </a>
                    </li>
                    <li class="menu">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        汉中
                        </a>
                    </li>
                    <li class="menu">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        延安</a>
                    </li>
                    <li class="menu">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        商洛</a>
                    </li>
                    <li class="menu">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        安康</a>
                    </li>
                    <li class="menu">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        榆林</a>
                    </li>
                    <li class="menu">
                        <a href="#">
                        <i class="fa fa-map-marker"></i>
                        杨凌</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>   
<!-- 右侧内容 -->
    <div class="content-right pull-right">
       <div class="content-list">
           <div class="list-top">
               <img src="../skins/assets/images/list-nav.png">
               <span>陕西省各地市人员投入情况分析</span>
               <div class="infohead-act pull-right">
                    <a href="#" onClick="javascript:history.back(-1);">返回</a>
                </div>
           </div>
           <div class="list-chart">
               <div class="diagram" id="personnel"></div>
           </div>
       </div>
    </div>


    </div>

    <!-- footer -->
    <div class="footer">
        <span>版权所有：陕西省科学技术厅   运行维护：陕西省科技资源统筹中心</br>陕ICP备05002100号-6</span>
    </div>
    
</body>



<!-- <script src="assets/js/jquery-1.4.2.min.js"></script> -->
<script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/echarts.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/main.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/echarts.js"/>"></script>
<script>
    $(function(){
        renderlabPersonCharts();
    })
</script>
</html>