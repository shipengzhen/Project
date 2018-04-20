<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购货管理</a> <span class="divider">/</span></li>
		<li><a href="admin/commodityManager">购物车</a></li>
	</ul>
</div>

<div class="row-fluid sortable">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2>
				<i class="icon-user"></i> 商品列表
			</h2>
		</div>
		<div class="box-content">
			<br/>
			<form action="user/shopingCard" method="post" style="display: none;">
				<div class="searcharea">
					<input id="pageNo" type="hidden" name="pageNo" />
				</div>
			</form>
			
				&nbsp;&nbsp;&nbsp;收件人: <input type="text" id="uname1"  value="${User.uname }" style="width: 60px;">
				&nbsp;&nbsp;&nbsp;手机号: <input type="text" id="phone1" value="${User.phone }" style="width: 100px;">
				&nbsp;&nbsp;&nbsp;地  址: <input type="text" id="address1" value="${User.address }"><br/>
				&nbsp;&nbsp;&nbsp;<span style="color: red;" id="dd123"></span>
			<hr/>
			<table
				class="table table-striped table-bordered bootstrap-datatable datatable">
				<thead>
					<tr>
						<th>商品名称</th>
						<th>市场价(元)</th>
						<th>数量</th>
						<th>总价(元)</th>
						<th>商品类型</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${pageInfo.list != null}">
						<c:forEach items="${pageInfo.list}" var="obj">
							<tr>
								<td class="center">${obj.name}</td>
								<td class="center">${obj.price}</td>
								<td class="center">${obj.ocsCnum}</td>
								<td class="center">${obj.ocsCnum*obj.price}</td>
								<td class="center">
								<c:if test="${obj.cstype==1}">
									商品
								</c:if>
								<c:if test="${obj.cstype==2}">
									套餐
								</c:if>
								</td>
								<td class="center"><a class="btn btn-danger delShopingCardcs"
									href="#" num="${obj.ocsCnum}" price="${obj.ocsCnum*obj.price}" oid="${obj.ocsOid}" csid="${obj.ocsCsid}" cstype="${obj.cstype}" csname="${obj.name}"> <i
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
								href="javascript:page(document.forms[0],1)" title="首页">首页</a></li>
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
								href="javascript:page(document.forms[0],${pageInfo.pages})"
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
	<!-- ---------------------------- -->
	<div style="float: right;">
			<input type="text" value="${order.price}" style="width:20%;height: 10%;">
			<input id="settleAccounts" price="${order.price}" oid="${order.orderid}" type="text" class="btn btn-primary" value="去结账" style="width:20%;height: 10%;">
		</div>
	
	
	<!-- // -->

</div>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="statics/userjs/shopingCard.js"></script>