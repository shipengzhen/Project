<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">信息管理</a> <span class="divider">/</span></li>
		<li><a href="/informanage/information.html">资讯管理</a></li>
	</ul>
</div>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> 资讯列表</h2>
						<div class="box-icon">
							<c:if test="${insertInfo=='1'}">
							<span class="icon32 icon-color icon-add custom-setting addInformation"/>
							</c:if>
						</div>
					</div>
					<form action="admin/infoList" method="post">
						<input type="hidden" name="pageNo" value="1">
					</form>
					
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>标题</th>
								  <th>文件大小</th>
								  <th>状态（发布/不发布）</th>
								  <th>发布者</th>
								  <th>最后修改时间</th>
								  <th>操作</th>
							  </tr>
						  </thead>   
						  <tbody>
						  
						  <c:if test="${info.list != null}">
						  <c:forEach items="${info.list}" var="infor">
							<tr>
							
								<td class="center">${infor.ztitle}</td>
								<td class="center">${infor.zfilesize/1000}KB</td>
								<td class="center">
								<c:choose>
									<c:when test="${User.roleid==1}">
									
									<input type="checkbox" title="直接勾选修改状态，立即生效" data-rel="tooltip"
									 class="modifyInformationState" inforstate="${infor.status}" inforid="${infor.zid}" 
									 <c:if test="${infor.status == 0}">checked="true"</c:if>/>
									
									
									</c:when>
									<c:otherwise>
									<input type="checkbox" title="直接勾选修改状态，立即生效" data-rel="tooltip" disabled="disabled"
									 class="modifyInformationState" inforstate="${infor.status}" inforid="${infor.zid}" 
									 <c:if test="${infor.status == 0}">checked="true"</c:if>/>
									</c:otherwise>
								</c:choose>
								
			
								 
								</td>
								<td class="center">${infor.createUname}</td>
								<td class="center"><fmt:formatDate value="${infor.updated}" pattern="yyyy-MM-dd"/></td>
								<td class="center">
									<c:if test="${selectInfo=='1'}">
									<a class="btn btn-success viewinformation" href="#" id="${infor.zid}" title="${infor.ztitle}">
										<i class="icon-zoom-in icon-white"></i>  
										查看                                           
									</a>
									</c:if>
									
									<c:if test="${updateInfo=='1'}">
									<a class="btn btn-info modifyinformation" href="#" id="${infor.zid}" title="${infor.ztitle}">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									</c:if>
									
									<c:if test="${deleteInfo=='1'}">
									<a class="btn btn-danger delinformation" href="#" id="${infor.zid}" title="${infor.ztitle}">
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
					
					<%--  <ul>
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

<!-- 新增 -->
	<div class="modal hide fade" id="addInformationDiv">
		<form action="admin/addInfo" enctype="multipart/form-data" method="post" onsubmit="return addInfoFunction();">
			<div class="modal-header">
				<button type="button" class="close addusercancel" data-dismiss="modal">×</button>
				<h3>添加资讯信息</h3>
			</div>
			<div class="add_information_modal-body">
				<ul id="add_formtip"></ul>
				<ul class="topul">
					<li>
					
					  <label>标题：</label><input id="informationTitle" type="text" name="ztitle" value=""/>
					 
					</li>
					<li>
					  <label>资讯类型：</label>
					  <select id="docType" name="ztypeid" style="width:100px;">
					 			<option value="" selected="selected">--请选择--</option>
					 			<c:if test="${dilist != null}">
					 				<c:forEach items="${dilist}" var="dic">
					 					<option value="${dic.dictionaryid}">${dic.valuename}</option>
					 				</c:forEach>
					 			</c:if>
					 		</select>
					 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 		<input type="radio" checked="checked" name="status" value="0">发布
					 		<input type="radio" name="status" value="1">不发布
					</li>
				</ul>
				<div class="clear"></div>
				<ul class="downul">
					<li>
						<span>上传附件：</span>
						<input id="uploadInformationFile" name="uploadInformationFile" type="file" /> 
						<input type="button" id="informationuploadbtn" value="上传"/>
						
						<span style="color:red;font-weight: bold;">*注：上传大小不得超过 500M</span>
						<input type="hidden" id="zfile" name="zfile"/>
						<input type="hidden" id="uploadfilenamehide" name="filename" />
					 	
					 	<input type="hidden" id="uploadfilepathhide" name="fileName" />
					 	
					 
					 	<input type="hidden" id="typeNamehide" name="typeName" />
					 	<input type="hidden" id="fileSizehide" name="zfilesize" />
					 </li>
					 <li id="filearea">
					 	
					 </li>
				</ul>
				<ul class="downul">
					<li>
					<span>资讯内容：</span> <br/><textarea class="cleditor" id="informationContent" name="zdoc" rows="3"></textarea>
					 </li>
				</ul>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn addinfocancel" data-dismiss="modal">取消</a>
				<input type="submit"  class="btn btn-primary" value="保存" />
			</div>
		</form>
	 </div>
	 
<!-- 修改 -->
	 <div class="modal hide fade" id="modifyInfoDiv">
		<form action="admin/updateInfo" enctype="multipart/form-data" method="post" onsubmit="return modifyInfoFunction();">
			<div class="modal-header">
				<button type="button" class="close addusercancel" data-dismiss="modal">×</button>
				<h3>修改资讯信息</h3>
			</div>
			<div class="add_information_modal-body">
				<ul id="modify_formtip"></ul>
				<ul class="topul">
					<li>
					  <label>标题：</label><input id="informationTitleModify" type="text" name="ztitle" value=""/>
					</li>
					<li>
					  <label>资讯类型：</label>
					  <select id="docTypeModity" name="ztypeid" style="width:100px;"></select>
					</li>
				</ul>
				<div class="clear"></div>
				<ul class="downul">
					<li>
						<span>上传附件：</span>
						<input id="uploadInformationFileM" name="uploadInformationFile" type="file" /> 
						<input type="button" style="display: none" id="informationuploadMbtn" value="上传"/>
					 	<span style="color:red;font-weight: bold;">*注：上传大小不得超过 500M</span>
					 	<input type="hidden" id="infoIdModify" name="zid"/>
					 	
					 	<input type="hidden" id="uploadfilepathhideM" name="zfile" />	<!-- url -->
					 	<input type="hidden" id="uploadfilenamehideM" name="filename" /> <!-- 名称 -->
					 	
					 	<!-- <input type="hidden" id="typeNamehideM" name="typeName" /> -->
					 	<input type="hidden" id="fileSizehideM" name="zfilesize" />   <!-- 大小 -->
					 </li>
					 <li id="fileareaM">
					 	
					 </li>
				</ul>
				<ul class="downul">
					<li id="modifyinformationli">
					 </li>
				</ul>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn modifyinfocancel" data-dismiss="modal">取消</a>
				<input type="submit"  class="btn btn-primary" value="保存" />
			</div>
		</form>
	 </div>
	 
<!-- 查看 -->
	 <div class="modal hide fade" id="viewInfoDiv">
			<div class="modal-header">
				<button type="button" class="close addusercancel" data-dismiss="modal">×</button>
				<h3>查看资讯信息</h3>
			</div>
			
			
			<div class="view_information_modal-body">
				<ul class="viewinformationul" id="viewContent">
				</ul>
				<div class="clear"></div>
			</div>
			
			
			
			
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">关闭</a>
			</div>
	 </div>
	 
	 
	 
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
	<script type="text/javascript">
		function page(frm,num){
			frm.pageNo.value = num;
			frm.submit();
		}	
	</script>
<script type="text/javascript">
	var dicJson =	[<c:forEach  items="${dilist}" var="dic"> 
							{"valueId":"${dic.dictionaryid}","valueName":"${dic.valuename}"},
							</c:forEach>{"valueId":"over","valueName":"over"}];
</script>
<script type="text/javascript" src="statics/localjs/information.js"></script> 
