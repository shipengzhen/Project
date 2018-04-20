<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>发药--中软高科-2015</title>
    <meta charset="UTF-8">
 	 <%@include file="../comm/import.jsp" %>
    <script type="text/javascript" src="../Js/ckeditor/ckeditor.js"></script>
 

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
    <script type="text/javascript">
    $(function () {       
		$('#backid').click(function(){
				window.location.href="dispensing.html";
		 });
    });
    </script>
</head>
<body>
<form action="/HMS/doDisAdd" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">病历号</td>
        <td>${register.id }<input type="hidden" name="registerId" value="${register.id }"> </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td>${register.name}</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>药品名称</td>
        <td>
        	
        	<select name="medicinenmae">
        		<c:forEach var="item" items="${meList}">
        			<option value="${item.medicinenmae}">${item.medicinenmae }</option>
        		</c:forEach>
        	</select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>发药数量</td>
        <td><input type="text" name="medicinenumber" value=""/></td>
    </tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success" onclick="window.history.go(-1)">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>