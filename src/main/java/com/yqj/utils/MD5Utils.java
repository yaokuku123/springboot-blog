package com.yqj.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: MD5Utils
 * Author: yaoqijun
 * Date: 2020/8/5 13:07
 */
public class MD5Utils {
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDegest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for(int offset = 0 ; offset < byteDegest.length ;offset++){
                i = byteDegest[offset];
                if(i<0){
                    i+=256;
                }
                if(i<16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            //16位加密
            //return buf.toString().substring(8,24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(code("199748"));
    }
}
