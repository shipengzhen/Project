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
		</div>

		<div class="box-content">
			<form action="user/shopingSetMeal" method="post">
				<div class="searcharea">
					<input id="pageNo" type="hidden" name="pageNo" /> 商品套餐名称: <input
						type="text" name="smName" value="${smName}" /> 套餐类型： <select
						name="smType" style="width: 100px;">
						<option value="" selected="selected">--请选择--</option>
						<c:if test="${setMealTypes != null}">
							<c:forEach items="${setMealTypes}" var="setMealType">
								<option
									<c:if test="${smType == setMealType.dictionaryid}">selected = "selected"</c:if>
									value="${setMealType.dictionaryid}">${setMealType.valuename}</option>
							</c:forEach>
						</c:if>
					</select> 价格:<input id="commoDityname" type="text" name="price1"
						value="${price1}" style="width: 50px;"
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
						<th>套餐名称</th>
						<th>套餐总价(元)</th>
						<th>套餐类型</th>
						<th width="20%">套餐说明</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${pageInfo.list != null}">
						<c:forEach items="${pageInfo.list}" var="sm">
							<tr>
								<td class="center">${sm.smname}</td>
								<td class="center">${sm.smprice}</td>
								<td class="center">${sm.smTypeName}</td>
								<td class="center">${sm.smdoc}</td>
								<td class="center">
								
								<input id="num${sm.smid}q"
									type="text"
									onkeyup="if(this.value==0){this.value=''}else{this.value=this.value.replace(/\D/g,'')}"
									value="1" onblur="if(this.value=='')value=1" />
								
						
								<td class="center">
								
						
								<c:choose>
									<c:when  test="${sm.smtypeid!=9}">
										<a
										class="btn btn-success addShopingCard" href="#" id="${sm.smid}"
										price="${sm.smprice}" smtypeid="${sm.smtypeid}" cstype="2"
										ordertype="2" status="2"> <i
											class="icon-zoom-in icon-white"></i> 加入购物车
									</a>
									
									</c:when>
									<c:otherwise>
										<button  disabled="disabled"
										class="btn btn-success addShopingCard" href="#" id="${sm.smid}"
										price="${sm.smprice}" smtypeid="${sm.smtypeid}" cstype="2"
										ordertype="2" status="2"> <i
											class="icon-zoom-in icon-white"></i> 加入购物车
									</button>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${sm.smtypeid==9}">
										 <a class="btn btn-info addOrders"  id="${sm.smid}"
											price="${sm.smprice}" smtypeid="${sm.smtypeid}" cstype="2"
											ordertype="1" status="1"> <i class="icon-edit icon-white"></i>
												立即购买
										 </a>
										
									</c:when>
									<c:otherwise>
										
									<a  class="btn btn-info lijigm"  li="${sm.smid}" ><i class="icon-edit icon-white"></i> 立即购买</a>
									<a style="display: none;"  class="btn btn-info addOrders" href="#"  ss="${sm.smid}"
										id="${sm.smid}q" price="${sm.smprice}"
										cstype="1" ordertype="1" status="1"> <i
											class="icon-edit icon-white"></i> 立即购买
									</a>
									</c:otherwise>
								</c:choose>
								
								
			
								
								
								
								</td>
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

<!-- 报单加入购物车 -->
<div class="modal hide fade" id="bdAddDiv" > 
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>报单购物</h3>
	</div>
	<div class="modal-body">
		<p id="userError"></p>
		<p>
			<label>会员名：
			 <input id="loginName" type="text"  name="loginName">（推荐注册会员）</label>
		</p>
		<p>
			<label>收货人：
			 <input id="name1" type="text"  name=""></label>
		</p>
		<p>
			<label>手机号：
			 <input id="phone1" type="text"  name=""></label>
		</p>
		<p>
			<label>地&nbsp;&nbsp;&nbsp;&nbsp;址：
			<textarea rows="" cols="" id="address1"></textarea>
		</p>
		
		
	</div>
	<div id="add_formtip"></div>
	<div class="modal-footer">
		<a href="#" class="btn addgoodsinfocancel" data-dismiss="modal">取消</a>
		<a href="#" class="btn btn-primary"  id="bdAdd">保存</a>
	</div>
</div>

<!-- 立即购买 -->


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
<script type="text/javascript" src="statics/userjs/shoping1.js"></script>
