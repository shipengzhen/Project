<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">后台管理</a> <span class="divider">/</span></li>
		<li><a href="admin/setMealManager">商品套餐管理</a></li>
	</ul>
</div>
<div class="row-fluid sortable">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2>
				<i class="icon-user"></i> 商品套餐列表
			</h2>
			<div class="box-icon">
				<span class="icon32 icon-color icon-add custom-setting addGoodsPack" />
			</div>
		</div>

		<div class="box-content">
			<form action="admin/setMealManager" method="post">
				<div class="searcharea">
					<input id="pageNo" type="hidden" name="pageNo" />
					商品套餐名称: <input type="text" name="smName" value="${smName}" /> 
					套餐类型： <select name="smType" style="width: 100px;">
						<option value="" selected="selected">--请选择--</option>
						<c:if test="${setMealTypes != null}">
							<c:forEach items="${setMealTypes}" var="setMealType">
								<option
									<c:if test="${smType == setMealType.dictionaryid}">selected = "selected"</c:if>
									value="${setMealType.dictionaryid}">${setMealType.valuename}</option>
							</c:forEach>
						</c:if>
					</select> 状态： <select name="smStatus" style="width: 100px;">
						<option value="" selected="selected">--请选择--</option>
						<c:if test="${smStatus == 1}">
							<option value="1" selected="selected">上架</option>
							<option value="2">下架</option>
						</c:if>
						<c:if test="${smStatus == 2}">
							<option value="2" selected="selected">下架</option>
							<option value="1">上架</option>
						</c:if>
						<c:if test="${smStatus == null || smStatus == 0}">
							<c:forEach items="${csList}" var="cs">
								<option value="${cs.valuename}">
									<c:if test="${cs.valuename == 1}">
										上架
									</c:if>
									<c:if test="${cs.valuename == 2}">
										下架
									</c:if>
								</option>
							</c:forEach>
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
						<th>套餐名称</th>
						<th>套餐总价(元)</th>
						<th>库存量</th>
						<th>状态(上架/下架)</th>
						<th>套餐类型</th>
						<th>最后更新时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${pageInfo.list != null}">
						<c:forEach items="${pageInfo.list}" var="sm">
							<tr>
								<td class="center">${sm.smname}</td>
								<td class="center">${sm.smprice}</td>
								<td class="center">${sm.smnumber}</td>
								<td class="center"><input type="checkbox"
									title="直接勾选修改状态，立即生效" data-rel="tooltip" class="modifystate"
									state="${sm.smstatic}" goodspackid="${sm.smid}"
									<c:if test="${sm.smstatic == 1}"> checked="true"</c:if> />
								</td>
								<td class="center">${sm.smTypeName}</td>
								<td class="center"><fmt:formatDate
										value="${sm.updated}" pattern="yyyy-MM-dd" /></td>
								<td class="center"><a class="btn btn-success viewgoodspack"
									href="#" id="${sm.smid}"> <i
										class="icon-zoom-in icon-white"></i> 查看
								</a> <a class="btn btn-info modifygoodspack" href="#"
									id="${sm.smid}"> <i class="icon-edit icon-white"></i>
										修改
								</a> <a class="btn btn-danger delgoodspack" href="#"
									id="${sm.smid}" goodsPackName="${sm.smname}">
										<i class="icon-trash icon-white"></i> 删除
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
							<li class="active"><a title="首页">首页</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:page(document.forms[0],1)" title="首页">首页</a></li>
						</c:otherwise>
					</c:choose>
					<c:forEach items="${pageInfo.navigatepageNums}" var="i">
						<li <c:if test='${pageInfo.pageNum==i}'> class="active" </c:if>>
							<a href='javascript:page(document.forms[0],${i})'> ${i} </a>
						</li>
					</c:forEach>
					<c:choose>
						<c:when test="${pageInfo.isLastPage}">
							<li class="active"><a title="尾页">尾页</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="javascript:page(document.forms[0],${pageInfo.pages})"
								title="尾页">尾页</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
				<%-- <ul>
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
				</ul> --%>
			</div>
		</div>
	</div>
	<!--/span-->
</div>
<!--/row-->

<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="statics/localjs/goodspacklist.js"></script>
