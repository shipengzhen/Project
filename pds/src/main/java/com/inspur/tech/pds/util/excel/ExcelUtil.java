package com.inspur.tech.pds.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.inspur.tech.pds.util.FileUtil;

import lombok.Data;

@Data
public class ExcelUtil {

	/**
	 * @功能描述：创建Workbook
	 * @参数说明：@param file
	 * @参数说明：@return
	 * @参数说明：@throws FileNotFoundException
	 * @参数说明：@throws IOException           @作者： shipengzhen
	 * @创建时间：2019年1月9日 上午10:10:20
	 */
	public static Workbook createWorkbook(File file) throws FileNotFoundException, IOException {
		// 根据后缀名称判断excel的版本
		String fileSuffixName = FileUtil.getFileSuffixName(file);
		Workbook workbook = null;
		if (ExcelVersion.V2003.getSuffix().equals(fileSuffixName)) {
			workbook = new HSSFWorkbook(new FileInputStream(file));

		} else if (ExcelVersion.V2007.getSuffix().equals(fileSuffixName)) {
			workbook = new XSSFWorkbook(new FileInputStream(file));

		} else {
			// 无效后缀名称，这里之能保证excel的后缀名称，不能保证文件类型正确，不过没关系，在创建Workbook的时候会校验文件格式
			throw new IllegalArgumentException("Invalid excel version");
		}
		return workbook;
	}

	/**
	 * @功能描述：读取Excel
	 * @参数说明：@param workbook
	 * @参数说明：@param file
	 * @参数说明：@return
	 * @参数说明：@throws FileNotFoundException
	 * @参数说明：@throws IOException           @作者： shipengzhen
	 * @创建时间：2019年1月9日 上午10:10:32
	 */
	public static List<ExcelSheetPO> readExcel(Workbook workbook, File file) throws FileNotFoundException, IOException {

		List<ExcelSheetPO> sheetPOs = new ArrayList<ExcelSheetPO>();

		// 开始读取数据
		if (null != workbook) {
			// 获取sheet数量
			int sheetNum = workbook.getNumberOfSheets();
			// log.info("sheet数量----->" + sheetNum);
			for (int i = workbook.getFirstVisibleTab(); i < sheetNum; i++) {
				// 获取sheet
				Sheet sheet = workbook.getSheetAt(i);
				if (null == sheet) {
					continue;
				}
				// 创建Sheet数据模型
				ExcelSheetPO sheetPO = new ExcelSheetPO();
				sheetPO.setSheetName(sheet.getSheetName());
				// 行集合
				List<ExcelRow> excelRows = new ArrayList<ExcelRow>();
				// 获取sheet行数
				int rowNum = sheet.getPhysicalNumberOfRows();
				// log.info("第" + (i + 1) + "个sheet的行数----->" + rowNum);
				for (int j = sheet.getFirstRowNum() + 1; j < rowNum; j++) {
					// 获取行
					Row row = sheet.getRow(j);
					if (null == row) {
						continue;
					}
					ExcelRow excelRow = new ExcelRow();
					// 获取行的单元格的数量
					int cellNum = row.getPhysicalNumberOfCells();
					cellNum = row.getLastCellNum() + 1;
					// log.info("第" + (i + 1) + "个sheet的第" + (j + 1) + "row的单元格的数量----->" +
					// cellNum);
					List<ExcelColumn> excelColumns = new ArrayList<ExcelColumn>();
					for (int k = 0; k < cellNum; k++) {
						// 获取Row的单元格
						Cell cell = row.getCell(k);
						Object value = "";
						if (null != cell) {
							value = getCellValue(workbook, cell);
						}
						ExcelColumn excelColumn = new ExcelColumn();
						Row firstRow = sheet.getRow(sheet.getFirstRowNum());
						String name = "";
						Cell titleCell = firstRow.getCell(k);
						if (null != titleCell) {
							name = getCellValue(workbook, titleCell).toString();
						}
						excelColumn.setName(name);
						excelColumn.setValue(value);
						excelColumns.add(excelColumn);
						// log.info("第" + (i + 1) + "个sheet的第" + (j + 1) + "row的第" + (k + 1) +
						// "个cell的值----->" + value);
					}
					excelRow.setColumns(excelColumns);
					excelRows.add(excelRow);
				}
				sheetPO.setRowList(excelRows);
				sheetPOs.add(sheetPO);
			}
		}
		return sheetPOs;
	}

	/**
	 * @功能描述：获取单元格中的值
	 * @参数说明：@param workbook
	 * @参数说明：@param cell
	 * @参数说明：@return @作者： shipengzhen
	 * @创建时间：2019年1月9日 上午9:18:20
	 */
	@SuppressWarnings("deprecation")
	private static Object getCellValue(Workbook workbook, Cell cell) {
		Object columnValue = null;
		if (cell != null) {
			switch (cell.getCellTypeEnum()) {
			// 字符串
			case STRING:
				columnValue = cell.getStringCellValue();
				break;
			// 数字
			case NUMERIC:
				CellStyle cellStyle = cell.getCellStyle();
				String dataFormatString = cellStyle.getDataFormatString();
				// System.out.println(dataFormatString);
				switch (dataFormatString) {
				case "@":
					DecimalFormat df = new DecimalFormat("0");// 格式化 number
					columnValue = df.format(cell.getNumericCellValue());
					break;
				case "0.00":
					columnValue = new BigDecimal(cell.getNumericCellValue());
					break;
				case "General":
					/*
					 * DecimalFormat nf = new DecimalFormat(dataFormatString); columnValue =
					 * nf.format(cell.getNumericCellValue());
					 */
					columnValue = new BigDecimal(cell.getNumericCellValue());
					break;

				default:
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
					columnValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
					break;
				}
				break;
			// 布尔
			case BOOLEAN:
				columnValue = cell.getBooleanCellValue();
				break;
			// 空白
			case BLANK:
				columnValue = "";
				break;
			// 公式
			case FORMULA:
				CreationHelper creationHelper = workbook.getCreationHelper();
				FormulaEvaluator evaluator = creationHelper.createFormulaEvaluator();
				evaluator.evaluateFormulaCell(cell);
				CellValue cellValue = evaluator.evaluate(cell);
				columnValue = cellValue.getNumberValue();
				break;
			// 其他
			default:
				columnValue = cell.toString();
			}
		}
		return columnValue;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("C:\\Users\\xiaomi\\Desktop\\基本信息.xls");
		Workbook workbook = createWorkbook(file);
		List<ExcelSheetPO> readExcel = ExcelUtil.readExcel(workbook, file);
		for (ExcelSheetPO excelSheetPO : readExcel) {
			System.out.println(excelSheetPO.getSheetName());
			List<ExcelRow> rowList = excelSheetPO.getRowList();
			for (ExcelRow row : rowList) {
				List<ExcelColumn> columns = row.getColumns();
				for (ExcelColumn column : columns) {
					System.out.println(column.getName());
					System.out.println(column.getValue());
				}
				System.out.println("-----------------------------------------------");
			}
		}
	}

}