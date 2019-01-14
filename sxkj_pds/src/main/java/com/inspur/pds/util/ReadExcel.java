package com.inspur.pds.util;

import com.inspur.pds.data.Customer;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;

/**
 * @Author: HP
 * @Date: 2019/1/8 12:58
 * @Description:读取Excel的工具类
 */
public class ReadExcel {
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;

    //构造方法
    public ReadExcel() {
    }

    //获取总行数
    public int getTotalRows() {
        return totalRows;
    }

    //获取总列数
    public int getTotalCells() {
        return totalCells;
    }

    //获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    /**
     * 读取Excel文件，获取信息集合
     *
     * @param multipartFile
     * @return
     */
    public List<Customer> getExcel(String fileName, MultipartFile multipartFile, HttpServletRequest request) {
        List<Customer> customerList = new ArrayList<>();
        //获取本地存储路径
        if (!multipartFile.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("uploadfile/");
            String oldFileName = multipartFile.getOriginalFilename();
            String fileNamePrefix = oldFileName.substring(0, oldFileName.lastIndexOf("."));
            String newFileNamePrefix = fileNamePrefix + System.currentTimeMillis() + ".xlsx";
            File targetFile = new File(path, newFileNamePrefix);
            String prefix = FilenameUtils.getExtension(oldFileName);

            if (prefix.equalsIgnoreCase("xls") || prefix.equalsIgnoreCase("xlsx")) {
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                // 保存
                try {
                    multipartFile.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 初始化输入流
            InputStream stream = null;
            try {
                //根据文件名判断文件是2003版本还是2007版本
                boolean isExcel2003 = true;
                if (ExcelUtil.isExcel2007(fileName)) {
                    isExcel2003 = false;
                }
                //根据新建的文件实例化输入流
                stream = new FileInputStream(targetFile);
                //根据excel里面的内容读取客户信息
                customerList = createExcel(stream, isExcel2003);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    /**
     * 根据Excel里面的内容读取客户端信息
     *
     * @param stream 输入流
     * @param isExcel2003 Excel版本
     * @return
     */
    public List<Customer> createExcel(InputStream stream, boolean isExcel2003) {
        List<Customer> customerList = null;
        try {
            Workbook workbook = null;
            if (isExcel2003) {
                workbook=new HSSFWorkbook(stream);
            } else {
                workbook  = new XSSFWorkbook(stream);
            }
            customerList = readExcelValue(workbook);
        }
            catch (org.apache.poi.poifs.filesystem.OfficeXmlFileException e) {
            e.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();
        }
        return customerList;
    }

    /**
     * 读取Excel里面的信息
     *
     * @param workbook
     * @return
     */
    public List<Customer> readExcelValue(Workbook workbook) {
        //获取第一个shell
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println("============" + sheet);
        //获取Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("行数=======" + this.totalRows);
        // 获取Excel的总列数
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<Customer> list = new ArrayList<>();
        Customer customer = new Customer();
        list.add(customer);
        // 循环Excel行数
        for (int i = 1; i < this.totalRows; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            // 循环Excel的列数
            for (int j = 0; i < this.totalCells; j++) {
                Cell cell = row.getCell(j);
                if (null != cell) {
                    if (j == 0) {
                    } else if (j == 1) {
                        customer.setCustomerName(getValue(cell));
                    } else if (j == 2) {
                        customer.setSimpleName(getValue(cell));
                    } else if (j == 3) {
                        customer.setTrade(getValue(cell));
                    } else if (j == 4) {
                        customer.setAddress(getValue(cell));
                    }
                }
            }
            list.add(customer);
        }
        return list;
    }
    /**
     * 得到Excel表中的值
     *
     * @param cell
     *            Excel中的每一个格子
     * @return Excel中每一个格子中的值
     */
    @SuppressWarnings({ "static-access", "unused" })
    private String getValue(Cell cell) {
        if (cell.getCellType() == CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(cell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(cell.getStringCellValue());
        }
    }
}
