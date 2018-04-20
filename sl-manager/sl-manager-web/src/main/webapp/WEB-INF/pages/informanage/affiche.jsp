<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">信息管理</a> <span class="divider">/</span></li>
		<li><a href="/informanage/affiche.html">公告管理</a></li>
	</ul>
</div>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> 公告列表</h2>
						
						<div class="box-icon">
							<c:if test="${insertAffiche=='1'}">
								<span class="icon32 icon-color icon-add custom-setting addAffiche"/>
							</c:if>
						</div>
					</div>
					<form action="admin/affichList"  method="post" style="display:none;">
						<input type="hidden" name="pageNum" value="1">
					</form>
					
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>标题</th>
								  <th>发布者</th>
								  <th>发布时间</th>
								  <th>有效期</th>
								  <th>操作 </th>
							  </tr>
						  </thead>   
						  <tbody>
						  
						  <c:if test="${info.list != null}">
						  <c:forEach items="${info.list}" var="affiche">
							<tr>
							
								<td class="center">${affiche.gtitle}</td>
								<td class="center">${affiche.userName}</td>
								<td class="center"><fmt:formatDate value="${affiche.created}" pattern="yyyy-MM-dd"/></td>
								<td class="center"><fmt:formatDate value="${affiche.begindate}" pattern="yyyy-MM-dd"/> - <fmt:formatDate value="${affiche.enddate}" pattern="yyyy-MM-dd"/></td>
								<td class="center">
									<c:if test="${selectAffiche=='1'}">
										<a class="btn btn-success viewaffiche" href="#" id="${affiche.gid}">
											<i class="icon-zoom-in icon-white"></i>  
											查看                                           
										</a>
									</c:if>
									
									<c:if test="${updateAffiche=='1'}">
									<a class="btn btn-info modifyaffiche" href="#" id="${affiche.gid}" title="${affiche.gtitle}">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									</c:if>
									
									<c:if test="${deleteAffiche=='1'}">
									<a class="btn btn-danger delaffiche" href="#" id="${affiche.gid}" title="${affiche.gtitle}">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
									</c:if>
								</td>
							</tr>
						  </c:forEach>
						 </c:if>
						  </tbody>
					  </table>   
					<div class="pagination pagination-centered">
								<ul>
					<c:choose>
					
						<c:when test="${info.isFirstPage}">
							<li class="active"><a title="首页">首页</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:page(document.forms[0],1)" title="首页">首页</a></li>
						</c:otherwise>
					</c:choose>
					<c:forEach items="${info.navigatepageNums}" var="i">
						<li <c:if test='${info.pageNum==i}'> class="active" </c:if>>
							<a href='javascript:page(document.forms[0],${i})'> ${i} </a>
						</li>
					</c:forEach>
					<c:choose>
						<c:when test="${info.isLastPage}">
							<li class="active"><a title="尾页">尾页</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="javascript:page(document.forms[0],${info.pages})"
								title="尾页">尾页</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
					
					 	 <%-- <ul>
						<li><a href="javascript:page(document.forms[0],1)" title="首页">首页</a></li>
						<c:forEach items="${info.navigatepageNums}" var="i">
							<li <c:if test='${info.pageNum==i}'> class="active" </c:if>  >
							<a href='javascript:page(document.forms[0],${i})'  >
								${i} 
							</a>
							</li>
						</c:forEach>
						<li><a href="javascript:page(document.forms[0],${info.pages})" title="尾页">尾页</a></li>
				   </ul> --%>
				    </div>
				  
				</div>
			</div><!--/span-->
		</div><!--/row-->
<!-- 新增 公告 -->
	<div class="modal hide fade" id="addAfficheDiv">
		<form action="admin/addAffich" enctype="multipart/form-data" method="post" onsubmit="return addAfficheFunction();">
			<div class="modal-header">
				<button type="button" class="close addusercancel" data-dismiss="modal">×</button>
				<h3>添加公告信息</h3>
			</div>
			<div class="add_affiche_modal-body">
				<ul id="add_formtip"></ul>
				<ul class="topul">
			<!-- 		<li>
					  <label>公告代码：</label><input id="afficheCode" type="text" name="code" value=""/>
					</li> -->
					<li>
					  <label>标题：</label><input id="afficheTitle" type="text" name="gtitle" value=""/>
					</li>
				</ul>
				<div class="clear"></div>
				<ul class="downul">
					<li>
					<label>有效期：</label> 
					    
					     <input class="Wdate" id="startTime" size="15" name="begindate" readonly="readonly" type="text" onClick="WdatePicker();"/>至
					    <input class="Wdate" id="endTime" size="15" name="enddate" readonly="readonly" type="text" onClick="WdatePicker();"/>
					 </li>
				</ul>
				<ul class="downul">
					<li>
					<span>公告内容：</span> <br/><textarea class="cleditor" id="afficheContent" name="gdoc" rows="3"></textarea>
					 </li>
				</ul>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn addusercancel" data-dismiss="modal">取消</a>
				<input type="submit"  class="btn btn-primary" value="保存" />
			</div>
		</form>
	 </div>
	 
	 
	 
<!-- 修改 -->
	 <div class="modal hide fade" id="modifyAfficheDiv">
		<form action="admin/udpateAffiche" enctype="multipart/form-data" method="post" onsubmit="return modifyAfficheFunction();">
			<div class="modal-header">
				<button type="button" class="close addusercancel" data-dismiss="modal">×</button>
				<h3>修改公告信息</h3>
				<input type="hidden" name="gid" id="afficheIdModify"/>
			</div>
			<div class="add_affiche_modal-body">
				<ul id="add_formtipModify"></ul>
				<ul class="topul">
					
					<li>
					  <label>标题：</label><input id="afficheTitleModify" type="text" name="gtitle" value=""/>
					</li>
				</ul>
				<div class="clear"></div>
				<ul class="downul">
					<li>
					<label>有效期：</label> 
					   
					 	<input class="Wdate" id="startTimeModify" size="15" name="begindate" readonly="readonly"  value="" type="text" onClick="WdatePicker();"/>至
					    <input class="Wdate" id="endTimeModify" size="15" name="enddate" readonly="readonly"  value="" type="text" onClick="WdatePicker();"/>
					 </li>
				</ul>
				<ul class="downul">
					<li id="modifyafficheli">
					 </li>
				</ul>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn addusercancel" data-dismiss="modal">取消</a>
				<input type="submit"  class="btn btn-primary" value="保存" />
			</div>
		</form>
	 </div>


<!-- 查看 -->
	 <div class="modal hide fade" id="viewAfficheDiv">
			<div class="modal-header">
				<button type="button" class="close addusercancel" data-dismiss="modal">×</button>
				<h3>查看公告信息</h3>
			</div>
			<div class="add_affiche_modal-body">
				<ul id="add_formtip"></ul>
				<ul class="topul">
				
					<li>
					  <label>标题：</label><input id="afficheTitleText" readonly="readonly" type="text" name="title" value=""/>
					</li>
				</ul>
				<div class="clear"></div>
				<ul class="downul">
					<li>
					<label>有效期：</label> <input id="startTimeText" readonly="readonly" value="" type="text" />  至
					   <input id="endTimeText" readonly="readonly" value="" type="text"/> 
					 </li>
				</ul>
				<ul class="downul">
					<li>
					<span>公告内容：</span> <br/><div id="afficheContentText" readonly="readonly" rows="3"></div>
					 </li>
				</ul>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">关闭</a>
			</div>
	 </div>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="statics/localjs/affiche.js"></script> 
<script type="text/javascript">

function page(frm,num){
	frm.pageNum.value = num;
	frm.submit();
}
</script>
