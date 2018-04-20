<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>录入住院信息--中软高科-2015</title>
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
				
				
				//根据gid，获取挂号信息
				$(".huoqu").click(function(){
					var gid=$("[name=gid]").val();
					
					$.post2('getGuaHao.ajax', {gid:gid}, function(data) {
						if(data == null) {
							return layer.alert("查询无果");
						}
						
						layer.msg("查询成功，已获得其信息");
						
						$(".gname").html(data.gname);
						$(".zjlx").html("身份证");
						$(".g_card").html(data.g_card);
						$(".g_shebao").html(data.g_shebao);
						$(".g_phone").html(data.g_phone);
						var g_zifei=data.g_zifei==1?"是":"否";	$(".g_zifei").html(g_zifei);
						$(".g_sex").html(data.g_sex);
						$(".g_age").html(data.g_age);
						var g_cf=data.g_cf==1?"初诊":"复诊";	$(".g_cf").html(g_cf);
						$(".kname").html(data.kname);
						$(".d_zsname").html(data.d_zsname);
						$(".g_beizhu").html(data.g_beizhu);
						
					}, function(e, ee, eee) {
						layer.alert("异常:" + eee);
					})
					
				})
			
				$(".ok").click(function() {

					if(chickform('#ff') == false) {
						return layer.msg('请填写完整!!!');
					}

					$.post2('doAdd.ajax', $('#ff').serialize(), function(data) {
						if(data.res == 1) {
							return layer.alert("添加成功", {}, function() {
								$('#backid').click();
							});
						} else {
							return layer.alert("添加失败");
						}
					}, function(e, ee, eee) {
						layer.alert("添加异常:" + eee);
					})

				})
			
			
			
			
			});
			
			
			
			
			
			
		</script>
	</head>

	<body>
		<form id="ff" action="index.html" method="post" class="definewidth m20">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>病历号</td>
					<td>
						<input type="text" name="gid" value="" />
						<button type="button" class="huoqu btn btn-primary">获取信息</button>
					</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">姓名</td>
					<td class="gname">-</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">证件类型</td>
					<td class="zjlx"></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">证件号</td>
					<td class="g_card">-</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">社保号</td>
					<td class="g_shebao">-</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">联系电话</td>
					<td class="g_phone">-</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">是否自费</td>
					<td class="g_zifei">-</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">性别</td>
					<td class="g_sex">-</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">年龄</td>
					<td class="g_age">-</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">初复诊</td>
					<td class="g_cf">-</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">所挂科室</td>
					<td class="kname">-</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">指定医生</td>
					<td class="d_zsname">-</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">备注</td>
					<td class="g_beizhu">-</td>
				</tr>
				<!-- 以上信息为输入病历号自动带出来的 -->
				<tr>
					<td width="10%" class="tableleft">护理</td>
					<td><input type="text" name="z_huli" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">床位号</td>
					<td><input type="text" name="z_cw" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">缴费押金</td>
					<td><input type="text" name="z_yajin" value="" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<button type="button" class="ok btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
							<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
						</center> </td>
				</tr>
			</table>
		</form>
	</body>

</html>