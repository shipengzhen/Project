<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>查看--中软高科-2015</title>
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
				window.location.href="index.html";
		 });
    });
    </script>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td>${doctor.doctorname }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">省份证</td>
        <td>${doctor.idcard }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">手机</td>
        <td>${doctor.phone }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">座机</td>
        <td>${doctor.telephone }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td>${doctor.sex }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">出生年月</td>
     	 <td> <fmt:formatDate value="${doctor.birthday}" pattern="yyyy-MM-dd"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">电子邮箱</td>
        <td>${doctor.email }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所属科室</td>
        <td>${opd.name }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">学历</td>
        <td>${doctor.education }</td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td>${doctor.remarks }</td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="button" class="btn btn-success"  onclick="window.history.go(-1)" >返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>