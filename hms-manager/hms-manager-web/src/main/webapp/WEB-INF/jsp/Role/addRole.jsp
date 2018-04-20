<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
   <%@include file="../comm/import.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/Js/lz/Role.js"></script>

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
<form action="/HMS/addRole" method="post" id="addRoleForm" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft"><font color="red">*</font>角色名称</td>
            <td><input type="text" id="roleName"  name="rolename"/><span id="roleNameMSG" style="color: red;"></span></td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>状态</td>
            <td>
                <input type="radio" name="status" value="1" checked/> 启用 
                 <input type="radio" name="status" value="0"/> 禁用
            </td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>权限</td>
            <td>
            	<c:forEach var="item" items="${List}" varStatus="i">
               	 	<ul><label class='checkbox inline'> 
               	 	<input type='checkbox' name='items' value='${item.id}'/>${item.rnam}</label></ul>  
            	</c:forEach>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">保存</button> 
                &nbsp;&nbsp;
                <button type="button" class="btn btn-success" name="backid"  onclick="window.history.go(-1)" id="backid">返回列表</button>
                ${msg}
            </td>
        </tr>
    </table>
</form>
</body>
</html>