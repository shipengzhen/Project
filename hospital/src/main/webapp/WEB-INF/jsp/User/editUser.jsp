<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改用户</title>
    <base href="${basePath}">
    <link rel="stylesheet" type="text/css" href="statics/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="statics/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="statics/Css/style.css" />
    <script type="text/javascript" src="statics/Js/jquery.js"></script>
    <script type="text/javascript" src="statics/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="statics/Js/bootstrap.js"></script>
    <script type="text/javascript" src="statics/Js/ckform.js"></script>
    <script type="text/javascript" src="statics/Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
<input type="hidden" name="id" value="{$user.id}" />
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft"><font color="red">*</font>登录名</td>
            <td>admin</td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>真实姓名</td>
            <td><input type="text" name="realname" value="admin"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email" value="qq@qq.com"/></td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>状态</td>
            <td>
                <input type="radio" name="status" value="0" checked/> 启用
              <input type="radio" name="status" value="1" /> 禁用
            </td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>角色</td>
            <td>
            	<select name="role">
        			<option value="">--请选择--</option>
        			<option value="1" selected>管理员</option>
        			<option value="2">院长</option>
            		<option value="3">医生护士</option>
       			 </select>
        	</td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">更新</button>&nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });
    });
</script>