package priv.general.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class SystemUtils {

	/**
	 * 获取客户端ip
	 * 2019年3月22日下午5:25:02
	 * @param request
	 * @return
	 */
	public static String getRemoteIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
	}
	/**
	 * 获取客户端MAC
	 * 2019年3月22日下午5:25:02
	 * @param ip
	 * @return
	 */
	public static String getRemoteMac(String ip) {
		String macAddr = null;
	    try {
	        Process process = Runtime.getRuntime().exec("nbtstat -a " + ip);
	        BufferedReader br = new BufferedReader(
	                new InputStreamReader(process.getInputStream()));
	        Pattern pattern = Pattern.compile("([A-F0-9]{2}-){5}[A-F0-9]{2}");
	        Matcher matcher;
	        for (String strLine = br.readLine(); strLine != null;
	             strLine = br.readLine()) {
	            matcher = pattern.matcher(strLine);
	            if (matcher.find()) {
	                macAddr = matcher.group();
	                break;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return macAddr;
	}
	
}
