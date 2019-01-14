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
    <link rel="stylesheet" type="text/css" href="<l:asset path="../assets/css/common/bootstrap.min.css"/> "/>
    <link rel="stylesheet" type="text/css" href="<l:asset path="../assets/css/login.css"/> "/>
</head>

<body>
<div class="header">
    <div class="warp">
        <div class="logo"></div>
    </div>
</div>
<div class="main-content">
    <div class="warp clearfix">
        <img class="pull-left left-bg" src="skins/assets/images/left-bg.png" alt="">
        <div class="pull-right login-content">
            <div class="login-head clearfix">
                <span>统一用户登录</span>
                <span>没有账户?<a href="#">立即注册</a></span>
            </div>
            <div class="login-text">
                <div class="int-group">
                    <span>用户名</span>
                    <input type="text" id="username" placeholder="请输入用户名">
                </div>
                <div class="int-group">
                    <span>密 &nbsp;码</span>
                    <input type="password" placeholder="请输入密码">
                </div>
                <div class="int-group pwd-code">
                    <span>验证码</span>
                    <input class="key-code" type="text" placeholder="验证码"><img
                        src="skins/assets/images/safe-icon.png"><a
                        href="">看不清?换一张</a>
                </div>
                <p class="forget-pwd">
                    <span>忘记密码<a href="#">立即找回</a></span>
                </p>

                <a class="login-btn" id="enterPage" href="javascript:void(0)">登&nbsp;录</a>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="warp">
        <p>
            <span>版权所有&copy;:陕西省科学技术厅</span>
            <span>鲁运行维护: 陕西省科技资源统筹中心</span>

        </p>
        <p><span>陕ICP备050021000号-6</span></p>
    </div>
</div>
</body>

</html>
<script type="text/javascript" src="<l:asset path='../assets/js/common/jquery-1.9.1.min.js'/>"></script>
<script>
    $(function () {
        $("#enterPage").click(function () {
            var username = $("#username").val();
            if (username == "tingzhang") {
                window.location.href = "director/index";
            } else if (username == "shiyanshi") {
                window.location.href = "laboratory/index";
            } else if (username == "yewuchu") {
                window.location.href = "business/index";
            } else if (username == "yulan") {
                window.location.href = "laboratory/lab_tianbao";
            } else {
                alert("请输入用户名！仅可输入tingzhang/shiyanshi/yewuchu/yulan这四个")
            }
        })
    })
</script>
