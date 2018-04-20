<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>住院结算--中软高科-2015</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.sorted.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/ckform.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>

		<script src="../kj/laydate/laydate.js"></script>
		<script src="../js/layer/layer.js"></script>
		<script src="../kj/fenye99.js"></script>
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
				$('#newNav').click(function() {
					window.location.href = "dispensing-gives.html";
				});
				//分页
				$("#box").paging({
		            currentPage:'${page.pn}',	//当前页
		            total: '${page.zy}',		//总页数
					showPage:'10',	//显示几个
		            beforeAjaxSubmit:function(){
		            	var pn=PageAPI.GetCurrentPage();
		            	location.href="account.html?pn="+pn+"&"+$("#ff").serialize();
		            }
		        });
			});

			function checkall() {
				var alls = document.getElementsByName("check");
				var ch = document.getElementById("checkall");
				if(ch.checked) {
					for(var i = 0; i < alls.length; i++) {
						alls[i].checked = true;
					}
				} else {
					for(var i = 0; i < alls.length; i++) {
						alls[i].checked = false;
					}
				}
			}

			//指定zid结算
			var jiesuan=function(zid){
				//alert(zid)
				$.post2("doJiesuan.ajax",{zid:zid},function(data){
					if(data.res>0){
						layer.msg("结算成功");
						setInterval(function(){
							location.reload();
						},500)
					}else{
						layer.msg("结算失败");
					}
				},function(e,ee,eee){
					layer.msg("结算异常"+eee);
				})
				
			}
			
			
		</script>
	</head>

	<body>

		<form id="ff" action="dispensing.html" method="get" class="definewidth m20">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">病历号：</td>
					<td><input type="text" name="gid" value="${gid}" /></td>

					<td width="10%" class="tableleft">姓名：</td>
					<td><input type="text" name="gname" value="${gname}" /></td>
				</tr>
				<tr>

					<td colspan="4">
						<center>
							<button type="submit" class="btn btn-primary" type="button">查询</button>
							<button type="reset" class="btn btn-primary" type="button">清空</button>
						</center>
					</td>
				</tr>
			</table>
		</form>

		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
					<th>病历号</th>
					<th>姓名</th>
					<th>当前余额</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${zhuyuans}" var="z" >
				<tr>
					<td style="vertical-align:middle;"><input type="checkbox" name="check" value="1"></td>
					<td style="vertical-align:middle;">${z.guahao.gid}</td>
					<td style="vertical-align:middle;">${z.guahao.gname}</td>
					<td style="vertical-align:middle;">${z.z_yajin}元</td>
					<td style="vertical-align:middle;">${z.z_js_state}</td>
					<td style="vertical-align:middle;">
						<a href="account-look.html?gid=${z.guahao.gid}">详细信息</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:jiesuan(${z.zid});" style=" ${z.z_js_state=='未结算'?'':'display:none;'}">结算</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>

		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<th colspan="5">
					<div class="inline pull-right page">
						${page.count} 条记录 ${page.pn}/${page.zy} 页
						<div class="box" id="box" style="float: right;margin: -5px 10px;"></div>
					</div>
					<div>
						<button type="button" class="btn btn-success" id="delPro">导出Excel</button>
					</div>

				</th>
			</tr>
		</table>

	</body>

</html>