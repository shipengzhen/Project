<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/tags/loushang-web" prefix="l" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>陕西科技PDS管理服务系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link rel="stylesheet" type="text/css" href="<l:asset path="../assets/css/common/normalize.css"  />"/>
    <link rel="stylesheet" type="text/css" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css" />"/>
    <link rel="stylesheet" type="text/css" href="<l:asset path="../assets/css/common/monui.css"   />"/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/head.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<l:asset path="../assets/css/map.css"   />"/>
    <script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-1.9.1.min.js"/>"></script>
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=758k4HtAQ4309tjiUVjC9TH5ObKMmL0N"></script>
    <script type="text/javascript" src="<l:asset path="../assets/js/map/jquery.nicescroll.min.js"/>"></script>
    <script type="text/javascript" src="<l:asset path="../assets/js/map/BMapLib_AreaRestriction.js"/>"></script>
    <script type="text/javascript" src="<l:asset path="../assets/js/map/mapdata.js"/>"></script>
    <script type="text/javascript" src="<l:asset path="../assets/js/map/map.js"/>"></script>

</head>
<body class="theme-blue">
<div class="main-body">
    <section id="main-content">
        <header class="clearfix">
            <div class="header-logo">
                <img src="../skins/assets/images/header-logo.png">
            </div>
            <div class="header-info">
                <span><a href="#"><i class="fa fa-user"></i>用户中心</a></span>
                <span><a href="../login"><i class="fa fa-sign-out"></i>注销</a></span>
            </div>
        </header>
        <div class="page-info clearfix">
            <div class="page-location">
                <i class="fa fa-location"></i>
                <span>创新地图</span>
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
        <div class="main">
            <div class="sidebar map_l bg">
                <form class="map_form clearfix">
                    <label for="search" class="hide"></label>
                    <input type="text" name="search" placeholder="请输入关键字">
                    <button><i class="fa fa-search" aria-hidden="true"></i></button>
                </form>
                <div class="m-tab map_tab_l">
                    <div class="tab-header zj_tab_tit">

                        <ul>
                            <li class="active">
                                <i></i>
                                <span>重点实验室</span>
                                <b></b>
                            </li>
                            <li>
                                <i></i>
                                <span>高新区</span>
                                <b></b>
                            </li>
                            <li>
                                <i></i>
                                <span>孵化器</span>
                                <b></b>
                            </li>
                            <li>
                                <i></i>
                                <span>众创空间</span>
                                <b></b>
                            </li>
                        </ul>
                    </div>
                    <div class="tab-body zj_tab_con">
                        <ul>
                            <li id="paltList">
                                <div class="sx-mapsearch">
                                    <ul>
                                        <li class="clearfix">
                                            <span>地区</span>
                                            <select class="m-select areaSelect">
                                                <option value="陕西省">不限</option>
                                                <option value="西安市">西安市</option>
                                                <option value="宝鸡市">宝鸡市</option>
                                                <option value="咸阳市">咸阳市</option>
                                                <option value="铜川市">铜川市</option>
                                                <option value="渭南市">渭南市</option>
                                                <option value="延安市">延安市</option>
                                                <option value="榆林市">榆林市</option>
                                                <option value="汉中市">汉中市</option>
                                                <option value="安康市">安康市</option>
                                                <option value="商洛市">商洛市</option>
                                                <option value="杨凌示范区">杨凌示范区</option>
                                            </select>
                                        </li>
                                    </ul>
                                </div>
                                <div class="map_tabcon map-result">
                                    <div class="map_tabcon_con_bot result-list">
                                        <ul niceScroll>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li id="servList" style="display:none">
                                <div class="sx-mapsearch">
                                    <ul>
                                        <li>
                                            <span>地区</span>
                                            <select class="m-select areaSelect">
                                                <option value="山东省">不限</option>
                                                <option value="济南市">济南市</option>
                                                <option value="青岛市">青岛市</option>
                                                <option value="淄博市">淄博市</option>
                                                <option value="枣庄市">枣庄市</option>
                                                <option value="东营市">东营市</option>
                                                <option value="烟台市">烟台市</option>
                                                <option value="潍坊市">潍坊市</option>
                                                <option value="济宁市">济宁市</option>
                                                <option value="泰安市">泰安市</option>
                                                <option value="威海市">威海市</option>
                                                <option value="日照市">日照市</option>
                                                <option value="莱芜市">莱芜市</option>
                                                <option value="临沂市">临沂市</option>
                                                <option value="德州市">德州市</option>
                                                <option value="聊城市">聊城市</option>
                                                <option value="滨州市">滨州市</option>
                                                <option value="菏泽市">菏泽市</option>
                                            </select>
                                        </li>
                                    </ul>
                                </div>
                                <div class="map_tabcon map-result">
                                    <div class="map_tabcon_con_bot result-list">
                                        <ul niceScroll>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li id="jigouList" style="display:none">
                                <div class="sx-mapsearch">
                                    <ul>
                                        <li>
                                            <span>地区</span>
                                            <select class="m-select areaSelect">
                                                <option value="山东省">不限</option>
                                                <option value="济南市">济南市</option>
                                                <option value="青岛市">青岛市</option>
                                                <option value="淄博市">淄博市</option>
                                                <option value="枣庄市">枣庄市</option>
                                                <option value="东营市">东营市</option>
                                                <option value="烟台市">烟台市</option>
                                                <option value="潍坊市">潍坊市</option>
                                                <option value="济宁市">济宁市</option>
                                                <option value="泰安市">泰安市</option>
                                                <option value="威海市">威海市</option>
                                                <option value="日照市">日照市</option>
                                                <option value="莱芜市">莱芜市</option>
                                                <option value="临沂市">临沂市</option>
                                                <option value="德州市">德州市</option>
                                                <option value="聊城市">聊城市</option>
                                                <option value="滨州市">滨州市</option>
                                                <option value="菏泽市">菏泽市</option>
                                            </select>
                                        </li>
                                    </ul>
                                </div>
                                <div class="map_tabcon map-result">
                                    <div class="map_tabcon_con_bot result-list">
                                        <ul niceScroll>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li id="userList" style="display:none">
                                <div class="sx-mapsearch">
                                    <ul>
                                        <li>
                                            <span>地区</span>
                                            <select class="m-select areaSelect">
                                                <option value="山东省">不限</option>
                                                <option value="济南市">济南市</option>
                                                <option value="青岛市">青岛市</option>
                                                <option value="淄博市">淄博市</option>
                                                <option value="枣庄市">枣庄市</option>
                                                <option value="东营市">东营市</option>
                                                <option value="烟台市">烟台市</option>
                                                <option value="潍坊市">潍坊市</option>
                                                <option value="济宁市">济宁市</option>
                                                <option value="泰安市">泰安市</option>
                                                <option value="威海市">威海市</option>
                                                <option value="日照市">日照市</option>
                                                <option value="莱芜市">莱芜市</option>
                                                <option value="临沂市">临沂市</option>
                                                <option value="德州市">德州市</option>
                                                <option value="聊城市">聊城市</option>
                                                <option value="滨州市">滨州市</option>
                                                <option value="菏泽市">菏泽市</option>
                                            </select>
                                        </li>
                                    </ul>
                                </div>
                                <div class="map_tabcon map-result">
                                    <div class="map_tabcon_con_bot result-list">
                                        <ul niceScroll>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li id="projList" style="display:none">
                                <div class="sx-mapsearch">
                                    <ul>
                                        <li>
                                            <span>地区</span>
                                            <select class="m-select areaSelect">
                                                <option value="山东省">不限</option>
                                                <option value="济南市">济南市</option>
                                                <option value="青岛市">青岛市</option>
                                                <option value="淄博市">淄博市</option>
                                                <option value="枣庄市">枣庄市</option>
                                                <option value="东营市">东营市</option>
                                                <option value="烟台市">烟台市</option>
                                                <option value="潍坊市">潍坊市</option>
                                                <option value="济宁市">济宁市</option>
                                                <option value="泰安市">泰安市</option>
                                                <option value="威海市">威海市</option>
                                                <option value="日照市">日照市</option>
                                                <option value="莱芜市">莱芜市</option>
                                                <option value="临沂市">临沂市</option>
                                                <option value="德州市">德州市</option>
                                                <option value="聊城市">聊城市</option>
                                                <option value="滨州市">滨州市</option>
                                                <option value="菏泽市">菏泽市</option>
                                            </select>
                                        </li>
                                    </ul>
                                </div>
                                <div class="map_tabcon map-result">
                                    <div class="map_tabcon_con_bot result-list">
                                        <ul niceScroll>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="map" id="map"></div>
        </div>
    </section>
</div>
</body>
</html>
