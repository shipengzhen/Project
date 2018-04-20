<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">后台管理</a> <span class="divider">/</span></li>
		<li><a href="admin/addSetMeal">添加商品套餐</a></li>
	</ul>
</div>
<div class="row-fluid sortable">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2>
				<i class="icon-user"></i>添加商品套餐
			</h2>
		</div>
		<div class="box-content">
			<ul id="add_formtip"></ul>
			<legend>添加商品套餐</legend>
			<form action="admin/addSetMeal" class="form-horizontal"
				enctype="multipart/form-data" method="post"
				onsubmit="return addGoodsPackFunc();">
				<div class="control-group">
					<label class="control-label" for="typeahead">套餐名称: </label>
					<div class="controls">
						<input type="text" id="a_goodsPackName" name="smname" /> <span
							style="color:red;font-weight: bold;">*</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="typeahead">套餐类型: </label>
					<div class="controls">
						<select id="a_typeId" name="smtypeid" style="width:100px;">
							<option value="" selected="selected">--请选择--</option>
							<c:if test="${setMealTypes != null}">
								<c:forEach items="${setMealTypes}" var="setMealType">
									<option value="${setMealType.dictionaryid}">${setMealType.valuename}</option>
								</c:forEach>
							</c:if>
						</select> <span style="color:red;font-weight: bold;">*</span>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="focusedInput">库存量：</label>
					<div class="controls">
						<input type="text" id="a_num" name="smnumber"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')" /> <span
							style="color:red;font-weight: bold;">*</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="typeahead">套餐售价: </label>
					<div class="controls">
						<input readonly="readonly" type="text" id="a_totalPrice"
							name="smprice" value="0"
							onkeyup="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;" />
						<span style="color:red;font-weight: bold;">*</span>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="typeahead">状态: </label>
					<div class="controls">
						<input type="radio" id="a_stateup" name="smstatic"
							checked="checked" value="1" />上架 <input type="radio"
							id="a_statedown" name="state" value="0" />下架
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="typeahead">相关商品: </label>
					<div class="controls">
						<ul class="aboutproductsList">
							<li><iframe id="goodsListFrame" class="goodsListFrame"
									src="admin/commodityList"></iframe></li>
							<li id="selectgoodslist"></li>
						</ul>
						<input id="goodsJson" type="hidden" name="goodsJson" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="textarea2">套餐说明:</label>
					<div class="controls">
						<textarea class="cleditor" id="a_note" name="smdoc" rows="3"></textarea>
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
<script type="text/javascript" src="statics/localjs/addgoodspack.js"></script>
