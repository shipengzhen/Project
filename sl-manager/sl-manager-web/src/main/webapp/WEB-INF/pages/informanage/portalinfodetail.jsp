<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
	<!-- 资讯 -->

			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-file"></i> ${information.ztitle}</h2>
						<div class="box-icon">
							<a href="javascript:window.history.back(-1);"><span class="icon icon-color icon-undo" title="返回" /></a>
						</div>
					</div>
					<div class="box-content">
					 <h1 style="text-align:center;">${information.ztitle}</h1>
					 	<div style="border-bottom:1px solid #ccc;padding:5px;">发布者： ${information.createUname}  发布时间：<fmt:formatDate value="${information.created}" pattern="yyyy-MM-dd"/></div>
					 	<p style="padding:10px;">
					 		${information.zdoc}
					 	</p>
					 	
					 	<c:if test="${information.zfile == null || information.zfile == null || information.filename == '' || information.filename == ''}">
					 	<p>
					 		附件：暂无
					 	</p>
					 	</c:if>
					 	<c:if test="${information.filename != null && information.filename != null && information.zfile != '' && information.zfile != ''}">
					 	<p>
					 		附件：<a onclick="downLoad()"  href="${information.zfile}">${information.filename} (右键另存为...)</a>
					 	</p>
					 	</c:if>
					 </div>
					</div><!--/span-->
				</div><!--/row-->
				
				
				
				
				
				
<script type="text/javascript" src="statics/localjs/infoxq.js"></script> 			
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
