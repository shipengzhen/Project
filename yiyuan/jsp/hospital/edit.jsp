<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>修改住院信息--中软高科-2015</title>
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
					
				//确认修改
				$(".ok").click(function(){
							
					if(chickform('#ff')==false){
						return layer.msg('请填写完整');
					}
					
					
					$.post2('doEdit.ajax',$('#ff').serialize(),function(data){
						if(data.res==1){
							return layer.alert("修改成功",{},function(){
								$('#backid').click();
							});
						}else{
							return layer.alert("修改失败");
						}
					},function(e,ee,eee){
						layer.alert("修改异常:"+eee);
					})
					
				})
				
			});
		</script>
	</head>

	<body>
		<form id="ff" action="index.html" method="post" class="definewidth m20">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">病历号</td>
					<td>${z.guahao.gid}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">姓名</td>
					<td>${z.guahao.gname}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">证件类型</td>
					<td>身份证</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">证件号</td>
					<td>${z.guahao.g_card}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">社保号</td>
					<td>${z.guahao.g_shebao}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">联系电话</td>
					<td>${z.guahao.g_phone}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">是否自费</td>
					<td>${z.guahao.g_zifei==1?"是":"否"}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">性别</td>
					<td>${z.guahao.g_sex}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">年龄</td>
					<td>${z.guahao.g_age}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">初复诊</td>
					<td>${z.guahao.g_cf==1?"初诊":"复诊"}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">所挂科室</td>
					<td>${z.guahao.kname}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">指定医生</td>
					<td>${z.guahao.d_zsname}</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">备注</td>
					<td>${z.guahao.g_beizhu} </td>
				</tr>
				<tr>
					<input type="hidden" name="zid" id="zid" value="${z.zid}" />
					<td width="10%" class="tableleft">护理</td>
					<td><input type="text" name="z_huli" value="${z.z_huli}" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">床位号</td>
					<td><input type="text" name="z_cw" value="${z.z_cw}" /></td>
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