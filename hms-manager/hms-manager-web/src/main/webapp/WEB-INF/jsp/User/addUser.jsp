<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<%@include file="../comm/import.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/Js/lz/User.js"></script>
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}

.red {
	color: red
}
</style>
</head>
<body>
	<form action="/HMS/doAddUser" id="addUserForm" method="post"
		class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft"><font color="red">*</font>登录名</td>
				<td><input type="text" id="loginname" name="loginname" /><span
					class="red msg" id="loginnameSpan"></span></td>
			</tr>
			<tr>
				<td class="tableleft"><font color="red">*</font>密码</td>
				<td><input type="text" id="loginpwd" name="loginpwd" /><span
					class="red msg"></span></td>
			</tr>
			<tr>
				<td class="tableleft"><font color="red">*</font>真实姓名</td>
				<td><input type="text" id="username" name="username" /><span
					class="red msg"></span></td>
			</tr>
			<tr>
				<td class="tableleft">邮箱</td>
				<td><input type="text" id="email" name="email" /><span
					class="red msg"></span></td>
			</tr>
			<tr>
				<td class="tableleft"><font color="red">*</font>状态</td>
				<td><input type="radio" name="status" value="0" checked /> 启用
					<input type="radio" name="status" value="1" /> 禁用</td>
			</tr>
			<tr>
				<td class="tableleft"><font color="red">*</font>角色</td>
				<td><select name="roleid" id="roleid">
						<option value="-1">--请选择--	
            		<c:forEach var="item" items="${RoleList}">
            			<option value="${item.id }">${item.rolename}
            		</c:forEach>
       			 </select><span class="red msg"></span>
        	</td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">更新</button>
                &nbsp;&nbsp;
                <button type="button" onclick="window.history.go(-1)" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>