package cea;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import java.util.Random;

public  class jiemian3 extends JFrame implements ActionListener, ItemListener
{
	static jiemian3 s;
	/*���ѧ����Ϣ�ؼ�*/
	JPanel jpl = new JPanel();
	JLabel label1 = new JLabel("�뽫��������Ļ�ѧ����ʽ��ƽ",JLabel.CENTER);
	JLabel label2 = new JLabel("",JLabel.CENTER);
	JLabel label3 = new JLabel("�뽫��ƽ���ϵ���ֱ������Ӧ����",JLabel.CENTER);
	JButton bt1 = new JButton("��ʼ����");
    JButton bt2 = new JButton("�ύ");
	JTextField tf1 = new JTextField(1);
	JTextField tf2= new JTextField(1);
	JTextField tf3 = new JTextField(1);
	JTextField tf4 = new JTextField(1);
	JTextField tf5 = new JTextField(1);
	JTextArea ta = new JTextArea(5,20);
	JScrollPane scrollPane = new JScrollPane();
	JTable table;
  	int max=82;
    int min=1;
    Connection conn;
    Statement stmt;
    ResultSet rs;

public jiemian3()
{
	super("��ѧ����ʽ��ð��");
	this.setResizable(false);
	this.setSize(500,800);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.add(jpl);
	jpl.setLayout(null);	
	/*�������*/
	label1.setBounds(80,20,220,20);
	jpl.add(label1);
	label2.setBounds(70,80,300,50);
	jpl.add(label2);
	label3.setBounds(60,140,250,20);
	jpl.add(label3);
	tf1.setBounds(70,180,30,20);
	jpl.add(tf1);
	tf2.setBounds(120,180,30,20);
	jpl.add(tf2);
	tf3.setBounds(170,180,30,20);
	jpl.add(tf3);
	tf4.setBounds(220,180,30,20);
	jpl.add(tf4);
	tf5.setBounds(270,180,30,20);
	jpl.add(tf5);
	ta.setBounds(70,260, 250, 200);
	ta.setBackground(Color.GRAY );
	jpl.add(ta);
	bt1.setBounds(80,220,90,20);
	bt1.addActionListener(this);
	jpl.add(bt1);
	bt2.setBounds(240,220,90,20);
	bt2.addActionListener(this);	
	jpl.add(bt2);
}	
	
@Override
public void actionPerformed(ActionEvent e0) {
		// TODO Auto-generated method stub
		
			 //���ݿ�����URL
		    //private static final String JDBC_URL = "jdbc:h2:E:/Test/h2/bin/test";
			 String JDBC_URL = "jdbc:h2:~/test";
		    //�������ݿ�ʱʹ�õ��û���
		     String USER = "sa";
		    //�������ݿ�ʱʹ�õ�����
		     String PASSWORD = "";
		    //����H2���ݿ�ʱʹ�õ������࣬org.h2.Driver���������H2���ݿ��Լ��ṩ�ģ���H2���ݿ��jar���п����ҵ�
		     String DRIVER_CLASS="org.h2.Driver";
		     
				Vector columnVector = new Vector();
				Vector dataVector = new Vector();
			try
		    {
				// ����H2���ݿ�����
		        Class.forName(DRIVER_CLASS);
		    }
		    catch (ClassNotFoundException ce)
		    {
			    JOptionPane.showMessageDialog(s,ce.getMessage());
		    }
			//bt1:����
			if(e0.getSource()==bt1){
			try{
				// ��������URL���û����������ȡ���ݿ�����
		       conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		       stmt = conn.createStatement();
		     Random random = new Random();
		     int t = random.nextInt(max-min+1) + min;
		     //��ѯ
		       rs = stmt.executeQuery("SELECT * FROM cea_ku where id = '"+t+"' ");
		       
		        if (rs.next()) {
		            System.out.println(rs.getString("id") + "," + rs.getString("name") + "," + rs.getString("ti") + "," + rs.getString("a")
		            + "," + rs.getString("b")+ "," + rs.getString("c")+ "," + rs.getString("d")+ "," + rs.getString("e"));
		            StringBuffer sb = new StringBuffer();
		    		int index = 0;
		    		String str_value = rs.getString("ti");
		    		char[] chars = str_value.toCharArray();// ��ǰ����
		    		
		    		  for (int i = 1; i < chars.length; i++) {  
		    	          
		    			  if(chars[i]>='0' && chars[i]<='9'){  //if��ǰ�ַ�������
		    	                //if(ǰһ���ַ��� ������ ���� ǰһ���ַ�����ĸ)  
		    	                if(chars[i-1]==')'   
		    	                        || (chars[i-1]>='A' && chars[i-1]<='Z')  
		    	                        || (chars[i-1]>='a' && chars[i-1]<='z')  ){  
		    	                    	sb.append(str_value.substring(index,i));  
		    	                            	sb.append("<sub>"+chars[i]+"</sub>");  
		    	                            	index = i+1; 
		    						}
		    	            } //~ if-else �жϵ�ǰ�ַ������� 
		    			  /*if(chars[i]>='0' && chars[i]<='9'){  //if��ǰ�ַ�������
		    	                //if(ǰһ���ַ��� ������ ���� ǰһ���ַ�����ĸ)  
		    	                if(chars[i-2]==')'   
		    	                        || (chars[i-1]>='A' && chars[i-1]<='Z')  
		    	                        || (chars[i-1]>='a' && chars[i-1]<='z')||(chars[i-1]>='0' && chars[i-1]<='9')  ){  
		    	                    	sb.append(str_value.substring(index,i));  
		    	                            	sb.append("<sub>"+chars[i]+"</sub>");  
		    	                            	index = i+1; 
		    						}
		    	            }*/
		    	        } //~ for(i++)  
		    		  sb.append(str_value.substring(index, chars.length));//����ȫ
		    			label2.setText("<HTML>"+sb.toString()+"</HTML>");
		        }
		       
				//rs.close();
				//conn.close();  //�ر�����
			
			}catch(Exception exp){
				exp.printStackTrace();  //���������Ϣ
			}
		}
		else
		{
			label2.setText("");
		}	
		//bt2���Դ�
		if(e0.getSource()==bt2){
			try {
				System.out.println(rs.getString("id") + "," + rs.getString("name") + "," + rs.getString("ti") + "," + rs.getString("a")
	            + "," + rs.getString("b")+ "," + rs.getString("c")+ "," + rs.getString("d")+ "," + rs.getString("e"));
	            StringBuffer sb = new StringBuffer();
	    		int index = 0;
	    		String str_value = rs.getString("name");
	    		char[] chars = str_value.toCharArray();// ��ǰ����
	    		
	    		  for (int i = 1; i < chars.length; i++) {  
	    	          if(chars[i]>='0' && chars[i]<='9'){  //if��ǰ�ַ�������
	    	                //if(ǰһ���ַ��� ������ ���� ǰһ���ַ�����ĸ)  
	    	                if(chars[i-1]==')'   
	    	                        || (chars[i-1]>='A' && chars[i-1]<='Z')  
	    	                        || (chars[i-1]>='a' && chars[i-1]<='z')  ){  
	    	                    	sb.append(str_value.substring(index,i));  
	    	                            	sb.append("<sub>"+chars[i]+"</sub>");  
	    	                            	index = i+1; 
	    						}
	    	            } //~ if-else �жϵ�ǰ�ַ�������
	    	        } //~ for(i++)  
	    		  sb.append(str_value.substring(index, chars.length));//����ȫ
	    			label2.setText("<HTML>"+sb.toString()+"</HTML>");
	    			
	    			String a = rs.getString("a");
	    			String b = rs.getString("b");
	    			String c = rs.getString("c");
	    			String d = rs.getString("d");
	    			String e = rs.getString("e");
	    			 String a1 =tf1.getText();
	    			 String b1 =tf2.getText();
	    			 String c1 =tf3.getText();
	    			 String d1 =tf4.getText();
	    			 String e1 =tf5.getText();
					if(a1 ==a && b1 ==b  && c1 ==c && d1 ==d  && e1 ==e  ){ 
						ta.setText("��ϲ������");
	    			 }else {ta.setText("��Ŷ�������Ŷ");}
					System.out.println(a+b+c+d+e+a1+b1+c1+d1+e1);
					rs.close();
					conn.close();  //�ر�����
	        }
			 catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
}
		


@Override
public void itemStateChanged(ItemEvent arg1) {

}

@SuppressWarnings("unused")
public static void main(String[] args)
{
	jiemian3 s = new jiemian3();
}
}
