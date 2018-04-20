//rich text editor

function page(frm, num) {
	frm.pageNo.value = num;
	frm.submit();
}

$('#a_goodsFormat').cleditor();
$('#a_note').cleditor();

$('.addGoodsInfo').click(function(e) {
	$("#add_formtip").html('');
	e.preventDefault();
	$('#addGoodsInfoDiv').modal('show');
});

$('.addgoodsinfocancel').click(function(e) {
	$("#add_formtip").html('');
	$("#a_goodsName").val('');
	$("#a_goodsSN").val('');
	$("#a_marketPrice").val('');
	$("#a_realPrice").val('');
	$("#a_num").val('');
	$("#a_unit").val('');
	$("#a_goodsFormat").val('');
	$("#a_note").val('');
});

$('.modifygoodsinfocancel').click(function(e) {
	$("#modify_formtip").html('');
});

// 修改商品信息时的信息详情
$('.modifygoodsinfo')
		.click(
				function(e) {
					var m_id = $(this).attr('id');
					$
							.ajax({
								url : 'admin/commodityInfo',
								type : 'POST',
								data : {
									commodityId : m_id
								},
								dataType : 'html',
								timeout : 1000,
								error : function() {
									alert("error");
								},
								success : function(result) {
									if ("failed" == result) {
										alert("操作超时！");
									} else if ("nodata" == result) {
										alert("没有数据！");
									} else {
										m = eval('(' + result + ')');
										$("#m_id").val(m.commodityid);
										$("#m_goodsName").val(m.commodityname);
										$("#mm_goodsName").val(m.commodityname);
										$("#m_marketPrice").val(m.yprice);
										$("#m_realPrice").val(m.xprice);
										$("#m_num").val(m.number);
										$("#m_state").html('');
										var state = m.status;
									/*	if (state == 1) {
											$("#m_state")
													.append(
															"<span>状态：</span><input type=\"radio\" name=\"status\" checked=\"checked\" value=\"1\"/>上架<input type=\"radio\" name=\"status\" value=\"2\"/>下架");
											// $("#m_stateup").attr("checked","checked");
											// $("#m_statedown").removeAttr("checked");

										} else if (state == 2) {
											$("#m_state")
													.append(
															"<span>状态：</span><input type=\"radio\" name=\"status\" value=\"1\"/>上架<input type=\"radio\" name=\"status\" checked=\"checked\" value=\"2\"/>下架");
										}*/

										$("#m_goodsFormatli").html("");
										$("#m_goodsFormatli")
												.append(
														"<span>商品规格：</span> <br/><textarea id=\"m_goodsFormat\" name=\"specifications\" rows=\"3\">"
																+ m.specifications
																+ "</textarea>");
										$('#m_goodsFormat').cleditor();

										$("#m_noteli").html("");
										$("#m_noteli").append(
												"<span>商品说明：</span> <br/><textarea id=\"m_note\" name=\"details\" rows=\"3\">"
														+ m.details
														+ "</textarea>");
										$('#m_note').cleditor();

										e.preventDefault();
										$('#modifyGoodsInfoDiv').modal('show');
									}
								}
							});
				});

// 查看商品信息
$('.viewgoodsinfo').click(function(e) {
	var m_id = $(this).attr('id');
	$.ajax({
		url : 'admin/commodityInfo',
		type : 'POST',
		data : {
			commodityId : m_id
		},
		dataType : 'html',
		timeout : 1000,
		error : function() {
			alert("error");
		},
		success : function(result) {
			if ("failed" == result) {
				alert("操作超时！");
			} else if ("nodata" == result) {
				alert("没有数据！");
			} else {
				m = eval('(' + result + ')');
				$("#v_goodsName").val(m.commodityname);
				$("#v_marketPrice").val(m.yprice);
				$("#v_realPrice").val(m.xprice);
				$("#v_num").val(m.number);
				var state = m.status;
				if (state == 1)
					$("#v_state").html("上架");
				else if (state == 2)
					$("#v_state").html("下架");

				$("#v_goodsFormat").html(m.specifications);
				$("#v_note").html(m.details);
				e.preventDefault();
				$('#viewGoodsInfoDiv').modal('show');
			}
		}
	});
});

// 删除商品
$('.delgoodsinfo').click(function(e) {
	var d = $(this);
	var d_goodsName = d.attr('goodsName');
	var d_id = d.attr('id');
	if (confirm("您确定要删除【" + d_goodsName + "】这个商品吗？")) {
		// delete
		$.post("admin/delCommodity", {
			'commodityId' : d_id
		}, function(result) {
			if ("success" == result) {
				alert("删除成功！");
				window.location.href = "admin/commodityManager";
			} else if ("isused" == result) {
				alert("该商品已被商品套餐引用，不能删除！");
			} else {
				alert("删除失败！");
			}
		}, 'html');
	}
});

// 新增时商品名称唯一验证
$("#a_goodsName").blur(function() {
	var commodityName = $.trim($("#a_goodsName").val());
	if (commodityName != "") {
		$.post("admin/acommodityNameExists", {
			'commodityName' : commodityName
		}, function(result) {
			if (result == "repeat") {
				$("#add_formtip").css("color", "red");
				$("#add_formtip").html("<li>对不起，该商品名称已存在。</li>");
				$("#add_formtip").attr("key", "1");
				result = false;
			} else if (result == "") {
				alert("操作超时!");
			} else if (result == "only") {
				$("#add_formtip").css("color", "green");
				$("#add_formtip").html("<li>该商品名称可以正常使用。</li>");
				$("#add_formtip").attr("key", "0");
			}
		}, 'html');
	}
});

// 新增验证
function addGoodsInfoFunction() {
	$("#add_formtip").html("");
	var result = true;
	if ($.trim($("#a_goodsName").val()) == ""
			|| $("#a_goodsName").val() == null) {
		$("#add_formtip").css("color", "red");
		$("#add_formtip").append("<li>对不起，商品名称不能为空。</li>");
		result = false;
	}else{
		if($("#add_formtip").attr("key") == "1"){
			$("#add_formtip").append("<li>对不起，该商品名称已存在。</li>");
			result = false;
		}
	}
	if ($.trim($("#a_marketPrice").val()) == ""
			|| $("#a_marketPrice").val() == null) {
		$("#add_formtip").css("color", "red");
		$("#add_formtip").append("<li>对不起，市场价不能为空。</li>");
		result = false;
	}
	if ($.trim($("#a_realPrice").val()) == ""
			|| $("#a_realPrice").val() == null) {
		$("#add_formtip").css("color", "red");
		$("#add_formtip").append("<li>对不起，优惠价不能为空。</li>");
		result = false;
	}
	if ($.trim($("#a_num").val()) == "" || $("#a_num").val() == null) {
		$("#add_formtip").css("color", "red");
		$("#add_formtip").append("<li>对不起，库存量不能为空。</li>");
		result = false;
	}
	return result;
}


//修改时商品名称唯一验证
$("#m_goodsName").blur(function() {
	var commodityName = $.trim($("#m_goodsName").val());
	var mm_goodsName=$.trim($("#mm_goodsName").val());
	if (commodityName != "") {
		$.post("admin/mcommodityNameExists", {
			'commodityName' : commodityName,
			'mm_goodsName':mm_goodsName
		}, function(result) {
			if (result == "repeat") {
				$("#modify_formtip").css("color", "red");
				$("#modify_formtip").html("<li>对不起，该商品名称已存在。</li>");
				$("#modify_formtip").attr("key", "1");
				result = false;
			} else if (result == "failed") {
				alert("操作超时!");
			} else if (result == "only") {
				$("#modify_formtip").css("color", "green");
				$("#modify_formtip").html("<li>该商品名称可以正常使用。</li>");
				$("#modify_formtip").attr("key", "0");
			}
		}, 'html');
	}
});

// 修改验证
function modifyGoodsInfoFunction() {
	$("#modify_formtip").html("");
	var result = true;
	if ($.trim($("#m_goodsName").val()) == ""
			|| $("#m_goodsName").val() == null) {
		$("#modify_formtip").css("color", "red");
		$("#modify_formtip").append("<li>对不起，商品名称不能为空。</li>");
		result = false;
	}else{
		if($("#modify_formtip").attr("key") == "1"){
			$("#modify_formtip").append("<li>对不起，该商品名称已存在。</li>");
			result = false;
		}
	}
	if ($.trim($("#m_marketPrice").val()) == ""
			|| $("#m_marketPrice").val() == null) {
		$("#modify_formtip").css("color", "red");
		$("#modify_formtip").append("<li>对不起，市场价不能为空。</li>");
		result = false;
	}
	if ($.trim($("#m_realPrice").val()) == ""
			|| $("#m_realPrice").val() == null) {
		$("#modify_formtip").css("color", "red");
		$("#modify_formtip").append("<li>对不起，优惠价不能为空。</li>");
		result = false;
	}
	if ($.trim($("#m_num").val()) == "" || $("#m_num").val() == null) {
		$("#modify_formtip").css("color", "red");
		$("#modify_formtip").append("<li>对不起，库存量不能为空。</li>");
		result = false;
	}
	return result;
}

// 修改商品状态
$(".modifystate").click(
		
		function() {
			var commoDityname = $("#commoDityname").val();
			var status = $("#status").val();
			var pageNo = $("#pageNo").val();

			modify = $(this);
			state = modify.attr("state");
			id = modify.attr("goodsinfoid");
			goodsInfoStart = new Object();
			goodsInfoStart.id = id;
			if (state == "1") {
				goodsInfoStart.state = 2;
				modify.attr("state", "2");
			} else {
				goodsInfoStart.state = 1;
				modify.attr("state", "1");
			}
			$.ajax({
				url : 'admin/modifyCommodityStates',
				type : 'POST',
				data : {
					commodityid : id,
					status : goodsInfoStart.state
				},
				dataType : 'html',
				timeout : 1000,
				error : function() {
					alert("上架或下架商品操作时失败！请重试。");
					location.href = "admin/commodityManager?commoDityname="
							+ commoDityname + "&status=" + status + "&pageNo="
							+ pageNo;
				},
				success : function(result) {
					if ( "success" == result) {
						if (state == "1")
							modify.attr("state", 2);
						else
							modify.attr("state", 1);
					} else if ("failed" == result) {
						alert("上架或下架商品操作时失败！请重试。");
						location.href = "admin/commodityManager?commoDityname="
								+ commoDityname + "&status=" + status
								+ "&pageNo=" + pageNo;
					} else if ("nodata" == result) {
						alert("对不起，没有任何数据需要处理！请重试。");
						location.href = "admin/commodityManager?commoDityname="
								+ commoDityname + "&status=" + status
								+ "&pageNo=" + pageNo;
					}else if(result=="noyy"){
						alert("商品在套餐中使用 不能下架");
						location.href = "admin/commodityManager?commoDityname="
							+ commoDityname + "&status=" + status
							+ "&pageNo=" + pageNo;
					}
				}
			});
		});

// 提示函数
function showmsg(msg) {
	var divBox = document.getElementById("showmsgBox") || "";
	if (divBox) {
		divBox.style.display = "block";
	} else {
		divBox = document.createElement("span");
		divBox.className = "showmsgBox";
		divBox.setAttribute("id", "showmsgBox");
		document.body.appendChild(divBox);
	}
	divBox.innerHTML = msg;
	divBox.style.left = document.documentElement.clientWidth / 2 + "px"
	setTimeout(function() {
		divBox.style.display = "none";
	}, 1000);
}
