<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>

				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i>汇款充值</h2>
					</div>
					<div class="box-content">
					
					
					<form class="form-horizontal"  method="post" action="accountsAction_update.action" id="form1">
						<div class="form-group">
							<label for="" class="col-md-2 control-label">汇款金额：</label>
							<div class="col-md-4 ">
								<input name="money" type="text" class="form-control" onkeyup="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;" />
								<span class="msg12"  style="color: red;"></span>
							</div>
						</div>
						<br/>
						<div class="form-group">
							<label for="" class="col-md-2 control-label">二级密码：</label>
							<div class="col-md-4 ">
								<input type="hidden" id="mima" value="${User.loginpwd2}">
								<input name="loginpwd2" type="password" class="form-control" />	<span class="msg12" style="color: red;"></span>
								<input type="hidden" name="mtype" value="0">
							</div>
						</div>
						<br/>
				<!-- 		<div class="form-group">
							<label for="" class="col-md-2 control-label">备注：</label>
							<div class="col-md-6">
								<textarea class="form-control" rows="10" cols="30" id="digest" name="remark"></textarea>
							</div>
						</div> -->
						<!-- data-toggle='modal' data-target='#myModal' -->
						<div class="col-md-10 col-md-offset-2">
							<input type="button" class="btn btn-success" name="sub" value="充值"/>
							 <input type="reset" class="btn btn-primary" value="重置" />
						</div>
					</form>
					<!--此处的提交只是显示模态框的-->
						
						<!-- Modal -->
					<div class="modal fade" id="CZsucc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">友情提示</h4>
					      </div>
					      <div class="modal-body">
					    		   <h3>充值成功！！！</h3> 
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					      </div>
					    </div>
					  </div>
					</div>
						
						
						
	
					
				</div>
			</div>
		</div>
				
	<%@include file="/WEB-INF/pages/common/foot.jsp"%>
	<script src="statics/localjs/chongzhi.js"></script>


		
		
