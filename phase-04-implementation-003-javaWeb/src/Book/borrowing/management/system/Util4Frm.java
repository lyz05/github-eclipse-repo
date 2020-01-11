/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Book.borrowing.management.system;

import java.awt.Component;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author congcong
 */
public class Util4Frm {
    private Util4Frm() {}       //��ֹʵ����
    /**
     * ��ǰ��½�û���ReaderNO�������еĴ��ھ�����
     */
    //public static String readerNO = null;
    /**
     * ����ķ������ڶ�jTable�е�������
     */
    private static boolean sort = false;
    
    /**
     * ���ô�����ʾЧ����ԭ������
     * @param comp �ṩ�����Ӧ��Component
     */
    public static void setUI(Component comp) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(comp);
        } catch(Exception err) {
            System.out.println("���ô���Ч���쳣:"+err);
        }
    }
    
    /**
     * ���ݱ�������Զ�����JTable�п��
     * @param table �޸ĵ�jtable
     */
    public static void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    
    /**
     * �ƶ�jTable��ǰѡ���еĹ��
     * @param jtable Ҫ�ƶ�����jTable
     * @param dis λ�������ԭ����λ�ƣ�+1��ʾ���£�-1��ʾ����
     */
    public static void moveFormRow(JTable jtable,int dis)
    {
        int tmp =  jtable.getSelectedRow() + dis;
        if (tmp<0) {
            JOptionPane.showMessageDialog(null,"�Ѿ��ǵ�һ��������","ϵͳ��ʾ",JOptionPane.INFORMATION_MESSAGE);
        } else if (tmp>=jtable.getRowCount()) {
            JOptionPane.showMessageDialog(null,"�Ѿ������һ��������","ϵͳ��ʾ",JOptionPane.INFORMATION_MESSAGE);
        } else 
        jtable.setRowSelectionInterval(tmp, tmp);
    }

    /**
     * �ƶ�jTable��ǰѡ���й�굽������ײ�
     * @param jtable
     * @param status 
     */
    public static void moveFormRowToTop(JTable jtable,int status)
    {
        int tmp = 0;
        if (status==1) {
            tmp = jtable.getRowCount()-1;
        }
        jtable.setRowSelectionInterval(tmp, tmp);
    }

    /**
     * ˢ�µײ�״̬���ı�ǩ��ʾ
     * @param jtable ������ı��
     * @param jlabel �ײ�״̬����ǩ
     */
    public static void resetBackText(JTable jtable,JLabel jlabel) {
        int row = jtable.getSelectedRow();
        int tot = jtable.getRowCount();
        if (row >=0  && row < tot)
        {
            jlabel.setText("���ǵ�"+(row+1)+"����¼������ѯ��"+tot+"����¼");
        } else
            jlabel.setText("����ѯ��"+tot+"����¼");
    }

    /**
     * ��ȡ��jTable������ʱ��Ҫ׷�ӵ�sql�ı�
     * @param jtable ���ĸ�jTable����
     * @param col ��Ӧ����
     * @return ����������Ҫ׷�ӵ�sql�ı�
     */
    public static String getappendsqlbyorder(JTable jtable,int col){
        //��ȡ����
        String colName = jtable.getColumnName(col);
        String appendsql = " order by "+colName;
        //����������ѡ���������
        if (sort) {
            appendsql += " desc";
        }
        //�ٴ����з���������������
        sort = !sort;
        return appendsql;
    }
    
    /**
     * �����ؼ�
     * @param jtextfield �������ؼ�
     */
    public static void locktextfiled(JTextField jtextfield){
        jtextfield.setEnabled(false);
    }
    
    /**
     * �����ؼ�
     * @param jtextfield �������ռ� 
     */
    public static void unlocktextfiled(JTextField jtextfield){
        jtextfield.setEnabled(true);
    }
    
    /**
     * ȷ��ɾ���Ի���
     * @return �Ƿ���ȷ�ϰ�ť
     */
    public static boolean confirmdelete() {
         return JOptionPane.showConfirmDialog(null,"��ȷ��ɾ������������","ϵͳ��ʾ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION;
    }
    /**
     * ȷ����������Ի���
     * @return �Ƿ���ȷ�ϰ�ť
     */
    public static boolean confirmresetpwd() {
         return JOptionPane.showConfirmDialog(null,"��ȷ�����ø��û�������","ϵͳ��ʾ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION;
    }
    
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

}
