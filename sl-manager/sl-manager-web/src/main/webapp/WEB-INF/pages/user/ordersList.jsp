<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购货管理</a> <span class="divider">/</span></li>
		<li><a href="admin/setMealManager">订单管理</a></li>
	</ul>
</div>
<div class="row-fluid sortable">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2>
				<i class="icon-user"></i>订单列表
			</h2>
		</div>

		<div class="box-content">
			<form action="user/ordersList" method="post">
				<div class="searcharea">
					<input id="pageNo" type="hidden" name="pageNo" /> 单号: <input
						type="text" name="ordersId" value="${ordersId}" />
					<c:if test="${roleId==1}">
						会员用户: <input type="text" name="loginName" value="${loginName}" />
					</c:if>
					订单类型： <select name="orderType" style="width: 100px;">
						<option value="">--请选择--</option>
						<c:if test="${orderType==0}">
							<option value="1">单消</option>
							<option value="2">重消</option>
						</c:if>
						<c:if test="${orderType==1}">
							<option value="1" selected="selected">单消</option>
							<option value="2">重消</option>
						</c:if>
						<c:if test="${orderType==2}">
							<option value="1">单消</option>
							<option value="2" selected="selected">重消</option>
						</c:if>
					</select>
					<button type="submit" class="btn btn-primary">
						<i class="icon-search icon-white"></i> 查询
					</button>
				</div>
			</form>

			<table
				class="table table-striped table-bordered bootstrap-datatable datatable">
				<thead>
					<tr>
						<th>商品单号</th>
						<th>会员用户名</th>
						<th>收货人</th>
						<th>商品总价(元)</th>
						<th>订单类型</th>
						<th>日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${pageInfo.list != null}">
						<c:forEach items="${pageInfo.list}" var="order">
							<tr>
								<td class="center">${order.orderid}</td>
								<td class="center">${order.uName}</td>
								<td class="center">${order.name}</td>
								<td class="center">${order.price}</td>
								<td class="center">
									<c:if test="${order.ordertype==1}">单消</c:if>
									<c:if test="${order.ordertype==2}">重消</c:if>
								</td>
								<td class="center"><fmt:formatDate value="${order.created}"
										pattern="yyyy-MM-dd" /></td>

								<td class="center"><a class="btn btn-danger delorders"
									href="#" id="${order.orderid}"> <i
										class="icon-trash icon-white"></i> 删除
								</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<div class="pagination pagination-centered">
				<ul>
					<c:choose>
						<c:when test="${pageInfo.isFirstPage}">
							<li class="active"><a
							 title="首页">首页</a></li>
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
		</div>
	</div>
	<!--/span-->
</div>
<!--/row-->

<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="statics/userjs/ordersList.js"></script>
