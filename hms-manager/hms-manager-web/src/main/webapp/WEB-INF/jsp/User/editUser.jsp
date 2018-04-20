<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
 	 <%@include file="../comm/import.jsp" %>
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
<form action="/HMS/doUserEdit" method="post" class="definewidth m20">
	<input type="hidden" name="id" value="${user.id}" />
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft"><font color="red">*</font>登录名</td>
            <td>${user.loginname}</td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>密码</td>
            <td><input type="password" name="loginpwd" value="${user.loginpwd}"/></td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>真实姓名</td>
            <td><input type="text" name="username" value="${user.username }"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email" value="${user.email }"/></td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>状态</td>
            <td>   
                 <input type="radio" name="status" value="1"  <c:if test="${user.status==1}">checked </c:if>  /> 启用
             	 <input type="radio" name="status" value="0" <c:if test="${user.status==0}">checked</c:if> /> 禁用	
            </td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>角色</td>
            <td>
       			 <select name="roleid" id="roleid">
            		<option value="-1" >--请选择--	</option>
            		<c:forEach var="item" items="${roleList}">
            			<option value="${item.id }" <c:if test="${item.id==user.roleid }">selected="selected"</c:if> >${item.rolename}</option>
            		</c:forEach>
       			 </select>
        	</td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">更新</button>&nbsp;&nbsp;
                <button type="button" class="btn btn-success" name="backid" onclick="window.history.go(-1)" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>