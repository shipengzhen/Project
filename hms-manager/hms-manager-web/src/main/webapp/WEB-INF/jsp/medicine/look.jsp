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
        <td width="10%" class="tableleft">药品编号</td>
        <td>${me.id }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">图片</td>
        <td><img  src="${me.img}"></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">进价</td>
        <td>${me.jprice }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">售价</td>
        <td>${me.sprice }元</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">药品名称</td>
        <td>${me.medicinenmae }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">药品类型</td>
        <td>${me.medicinetype }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">简单描述</td>
        <td>${me.describe }</td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">过期日期</td>
        <td>${me.qgp }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">详细描述</td>
        <td>${me.doc }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">生产厂商</td>
        <td>${me.factory }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">服用说明</td>
        <td>${me.eatdoc }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">库存</td>
        <td>${me.stock }</td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td>${me.remarks }</td>
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