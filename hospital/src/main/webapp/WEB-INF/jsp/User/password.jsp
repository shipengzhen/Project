<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改用户名密码信息</title>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="statics/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="statics/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="statics/Css/style.css" />
    <script type="text/javascript" src="statics/Js/jquery.js"></script>
    <script type="text/javascript" src="statics/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="statics/Js/bootstrap.js"></script>
    <script type="text/javascript" src="statics/Js/ckform.js"></script>
    <script type="text/javascript" src="statics/Js/common.js"></script>

</head>
<body>
<form class="form-inline definewidth m20" action="${path}/user/modifypassword" method="get">    
   <table>
		<tr>
			<td align="right"><font color="red">*</font>原密码:</td><td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td align="right"><font color="red">*</font>新密码:</td><td><input type="password" name="newPassword"/></td>
		</tr>
		<tr>
			<td align="right"><font color="red">*</font>确认密码:</td><td><input type="password" name="againNewPassword"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><br/>
				<input type="submit" value="保存" class="btn btn-primary"/>
			</td>
		</tr>
   </table>
</form>
</body>
</html>