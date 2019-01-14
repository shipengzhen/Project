<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/tags/loushang-web" prefix="l" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<%
    String importMsg = "";
    if (request.getSession().getAttribute("msg") != null) {
        importMsg = request.getSession().getAttribute("msg").toString();
    }
    request.getSession().setAttribute("msg", "");
%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">
    <meta name="renderer" content="webkit">
    <title>陕西科技PDS管理服务系统</title>
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/bootstrap.min.css"/> "/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/head.css"/> "/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/monitor.css"/>"/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/lab-tianbao.css"/>"/>
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
        <span>信息填报</span>
    </div>
</div>
<div class="labinfo-content">
    <!-- 实验室基本信息 -->
    <div class="info-group marginBottom10">
        <div class="info-head">
            <img src="../skins/assets/images/monitorAlert/icon-1.png" alt="">
            <i>实验室基本信息</i>
            <div class="infohead-act pull-right">
                <a href="#">基本信息修改</a>
                <a href="../laboratory/labMonitor">监测预警</a>
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
    <!-- 区域内投入指标信息 -->
    <div class="info-group">
        <div class="info-head">
            <img src="../skins/assets/images/monitorAlert/icon-2.png" alt="">
            <i>我的填报</i>
        </div>
        <div class="info-content">
            <ul class="tb-group">
                <li>
                    <div href="#" class="tb-li clearfix">
                        <p>
                            <img src="../skins/assets/images/tianbao/tianbao1.png" alt="">
                            <i>历史信息</i>
                        </p>
                        <img src="../skins/assets/images/tianbao/list-img1-1.png" alt="">
                        <a href="../laboratory/lab_history" class="tabli-act1">
                            历史填报信息查询
                        </a>
                        <input id="excel_file" type="file" name="attach">
                        <input type="button" value="导入Excel" onclick="keys();">
                        <font id="importMsg" color="red"><%=importMsg%></font><input type="hidden"/>
                    </div>
                </li>
                <li>
                    <div href="#" class="tb-li clearfix">
                        <p>
                            <img src="../skins/assets/images/tianbao/tianbao2.png" alt="">
                            <i>年度报告</i>
                        </p>
                        <img src="../skins/assets/images/tianbao/list-img2-2.png" alt="">
                        <a href="#" class="tabli-act2">
                            年度信息填报
                        </a>
                        <a href="#" class="tabli-act2">
                            年度信息浏览
                        </a>
                    </div>
                </li>
                <li>
                    <div href="#" class="tb-li clearfix">
                        <p>
                            <img src="../skins/assets/images/tianbao/tianbao3.png" alt="">
                            <i>季度报告</i>
                        </p>
                        <img src="../skins/assets/images/tianbao/list-img3-3.png" alt="">
                        <a href="#" class="tabli-act3">
                            季度信息填报
                        </a>
                        <a href="#" class="tabli-act3">
                            季度信息预览
                        </a>
                    </div>
                </li>
            </ul>
            <div class="label-infos clearfix">
                <img class="pull-left" src="../skins/assets/images/tianbao/label-info.png" alt="">
                <p class="pull-left">
                    <span>温馨提示：</span>
                    <i>填报完成实验室信息，次年度填写信息时，无须再次重新填写，每季度点击季度信息填写即可。遇到系统问题，请联系技术支持人员。</i>
                    <i>电话：1234567811。</i>
                </p>
            </div>
        </div>
    </div>


</div>
<div class="footer">
    <p>
        版权所有&copy;:陕西省科学技术厅 鲁运行维护: 陕西省科技资源统筹中心

    </p>
    <p>陕ICP备050021000号-6</p>
</div>
</body>
<script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/ajaxfileupload.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/layui/layui.all.js"/>"></script>

<script type="text/javascript">
    function keys() {
        var excel_file = $("#excel_file").val();
        if (excel_file == "" || excel_file.length == 0) {
            layer.msg('请选择文件!', {icon: 3});
            return false;
        } else {
            var suffix = excel_file.substr(excel_file.lastIndexOf("."));
            if (suffix == ".xls" || suffix == ".xlsx") {
                $.ajaxFileUpload({
                    url: '../laboratory/fileupload',
                    type: 'post',
                    fileElementId: 'excel_file',
                    dataType: 'text',
                    success: function (returnData) {
                        if (returnData) {
                            layer.msg('导入成功！',{icon:6});
                            $("#excel_file").val(returnData);
                            return false;
                        } else {
                            layer.msg('导入失败！',{icon:5});
                            return false;
                        }
                    }
                })
            } else {
                layer.msg('附件格式不正确,请重新选择！',{icon:2});
                return false;
            }
        }

    }
</script>
</html>
