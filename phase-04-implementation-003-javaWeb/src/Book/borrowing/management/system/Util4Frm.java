/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Book.borrowing.management.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.NEW;

import Book.borrowing.management.system.model.*;


/**
 *
 * @author congcong
 * 通用类
 */
public class Util4Frm {
    private Util4Frm() {}       //禁止实例化
    
    


    /**
     * 刷新底部状态栏的标签显示
     * @param jtable 待处理的表格
     * @param jlabel 底部状态栏标签
     */
    public static void resetBackText(JTable jtable,JLabel jlabel) {
        int row = jtable.getSelectedRow();
        int tot = jtable.getRowCount();
        if (row >=0  && row < tot)
        {
            jlabel.setText("这是第"+(row+1)+"条记录，共查询到"+tot+"条记录");
        } else
            jlabel.setText("共查询到"+tot+"条记录");
    }

    /**
     * 获取对jTable列排序时需要追加的sql文本
     * @param jtable 对哪个jTable操作
     * @param col 对应的列
     * @return 返回排序需要追加的sql文本
     */
    public static String getappendsqlbyorder(String colName){
        //获取列名
        String appendsql = " order by "+colName;
        //根据排序方向选择升序或降序
        //if (sort) {
        //    appendsql += " desc";
        //}
        //再次运行方法，更换排序方向
        //sort = !sort;
        return appendsql;
    }
    
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
    
    public static void showMessageDialogAndReturn(HttpServletResponse response,String message,String url) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("<script>");
		response.getWriter().append("alert('"+message+"');");
		if (!url.equals("")) response.getWriter().append("window.location.href='"+url+"';");
		response.getWriter().append("</script>");
    }
    
    public static boolean judgeusername(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("application/json;charset=utf-8");
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
    	if (request.getSession().getAttribute("username")==null) {
    		response.getWriter().append(JSON.toJSONString(new MessageJSONModel("601","您还未登录，请先登录系统")));
    	}
    	return request.getSession().getAttribute("username")!=null;
    }
}
