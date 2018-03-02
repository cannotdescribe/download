package com.insigma.download.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    public static String getSuffix(HttpServletRequest request){
        String url = request.getRequestURI();
        int i = url.lastIndexOf(".");
        if(i<=0){
            return null;
        }else{
            return url.substring(i, url.length());
        }
    }
}
