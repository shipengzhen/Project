<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
 	<%@include file="../comm/import.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/Js/lz/Resource.js"></script>
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
    <script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="/HMS/goResourceIndex";
		 });
    });
</script>
</head>
<body>
<form action="/HMS/updateRItem" method="post" id="updateFrom" class="definewidth m20">
	<input type="hidden" name="id" value="${Item.id}" />
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft"><font color="red">*</font>资源名称</td>
            <td><input id="updaternam" type="text" name="rnam" value="${Item.rnam}"/> <span id="updaternammsg" style="color: red;"></span></td>
            
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>url</td>
            <td><input id="updateurl" type="text" name="url" value="${Item.url}"/><span id="updateurlmsg" style="color: red;"></span></td>
        </tr>
        <tr>
            <td class="tableleft"><font color="red">*</font>是否有效</td>
            <td>
                <input type="radio"  name="status" value="1" <c:if test="${Item.status==1}">checked='checked'</c:if> /> 有效
                 <input type="radio" name="status" value="0" <c:if test="${Item.status==0}">checked='checked'</c:if>/> 无效
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">更新</button>&nbsp;&nbsp;
                <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
           		&nbsp;&nbsp;&nbsp;${msg}
            </td>
        </tr>
    </table>
</form>
</body>
</html>