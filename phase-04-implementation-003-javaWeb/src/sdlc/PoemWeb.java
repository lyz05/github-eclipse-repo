package sdlc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class PoemWeb {
	/*
	public  String poemTest="��������ͯ�뾩��<br /> <span style=\"font-size: 18px; color: grey\">\r\n" + 
    		"			[��] ��� </span><br /> \r\n" + 
    		"			<br /> �׾�����ɽ�й飬�Ƽ����������ʡ� \r\n" + 
    		"			<br /> ��ͯ�뼦�ð׾ƣ���Ů��Цǣ���¡�\r\n" +
    		"           <br /> �߸�ȡ������ο��������������ԡ�\r\n" +
    		"           <br /> ��˵��˿಻�磬���޿�����Զ����\r\n" +
    		"           <br /> ����޸����򳼣�����Ǽ������ء�\r\n" +
    		"           <br /> �����Ц����ȥ���ұ����������ˡ�";
    */
    // MySQL 8.0 ���ϰ汾 - JDBC �����������ݿ� URL
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    String DB_URL = "jdbc:mysql://tomcat:3306/sdlc?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    String USER;
    String PASS;
 
    public PoemWeb() {
    	ResourceBundle resource = ResourceBundle.getBundle("dbconfig");
    	JDBC_DRIVER = resource.getString("jdbc.driverClass");
    	DB_URL = resource.getString("jdbc.sdlc.jdbcUrl");
    	USER = System.getenv("MYSQL_USER");
    	PASS = System.getenv("MYSQL_PASS");
	}
    
	public static void main(String[] args) {
		//PoemWeb poem=new PoemWeb();
	    //String poemText=poem.getPoemContent();
		PoemWeb poem=new PoemWeb();
		String poemText=poem.getPoemContent(1);
		System.out.print(poemText);
	}
    public String getPoemContent(int num) {
    	Connection conn = null;
        Statement stmt = null;
        String poemTest = "";
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, content FROM poem";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            int cnt = 0;
            while(rs.next()){
            	cnt ++;
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String content = rs.getString("content");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print(", content: " + content);
                System.out.print("\n");
                
                //����ʫ�ʵ�����
                if (cnt == num)
                {
                	poemTest = content;
                }
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    	return poemTest;
    }
}
//create database sdlc;
//use sdlc
//create table if not exists `poem`(`id` int primary key,`content` char(255)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//INSERT INTO `poem` VALUES ('1', '��������ͯ�뾩��<br /> <span style=\"font-size: 18px; color: grey\">[��] ��� </span><br /> <br /> �׾�����ɽ�й飬�Ƽ����������ʡ�<br /> ��ͯ�뼦�ð׾ƣ���Ů��Цǣ���¡�<br /> �߸�ȡ������ο��������������ԡ�<br /> ��˵��˿಻�磬���޿�����Զ����<br /> ����޸����򳼣�����Ǽ������ء�<br /> �����Ц����ȥ���ұ����������ˡ�');
//INSERT INTO `poem` VALUES ('2', '��ʫ�ʰ�\"���˵���\"��<br /> <span style=\"font-size: 18px; color: grey\">-���� </span><br /> <br /> ���紵�嶫���ӣ��������׷��ࡣ <br /> �����ǼʼҺ�ȥ���������γ����ӡ�');