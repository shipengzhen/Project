<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购货管理</a> <span class="divider">/</span></li>
		<li><a href="admin/commodityManager">商品列表</a></li>
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
			<form action="user/shopingCommodity" method="post">
				<div class="searcharea">
					<input id="pageNo" type="hidden" name="pageNo"
						value="${pageInfo.pageNum}" /> 商品名称: <input id="commoDityname"
						type="text" name="commoDityname" value="${commoDityname}" /> 优惠价:<input
						id="commoDityname" type="text" name="price1" value="${price1}"
						style="width: 50px;"
						onkeyup="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;" />至
					&emsp;<input id="commoDityname" type="text" name="price2"
						value="${price2}" style="width: 50px;"
						onkeyup="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;" />
					<button type="submit" class="btn btn-primary">
						<i class="icon-search icon-white"></i> 查询
					</button>
				</div>
			</form>

			<table
				class="table table-striped table-bordered bootstrap-datatable datatable">
				<thead>
					<tr>
						<th>商品名称</th>
						<th>市场价(元)</th>
						<th>优惠价(元)</th>
						<th width="20%">说明</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${pageInfo.list != null}">
						<c:forEach items="${pageInfo.list}" var="commodity">
							<tr>
								<td class="center">${commodity.commodityname}</td>
								<td class="center">${commodity.yprice}</td>
								<td class="center">${commodity.xprice}</td>
								<td class="center">${commodity.details}</td>
								<td class="center"><input id="num${commodity.commodityid}q"
									type="text"
									onkeyup="if(this.value==0){this.value=''}else{this.value=this.value.replace(/\D/g,'')}"
									value="1" onblur="if(this.value=='')value=1" /></td>
								<td class="center"><a
									class="btn btn-success addShopingCard" href="#"
									id="${commodity.commodityid}" price="${commodity.xprice}"
									cstype="1" ordertype="2" status="2"> <i
										class="icon-zoom-in icon-white"></i> 加入购物车
								</a> 
								
								<a  class="btn btn-info lijigm"  li=${commodity.commodityid } ><i class="icon-edit icon-white"></i> 立即购买</a>
								<a style="display: none;"  class="btn btn-info addOrders" href="#"  ss="${commodity.commodityid }"
									id="${commodity.commodityid}q" price="${commodity.xprice}"
									cstype="1" ordertype="1" status="1"> <i
										class="icon-edit icon-white"></i> 立即购买
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
</div>
<!-- 购买成功 -->

		<!-- Modal -->
<div class="modal fade" id="fukuan" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h3 class="modal-title" id="myModalLabel">确认购物</h3>
      </div>
       <div class="container-fluid">
       
       <form class="form-horizontal">
      	 <br/>
      	  <div class="form-group">
		    <label  class="col-sm-2 control-label">收货人:</label>
		    <div class="col-sm-10">
		      <input type="text" id="shren" class="form-control" value="${User.uname}"  placeholder="收货人"> <span style="color: red;" class="spSMG"></span>
		    </div>
		  
		  </div>
		    <br/>
		   <div class="form-group">
		    <label  class="col-sm-2 control-label">手机号:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="shPhone"   value="${User.phone }" placeholder="手机号"><span style="color: red;" class="spSMG"></span>
		    </div>
		  </div>
		
		  <br/>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">地址:</label>
		    <div class="col-sm-10">
		    	<textarea id="shaddress">${User.address}</textarea><span style="color: red;" class="spSMG"></span>
		    </div>
		  </div>
		  <br/>
		  <div class="form-group">
		    <label  class="col-sm-2 control-label">支付密码:</label>
		    <div class="col-sm-10">
		    <input type="hidden" id="pwd2session" value="${User.loginpwd2 }">
		      <input type="password" class="form-control" id="pwd2"  placeholder="密码"><span style="color: red;" class="spSMG"></span>
		    </div>
		  </div>
		  <br/>
		
		</form>
       
       
		  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" id="isok" data-dismiss="modal" class="btn btn-primary">确认</button>
      </div>
    </div>
  </div>
</div>



<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="statics/userjs/shoping.js"></script>