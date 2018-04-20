<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>

			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-th"></i> 公告栏</h2>
						<div class="box-icon">
							<a style="display:block;width:60px;padding-right:1px;font-size:14px;" href="/informanage/portalafficheList.html">more >></a>
						</div>
					</div>
					<div class="box-content">
					  <table style="width:100%;">
						  <c:if test="${info.list != null}">
						  <c:forEach items="${info.list}" var="affiche">
							<tr>
								<td style="width:20px;padding:3px;"><span class="icon icon-color icon-info"/></td>
								<td style=""><a href="admin/goAfficheView?id=${affiche.gid}">${affiche.gtitle}</a></td>
								<td style="width:80px;"><fmt:formatDate value="${affiche.begindate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						  </c:forEach>
						 </c:if> 
					  </table>  
					 </div>
					</div><!--/span-->
				</div><!--/row-->
				
				
				
				
				<div class="row-fluid sortable">	
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-file"></i> 资讯栏</h2>
						<div class="box-icon">
							<a style="display:block;width:60px;padding-right:1px;font-size:14px;" href="admin/infoList">more >></a>
						</div>
					</div>
					<div class="box-content">
						<table style="width:100%;">
						  <c:if test="${infolist != null}">
						  <c:forEach items="${infolist}" var="info">
							<tr>
								<td style="width:20px;padding:3px;"><span class="icon icon-color icon-info"/></span></td>
								<td style=""><a href="admin/goInfoXQ?id=${info.zid}">${info.ztitle}</a></td>
								<td style="width:80px;"><fmt:formatDate value="${info.created}" pattern="yyyy-MM-dd"/></td>
							</tr>
						  </c:forEach>
						 </c:if>
					  </table>  
					  </div>
					</div><!--/span-->
				</div><!--/row-->
				
				
				
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
