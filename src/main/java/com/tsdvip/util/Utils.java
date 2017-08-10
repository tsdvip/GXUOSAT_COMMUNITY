package com.tsdvip.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

public class Utils {
	
	private static final String salt = "你吃了吗";
	
	public static String crypt(String pwd){
		return DigestUtils.md5Hex(pwd+salt);
	}
	
	public static String getUserIdByCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组  
        if (null==cookies) {  
            System.out.println("没有cookie=========");  
        } else {  
            for(Cookie cookie : cookies){  
                if("userId".equals(cookie.getName())){
                	return cookie.getValue();
                }
            }  
        }
        return null;
	}

}
