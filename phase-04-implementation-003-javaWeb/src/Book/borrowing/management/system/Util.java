/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Book.borrowing.management.system;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import Book.borrowing.management.system.model.*;


/**
 *
 * @author congcong
 * 通用类
 */
public class Util {
    private Util() {}       //禁止实例化
       
    /**
     * 密码加密函数
     * @param input 输入的密码
     * @return 加密后的密码
     */
    public static String encodeInp(String input)
    {
         if (input.equals("")) return "";

         input += "\0\0\0\0";
         char keyStr[] = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=").toCharArray();
         String output = new String();
         int chr1,chr2,chr3;
         int enc1,enc2,enc3,enc4;
         int i=0;
         do{
                chr1 = input.charAt(i ++);
                chr2 = input.charAt(i ++);
                chr3 = input.charAt(i ++);
                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;
                if(chr2==0)
                {
                        enc3 = enc4 = 64;
                } else if (chr3==0)
                {
                        enc4 = 64;
                }
                output += keyStr[enc1];
                output += keyStr[enc2];
                output += keyStr[enc3];
                output += keyStr[enc4];

                chr1 = chr2 = chr3 = 0;
                enc1 = enc2 = enc3 = enc4 = 0;

         }while (input.charAt(i) != '\0');
         return output;
    }
    
    /**
     * 判断是否登录，同时设置请求和响应编码信息
     * @param request 请求信息
     * @param response 回应信息
     * @return 是否登录
     * @throws ServletException
     * @throws IOException
     */
    public static boolean judgeusername(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	boolean flag = request.getSession().getAttribute("username")!=null;
    	if (!flag) {
    		response.getWriter().append(JSON.toJSONString(new MessageJSONModel("601","notlogin",getlanguage(request))));
    	}
    	return flag;
    }
    
    /**
     * 判断是否是管理员角色
     * @param request 请求信息
     * @param response 回应信息
     * @return 是否为管理员
     * @throws ServletException
     * @throws IOException
     */
    public static boolean judgeadmin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	boolean flag = request.getSession().getAttribute("role").equals("admin");
    	if (!flag) {
    		response.getWriter().append(JSON.toJSONString(new MessageJSONModel("602","illegal",getlanguage(request))));
    	}
    	return flag;
    }
    
    /**
     * 判断是否是读者角色
     * @param request 请求信息
     * @param response 回应信息
     * @return 是否为管理员
     * @throws ServletException
     * @throws IOException
     */
    public static boolean judgereader(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	boolean flag = request.getSession().getAttribute("role").equals("reader");
    	if (!flag) {
    		response.getWriter().append(JSON.toJSONString(new MessageJSONModel("602","illegal",getlanguage(request))));
    	}
    	return flag;
    }
    
    /**
     * 获取当前用户所用的语言
     * @param request
     * @return
     */
    public static String getlanguage(HttpServletRequest request) {
    	if (request.getSession().getAttribute("language")==null)
    		return "zh_CN";
    	else
    		return request.getSession().getAttribute("language").toString();
    }
    
    public static void setRequestResponseAccess(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
    	//设置字体编码及返回json的header
    	response.setContentType("application/json;charset=utf-8");
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
    	// 允许该域发起跨域请求
		response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
        // 允许的外域请求方式
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        // 在999999秒内，不需要再发送预检验请求，可以缓存该结果
        response.setHeader("Access-Control-Max-Age", "0");
        // 允许跨域请求包含某请求头,x-requested-with请求头为异步请求
        response.setHeader("Access-Control-Allow-Headers",
        		"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("XDomainRequestAllowed","1");
    }
}
