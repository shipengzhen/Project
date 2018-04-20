<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>添加药品--中软高科-2015</title>
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
    <script type="text/javascript">
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });
    });
    </script>
</head>
<body>
<form action="/HMS/UpdateStock" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">药品编号</td>
        <td>${medicine.id }</td>
    </tr> 
	
    <tr>
        <td width="10%" class="tableleft">药品名称</td>
        <td>${medicine.medicinenmae }</td>
    </tr>    
	<tr>
        <td width="10%" class="tableleft">余量</td>
        <td><c:if test="${medicine.stock==null}">0</c:if> ${medicine.stock }
        	<input type="hidden" name="Ystock" value="${medicine.stock }">
        </td>
    </tr>    
	
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>数量</td>
        <td>
        	<input type="hidden" name="id"  value="${medicine.id}" />
			<input type="text" name="stock"  value="" />
		</td>
    </tr>
	

    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success" onclick="window.history.go(-1)">返回列表</button>
				${msg}
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>