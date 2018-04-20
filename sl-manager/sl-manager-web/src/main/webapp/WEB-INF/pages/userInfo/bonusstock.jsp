<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">信息查询</a> <span class="divider">/</span></li>
		<li><a href="/informanage/affiche.html">推荐列表</a></li>
	</ul>
</div>
			<div class="row-fluid sortable">	
				
				<div class="box span12">
				
				
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> 推荐列表</h2>
					</div>
					
				
	
					
					<div class="box-content">
						<form action="admin/goPremium" method="post">
							<div class="searcharea">
							<input type="hidden" name="pageNo" value="1">
							用户名称:
							<input type="text" name="loginname" value="${loginname}" />
							会员类型：
							
							 <select name="associatorid" style="width:100px;"> 
							 	<option value="0" >--请选择--</option>
					 			<c:forEach items="${rTlist}" var="zj">
					 				<c:if test="${zj.id!=2}"> 
					 				
					 					<option value="${zj.id}" <c:if test='${zj.id==associatorid}' >selected="selected" </c:if> >${zj.roletypename}</option>
					 					
					 				</c:if>
					 			</c:forEach>
					 		</select>
							
							<button type="submit" class="btn btn-primary">
							<i class="icon-search icon-white"></i> 查询 </button>
						</div>
						</form>	
					
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th style="width: 15%;">时间</th>
								  <th>用户名</th>
								  <th>真实姓名</th>
								  <th style="width: 8%;">性别</th>
								  <th>推荐人类型</th>
								  <th>奖金</th>
							 </tr>
						  </thead>   
						  <tbody>
						  
						  <c:if test="${info.list != null}">
						  <c:forEach items="${info.list}" var="u">
							<tr>
							
								<td class="center"><fmt:formatDate value="${u.created}" pattern="yyyy-MM-dd"/> </td>
								<td class="center">${u.loginname}</td>
								<td class="center">${u.uname}</td>
								<td class="center">${u.sex }</td>
								<td class="center">
									  <c:if test="${rTlist != null}">
					 					<c:forEach items="${rTlist}" var="zj">
					 						<c:if test="${u.associatorid == zj.id}">${zj.roletypename}</c:if>
					 					</c:forEach>
					 			  	 </c:if>
								</td>
								<td char="center">
									<c:if test="${u.associatorid==3}">
										<c:forEach var="i" items="${SetMealList}">
											<c:if test="${i.smname=='消费会员'}">
												${i.smprice*0.1}
											</c:if>
										</c:forEach>
									</c:if>
									<c:if test="${u.associatorid==4}">
										<c:forEach var="i" items="${SetMealList}">
											<c:if test="${i.smname=='vip会员'}">
												${i.smprice*0.1}
											</c:if>
										</c:forEach>
									</c:if>
									<c:if test="${u.associatorid==5}">
										<c:forEach var="i" items="${SetMealList}">
											<c:if test="${i.smname=='加盟店'}">
												${i.smprice*0.1}
											</c:if>
										</c:forEach>
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

	 
	 
	 



<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="statics/localjs/affiche.js"></script> 
<script type="text/javascript">

function page(frm,num){
	frm.pageNo.value = num;
	frm.submit();
}
</script>
