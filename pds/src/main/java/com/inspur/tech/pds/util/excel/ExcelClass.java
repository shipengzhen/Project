package com.inspur.tech.pds.util.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.inspur.tech.pds.data.HorizontalTopicDto;
import com.inspur.tech.pds.util.DateTimeUtil;
import com.inspur.tech.pds.util.UUIDTool;

public class ExcelClass {

	public static <T> T getObject(Class<T> class1, ExcelRow row) {

		List<Field> fields = new ArrayList<Field>();
		Class<?> class2 = class1;
		while (class2 != null) {// 当父类为null的时候说明到达了最上层的父类(Object类).
			fields.addAll(Arrays.asList(class2.getDeclaredFields()));
			class2 = class2.getSuperclass(); // 得到父类,然后赋给自己
		}
		T obj = null;
		try {
			obj = class1.newInstance();

			List<ExcelColumn> columns = row.getColumns();
			for (ExcelColumn column : columns) {
				for (Field field : fields) {
					if (field.isAnnotationPresent(ApiField.class)) {
						ApiField apiField = field.getAnnotation(ApiField.class);
						Object value = "";
						if (apiField.value().equalsIgnoreCase("id")) {
							value = UUIDTool.getUUID();
							field.setAccessible(true);
							field.set(obj, value);
						} else if (apiField.value().equalsIgnoreCase(column.getName())) {
							value = column.getValue();
							if (field.getType() == Date.class) {
								value = DateTimeUtil.stringChangeDate(value.toString(), "yyyy-MM-dd");
							} else if (field.getType() == Timestamp.class) {
								// value = Timestamp.valueOf(value.toString());
								continue;
							}
							field.setAccessible(true);
							field.set(obj, value);
						}
					} else {
						Object value = "";
						if (field.getName().equalsIgnoreCase("id")) {
							value = UUIDTool.getUUID();
							field.setAccessible(true);
							field.set(obj, value);
						} else if (field.getName().equalsIgnoreCase(column.getName())) {
							value = column.getValue();
							if (field.getType() == Date.class) {
								value = DateTimeUtil.stringChangeDate(value.toString(), "yyyy-MM-dd");
							} else if (field.getType() == Timestamp.class) {
								// value = Timestamp.valueOf(value.toString());
								continue;
							}
							field.setAccessible(true);
							field.set(obj, value);
						}
					}
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static <T> List<T> getList(Class<T> class1, File file) {
		List<T> list = new ArrayList<T>();
		try {
			Workbook workbook = ExcelUtil.createWorkbook(file);
			List<ExcelSheetPO> readExcel = ExcelUtil.readExcel(workbook, file);
			for (ExcelSheetPO excelSheetPO : readExcel) {
				List<ExcelRow> rowList = excelSheetPO.getRowList();
				for (ExcelRow row : rowList) {
					list.add(getObject(class1, row));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, FileNotFoundException, IOException {
		File file = new File("C:\\Users\\xiaomi\\Desktop\\横向课题.xls");
		List<HorizontalTopicDto> horizontalTopicDtos = ExcelClass.getList(HorizontalTopicDto.class, file);
		for (HorizontalTopicDto basicInfo : horizontalTopicDtos) {
			System.out.println(basicInfo.getLaboratoryName());
		}
	}

}
