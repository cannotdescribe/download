package com.insigma.download.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    public static String getSuffix(HttpServletRequest request){
        String url = request.getRequestURI();
        return url.substring(url.lastIndexOf("."), url.length());
    }
}
