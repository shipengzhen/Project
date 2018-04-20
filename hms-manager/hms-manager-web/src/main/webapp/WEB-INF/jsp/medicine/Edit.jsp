<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>添加药品--中软高科-2015</title>
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
	.ddq{color: red; }

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
<form action="/HMS/doMeEdit"  method="post" class="definewidth m20" enctype="multipart/form-data" >
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>药品编号</td>
        <td><input type="hidden" name="id" value="${medicine.id}" /><span>${medicine.id}</span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">图片</td>
        <td><input type="file" name="attach" value=""/>${error}<span class="ddq"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>进价</td>
        <td><input type="text" name="jprice" value="${medicine.jprice }"/><span class="ddq"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>售价</td>
        <td><input type="text" name="sprice" value="${medicine.sprice }"/><span class="ddq"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>药品名称</td>
        <td><input type="text" name="medicinenmae" value="${medicine.medicinenmae }"/><span class="ddq"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>药品类型</td>
        <td>
        	
        	<input type="radio" name="medicinetype" value="处方药" <c:if test="${medicine.medicinetype=='处方药' }">checked</c:if>  />处方药&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="medicinetype" value="非方药" <c:if test="${medicine.medicinetype=='非方药' }">checked</c:if>  />非方药&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="medicinetype" value="中药" <c:if test="${medicine.medicinetype=='中药' }">checked</c:if>  />中药&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="medicinetype" value="西药" <c:if test="${medicine.medicinetype=='西药' }">checked</c:if> />西药
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">简单描述</td>
        <td><input type="text" name="describe" value="${medicine.describe }"/></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>保质期</td>
        <td><input type="text" name="qgp" value="${medicine.qgp }"/>月<span class="ddq"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">详细描述</td>
        <td><textarea name="doc">${medicine.doc }</textarea></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">生产厂商</td>
        <td><textarea name="factory">${medicine.factory}</textarea></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>服用说明</td>
        <td><input type="text" name="eatdoc" value="${medicine.eatdoc }"/></td>
    </tr>
   
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td><textarea name="remarks">${medicine.remarks}</textarea></td>
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