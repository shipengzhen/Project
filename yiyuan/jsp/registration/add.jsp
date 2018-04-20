<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>添加挂号--中软高科-2015</title>
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
				
				//根据身份证计算信息
				$("[name=g_card]").bind("input",function(){
					var card=$(this).val();
					if(card.length!=18){
						//return;
					}
					
					//性别
					if(card[16]%2==1){
						$(".nv").attr("checked",false);
						$(".nan").attr("checked",true);
					}else{
						$(".nan").attr("checked",false);
						$(".nv").attr("checked",true);
					}
					
					var age=new Date().getFullYear()-card.substring(6,10);
					$("[name=g_age]").val(age);
					
				})
				
				//科室对应医生的联动
				$("[name=kid]").change(function(){
					$.post2("getDoctorByKid.ajax",{kid:$(this).val()},function(data){
						$("[name=did]").html("");
						$(data).each(function(){
							var str='<option value="'+this.did+'">'+this.d_zsname+'</option>';
							$("[name=did]").append(str);
						})
						
						
					},function(e,ee,eee){
						layer.msg("获取联动数据失败:"+eee);
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
						<font color="red">*</font>姓名</td>
					<td><input type="text" name="gname" value="" /></td>
				</tr>

				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>身份证号</td>
					<td><input type="text" name="g_card" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">社保号</td>
					<td><input type="text" name="g_shebao" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>挂号费</td>
					<td><input type="text" name="g_money" value="" />元</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>联系电话</td>
					<td><input type="text" name="g_phone" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>是否自费</td>
					<td><input type="radio" name="g_zifei" value="0" checked/>否&nbsp;&nbsp;&nbsp;
						<input type="radio" name="g_zifei" value="1" />是</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>性别</td>
					<td><input type="radio" class="nan" name="g_sex" value="男" checked/>男&nbsp;&nbsp;&nbsp;
						<input type="radio" class="nv" name="g_sex" value="女" />女</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">年龄</td>
					<td><input type="text" name="g_age" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">职业</td>
					<td><input type="text" name="g_zhiye" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">初复诊</td>
					<td><input type="radio" name="g_cf" value="1" checked/>初诊&nbsp;&nbsp;&nbsp;
						<input type="radio" name="g_cf" value="2" />复诊</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>所挂科室</td>
					<td>
						<select name="kid">
							<c:forEach items="${keromes}" var="k" >
								<option value="${k.kid}">${k.kname}</option>
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
								<option value="${d.did}">${d.d_zsname}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">备注</td>
					<td>
						<input type="hidden" name="g_status" value="已挂号" />
						<textarea name="g_beizhu"></textarea>
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