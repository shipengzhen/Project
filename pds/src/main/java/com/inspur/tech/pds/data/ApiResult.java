package com.inspur.tech.pds.data;

import lombok.Data;

@Data
public class ApiResult {

	// 0成功其他失败
	private int code = 404;

	// 返回信息
	private String msg = "网络异常";

	// 相应数据
	private Object data;

}
