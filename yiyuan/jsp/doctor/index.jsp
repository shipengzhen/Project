<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title></title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/jquery.sorted.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/ckform.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>

		<script src="../js/layer/layer.js"></script>
		<script src="../kj/fenye99.js"></script>

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
					window.location.href = "add.html";
				});
				//分页
				$("#box").paging({
		            currentPage:'${page.pn}',	//当前页
		            total: '${page.zy}',		//总页数
					showPage:'10',	//显示几个
		            beforeAjaxSubmit:function(){
		            	var pn=PageAPI.GetCurrentPage();
		            	location.href="index.html?pn="+pn+"&"+$("#ff").serialize();
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

			function delAll() {
				var alls = document.getElementsByName("check");
				var ids = new Array();
				for(var i = 0; i < alls.length; i++) {
					if(alls[i].checked) {
						ids.push(alls[i].value);
					}
				}
				if(ids.length > 0) {
					if(confirm("确认操作?")) {
						alert("成功!");
					}
				} else {
					alert("请选中要操作的项");
				}
			}
		</script>
	</head>

	<body>

		<form id="ff" action="index.html" method="get" class="definewidth m20">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">医生编号：</td>
					<td><input type="text" name="didStr" value="${didStr}" /></td>

					<td width="10%" class="tableleft">医生姓名：</td>
					<td><input type="text" name="d_zsname" value="${d_zsname}" /></td>

					<td width="10%" class="tableleft">科室：</td>
					<td><input type="text" name="kname" value="${kname}" /></td>
				</tr>
				<tr>
					<td colspan="6">
						<center>
							<button type="submit" class="btn btn-primary" type="button">查询</button>
							<button type="submit" class="btn btn-primary" type="button">清空</button>
						</center>
					</td>
				</tr>
			</table>
		</form>

		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
					<th>医生编号</th>
					<th>医生姓名</th>
					<th>入院时间</th>
					<th>所属科室</th>
					<th>学历</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${doctors}" var="d" >
				<tr>
					<td style="vertical-align:middle;"><input type="checkbox" name="check" value="${d.did}"></td>
					<td style="vertical-align:middle;">${d.did}</td>
					<td style="vertical-align:middle;">${d.d_zsname}</td>
					<td style="vertical-align:middle;">${d.d_csday}</td>
					<td style="vertical-align:middle;">${d.kname}</td>
					<td style="vertical-align:middle;">${d.d_xueli}</td>
					<td style="vertical-align:middle;">
						<a href="look.html?did=${d.did}">详情>>></a>&nbsp;&nbsp;&nbsp;
						<a href="edit.html?did=${d.did}">更改</a>
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
					<div><button type="button" class="btn btn-success" id="newNav">添加新医生</button>
						<button type="button" class="btn btn-success" id="delPro">导出Excel</button>
					</div>

				</th>
			</tr>
		</table>

	</body>

</html>