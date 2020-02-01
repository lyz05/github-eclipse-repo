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
 * ͨ����
 */
public class Util {
    private Util() {}       //��ֹʵ����
       
    /**
     * ������ܺ���
     * @param input ���������
     * @return ���ܺ������
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
     * �ж��Ƿ��¼��ͬʱ�����������Ӧ������Ϣ
     * @param request ������Ϣ
     * @param response ��Ӧ��Ϣ
     * @return �Ƿ��¼
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
     * �ж��Ƿ��ǹ���Ա��ɫ
     * @param request ������Ϣ
     * @param response ��Ӧ��Ϣ
     * @return �Ƿ�Ϊ����Ա
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
     * �ж��Ƿ��Ƕ��߽�ɫ
     * @param request ������Ϣ
     * @param response ��Ӧ��Ϣ
     * @return �Ƿ�Ϊ����Ա
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
     * ��ȡ��ǰ�û����õ�����
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
    	//����������뼰����json��header
    	response.setContentType("application/json;charset=utf-8");
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
    	// ����������������
		response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
        // �������������ʽ
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        // ��999999���ڣ�����Ҫ�ٷ���Ԥ�������󣬿��Ի���ý��
        response.setHeader("Access-Control-Max-Age", "0");
        // ��������������ĳ����ͷ,x-requested-with����ͷΪ�첽����
        response.setHeader("Access-Control-Allow-Headers",
        		"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("XDomainRequestAllowed","1");
    }
}
