package Book.borrowing.management.system;

import java.util.Locale;
import java.util.ResourceBundle;

public class test {
    public static void main(String[] args){
        //获取OS使用的语言环境
        //根据指定的语言环境加载对应的资源文件。第一个参数是字符串，指定资源文件的baseName，第二个参数指定Locale（语言环境）。可缺省第二个参数（默认就是OS的当前/默认语言环境）
        System.out.println("en_US".split("_")[1]);
    	Locale locale = new Locale("en","US");
        ResourceBundle bundle=ResourceBundle.getBundle("i18n",locale);
        //通过key获取已加载资源的value，参数为key
        System.out.println(locale);
        System.out.println(bundle.getString("loginerror"));
    }
}
