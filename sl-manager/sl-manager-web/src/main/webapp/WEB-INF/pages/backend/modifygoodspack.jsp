<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">后台管理</a> <span class="divider">/</span></li>
		<li><a href="admin/modifysetMeal">修改商品套餐</a></li>
	</ul>
</div>
<div class="row-fluid sortable">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2>
				<i class="icon-user"></i>修改商品套餐
			</h2>
		</div>
		<div class="box-content">
			<ul id="modify_formtip"></ul>
			<legend>修改商品套餐</legend>
			<form action="admin/modifySetMeal"
				class="form-horizontal" enctype="multipart/form-data" method="post"
				onsubmit="return modifyGoodsPackFunc();">
				<div class="control-group">
					<input id="m_id" type="hidden" name="smid" value="${setmeal.smid}" />
					<label class="control-label" for="typeahead">套餐名称: </label>
					<div class="controls">
						<input type="text" id="m_goodsPackName" name="smname"
							value="${setmeal.smname}" />
							<input type="hidden" id="mm_goodsPackName" name=""
							value="${setmeal.smname}" /> <span
							style="color: red; font-weight: bold;">*</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="typeahead">套餐类型: </label>
					<div class="controls">
						<input id="m_typeName" type="hidden" value="${setmeal.smTypeName}"
							name="smTypeName" /> <select id="m_typeId" name="smtypeid"
							style="width: 100px;">
							<option value="" selected="selected">--请选择--</option>
							<c:if test="${setMealTypes != null}">
								<c:forEach items="${setMealTypes}" var="setMealType">
									<option
										<c:if test="${setmeal.smtypeid == setMealType.dictionaryid}">selected = "selected"</c:if>
										value="${setMealType.dictionaryid}">${setMealType.valuename}</option>
								</c:forEach>
							</c:if>
						</select> <span style="color: red; font-weight: bold;">*</span>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="focusedInput">库存量：</label>
					<div class="controls">
						<input type="text" id="m_num" name="smnumber"
							value="${setmeal.smnumber}"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')" /> <span
							style="color: red; font-weight: bold;">*</span>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="typeahead">套餐总价: </label>
					<div class="controls">
						<input type="text" id="m_totalPrice" name="smprice"
							value="${setmeal.smprice}"
							onkeyup="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;" />
						<span style="color: red; font-weight: bold;">*</span>
					</div>
				</div>

				<%-- <div class="control-group">
					<label class="control-label" for="typeahead">状态: </label>
					
					<div class="controls">
						<c:if test="${setmeal.smstatic ==1}">
							<input type="radio" name="smstatic" checked="checked" value="1" />上架
					  		<input type="radio" name="smstatic" value="2" />下架
					  </c:if>
						<c:if test="${setmeal.smstatic ==2}">
							<input type="radio" name="smstatic" value="1" />上架
					  		<input type="radio" name="smstatic"  checked="checked" value="2" />下架
					  </c:if>
					</div>
				</div> --%>

				<div class="control-group">
					<label class="control-label" for="typeahead">相关商品: </label>
					<div class="controls">
						<ul class="aboutproductsList">
							<li><iframe id="goodsListFrame" class="goodsListFrame"
									src="admin/commodityList"></iframe>
							</li>
							<li id="selectgoodslist">
							<span  style="margin-top:5px; font-size: 17px; font-weight: bold; color: #006699; padding: 3px;">已选商品：</span>
							<hr/>
							<c:if test="${commodityList != null}">
									<c:forEach items="${commodityList}" var="objs">
										<div id="selectdiv">
											<label class="goodsname">${objs[0].commodityname}</label> <label
												class="goodscount"><input class="finalresult"
												onblur="if(this.value=='')value=1" onkeyup="if(this.value==0){this.value=''}else{this.value=this.value.replace(/\D/g,'')}"
												goodsid="${objs[0].commodityid}" rprice="${objs[0].xprice}"
												type="text" value="${objs[1]}" /></label><label>${objs[0].xprice}</label> <label class="del"
												rprice="${objs[0].xprice}"><img
												src="statics/img/cancel-on.png" /></label> <label class="clear"></label>
										</div>
									</c:forEach>
								</c:if></li>
						</ul>
						<input id="goodsJson" type="hidden" name="goodsJson" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="textarea2">套餐说明:</label>
					<div class="controls">
						<textarea class="cleditor" id="m_note" name="smdoc" rows="3">${setmeal.smdoc}</textarea>
					</div>
				</div>
				<div class="form-actions">
					<button type="submit" class="btn btn-primary">保存</button>
					<button type="button" class="btn backbtn">返回</button>
				</div>
			</form>
		</div>
	</div>
	<!--/span-->
</div>
<!--/row-->

<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="statics/localjs/modifygoodspack.js"></script>
