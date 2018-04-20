<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>kankan</title>
		<title></title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
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
					<td width="10%" class="tableleft">姓名</td>
					<td>${doctor.d_zsname}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">证件类型</td>
					<td>身份证</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">证件号</td>
					<td>${doctor.d_card}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">手机</td>
					<td>${doctor.d_phone}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">座机</td>
					<td>${doctor.d_zuoji}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">性别</td>
					<td>${doctor.d_sex}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">年龄</td>
					<td>${doctor.d_age}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">出生年月</td>
					<td>${doctor.d_csday}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">电子邮箱</td>
					<td>${doctor.d_email}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">所属科室</td>
					<td>${doctor.kname}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">学历</td>
					<td>${doctor.d_xueli}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">备注</td>
					<td>${doctor.d_beizhu}</td>
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