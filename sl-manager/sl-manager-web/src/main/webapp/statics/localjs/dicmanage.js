$(".addDicBtn").click(function(e) {
	e.preventDefault();
	$("#addDicModel").modal('show');
});

$(".maintitle").mouseenter(function() {
	$(this).children(".mainset").show();
});

$(".maintitle").mouseleave(function() {
	$(this).children(".mainset").hide();
});

$(".addDicLiBtn").click(function(e) {
	e.preventDefault();
	$("#addDicSubModel").modal('show');

});

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//类型编号不能重复验证(添加)
$("#typeCode").blur(function() {
	$("#addDictip").html("");
	var typeCode = $("#typeCode").val();
	$.post("admin/typeCodeIsexit", {
		'typecode' : typeCode
	}, function(result) {
		if (result == "ok") {
			$("#addDictip").css("color", "red");
			$("#addDictip").html("对不起，该类型编号已存在。");
		}
	}, 'html');
});
//类型名称不能重复验证(添加)
$("#typeName").blur(function() {
	$("#addDictip").html("");
	var typeName = $("#typeName").val();
	$.post("admin/typeNameIsexit", {
		'typename' : typeName
	}, function(result) {
		if (result == "ok") {
			$("#addDictip").css("color", "red");
			$("#addDictip").html("对不起，该类型名称已存在。");
		}
	}, 'html');
});

//添加字典类型
$("#addDicExeBtn").click(function() {
	dic = new Object();
	dic.typeCode = $.trim($("#typeCode").val());
	dic.typeName = $.trim($("#typeName").val());
	tip = $("#addDictip");
	if (dic.typeCode == "") {
		$("#typeCode").focus();
		tip.css("color", "red");
		tip.html("类型编号不能为空！");
	} else if (dic.typeName == "") {
		$("#typeName").focus();
		tip.css("color", "red");
		tip.html("类型名称不能为空！");
	} else {
		//alert(dic.typeCode + "," +dic.typeName + "," + dic.valueName);
		$.ajax({
			url : 'admin/addDicType',
			type : 'POST',
			data : {
				typecode : dic.typeCode,
				typename : dic.typeName,
			},
			dataType : 'html',
			timeout : 1000,
			error : function() {
				tip.css("color", "red");
				tip.html("数据字典添加失败！请重试。");
			},
			success : function(result) {
				if (result != "" && "success" == result) {
					window.location.href = "admin/dictionaryManage";
				} else if ("failed" == result) {
					tip.css("color", "red");
					tip.html("数据类型失败！请重试。");
				} else if ("recode" == result) {
					tip.css("color", "red");
					tip.html("数据类型添加失败！类型编号不能重复，请重试。");
				} else if ("rename" == result) {
					tip.css("color", "red");
					tip.html("数据类型添加失败！类型名称不能重复，请重试。");
				} else if ("nodata" == result) {
					alert("对不起，没有任何数据需要处理！请重试。");
				}
			}
		});
	}
});

///////////////////////////////////////////////////////////////////////////////////////////////

//类型编号不能重复验证(修改)
$("#modifytypeCode").blur(function() {
	$("#modifyDictip").html("");
	var typeCode = $("#modifytypeCode").val();
	$.post("admin/typeCodeIsexit", {
		'typecode' : typeCode,
	}, function(result) {
		if (result == "ok") {
			$("#modifyDictip").css("color", "red");
			$("#modifyDictip").html("对不起，该类型编号已存在。");
		}
	}, 'html');
});
//类型名称不能重复验证(修改)
$("#modifytypeName").blur(function() {
	$("#modifyDictip").html("");
	var typeName = $("#modifytypeName").val();
	$.post("admin/typeNameIsexit", {
		'typename' : typeName
	}, function(result) {
		if (result == "ok") {
			$("#modifyDictip").css("color", "red");
			$("#modifyDictip").html("对不起，该类型名称已存在。");
		}
	}, 'html');
});

//修改字典类型模态框
$(".modifyMainDic").click(function(e) {
	dictypecode = $(this).attr("dictypecode");
	dictypename = $(this).attr("dictypename");
	dicid = $(this).attr("dicid");

	$("#modifytypeCode").val(dictypecode);
	$("#modifytypeName").val(dictypename);
	$("#modifydicid").val(dicid);
	$("#modifydictypecode").val(dictypecode);
	$("#modifydictypename").val(dictypename);

	e.preventDefault();
	$("#modifyDicModel").modal('show');
});

//修改字典类型
$("#modifyDicExeBtn").click(function() {
	dic = new Object();
	dic.typeCode = $.trim($("#modifytypeCode").val());
	dic.typeName = $.trim($("#modifytypeName").val());

	olddic = new Object();
	olddic.typeCode = $("#modifydictypecode").val();
	olddic.typeName = $("#modifydictypename").val();

	tip = $("#modifyDictip");
	if (dic.typeCode == "") {
		$("#modifytypeCode").focus();
		tip.css("color", "red");
		tip.html("类型代码不能为空！");
	} else if (dic.typeName == "") {
		$("#modifytypeName").focus();
		tip.css("color", "red");
		tip.html("类型名称不能为空！");
	} else if (dic.typeName == olddic.typeName&&dic.typeCode==olddic.typeCode) {
		tip.css("color", "red");
		tip.html("对不起，没有任何数据需要处理！请重试。");
	}else {
		//alert(dic.typeCode + "," +dic.typeName + "," + dic.id);
		$.ajax({
			url : 'admin/modifylDicType',
			type : 'POST',
			data : {
				oldTypeCode : olddic.typeCode,
				oldTypeName :olddic.typeName,
				typecode : dic.typeCode,
				typename : dic.typeName
			},
			dataType : 'html',
			timeout : 1000,
			error : function() {
				alert("数据字典修改失败！请重试。");
			},
			success : function(result) {
				if (result != "" && "success" == result) {
					window.location.href = "admin/dictionaryManage";
				}else if ("rename" == result) {
					tip.css("color", "red");
					tip.html("数据类型添加失败！类型名称不能重复，请重试。");
				} else if ("failed" == result) {
					tip.css("color", "red");
					tip.html("数据字典修改失败！请重试。");
				} else if ("nodata" == result) {
					tip.css("color", "red");
					tip.html("对不起，没有任何数据需要处理！请重试。");
				}
			}
		});
	}
});


//删除字典类型
$(".delMainDic").click(function() {
	dictypecode = $(this).attr("dictypecode");
	dictypename = $(this).attr("dictypename");
	if (confirm("删除操作会删除\"" + dictypename + "\"下所有的字典值，您确定要删除\"" + dictypename + "\"吗？")) {
		$.ajax({
			url : 'admin/delDicType',
			type : 'POST',
			data : {
				typeCode : dictypecode
			},
			dataType : 'html',
			timeout : 1000,
			error : function() {
				alert("数据字典删除失败！请重试。");
			},
			success : function(result) {
				if (result != "" && "success" == result) {
					window.location.href = "admin/dictionaryManage";
				} else if ("failed" == result) {
					alert("数据字典删除失败！请重试。");
				} else if ("nodata" == result) {
					alert("对不起，没有任何数据需要处理！请重试。");
				}
			}
		});
	}
});

var maxValue = 0;
//展示字典数据
$(".typecodelist").click(function() {
	taga = $(this);
	typecode = taga.attr("typecode");
	typename = taga.attr("typename");
	$("#typeDicSubCode").val(typecode);
	$("#typeDicSubName").val(typename);
	$("#valueDicSubName").val("");
	$("#addDicSubtip").html("");
	$("#optitle").html("当前操作：" + typecode + " - " + typename);
	//alert(id + "," + typecode + "," + typename);
	//getJsonDic tcode
	$.ajax({
		url : 'admin/getJsonDic',
		type : 'POST',
		data : {
			typecode : typecode
		},
		dataType : 'html',
		timeout : 1000,
		error : function() {
			alert("查询" + typename + "失败！请重试。");
		},
		success : function(result) {
			if ("failed" == result) {
				alert("查询" + typename + "失败！请重试。");
			} else if ("nodata" == result) {
				alert("查询" + typename + "失败！请重试。");
			} else {
				//alert(result);
				jsonObj = eval('(' + result + ')');
				//alert(jsonObj.length);
				dicListUL = $("#dicListUL");
				/*
				 <li>
					<div>类型代码:</div>
					<div>类型名称:</div>
					<div>数据数值:<input type="text" id=""/></div>
					<div>数值名称:<input type="text" id=""/></div>
					<div class="editdiv">
						<img src="/statics/img/ico10.png"> <img src="/statics/img/linkdel.png">
					</div>
				</li>
				 */
				str = "";
				dicListUL.html("");
				for (var i = 0; i < jsonObj.length; i++) {
					str += "<li id=\"li" + jsonObj[i].dictionaryid + "\">";
					str += "<div>类型代码:" + jsonObj[i].typecode + "</div>";
					str += "<div>类型名称:" + jsonObj[i].typename + "</div>";
					str += "<div><input type=\"hidden\" disabled=\"disabled\" onkeyup=\"this.value=this.value.replace(\/\\D\/g,'')\" onafterpaste=\"this.value=this.value.replace(\/\\D\/g,'')\" id=\"valueIdText" + jsonObj[i].dictionaryid + "\" value=\"" + jsonObj[i].dictionaryid + "\"/></div>";
					str += "<div>数值名称:<input type=\"text\" id=\"valueNameText" + jsonObj[i].dictionaryid + "\" value=\"" + jsonObj[i].valuename + "\"/></div>";
					str += "<div>描&emsp;&emsp;述:<input type=\"text\" id=\"describedText" + jsonObj[i].dictionaryid + "\" value=\"" + jsonObj[i].described + "\"/></div>";
					str += "<div class=\"editdiv\">";
					str += "<img class=\"modifyDicValue\" modifytypecode=" + jsonObj[i].typecode + " modifytypename=" + jsonObj[i].typename + " id=\"" + jsonObj[i].dictionaryid + "\" valueid=\"" + jsonObj[i].dictionaryid + "\" valuename=\"" + jsonObj[i].valuename + "\" src=\"statics/img/ico10.png\"> <img class=\"delDicValue\" deltypename=" + jsonObj[i].typename + " id=\"" + jsonObj[i].dictionaryid + "\" valueid=\"" + jsonObj[i].dictionaryid + "\" valuename=\"" + jsonObj[i].valuename + "\"  src=\"statics/img/linkdel.png\">";
					str += "<input type=\"hidden\" id=\"modifyDescribed\" value=\"" +jsonObj[i].described+ "\" /></div>";
					str += "<div id=\"dicTip" + jsonObj[i].dictionaryid + "\"></div>";
					str += "</li>";
					maxValue = jsonObj[i].dictionaryid;
				}
				//str += "<li id=\"addDicLiBtn\" class=\"addDicLiBtn\"><img src=\"/statics/img/winapp_add.png\"/></li>";
				dicListUL.append(str);
				$("#addsubdicul").show();
				$(".modifyDicValue").click(function() {
					modify = $(this);
					dic = new Object();
					dic.id = modify.attr("id");
					dic.valueName = modify.attr("valuename");
					var oldValueName=dic.valueName;
					dic.typecode=modify.attr("modifytypecode");
					dic.modifyDescribed=$("#modifyDescribed").val();
					tip = $("#dicTip" + dic.id);
					//modifytypename
					//alert(dic.id + "," + dic.valueId + "," + dic.valueName);
					if (confirm("您确定要修改【" + modify.attr("modifytypename") + "】- 【" + dic.valueName + "】的数据配置吗？")) {
						//modifyDic dicJson
						dic.valueId = $.trim($("#valueIdText" + dic.id).val());
						dic.valueName = $.trim($("#valueNameText" + dic.id).val());
						dic.described =$.trim($("#describedText" + dic.id).val());
						if (dic.valueId == "") {
							$("#valueIdText" + dic.id).focus();
							tip.css("color", "red");
							tip.html("数据数值 不能为空。");
						} else if (dic.valueName == "") {
							$("#valueNameText" + dic.id).focus();
							tip.css("color", "red");
							tip.html("数据名称 不能为空。");
						} else if (dic.valueName == modify.attr("valuename")&&dic.modifyDescribed==dic.described) {
							tip.css("color", "red");
							tip.html("对不起，没有任何数据需要处理！请重试。");
						} else {
							$.ajax({
								url : 'admin/modifyDic',
								type : 'POST',
								data : {
									oldValueName:oldValueName,
									dictionaryid:dic.valueId,
									typecode:dic.typecode,
									valuename:dic.valueName,
									described:dic.described
								},
								dataType : 'html',
								timeout : 1000,
								error : function() {
									tip.css("color", "red");
									tip.html("数据字典修改失败！请重试。");
								},
								success : function(result) {
									if (result != "" && "success" == result) {
										tip.css("color", "green");
										tip.html("恭喜您，修改成功。^_^");
									} else if ("failed" == result) {
										tip.css("color", "red");
										tip.html("数据字典修改失败！请重试。");
									} else if ("nodata" == result) {
										tip.css("color", "red");
										tip.html("对不起，没有任何数据需要处理！请重试。");
									} else if ("rename" == result) {
										tip.css("color", "red");
										tip.html("添加失败！该类型代码下的数据ID不能重复，请重试。");
									}
								}
							});
						}
					}
				});
				$(".delDicValue").click(function() {
					del = $(this);
					dic = new Object();
					dic.id = del.attr("id");
					dic.valueName = del.attr("valuename");
					tip = $("#dicTip" + dic.id);
					//alert(dic.id + "," + dic.valueId + "," + dic.valueName);
					if (confirm("您确定要删除【" + del.attr("deltypename") + "】- 【" + dic.valueName + "】的数据配置吗？")) {
						//delDic id
						$.ajax({
							url : 'admin/delDic',
							type : 'POST',
							data : {
								dictionaryid : dic.id
							},
							dataType : 'html',
							timeout : 1000,
							error : function() {
								tip.css("color", "red");
								tip.html("数据字典删除失败！请重试。");
							},
							success : function(result) {
								if (result != "" && "success" == result) {
									//alert(del.parents("li"+dic.id));
									del.parents("#li" + dic.id).remove();
								} else if ("failed" == result) {
									tip.css("color", "red");
									tip.html("数据字典删除失败！请重试。");
								} else if ("nodata" == result) {
									tip.css("color", "red");
									tip.html("对不起，没有任何数据需要处理！请重试。");
								}
							}
						});
					}
				});
			}
		}
	});
});

//添加字典数据时非重验证
$("#valueDicSubName").blur(function() {
	var typeCode=$.trim($("#typeDicSubCode").val());
	var valueName=$(this).val();
	$.post("admin/valueNameIsexit", {
		'typeCode':typeCode,
		'valueName' : valueName
	}, function(result) {
		if (result == "ok") {
			$("#addDicSubtip").css("color", "red");
			$("#addDicSubtip").html("对不起，该数据名称已存在。");
		}
	}, 'html');
});

//添加字典数据
$("#addDicsubExeBtn").click(function() {
	dic = new Object();
	dic.typeCode = $.trim($("#typeDicSubCode").val());
	dic.typeName = $.trim($("#typeDicSubName").val());
	dic.valueName = $.trim($("#valueDicSubName").val());
	dic.described = $.trim($("#described").val());
	tip = $("#addDicSubtip");
	if (dic.typeCode == "") {
		$("#typeDicSubCode").focus();
		tip.css("color", "red");
		tip.html("类型代码不能为空！");
	} else if (dic.typeName == "") {
		$("#typeDicSubName").focus();
		tip.css("color", "red");
		tip.html("类型名称不能为空！");
	} else if (dic.valueName == "") {
		$("#valueDicSubName").focus();
		tip.css("color", "red");
		tip.html("数据名称不能为空！");
	} else {
		//alert(dic.typeCode + "," +dic.typeName + "," + dic.valueName + "," + dic.valueId);
		$.ajax({
			url : 'admin/addDic',
			type : 'POST',
			data : {
				typecode:dic.typeCode,
				typename:dic.typeName,
				valuename:dic.valueName,
				described:dic.described
			},
			dataType : 'html',
			timeout : 1000,
			error : function() {
				tip.css("color", "red");
				tip.html("数据字典添加失败！请重试。");
			},
			success : function(result) {
				if (result != "" && "success" == result) {

					var str = "";
					str += "<li id=\"li999\">";
					str += "<div>类型代码:" + dic.typeCode + "</div>";
					str += "<div>类型名称:" + dic.typeName + "</div>";
					str += "<div>数值名称:<input type=\"text\" id=\"valueNameText" + dic.id + "\" value=\"" + dic.valueName + "\"/></div>";
					str += "<div>描&emsp;&emsp;述:<input type=\"text\"  value=\"" + dic.described + "\"/></div>";
					str += "<div class=\"editdiv\">";
					str += "新增数据成功。";
					str += "</div>";
					str += "<div id=\"dicTip" + dic.id + "\"></div>";
					str += "</li>";

					$("#dicListUL").append(str);
					tip.css("color", "green");
					tip.html("数据字典添加成功。^_^。");
				} else if ("failed" == result) {
					tip.css("color", "red");
					tip.html("数据字典添加失败！请重试。");
				} else if ("rename" == result) {
					tip.css("color", "red");
					tip.html("数据字典添加失败！该类型代码下的数据ID不能重复，请重试。");
				} else if ("nodata" == result) {
					alert("对不起，没有任何数据需要处理！请重试。");
				}
			}
		});
	}
});