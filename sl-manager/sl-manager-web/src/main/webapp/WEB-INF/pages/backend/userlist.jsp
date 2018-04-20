<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">后台管理</a> <span class="divider">/</span></li>
		<li><a href="/backend/userlist.html">用户管理</a></li>
	</ul>
</div>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> 用户列表</h2>
						<div class="box-icon">
						
							<span class="icon32 icon-color icon-add custom-setting adduser"/>
						</div>
					</div>
			
					<div class="box-content">
						<form action="admin/userList" method="post">
							<div class="searcharea">
							用户名称:
							<input type="text" name="loginname" value="${user1.loginname}" />
							<input type="hidden" name="pageNo" > 
							推荐人：
							<input type="text" name="refereeName" value="${user1.refereeName}" />
							角色：
							 <select name="roleid" style="width:100px;">
					 			<option value="" selected="selected">--请选择--</option>
					 			<c:if test="${rList != null}">
					 				<c:forEach items="${rList}" var="role">
					 				<option <c:if test="${user1.roleid == role.roleid}">selected = "selected"</c:if>
					 					value="${role.roleid}">${role.rolename}</option>
					 				</c:forEach>
					 			</c:if>
					 		</select>
							是否启用：
							 <select name="status" style="width:100px;">
								<option value="" selected="selected">--请选择--</option>
								　　 <c:if test="${user1.status == 1}">  
									　　<option value="0" selected="selected">启用</option>
										<option value="1">未启用</option>
								　　 </c:if>  
								　　 <c:if test="${user1.status == 2}">  
									　    <option value="1" selected="selected">未启用</option>
										<option value="0">启用</option>
								 	 </c:if>
								　　  <c:if test="${user1.status == null}">  
									　    <option value="1">未启用</option>
										<option value="0">启用</option>
								 	</c:if>
						 	</select>
							<button type="submit" class="btn btn-primary"><i class="icon-search icon-white"></i> 查询 </button>
						</div>
						</form>
					
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>用户名</th>
								  <th>角色</th>
								  <th>会员类型</th>
								  <th>推荐人</th>
								  <th>状态(启用/禁用)</th>
								  <th>注册时间</th>
								  <th>操作</th>
							  </tr>
						  </thead>   
						  <tbody>
						  
						  <c:if test="${info.list != null}">
						  <c:forEach items="${info.list}" var="user2">
							<tr>
								<td class="center">${user2.loginname}</td>
								<td class="center">
								  <c:if test="${rList != null}">
					 				<c:forEach items="${rList}" var="role">
					 					<c:if test="${user2.roleid == role.roleid}">${role.rolename}</c:if>
					 				</c:forEach>
					 			  </c:if>
								</td>
								<td class="center">
								  <c:if test="${RoleTypelist != null}">
					 				<c:forEach items="${RoleTypelist}" var="zj">
					 					<c:if test="${user2.associatorid == zj.id}">${zj.roletypename}</c:if>
					 				</c:forEach>
					 			  </c:if>
								
								</td>
								<td class="center">${user2.refereeName}</td>
								<td class="center">
								<c:if test="${user2.status == 1}">
									<input type="checkbox" disabled="disabled"/>禁用
								</c:if>
                    			<c:if test="${user2.status == 0}">
                    				<input type="checkbox" checked="true" disabled="disabled"/>启用
                    			</c:if>
								</td>
								<td class="center">
								<fmt:formatDate value="${user2.created}" pattern="yyyy-MM-dd"/>
								</td>
								<td class="center">
									<a class="btn btn-success viewuser" id="${user2.userid}">
										<i class="icon-zoom-in icon-white"></i>  
										查看                                           
									</a>
									<a class="btn btn-info modifyuser" id="${user2.userid}">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger deluser" logincode="${user2.loginname}" id="${user2.userid}" idcardpicpath="${user2.cardimg}" bankpicpath="${user2.yhimg}">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
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
				  <%--   <ul>
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
		
		
		
		
	<!--添加用户信息  -->
	<div class="modal hide fade" id="addUserDiv">
		<form action="admin/addUser" enctype="multipart/form-data" method="post" onsubmit="return addUserFunction();">
			<div class="modal-header">
				<button type="button" class="close addusercancel" data-dismiss="modal">×</button>
				<h3>添加用户信息</h3>
			</div>
			<div class="modal-body">
				<ul id="add_formtip"></ul>
				<ul class="topul">
					<li>
					  <label>角色：</label>
					 <!--  <input id="selectrolename" type="hidden" name="roleName" value=""/> -->
					  
					  <!-- 角色id -->
					  <select id="selectrole" name="roleid" style="width:100px;">
			 			<option value="" selected="selected">--请选择--</option>
			 				<c:forEach items="${rList}" var="role">
			 					<option value="${role.roleid}">${role.rolename}</option>
			 				</c:forEach>
			 		 </select>
			 		 
			 		 
			 		 <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>会员类型：</label>
					  <input id="selectusertypename" type="hidden" name="userTypeName" value=""/>
					  
					  <select id="selectusertype" name="associatorid" style="width:100px;">
					  	<option value="" selected="selected">--请选择--</option>
			 		  </select>
			 		  
					</li>
					<li>
					
					  <label>用户名：</label><input type="text" id="a_logincode" name="loginname" placeholder="字母和数字6~12位" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
					  <span style="color:red;font-weight: bold;">*</span>
					  <span></span>
					</li>
					<li>
					  <label>姓名：</label><input type="text" id="a_username" name="uname" />
					  <span style="color:red;font-weight: bold;">*</span>
					</li> 
					<li>
					  <label>性别：</label>
		 			  <select name="sex" style="width:100px;">
		 				<option value="男">男</option>
		 				<option value="女">女</option>
		 			  </select> 
					</li> 
					<li>
					  <label>证件类型：</label>
					  <input id="selectcardtypename" type="hidden" name="cardTypeName" value=""/>
					  <select id="selectcardtype" name="cardtypeid" style="width:100px;">
			 			<c:if test="${zjlist != null}">
			 				<c:forEach items="${zjlist}" var="cardType">
			 					<option value="${cardType.dictionaryid}">${cardType.valuename}</option>
			 				</c:forEach>
			 			</c:if>
			 		 </select>
			 		 <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>证件号码：</label>
					  <input type="text" id="a_idcard" name="cardnumber" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					
					<li>
					  <label>联系电话：</label>
					  <input type="text" id="a_mobile" name="phone" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>Email：</label><input type="text" id="a_email" name="email"/>
					</li>
					<li>
					  <label>邮政编码：</label><input type="text" id="a_postCode" name="postalcode" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					</li>
					<li>
					  <label>开户行：</label><!-- <input type="text" id="a_bankname" name="bankname"/> -->
					  
					  <select id="a_bankname" name="bankname" style="width:157px;">
					  	<c:forEach items="${backNameList}" var="backnlist" >
					  		<option >${backnlist.valuename }</option>
					  	</c:forEach>
					  
					  </select>
					  
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>开户卡号：</label><input type="text" id="a_bankaccount" name="banknumber" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>开户人：</label><input type="text" id="a_accountholder" name="bankuname"/>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>推荐人：</label><input type="hidden" name="referee" value="${User.userid}" readonly="readonly"/>
					  <input type="text" name="referee123" value="${User.loginname}" readonly="readonly"/>
					</li>
					<li>
					  <label>注册时间：</label>
					   <input type="text" id="a_cdate"  value="" readonly="readonly"/>
					   </li>
					<li>
					  <label>是否启用：</label>
		 			  <select name="status" style="width:100px;">
		 				<option value="0" selected="selected">启用</option>
		 				<option value="1">不启用</option>
		 			  </select> <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li class="lastli">
					  <label>收货地址：</label><textarea id="a_useraddress" name="address"></textarea>
					</li>
				</ul>
				<div class="clear"></div>
				<ul class="downul">
					<li>
					<label>上传身份证图片：</label>
						<input type="hidden" id="a_fileInputIDPath" name="cardimg" value=""/>
						
						<input id="a_fileInputID" name="a_fileInputID" type="file"/>
						<input type="button" id="a_uploadbtnID" value="上传"/>
						<p><span style="color:red;font-weight: bold;">*注：1、正反面.2、大小不得超过50k.3、图片格式：jpg、png、jpeg、pneg</span></p>
						<div id="a_idPic"></div>
						
					 </li>
				</ul>
				<ul class="downul">
					<li>
					<label>上传银行卡图片：</label>
						<input type="hidden" id="a_fileInputBankPath" name="yhimg" value=""/>
						
						<input id="a_fileInputBank" name="a_fileInputBank" type="file"/>
						<input type="button" id="a_uploadbtnBank" value="上传"/>
						<p><span style="color:red;font-weight: bold;">*注：1、大小不得超过50k.2、图片格式：jpg、png、jpeg、pneg</span></p>
						<div id="a_bankPic"></div>
					 </li>
				</ul>
			</div>
			
			<div class="modal-footer">
				<a href="#" class="btn addusercancel" data-dismiss="modal">取消</a>
				<input type="submit"  class="btn btn-primary" value="保存" />
			</div>
		</form>
	 </div>


	<!-- 修改  -->

	 <div class="modal hide fade" id="modifyUserDiv">
		<form action="admin/UpdateUser" enctype="multipart/form-data" method="post" onsubmit="return modifyUserFunction();">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>修改用户信息</h3>
			</div>
			<div class="modal-body">
				<ul id="modify_formtip"></ul>
				<input id="m_id" type="hidden" name="userid"/>
				<ul class="topul">
					<li>
					  <label>角色：</label>
					  <input id="m_rolename" type="hidden" name="roleName" value=""/>
					  	<select id="m_roleId" name="roleid" style="width:100px;">
					  </select>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>会员类型：</label>
					  <input id="m_selectusertypename" type="hidden" name="" value=""/>
					  <select id="m_selectusertype" name="associatorid" style="width:100px;">
			 		  </select>
					</li>
					<li>
					  <label>用户名：</label><input type="text" id="m_logincode" name="loginname" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>姓名：</label><input type="text" id="m_username" name="uname" />
					  <span style="color:red;font-weight: bold;">*</span>
					</li> 
					<li>
					  <label>性别：</label>
		 			  <select id="m_sex" name="sex" style="width:100px;">
					  </select>
					</li> 
					<li>
					  <label>证件类型：</label>
					  <input id="m_cardtypename" type="hidden" name="" value=""/>
					  
					  <select id="m_cardtype" name="cardtypeid" style="width:100px;">
					  </select>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>证件号码：</label><input type="text" id="m_idcard" name="cardnumber" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
				
					<li>
					  <label>联系电话：</label><input type="text" id="m_mobile" name="phone" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>Email：</label><input type="text" id="m_email" name="email"/>
					</li>
					<li>
					  <label>邮政编码：</label><input type="text" id="m_postcode" name="postalcode" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					</li>
					<li>
					  <label>开户行：</label><!--  <input type="text" id="m_bankname" name="bankname"/> -->
					     <select id="m_bankname" name="bankname" style="width:157px;">
						  	
					  	</select>
					  
					  <span style="color:red;font-weight: bold;">*</span>
					  
					 
					  
					</li>
					<li>
					  <label>开户卡号：</label><input type="text" id="m_bankaccount" name="banknumber" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>开户人：</label><input type="text" id="m_accountholder" name="bankuname"/>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li>
					  <label>推荐人：</label><input type="text" id="m_refercode" readonly="readonly"/>
					</li>
					<li>
					  <label>注册时间：</label>
					  <input type="text" id="m_createtime" name="" readonly="readonly"/>
					</li>
					<li>
					  <label>是否启用：</label>
					  <select id="m_isstart" name="status" style="width:100px;">
					  </select>
					  <span style="color:red;font-weight: bold;">*</span>
					</li>
					<li class="lastli">
					  <label>收货地址：</label><textarea id="m_useraddress" name="address"></textarea>
					</li>
					
				</ul>
				<div class="clear"></div>
				<ul class="downul">
					<li>
					<label>上传身份证图片：</label>
						<input type="hidden" id="m_fileInputIDPath" name="cardimg" value=""/>
						
						<input id="m_fileInputID" name="m_fileInputID" type="file">
						<input type="button" id="m_uploadbtnID" value="上传" style="display:none;"/>
						<p><span style="color:red;font-weight: bold;">*注：1、正反面.2、大小不得超过50k.3、图片格式：jpg、png、jpeg、pneg</span></p>
						<div id="m_idPic"></div>
					 </li>
				</ul>
				<ul class="downul">
					<li>
					<label>上传银行卡图片：</label>
						<input type="hidden" id="m_fileInputBankPath" name="yhimg" value=""/>
						
						<input id="m_fileInputBank" name="m_fileInputBank" type="file">
						<input type="button" id="m_uploadbtnBank" value="上传"/>
						<p><span style="color:red;font-weight: bold;">*注：1、大小不得超过50k.2、图片格式：jpg、png、jpeg、pneg</span></p>
						<div id="m_bankPic"></div>
					 </li>
				</ul>
			</div>
			
			<div class="modal-footer">
				<a href="#" class="btn modifyusercancel" data-dismiss="modal">取消</a>
				<input type="submit"  class="btn btn-primary" value="保存" />
			</div>
		</form>
	 </div>
	
	
	<!-- 查看 -->
	 <div class="modal hide fade" id="viewUserDiv">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>查看用户信息</h3>
			</div>
			<div class="modal-body">
				<input id="v_id" type="hidden" value=""/>
				<ul class="topul">
					<li>
					  <label>角色：</label>
					  <input id="v_rolename" type="text" value=""/>
					</li>
					<li>
					  <label>会员类型：</label>
					  <c:forEach var="var" items="${hylist}">
					  	
					  </c:forEach>
					  
					  <input id="v_usertypename" type="text" value=""/>
					</li>
					<li>
					  <label>用户名：</label><input type="text" id="v_logincode" value="" />
					</li>
					<li>
					  <label>姓名：</label><input type="text" id="v_username" value="" />
					</li> 
					<li>
					  <label>性别：</label>
					  <input type="text" id="v_sex" value="" />
					</li> 
					<li>
					  <label>证件类型：</label>
					  <input id="v_cardtypename" type="text" value=""/>
					</li>
					<li>
					  <label>证件号码：</label><input type="text" id="v_idcard" value="" />
					</li>
				
					<li>
					  <label>联系电话：</label><input type="text" id="v_mobile" value=""/>
					</li>
					<li>
					  <label>Email：</label><input type="text" id="v_email" value=""/>
					</li>
					<li>
					  <label>邮政编码：</label><input type="text" id="v_postcode" value=""/>
					</li>
					<li>
					  <label>开户行：</label><input type="text" id="v_bankname" value=""/>
					</li>
					<li>
					  <label>开户卡号：</label><input type="text" id="v_bankaccount" value=""/>
					</li>
					<li>
					  <label>开户人：</label><input type="text" id="v_accountholder" value=""/>
					</li>
					<li>
					  <label>推荐人：</label><input type="text" id="v_refercode" value=""/>
					</li>
					<li>
					  <label>注册时间：</label>
					  <input type="text" id="v_createtime" value=""/>
					</li>
					<li>
					  <label>是否启用：</label>
					  <select id="v_isstart" style="width:100px;" disabled="disabled">
					  </select>
					</li>
					<li class="lastli">
					  <label>收货地址：</label>
					  <textarea id="v_useraddress" name="userAddress"></textarea>
					</li>
					
				</ul>
				<div class="clear"></div>
				<ul class="downul">
					<li>
					<label>上传身份证图片
					(正反面)：</label>
						<input type="hidden" id="v_fileInputIDPath" value=""/>
						<div id="v_idPic"></div>
					 </li>
				</ul>
				<ul class="downul">
					<li>
					<label>上传银行卡图片：</label>
						<input type="hidden" id="v_fileInputBankPath" value=""/>
						<div id="v_bankPic"></div>
					 </li>
				</ul>
			</div>
			
			<div class="modal-footer">
				<a href="#" class="btn viewusercancel" data-dismiss="modal">关闭</a>
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
     var cartTypeListJson =	[ 
    						<c:forEach  items="${zjlist}" var="cardType"> 
								{"valueId":"${cardType.dictionaryid}","valueName":"${cardType.valuename}"},
							</c:forEach>
								{"valueId":"over","valueName":"over"}
							];
    var roleListJson =	[
    					<c:forEach  items="${rList}" var="role"> 
							{"id":"${role.roleid}","roleName":"${role.rolename}"},
						</c:forEach>
						{"id":"over","roleName":"over"}
						]; 
    
    var backname=[
			 	<c:forEach items="${backNameList}" var="backnlist">
			 	{"valuename":"${backnlist.valuename }"},
		  		</c:forEach>
		{"valuename":"over"}
    	
    ];
</script>





<script type="text/javascript" src="statics/localjs/userlist1.js"></script> 
