<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>添加收费项目--中软高科-2015</title>
    <meta charset="UTF-8">
 	<%@include file="../comm/import.jsp" %>
 	  <script type="text/javascript" src="${pageContext.request.contextPath}/statics/Js/lz/charge.js"></script>
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

		.dd{ color: red; }
    </style>
    <script type="text/javascript">
    $(function () {       
		$('#backid').click(function(){
				window.location.href="charge.html";
		 });
    });
    </script>
</head>
<body>
<form action="/HMS/doUpdateCitem" id="addCostItem" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
	 <tr>
        <td width="10%" class="tableleft">编号</td>
        <td><input type="hidden" name="id" value="${item.id }" />${item.id }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>收费项目名称</td>
        <td><input type="text" name="costitemname" value="${item.costitemname }" /><span class="dd"></span></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>收费金额</td>
        <td><input type="text" name="cost" value="${item.cost }"/><span class="dd"></span></td>
    </tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> 
				&nbsp;&nbsp;<button type="button" class="btn btn-success" onclick="window.history.go(-1)">返回列表
				</button>
				${msg}
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>