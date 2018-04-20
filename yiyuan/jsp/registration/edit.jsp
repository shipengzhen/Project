<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>挂号--中软高科-2015</title>
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
			<input type="hidden" name="gid" id="gid" value="${guahao.gid}" />
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>姓名</td>
					<td><input type="text" name="gname" value="${guahao.gname}" /></td>
				</tr>

				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>身份证号</td>
					<td><input type="text" name="g_card" value="${guahao.g_card}" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">社保号</td>
					<td><input type="text" name="g_shebao" value="${guahao.g_shebao}" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>挂号费</td>
					<td><input type="text" name="g_money" value="${guahao.g_money}" />元</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>联系电话</td>
					<td><input type="text" name="g_phone" value="${guahao.g_phone}" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>是否自费</td>
					<td><input type="radio" name="g_zifei" value="0" checked/>否&nbsp;&nbsp;&nbsp;
						<input type="radio" name="g_zifei" value="1" ${guahao.g_zifei==1?"checked":""}/>是</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>性别</td>
					<td><input type="radio" class="nan" name="g_sex" value="男" checked/>男&nbsp;&nbsp;&nbsp;
						<input type="radio" class="nv" name="g_sex" value="女" ${guahao.g_sex=="女"?"checked":""}/>女</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">年龄</td>
					<td><input type="text" name="g_age" value="${guahao.g_age}" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">职业</td>
					<td><input type="text" name="g_zhiye" value="${guahao.g_zhiye}" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">初复诊</td>
					<td><input type="radio" name="g_cf" value="1" checked/>初诊&nbsp;&nbsp;&nbsp;
						<input type="radio" name="g_cf" value="2" ${guahao.g_cf==2?"checked":""}/>复诊</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>所挂科室</td>
					<td>
						<select name="kid">
							<c:forEach items="${keromes}" var="k" >
								<option value="${k.kid}" ${k.kid==guahao.kid?"selected":""}>${k.kname}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>指定医生</td>
					<td>
						<select name="did">
							<c:forEach items="${doctors}" var="d" >
								<option value="${d.did}" ${k.did==guahao.did?"selected":""}>${d.d_zsname}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">备注</td>
					<td>
						<!--<input type="hidden" name="g_status" value="已挂号" />-->
						<textarea name="g_beizhu">${guahao.g_beizhu}</textarea>
					</td>
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