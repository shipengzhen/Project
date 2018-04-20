$('#m_note').cleditor({
	width : 730,
	height : 300
});

$('.backbtn').click(function(e) {
	window.location.href = "admin/setMealManager";
});

$("#m_typeId").change(function() {
	$("#m_typeName").val($("#m_typeId").find("option:selected").text());
});

function addGoods(id, goodsname, rprice) {
	// alert(id+"_"+ goodsname +"_"+ rprice+" _");
	var ok = true;
	$(".goodsname").each(function() {
		title = $(this).html();
		if (goodsname == title) {
			ok = false;
			return false;
			value="1" 
		}
	});
	if (ok) {
		str = "<div id=\"selectdiv\"><label class=\"goodsname\">"
				+ goodsname
				+ "</label>"
				+ "<label class=\"goodscount\"><input onblur=\"if(this.value=='')value=1\" onkeyup=\"if(this.value==0){this.value=''}else{this.value=this.value.replace(/\\D/g,'')}\" class=\"finalresult\" goodsid=\""
				+ id + "\" rprice=\"" + rprice
				+ "\" type=\"text\" value=\"1\"/></label><label>"+rprice+"</label>"
				+ "<label class=\"del\" rprice=\"" + rprice
				+ "\"><img src=\"statics/img/cancel-on.png\"/></label>"
				+ "<label class=\"clear\"></label></div>";
		$("#selectgoodslist").append(str);
		var gcount = $(".finalresult").val();
		$(".del").val(gcount);
		var tprice = rprice * gcount;
		var tempprice = $("#m_totalPrice").val();
		$("#m_totalPrice").val(tprice);
		if (tempprice == "" || tempprice == null)
			tempprice = 0;
		tprice = parseInt(tprice) + parseInt(tempprice);
		console.log("tprice------ " + tprice);
		$("#m_totalPrice").val(tprice);
		$('.del').click(function(e) {
			$(this).parents("#selectdiv").remove();
			$("#selectgoodslist").change();
		});
	}
}

$('.del').click(function(e) {
	$(this).parents("#selectdiv").remove();
	$("#selectgoodslist").change();
});

$("#selectgoodslist").change(function() {
	var totleprice = 0;
	$(".finalresult").each(function() {
		id = $(this).attr("goodsid");
		rprice = $(this).attr("rprice");
		gcount = $(this).val();
		totleprice = parseInt(totleprice) + parseInt(rprice * gcount);
	});
	$("#m_totalPrice").val(totleprice);
});


//套餐名称唯一验证
$("#m_goodsPackName").blur(function() {
	var setMealName = $.trim($(this).val());
	var mm_goodsPackName=$("#mm_goodsPackName").val();
	if (setMealName != "") {
		$.post("admin/msetMealNameNameExists", {
			'setMealName' : setMealName,
			'mm_goodsPackName':mm_goodsPackName
		}, function(result) {
			if (result == "repeat") {
				$("#modify_formtip").css("color", "red");
				$("#modify_formtip").html("<li>对不起，该套餐名称已存在。</li>");
				$("#modify_formtip").attr("key", "1");
				result = false;
			} else if (result == "") {
				alert("操作超时!");
			} else if (result == "only") {
				$("#modify_formtip").css("color", "green");
				$("#modify_formtip").html("<li>该套餐名称可以正常使用。</li>");
				$("#modify_formtip").attr("key", "0");
			}
		}, 'html');
	}else{
		$("#modify_formtip").css("color", "red");
		$("#modify_formtip").html("<li>对不起，该套餐名称不能为空。</li>");
	}
});


$("#m_num").blur(function() {
	var a_num = $.trim($(this).val());
	if (a_num == "") {
		$("#add_formtip").css("color", "red");
		$("#add_formtip").html("<li>库存量不能为空。</li>");
	}
});


function modifyGoodsPackFunc() {
	$("#modify_formtip").html("");
	var result = true;
	json = "[";
	$(".finalresult").each(
			function() {
				id = $(this).attr("goodsid");
				gcount = $(this).val();
				json = json + "{";
				json = json + "\"goodsInfoId\":\"" + id + "\",\"goodsNum\":\""
						+ gcount + "\"";
				json = json + "},";
			});
	json = json + "{";
	json = json + "\"goodsInfoId\":\"0\",\"goodsNum\":\"0\"";
	json = json + "}";
	json = json + "]";
	$("#goodsJson").val(json);

	if ($.trim($("#m_goodsPackName").val()) == ""
			|| $("#m_goodsPackName").val() == null) {
		$("#modify_formtip").css("color", "red");
		$("#modify_formtip").append("<li>对不起，套餐名称不能为空。</li>");
		result = false;
	}else{
		if($("#modify_formtip").attr("key") == "1"){
			$("#modify_formtip").append("<li>对不起，该套餐名称已存在。</li>");
			result = false;
		}
	}
	if ($("#m_typeId").val() == "") {
		$("#modify_formtip").css("color", "red");
		$("#modify_formtip").append("<li>对不起，套餐类型不能为空。</li>");
		result = false;
	}
	if ($.trim($("#m_num").val()) == "" || $("#m_num").val() == null) {
		$("#modify_formtip").css("color", "red");
		$("#modify_formtip").append("<li>对不起，套餐库存量不能为空。</li>");
		result = false;
	}
	if ($.trim($("#m_totalPrice").val()) == ""
			|| $("#m_totalPrice").val() == null) {
		$("#modify_formtip").css("color", "red");
		$("#modify_formtip").append("<li>对不起，套餐总价不能为空。</li>");
		result = false;
	}

	return result;
}