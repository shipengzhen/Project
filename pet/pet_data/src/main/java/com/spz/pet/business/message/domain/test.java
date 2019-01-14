package com.spz.pet.business.message.domain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**  
 * Copyright © 2018Company. All rightsreserved.
 * @文件名 test.java
 * @项目名 pet_data
 * @包名 com.spz.pet.message.domain
 * @类名 test
 * @功能描述 TODO
 * @创建人 施鹏振 
 * @创建时间 2018年11月27日下午4:29:59
 * @版本 TODO
 */
public class test {
    private static final int BLACK = 0xFF000000;

    private static final int WHITE = 0xFFFFFFFF;

    public static void main(String[] args) throws Exception {
        String text = "https://www.baidu.com/"; 
        //这里是URL ，扫描之后就跳转到这个界面
        String path = "F:\\tmp\\"; 
        //图片生成的位置
        int width = 900;
        int height = 900;
        // 二维码图片格式
        String format = "gif";// 设置编码，防止中文乱码

        Hashtable<EncodeHintType, Object> ht = new Hashtable<EncodeHintType, Object>();
        ht.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 设置二维码参数(编码内容，编码类型，图片宽度，图片高度,格式)
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, ht);
        // 生成二维码(定义二维码输出服务器路径)
        File outputFile = new File(path);
        if (!outputFile.exists()) {//创建文件夹
            outputFile.mkdir();
        }
        int b_width = bitMatrix.getWidth();
        int b_height = bitMatrix.getHeight();
        // 建立图像缓冲器
        BufferedImage image = new BufferedImage(b_width, b_height, BufferedImage.TYPE_3BYTE_BGR);
        for (int x = 0; x < b_width; x++) {
            for (int y = 0; y < b_height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
            }
        }
        // 生成二维码
        //二维码的名称 是 erweima.sgif
        File file=new File(path + "erweima." + format);
        ImageIO.write(image, format, file); 
    }
}
