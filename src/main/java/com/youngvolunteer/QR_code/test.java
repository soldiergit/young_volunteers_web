package com.youngvolunteer.QR_code;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class test {

    public static void main(String[] args) {
//        NoLogo();
        HaveLogo();
    }

    /**
     * 不带有logo的测试
     */
    public static void NoLogo() {
        try {
            String content = "https://www.baidu.com";
            String path = "/home/soldier/Downloads/";

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);
            File file1 = new File(path, "01.jpg");
            MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);


        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 带有logo的测试
     */
    public static void HaveLogo() {
        try {
            String text = "https://www.baidu.com";
            QRCodeUtil.encode(text, "/home/soldier/Downloads/01.jpg", "/home/soldier/Downloads/", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}