package Book.borrowing.management.system;

import java.util.Locale;
import java.util.ResourceBundle;

public class test {
    public static void main(String[] args){
        //��ȡOSʹ�õ����Ի���
        //����ָ�������Ի������ض�Ӧ����Դ�ļ�����һ���������ַ�����ָ����Դ�ļ���baseName���ڶ�������ָ��Locale�����Ի���������ȱʡ�ڶ���������Ĭ�Ͼ���OS�ĵ�ǰ/Ĭ�����Ի�����
        System.out.println("en_US".split("_")[1]);
    	Locale locale = new Locale("en","US");
        ResourceBundle bundle=ResourceBundle.getBundle("i18n",locale);
        //ͨ��key��ȡ�Ѽ�����Դ��value������Ϊkey
        System.out.println(locale);
        System.out.println(bundle.getString("loginerror"));
    }
}
