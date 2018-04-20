<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">会员管理</a> <span class="divider">/</span></li>
		<li><a href="/member/modifypersonalinfo.html">修改本人资料</a></li>
	</ul>
</div>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i>修改本人资料</h2>
					</div>
				<div class="box-content">
				<form action="admin/UpdateUserZJ" enctype="multipart/form-data" method="post" onsubmit="return modifyPersonalInfoFunc();">
					<div class="member-modal-body">
						<ul id="modify_formtip"></ul>
						<input id="m_id" type="hidden" name="userid" value="${currentUser.userid}"/>
						<ul class="topul">
							<li>
							  <label>角色：</label>
							  <input id="m_rolename" type="text" name="roleName" value="${currentUser.roleName}" readonly="readonly"/>
							  <span style="color:red;font-weight: bold;">*</span>
							</li>
							<li>
							  <label>会员类型：</label>
							  <input id="m_usertypename" type="text" name="hyType" value="${currentUser.hyType}" readonly="readonly"/>
							</li>
							<li>
							  <label>用户名：</label><input type="text" id="m_logincode" name="loginname" value="${currentUser.loginname}" readonly="readonly"/>
							  <span style="color:red;font-weight: bold;">*</span>
							</li>
							<li>
							  <label>姓名：</label><input type="text" id="m_username" name="uname" value="${currentUser.uname}" />
							  <span style="color:red;font-weight: bold;">*</span>
							</li> 
							<li>
							  <label>性别：</label>
 							  <select id="m_sex" name="sex" style="width:100px;">
								<option value="" selected="selected">--请选择--</option>
								　　 <c:if test="${currentUser.sex == '男'}">  
									　　<option value="男" selected="selected">男</option>
										<option value="女">女</option>
								　　 </c:if>  
								　　 <c:if test="${currentUser.sex == '女'}">  
									　    <option value="女" selected="selected">女</option>
										<option value="男">男</option>
								 	 </c:if>
								　　  <c:if test="${currentUser.sex == null || currentUser.sex == ''}">  
									　    <option value="男">男</option>
										<option value="女">女</option>
								 	</c:if>
						 	  </select>
							</li> 
							<li>
							  <label>证件类型：</label>
							  <input id="m_cardtypename" type="hidden" name="cardTypeName" value="${currentUser.cardnumberName}"/>
							   
							   <select id="m_cardtype" name="cardtypeid" style="width:100px;">
					 			<option value="" selected="selected">--请选择--</option>
					 			<c:if test="${zjlist != null}">
					 				<c:forEach items="${zjlist}" var="cardtype">
					 					<option <c:if test="${currentUser.cardtypeid == cardtype.dictionaryid}">selected = "selected"</c:if>
					 					value="${cardtype.dictionaryid}">${cardtype.valuename}</option>
					 				</c:forEach>
					 			</c:if>
					 		   </select>
							  <span style="color:red;font-weight: bold;">*</span>
							</li>
							<li>
							    <label>证件号码：</label><input type="text" id="m_idcard" name="cardnumber" value="${currentUser.cardnumber}" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
								<span style="color:red;font-weight: bold;">*</span>
							</li>
							
							<li>
							    <label>联系电话：</label><input type="text" id="m_mobile" name="phone" value="${currentUser.phone}" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
								<span style="color:red;font-weight: bold;">*</span>
							</li>
							<li>
							  <label>Email：</label><input type="text" id="m_email" name="email" value="${currentUser.email}"/>
							</li>
							<li>
							  <label>邮政编码：</label><input type="text" id="m_postcode" name="postalcode" value="${currentUser.postalcode}" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
							</li>
							<li>
							    <label>开户行：</label>
							    
				<%-- <input type="text" id="m_bankname" name="bankname" value="${currentUser.bankname}"/> --%>
				
								<select  id="m_bankname" name="bankname" style="width: 160px;" >
								
										<c:forEach items="${backNameList}" var="bt">
											<option <c:if test="${currentUser.bankname==bt.valuename }" >selected="selected"</c:if> >${bt.valuename}</option>
										</c:forEach>
								
									
								</select>
									
									
								
								<span style="color:red;font-weight: bold;">*</span>
							</li>
							<li>
							    <label>开户卡号：</label><input type="text" id="m_bankaccount" name="banknumber" value="${currentUser.banknumber}" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
								<span style="color:red;font-weight: bold;">*</span>
							</li>
							<li>
							    <label>开户人：</label><input type="text" id="m_accountholder" name="bankuname" value="${currentUser.bankuname}"/>
								<span style="color:red;font-weight: bold;">*</span>
							</li>
							<li>
							  <label>推荐人：</label><input type="text" id="m_refercode" name="refereeName" value="${currentUser.refereeName}" readonly="readonly"/>
							</li>
							<li>
							  <label>注册时间：</label>
							  <input class="Wdate" id="m_createtime" size="15" name="created" disabled="disabled"  type="text" onClick="WdatePicker();" value="<fmt:formatDate value="${currentUser.created}" pattern="yyyy-MM-dd"/>"/>
							</li>
							<li>
							  <label>是否启用：</label>
							  <select id="m_isstart" name="status" style="width:100px;">
								　　 <c:if test="${currentUser.status == '0'}">  
									　　<option value="0" selected="selected">启用</option>
										<option value="1">未启用</option>
								　　 </c:if>  
								　　 <c:if test="${currentUser.status == '1'}">  
									　    <option value="1" selected="selected">未启用</option>
										<option value="0">启用</option>
								 	 </c:if>
						 	  </select>
							  <span style="color:red;font-weight: bold;">*</span>
							</li>
							<li class="lastli">
							  <label>收货地址：</label><textarea id="m_useraddress" name="address">${currentUser.address}</textarea>
							</li>
						</ul>
						<div class="clear"></div>
						<ul class="downul">
							<li>
							<label>上传身份证图片：</label>
								<input type="hidden" id="m_fileInputIDPath" name="cardimg" value="${currentUser.cardimg}"/>
								
								<input id="m_fileInputID" name="m_fileInputID" type="file"/>
								<c:if test="${currentUser.cardimg == null || currentUser.cardimg == ''}">
								     <input type="button" id="m_uploadbtnID" value="上传"/>
									 <p><span style="color:red;font-weight: bold;">*注：1、正反面.2、大小不得超过50k.3、图片格式：jpg、png、jpeg、pneg</span></p>
									 <div id="m_idPic"></div>
								</c:if>
								<c:if test="${currentUser.cardimg != null && currentUser.cardimg != ''}">
								     <input type="button" id="m_uploadbtnID_h" value="上传" style="display:none;"/>
									 <p><span style="color:red;font-weight: bold;">*注：1、正反面.2、大小不得超过50k.3、图片格式：jpg、png、jpeg、pneg</span></p>
									 <div id="m_idPic">
									 <p><span onclick="delpic('${currentUser.userid}','m_idPic','m_uploadbtnID_h',this,'${currentUser.cardimg}','m_fileInputIDPath','m_fileInputID');">x</span>
									 <img src="${currentUser.cardimg}"?m="+Math.random()+"" />
									 </p>
									 </div>
								</c:if>
							 </li>
						</ul>
						<ul class="downul">
							<li>
							<label>上传银行卡图片：</label>
								<input type="hidden" id="m_fileInputBankPath" name="yhimg" value="${currentUser.yhimg}"/>
								<input id="m_fileInputBank" name="m_fileInputBank" type="file">
								<c:if test="${currentUser.yhimg == null || currentUser.yhimg == ''}">
									 <input type="button" id="m_uploadbtnBank" value="上传"/>
									 <p><span style="color:red;font-weight: bold;">*注：1、大小不得超过50k.2、图片格式：jpg、png、jpeg、pneg</span></p>
									 <div id="m_bankPic"></div>
								</c:if>
								<c:if test="${currentUser.yhimg != null && currentUser.yhimg != ''}">
								     <input type="button" id="m_uploadbtnBank_h" value="上传" style="display:none;"/>
									 <p><span style="color:red;font-weight: bold;">*注：1、大小不得超过50k.2、图片格式：jpg、png、jpeg、pneg</span></p>
									 <div id="m_bankPic">
									 <p><span onclick="delpic('${currentUser.userid}','m_bankPic','m_uploadbtnBank_h',this,'${currentUser.yhimg}','m_fileInputBankPath','m_fileInputBank');">x</span>
									 <img src="${currentUser.yhimg}"?m="+Math.random()+"" />
									 </p>
									 </div>
								</c:if>
							 </li>
						</ul>
					</div>
					<div class="clear"></div>
					<div class="modifymemberinfo">
						<input type="submit"  class="btn btn-primary" value="保存" />
					</div>
				</form>	
				</div>
			</div><!--/span-->
		</div><!--/row-->
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="statics/localjs/modifypersonalinfo1.js"></script> 
