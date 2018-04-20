<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">后台管理</a> <span class="divider">/</span></li>
		<li><a href="admin/commodityManager">商品管理</a></li>
	</ul>
</div>

<div class="row-fluid sortable">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2>
				<i class="icon-user"></i> 商品列表
			</h2>
			<div class="box-icon">
				<span class="icon32 icon-color icon-add custom-setting addGoodsInfo" />
			</div>
		</div>

		<div class="box-content">
			<form action="admin/commodityManager" method="post">
				<div class="searcharea">
					<input id="pageNo" type="hidden" name="pageNo"
						value="${pageInfo.pageNum}" /> 商品名称: <input id="commoDityname"
						type="text" name="commoDityname" value="${commoDityname}" /> 状态：
					<select id="status" name="status" style="width:100px;">
						<option value="" selected="selected">--请选择--</option>
						<c:if test="${status == 1}">
							<option value="1" selected="selected">上架</option>
							<option value="2">下架</option>
						</c:if>
						<c:if test="${status == 2}">
							<option value="2" selected="selected">下架</option>
							<option value="1">上架</option>
						</c:if>
						<c:if test="${status == null || status == 0}">
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
						<th>商品名称</th>
						<th>市场价(元)</th>
						<th>优惠价(元)</th>
						<th>库存量</th>
						<th>状态(上架/下架)</th>
						<th>最后更新时间</th>
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
								<td class="center">${commodity.number}</td>
								<td class="center">
					<input type="checkbox" title="直接勾选修改状态，立即生效" data-rel="tooltip" class="modifystate"
									state="${commodity.status}"
									goodsinfoid="${commodity.commodityid}"
									<c:if test="${commodity.status == 1}">checked="true"</c:if> /></td>
								<td class="center"><fmt:formatDate
										value="${commodity.updated}" pattern="yyyy-MM-dd" /></td>
								<td class="center"><a class="btn btn-success viewgoodsinfo"
									href="#" id="${commodity.commodityid}"> <i
										class="icon-zoom-in icon-white"></i> 查看
								</a> <a class="btn btn-info modifygoodsinfo" href="#"
									id="${commodity.commodityid}"> <i
										class="icon-edit icon-white"></i> 修改
								</a> <a class="btn btn-danger delgoodsinfo" href="#"
									id="${commodity.commodityid}"
									goodsName="${commodity.commodityname}"> <i
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
			</div>
		</div>
	</div>
	<!--/span-->
</div>
<!--/row-->

<!-- 新增商品信息 -->
<div class="modal hide fade" id="addGoodsInfoDiv">
	<form action="admin/addCommodity" enctype="multipart/form-data"
		method="post" onsubmit="return addGoodsInfoFunction();">
		<div class="modal-header">
			<button type="button" class="close addgoodsinfocancel"
				data-dismiss="modal">×</button>
			<h3>添加商品信息</h3>
		</div>
		<div class="modal-body">
			<ul id="add_formtip"></ul>
			<ul class="topul">
				<li><label>商品名称：</label><input type="text" id="a_goodsName"
					name="commodityname" /> <span style="color:red;font-weight: bold;">*</span>
				</li>
				<li><label>市场价：</label> <input type="text" id="a_marketPrice"
					name="yprice"
					onkeyup="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;" />
					<span style="color:red;font-weight: bold;">*</span></li>
				<li><label>优惠价：</label> <input type="text" id="a_realPrice"
					name="xprice"
					onkeyup="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;" />
					<span style="color:red;font-weight: bold;">*</span></li>
				<li><label>库存量：</label><input type="text" id="a_num"
					name="number" onkeyup="this.value=this.value.replace(/\D/g,'')"
					onafterpaste="this.value=this.value.replace(/\D/g,'')" /> <span
					style="color:red;font-weight: bold;">*</span></li>
				<li><label>状态：</label> <input type="radio" id="a_state"
					name="status" checked="checked" value="1" />上架 <input type="radio"
					id="a_state" name="status" value="2" />下架</li>
			</ul>
			<div class="clear"></div>

			<ul class="downul">
				<li><span>商品规格：</span> <br /> <textarea class="cleditor"
						id="a_goodsFormat" name="specifications" rows="3"></textarea></li>
			</ul>
			<ul class="downul">
				<li><span>商品说明：</span> <br /> <textarea class="cleditor"
						id="a_note" name="details" rows="3"></textarea></li>
			</ul>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn addgoodsinfocancel" data-dismiss="modal">取消</a>
			<input type="submit" class="btn btn-primary" value="保存" />
		</div>
	</form>
</div>

<!-- 修改商品信息 -->
<div class="modal hide fade" id="modifyGoodsInfoDiv">
	<form action="admin/modifyCommodity" enctype="multipart/form-data"
		method="post" onsubmit="return modifyGoodsInfoFunction();">
		<div class="modal-header">
			<button type="button" class="close modifygoodsinfocancel"
				data-dismiss="modal">×</button>
			<h3>修改商品信息</h3>
		</div>
		<div class="modal-body">
			<ul id="modify_formtip"></ul>
			<input id="m_id" type="hidden" name="commodityid" />
			<ul class="topul">
				<li><label>商品名称：</label><input type="text" id="m_goodsName" name="commodityname" />
				 <span style="color:red;font-weight: bold;">*</span>
				</li>
				<li><label>市场价：</label><input type="text" id="m_marketPrice"
					name="yprice"
					onkeyup="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;" />
					<span style="color:red;font-weight: bold;">*</span></li>
				<li><label>优惠价：</label> <input type="text" id="m_realPrice"
					name="xprice"
					onkeyup="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;" />
					<span style="color:red;font-weight: bold;">*</span></li>
				<li><label>库存量：</label><input type="text" id="m_num"
					name="number" onkeyup="this.value=this.value.replace(/\D/g,'')"
					onafterpaste="this.value=this.value.replace(/\D/g,'')" /> <span
					style="color:red;font-weight: bold;">*</span></li>

			</ul>
			<div class="clear"></div>
			<ul class="downul">
				<li id="m_state"></li>
				<li id="m_goodsFormatli"></li>
			</ul>
			<ul class="downul">
				<li id="m_noteli"></li>
			</ul>
		</div>

		<div class="modal-footer">
			<a href="#" class="btn modifygoodsinfocancel" data-dismiss="modal">取消</a>
			<input type="submit" class="btn btn-primary" value="保存" />
		</div>
	</form>
</div>

<!-- 查看商品信息 -->
<div class="modal hide fade" id="viewGoodsInfoDiv">
	<div class="modal-header">
		<button type="button" class="close viewgoodsinfocancel"
			data-dismiss="modal">×</button>
		<h3>查看商品信息</h3>
	</div>
	<div class="modal-body">
		<ul class="topul">
			<li><label>商品名称：</label><input type="text" id="v_goodsName"
				name="goodsName" readonly="readonly" /></li>
			<li><label>市场价：</label><input type="text" id="v_marketPrice"
				name="marketPrice" readonly="readonly" /></li>
			<li><label>优惠价：</label> <input type="text" id="v_realPrice"
				name="realPrice" readonly="readonly" /></li>
			<li><label>库存量：</label><input type="text" id="v_num" name="num"
				readonly="readonly" /></li>
			<li><label>状态：</label> <span id="v_state"></span></li>
		</ul>
		<div class="clear"></div>
		<ul class="downul">
			<li><span>商品规格：</span> <br />
				<div id="v_goodsFormat" readonly="readonly" rows="3"></div></li>
		</ul>
		<ul class="downul">
			<li><span>商品说明：</span> <br />
				<div id="v_note" readonly="readonly" rows="3"></div></li>
		</ul>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn viewgoodsinfocancel" data-dismiss="modal">关闭</a>
	</div>
</div>

<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="statics/localjs/goodsinfolist.js"></script>
