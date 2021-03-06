/**
 * @文件名称： ExcelSheetPO.java
 * @文件路径： com.spz.excel.util
 * @功能描述： TODO
 * @作者： shipengzhen
 * @创建时间：2019年1月8日 下午6:32:23
 */
package com.inspur.tech.pds.util.excel;

import java.util.List;

import lombok.Data;

/**
 * 定义表格的数据对象
 * 
 * @author JIANGYOUYAO
 * @email 935090232@qq.com
 * @date 2017年12月20日
 */
@Data
public class ExcelSheetPO {

	// sheet的名称
	private String sheetName;

	// 表格标题
	private String title;

	// 头部标题集合
	private String[] headers;

	// 数据集合
	private List<ExcelRow> rowList;

}
