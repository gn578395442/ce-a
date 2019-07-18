package cea;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;
 
/**
 *Javaͨ��JDBC��ʽ����H2���ݿ�
 */
public class H2ConnTest2 {
    //���ݿ�����URL
    //private static final String JDBC_URL = "jdbc:h2:E:/Test/h2/bin/test";
	private static final String JDBC_URL = "jdbc:h2:~/test";
    //�������ݿ�ʱʹ�õ��û���
    private static final String USER = "sa";
    //�������ݿ�ʱʹ�õ�����
    private static final String PASSWORD = "";
    //����H2���ݿ�ʱʹ�õ������࣬org.h2.Driver���������H2���ݿ��Լ��ṩ�ģ���H2���ݿ��jar���п����ҵ�
    private static final String DRIVER_CLASS="org.h2.Driver";
    
    public static void main(String[] args) throws Exception {
        // ����H2���ݿ�����
        Class.forName(DRIVER_CLASS);
        // ��������URL���û����������ȡ���ݿ�����
        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        //�������USER_INFO�����ɾ��USER_INFO��
        //stmt.execute("DROP TABLE IF EXISTS cea_ku");
        //����USER_INFO��
        //stmt.execute("CREATE TABLE cea_ku(id VARCHAR(36) PRIMARY KEY,name VARCHAR(100))");
        //����
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('11','C+CO2=2CO')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('12','CO2+H2O=H2CO3')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('13','CaO+H2O=Ca(OH)2')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('14','Na2O+H2O=2NaOH')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('15','SO3+H2O=H2SO4')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('16','CuSO4+5H2O=CuSO4��5H2O')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('17','2H2O=2H2+O2')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('18','Cu2(OH)2CO3=2CuO+H2O+CO2')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('19','2KClO3MnO22KCl+3O2')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('20','2KMnO4=K2MnO4+MnO2+O2')");
        //ɾ��
        //stmt.executeUpdate("DELETE FROM cea_ku WHERE id='3'");
        //�޸�
        //stmt.executeUpdate("UPDATE cea_ku SET id='2' WHERE id='02'");
        //��ѯ
        ResultSet rs = stmt.executeQuery("SELECT * FROM cea_ku");
        //���������
        while (rs.next()) {
            System.out.println(rs.getString("id") + "," + rs.getString("name"));
        }
        //�ͷ���Դ
        stmt.close();
        //�ر�����
        conn.close();
    }
}
