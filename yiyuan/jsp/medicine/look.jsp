<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>查看--中软高科-2015</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.sorted.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/ckform.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>

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
			});
		</script>
	</head>

	<body>
		<form action="index.html" method="post" class="definewidth m20">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">药品编号</td>
					<td>${yao.yno}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">图片</td>
					<td><img src="../../static/yimg/${yao.y_img}" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">进价</td>
					<td>${yao.y_sj}元</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">售价</td>
					<td>${yao.y_sj}元</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">药品名称</td>
					<td>${yao.y_name}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">药品类型</td>
					<td>${yao.y_type==1?"处方药":yao.y_type==2?"中药":"西药"}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">简单描述</td>
					<td>${yao.y_ms}</td>
				</tr>

				<tr>
					<td width="10%" class="tableleft">保质期</td>
					<td>${yao.y_baozhi}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">详细描述</td>
					<td>${yao.y_xxms}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">生产厂商</td>
					<td>${yao.y_sccs}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">库存</td>
					<td>${yao.y_kucun}袋</td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
						</center> </td>
				</tr>
			</table>
		</form>
	</body>

</html>