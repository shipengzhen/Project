<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>添加药品--中软高科-2015</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.sorted.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/ckform.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>

		<script src="../js/layer/layer.js"></script>
		<script src="../kj/jqjq.js"></script>

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
			$(function() {
				$('#backid').click(function() {
					window.location.href = "index.html";
				});
				
				$("#ff").submit(function(){
					if(chickform('#ff') == false) {
						layer.msg('请填写完整!!!');
						return false;
					}
					
					if($("[name=y_img]").val()==""){
						layer.msg('请选择图片');
						return false;
					}
					
				})
				
				
			});
		</script>
	</head>

	<body>
		<form id="ff" action="doAdd" method="post"  class="definewidth m20" enctype="multipart/form-data">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>药品编号</td>
					<td><input type="text" name="yno" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">图片</td>
					<td><input type="file" name="file" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>进价</td>
					<td><input type="text" name="y_jj" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>售价</td>
					<td><input type="text" name="y_sj" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>药品名称</td>
					<td><input type="text" name="y_name" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>药品类型</td>
					<td>
						<input type="radio" name="y_type" value="1" checked/>处方药&nbsp;&nbsp;&nbsp;
						<input type="radio" name="y_type" value="2" />中药&nbsp;&nbsp;&nbsp;
						<input type="radio" name="y_type" value="3" />西药</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">简单描述</td>
					<td><input type="text" name="y_ms" value="" /></td>
				</tr>

				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>保质期</td>
					<td><input type="text" name="y_baozhi" value="" />月</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">详细描述</td>
					<td><textarea name="y_xxms"></textarea></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">生产厂商</td>
					<td><textarea name="y_sccs"></textarea></td>
					<input type="hidden" name="y_state" value="销售中" />
				</tr>

				<tr>
					<td colspan="2">
						<center>
							<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
							<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
						</center> </td>
				</tr>
			</table>
		</form>
	</body>

</html>