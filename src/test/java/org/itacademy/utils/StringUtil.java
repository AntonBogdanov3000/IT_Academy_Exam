package org.itacademy.utils;

public class StringUtil {

    public static String getCreatedPostId(String url){
        String post = url.substring(url.indexOf("?")+1, url.indexOf("&"));
        return post.replace("=", "-");
    }
}
