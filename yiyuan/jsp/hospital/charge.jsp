<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>收费项目管理</title>
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
					window.location.href = "charge-edit1.html";
				});
				
				//分页
				$("#box").paging({
		            currentPage:'${page.pn}',	//当前页
		            total: '${page.zy}',		//总页数
					showPage:'10',	//显示几个
		            beforeAjaxSubmit:function(){
		            	var pn=PageAPI.GetCurrentPage();
		            	location.href="charge.html?pn="+pn+"&"+$("#ff").serialize();
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

			
			var doChargeDel=function(pid){
				$.post2("doChargeDel.ajax",{pid:pid},function(data){
					if(data.res>0){
						layer.msg("删除成功");
						setInterval(function(){
							location.reload();
						},500)
					}else if(data.res>=-1){
						layer.msg("删除失败，仍有记录引用此项");
					}else{
						layer.msg("删除失败");
					}
				},function(e,ee,eee){
					layer.msg("删除异常"+eee);
				})
				
			} 
			
			
			
			
			$(function() {
				$('#backid').click(function() {
					window.location.href = "dispensing.html";
				});
			});
		</script>
	</head>

	<body>

		<form id="ff" action="charge.html" method="get" class="definewidth m20">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">收费项目名称：</td>
					<td width="10%"><input type="text" name="pname" value="${pname}" /></td>

					<td>
						<button type="submit" class="btn btn-primary" type="button">查询</button>
						<button type="reset" class="btn btn-primary" type="button">清空</button> </td>
				</tr>

			</table>

		</form>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th>编号</th>
					<th>收费项目名称</th>
					<th>收费金额</th>
					<th>创建日期</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${pays}" var="p" >
				<tr>
					<td style="vertical-align:middle;">${p.pid}</td>
					<td style="vertical-align:middle;">${p.pname}</td>
					<td style="vertical-align:middle;">${p.pmoney}</td>
					<td style="vertical-align:middle;">${p.pdate}</td>
					<td style="vertical-align:middle;">
						<a href="javascript:doChargeDel(${p.pid});">删除</a>
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
						<button type="button" class="btn btn-success" id="newNav">添加收费项目</button>
					</div>

				</th>
			</tr>
		</table>

	</body>

</html>