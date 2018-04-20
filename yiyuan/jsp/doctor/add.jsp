<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>添加医生--中软高科-2015</title>
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
				
				$(".ok").click(function() {

					if(chickform('#ff') == false) {
						return layer.msg('请填写完整');
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
				
				//根据身份证计算信息
				$("[name=d_card]").bind("input",function(){
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
					
					//出生年月
					var d_csday=card.substring(6,10)+"-"+card.substring(10,12)+"-"+card.substring(12,14);
					$("[name=d_csdayDate]").val(d_csday);
					
					var age=new Date().getFullYear()-card.substring(6,10);
					$("[name=d_age]").val(age);
					
					
					
					
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
					<td><input type="text" name="d_zsname" value="" /></td>
				</tr>

				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>身份证号</td>
					<td><input type="text" name="d_card" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>手机</td>
					<td><input type="text" name="d_phone" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">座机</td>
					<td><input type="text" name="d_zuoji" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>性别</td>
					<td>
						<input type="radio" class="nan" name="d_sex" value="男" checked/>男&nbsp;&nbsp;&nbsp;
						<input type="radio" class="nv" name="d_sex" value="女" />女
					</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>出生年月</td>
					<td><input type="text" name="d_csdayDate" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>年龄</td>
					<td><input type="text" name="d_age" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">电子邮箱</td>
					<td><input type="text" name="d_email" value="" /></td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>所属科室</td>
					<td>
						<select name="kid">
							<c:forEach items="${KeRomes}" var="k" >
								<option value="${k.kid}">${k.kname}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">学历</td>
					<td>
						<select name="d_xueli" value="博士">
							<option value="本科">专科</option>
							<option value="本科">本科</option>
							<option value="博士">博士</option>
							<option value="博士后">博士后</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%" class="tableleft">备注</td>
					<td><textarea name="d_beizhu"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<button type="button" class="ok btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
							<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
						</center>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>