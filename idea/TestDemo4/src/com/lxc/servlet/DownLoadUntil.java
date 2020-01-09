package com.lxc.servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

public class DownLoadUntil {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")){
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", "");
        }else if (agent.contains("Firefox")){
            Base64.Encoder encoder = Base64.getEncoder();
            filename = "=?utf-8?B?"+encoder.encodeToString(filename.getBytes("utf-8")) + "?=";
        }else{
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
