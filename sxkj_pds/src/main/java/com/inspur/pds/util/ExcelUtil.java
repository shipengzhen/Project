package com.inspur.pds.util;

/**
 * @Author: HP
 * @Date: 2019/1/8 12:56
 * @Description:用于描述判断Excel版本的工具类
 */
public class ExcelUtil {
    /**
     * 是否是03的版本，返回true是2003
     * @param filePath
     * @return
     */
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * 是否是07的版本，返回true是2007
     * @param filePath
     * @return
     */
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 验证Excel文件
     *
     * @param filePath
     * @return
     */
    public static boolean isExcel(String filePath){
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))){
            return false;
        }
        return true;
    }
}
