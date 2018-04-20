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
					<td width="10%" class="tableleft">姓名</td>
					<td>${guahao.gname}</td>
				</tr>

				<tr>
					<td width="10%" class="tableleft">身份证号</td>
					<td>${guahao.g_card}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">挂号费</td>
					<td>${guahao.g_money}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">社保号</td>
					<td>${guahao.g_shebao}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">联系电话</td>
					<td>${guahao.g_phone}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">是否自费</td>
					<td>${guahao.g_zifei==1?"是":"否"}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">性别</td>
					<td>${guahao.g_sex}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">年龄</td>
					<td>${guahao.g_age}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">职业</td>
					<td>${guahao.g_zhiye}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">初复诊</td>
					<td>${guahao.g_cf==1?"初诊":"复诊"}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">所挂科室</td>
					<td>${guahao.kname}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">指定医生</td>
					<td>${guahao.d_zsname}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">备注</td>
					<td>${guahao.g_beizhu}</td>
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