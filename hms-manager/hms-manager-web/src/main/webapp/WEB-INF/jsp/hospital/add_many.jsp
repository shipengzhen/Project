<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>录入住院信息--中软高科-2015</title>
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
				window.location.href="/HMS/gohospitalIndex";
		 });
    });
    </script>
</head>
<body>
<form action="/HMS/doUpdateMoney" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">病历号</td>
        <td>${register.id }
        	<input type="hidden" name="id" value="${register.id }">
        </td>
        
    </tr>
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td>${register.name }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td>${register.idcard }</td>
    </tr>
	
	<tr>
        <td width="10%" class="tableleft">余额</td>
        <td>${register.cashPledge }元
        	<input type="hidden" name="yMoeny" value="${register.cashPledge }">
        </td>
    </tr>
	
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>缴费押金</td>
        <td><input type="text" name="cashPledge" value=""/>元 </td>
    </tr>

    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success" id="backid">返回列表</button>
				${msg }
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>