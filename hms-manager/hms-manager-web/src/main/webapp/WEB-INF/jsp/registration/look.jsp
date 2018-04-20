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
        <td>${register.name }</td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">身份证号</td>
        <td>${register.idcard }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">挂号费</td>
        <td>${register.cost }元</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td>${register.seid }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td>${register.phone }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
        <td>${register.isfy }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td>${register.sex }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td>${register.age }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">职业</td>
        <td>${register.occupation }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初复诊</td>
        <td>${register.cfz }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所挂科室</td>
        <td>${opd.name }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
        <td>${doctors.doctorname }</td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td>${register.remarks }</td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="button" class="btn btn-success" onclick="window.history.go(-1)">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>