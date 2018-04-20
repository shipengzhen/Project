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
<form action="/HMS/doditRole" method="post" class="definewidth m20" >
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>角色名称</td>
        <td><input type="text" name="rolename" value="${tbRole.rolename }"/>
        	<input type="hidden" name="id" value="${tbRole.id}">
        </td>
        
    </tr>
    <tr>
        <td class="tableleft"><font color="red">*</font>状态</td>
        <td>
        	 
            <input type="radio" name="status" value="1"  <c:if test="${tbRole.status==1}">checked</c:if>  /> 启用
            <input type="radio" name="status" value="0" <c:if test="${tbRole.status==0}">checked</c:if>  /> 禁用
        </td>
    </tr>
    <tr>
        <td class="tableleft"><font color="red">*</font>权限</td>
        <td>
        	<c:forEach var="item" items="${TbResourceItemlist }">
        		<ul>
	        		<label class='checkbox inline'>
	        		  <input type='checkbox' <c:forEach var="roleitem" items="${RoleResourcelist}"><c:if test="${item.id==roleitem.itemid}">checked</c:if> </c:forEach>  name='items' value='${item.id}' />${item.rnam }
	        		</label>
        		</ul> 
        	</c:forEach>
		</td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">更新</button> &nbsp;&nbsp;
            <button type="button" class="btn btn-success" name="backid" onclick="window.history.go(-1)" id="backid">返回列表</button>
            &nbsp;&nbsp;&nbsp;&nbsp;<span style="color: red;">${msg}</span>
        </td>
    </tr>
</table>
</form>
</body>
</html>