<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="<%=request.getContextPath()%>/">
<style type="text/css">
body {
	font-size: 12px;
	padding: 0px;
	margin: 0px;
}

.s{
	margin-top:5px;
	font-size: 17px;
	font-weight: bold;
	color: #006699;
	padding: 3px;
}

.searcharea {
	padding: 3px;
}

ul {
	list-style: none;
	margin-left: -30px;
}

ul li {
	padding: 5px;
	height: 30px;
	cursor: pointer;
}

ul li:hover {
	background: #efefef;
	border: 1px dashed #ccc;
}

label {
	float: left;
}

.goodsname {
	display: block;
	width: 180px;
	height: 30px;
	overflow: hidden;
}

.kucun {
	display: block;
	width: 80px;
	height: 30px;
	overflow: hidden;
}

.add {
	display: block;
	width: 30px;
	height: 30px;
	vertical-align: middle;
	overflow: hidden;
	line-height: 30px;
	text-align: center;
	cursor: pointer;
}

.clear {
	clear: both;
}

h2 a {
	font-size: 12px;
	color: green;
}

.li li {
	width: 10%;
	float: left;
}
a{
	color: #000;
}
</style>

<!-- jQuery -->
<script src="statics/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".add").click(function() {
			gid = $(this).attr("gid");
			gname = $(this).attr("gname");
			rprice = $(this).attr("rprice");
			window.parent.addGoods(gid, gname, rprice);
		});
	});

	function page(frm, num) {
		frm.pageNo.value = num;
		frm.submit();
	};
</script>
</head>
<body>
	<span class="s">选择商品：</span>
	<hr/>
	<form action="admin/commodityList" method="post">
		<div class="searcharea">
			<input id="pageNo" type="hidden" name="pageNo"
				value="${pageInfo.pageNum}" /> 商品名称: <input id="commoDityname"
				type="text" name="commoDityname" value="${commoDityname}" />
			<button type="submit" class="btn btn-primary">
				<i class="icon-search icon-white"></i> 查询
			</button>
		</div>
	</form>

	<c:if test="${pageInfo.list != null}">
		<ul>
			<c:forEach items="${pageInfo.list}" var="commodity">
				<li><label class="goodsname">${commodity.commodityname}</label>
					<label class="kucun">库存：${commodity.number}</label> <label
					class="add" gid="${commodity.commodityid}" gname="${commodity.commodityname}"
					rprice="${commodity.xprice}"><img
						src="statics/img/+.png" width="24px;" /></label> <label class="clear"></label>
				</li>
			</c:forEach>
		</ul>
		<div class="li">
			<ul>
				<c:choose>
					<c:when test="${pageInfo.isFirstPage}">
						<li class="active" ><a
						 title="首页">首页</a>
							
						</li>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:page(document.forms[0],1)"
							title="首页">首页</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach items="${pageInfo.navigatepageNums}" var="i">
					<li <c:if test='${pageInfo.pageNum==i}'> class="active" </c:if>>
						<a href='javascript:page(document.forms[0],${i})'> ${i} </a>
					</li>
				</c:forEach>
				<c:choose>
					<c:when test="${pageInfo.isLastPage}">
						<li class="active"><a
							
							title="尾页">尾页</a></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="javascript:page(document.forms[0],${pageInfo.pages})"
							title="尾页">尾页</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</c:if>
</html>
