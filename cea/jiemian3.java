package cea;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("serial")
public  class jiemian3 extends JFrame implements ActionListener, ItemListener
{
	static jiemian3 s;
	/*��ӿؼ�*/
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
	
	 //���ݿ�����URL
    //private static final String JDBC_URL = "jdbc:h2:E:/Test/h2/bin/test";
	 String JDBC_URL = "jdbc:h2:~/test";
    //�������ݿ�ʱʹ�õ��û���
     String USER = "sa";
    //�������ݿ�ʱʹ�õ�����
     String PASSWORD = "";
    //����H2���ݿ�ʱʹ�õ������ࡣorg.h2.Driver���������H2���ݿ��Լ��ṩ�ģ���H2���ݿ��jar���п����ҵ�
     String DRIVER_CLASS="org.h2.Driver";
     //ȫ�ֶ���
    Connection conn;Statement stmt;
    ResultSet rs,rs1;
    int max=82,min=1,a1,b1,c1,d1,e1,a2,b2,c2,d2,e2;
    String ti1,name1,ta1="",ta2="",ta3="";

public jiemian3()
{
	super("��ѧ����ʽ��ð��");
	this.setResizable(false);
	this.setSize(400,550);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.add(jpl);
	jpl.setLayout(null);	
	/*�������*/
	label1.setBounds(80,20,220,20);
	jpl.add(label1);
	label2.setBounds(70,80,250,50);
	jpl.add(label2);
	label3.setBounds(60,140,250,20);
	jpl.add(label3);
	tf1.setBounds(70,180,30,20);
	jpl.add(tf1);
	tf1.addActionListener(this);
	tf2.setBounds(120,180,30,20);
	jpl.add(tf2);
	tf2.addActionListener(this);
	tf3.setBounds(170,180,30,20);
	jpl.add(tf3);
	tf3.addActionListener(this);
	tf4.setBounds(220,180,30,20);
	jpl.add(tf4);
	tf4.addActionListener(this);
	tf5.setBounds(270,180,30,20);
	jpl.add(tf5);
	tf5.addActionListener(this);
	ta.setBounds(70,260, 250, 200);
	ta.setBackground(Color.GRAY );
	ta.setEditable(false);
	ta.setLineWrap(true);		//�����Զ����й��� 
	//ta.setWrapStyleWord(true);  // ������в����ֹ���
	jpl.add(ta);
	bt1.setBounds(80,220,90,20);
	bt1.addActionListener(this);
	jpl.add(bt1);
	bt2.setBounds(240,220,90,20);
	bt2.addActionListener(this);	
	jpl.add(bt2);
	//�س�������ť
	bt1.registerKeyboardAction(bt1.getActionForKeyStroke(
			 KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
			 KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),JComponent.WHEN_FOCUSED);
	bt1.registerKeyboardAction(bt1.getActionForKeyStroke(
			 KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
			 KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),JComponent.WHEN_FOCUSED);
	bt2.registerKeyboardAction(bt2.getActionForKeyStroke(
			 KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
			 KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),JComponent.WHEN_FOCUSED);
	bt2.registerKeyboardAction(bt2.getActionForKeyStroke(
			 KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
			 KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),JComponent.WHEN_FOCUSED);
	tips();
}	

public  void chuti() {
		try{// ����H2���ݿ�����
	        Class.forName(DRIVER_CLASS);
	    }
	    catch (ClassNotFoundException ce){
		    JOptionPane.showMessageDialog(s,ce.getMessage());
	    }
		
		try{// ��������URL���û����������ȡ���ݿ�����
		    conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		    stmt = conn.createStatement();
		  Random random = new Random();
		  int t = random.nextInt(max-min+1) + min;
		  //��ѯ
		    rs = stmt.executeQuery("SELECT * FROM cea_ku where id = '"+t+"' ");
		    //rs��Ϣת��
		     if (rs.next()) {
		    		//String id1 = rs.getString("id");
		 			ti1 = rs.getString("ti");
		 			name1 = rs.getString("name");
					a1 = rs.getInt("a");
					b1 = rs.getInt("b");
					c1 = rs.getInt("c");
					d1 = rs.getInt("d");
					e1 = rs.getInt("e");
					ta2= rs.getString("miaoshu");
		         System.out.println(rs.getString("id") + "," + rs.getString("name") + "," + rs.getString("ti") + "," + rs.getInt("a")
		         + "," + rs.getInt("b")+ "," + rs.getInt("c")+ "," + rs.getInt("d")+ "," + rs.getInt("e")+ "," +rs.getString("miaoshu"));
		         //��ѧ����ʽ���±�ת��
		         StringBuffer sb = new StringBuffer();
		 		int index = 0;
		 		char[] chars = ti1.toCharArray();// ��ǰ����
		 		
		 		  for (int i = 1; i < chars.length; i++) {  
		 			  if(chars[i]>='0' && chars[i]<='9'){  //if��ǰ�ַ�������
		 	                //if(ǰһ���ַ��� ������ ���� ǰһ���ַ�����ĸ)  
		 	                if(chars[i-1]==')'   
		 	                        || (chars[i-1]>='A' && chars[i-1]<='Z')  
		 	                        || (chars[i-1]>='a' && chars[i-1]<='z')  ){  
		 	                    	sb.append(ti1.substring(index,i));  
		 	                            	sb.append("<sub>"+chars[i]+"</sub>");  
		 	                            	index = i+1; 
		 						}
		 	            } //~ if-else �жϵ�ǰ�ַ�������
		 	        } //~ for(i++)  
		 		  sb.append(ti1.substring(index, chars.length));//��ȫ
		 			label2.setText("<HTML>"+sb.toString()+"</HTML>");
		     }
		    
				rs.close();
				conn.close();  //�ر�����
		}catch(Exception exp){
			exp.printStackTrace();  //���������Ϣ
		}
		ta.setText(ta1+ "\n" +"\n" +ta2+ "\n" +"\n" +ta3);
}

public void panduan() {
	if(rs == null){//���rs�Ƿ�Ϊ��
		JOptionPane.showMessageDialog(s,"�㻹û�г�����");
      }else {//��ֹһ�������ύ
    	  if (rs == rs1){
				JOptionPane.showMessageDialog(s,"��һ����ո��������ϣ�");
				}else {
					char[] chars = name1.toCharArray();// ��ǰ����
					StringBuffer sb = new StringBuffer();
					int index = 0;
					  for (int i = 1; i < chars.length; i++) {  
					      if(chars[i]>='0' && chars[i]<='9'){  //if��ǰ�ַ�������
					            //if(ǰһ���ַ��� ������ ���� ǰһ���ַ�����ĸ)  
					            if(chars[i-1]==')'   
					                    || (chars[i-1]>='A' && chars[i-1]<='Z')  
					                    || (chars[i-1]>='a' && chars[i-1]<='z')  ){  
					                	sb.append(name1.substring(index,i));  
					                        	sb.append("<sub>"+chars[i]+"</sub>");  
					                        	index = i+1; 
									}
					        } //~ if-else �жϵ�ǰ�ַ�������
					    } //~ for(i++)  
					  sb.append(name1.substring(index, chars.length));//��ȫ
						label2.setText("<HTML>"+sb.toString()+"</HTML>");
						try{//�ж϶Դ�
							a2 =Integer.parseInt(tf1.getText());
							b2 =Integer.parseInt(tf2.getText());
							c2 =Integer.parseInt(tf3.getText());
							d2 =Integer.parseInt(tf4.getText());
							e2 =Integer.parseInt(tf5.getText());
					    }
					    catch (Exception ce1){
						    JOptionPane.showMessageDialog(s,ce1.getMessage()+ "\n" +"�����������ֲ���Ӵ��");
							tf1.requestFocus();
							tf1.selectAll();
						    return; 
					    }
						if(a1 ==a2 && b1 ==b2  && c1 ==c2 && d1 ==d2  && e1 ==e2  ){ 
							ta1="��ϲ������";
							ta.setText(ta1+ "\n" +"\n" +ta2+ "\n" +"\n" +ta3);
						 }else {
							 ta1="��Ŷ�������Ŷ";
							 ta.setText(ta1+ "\n" +"\n" +ta2+ "\n" +"\n" +ta3);}}rs1=rs;}
}
@Override
public void actionPerformed(ActionEvent e0) {
		// TODO Auto-generated method stub
			//bt1:����
			if(e0.getSource()==bt1){
			chuti();
			tf1.requestFocus();
			tf1.selectAll();
		}
			
		//bt2���Դ�
		if(e0.getSource()==bt2){
			bt1.requestFocus();
			panduan();
		}
		//�����л�
		if (e0.getSource() == tf1) {
			tf2.requestFocus();
			tf2.selectAll();}
			else if (e0.getSource() == tf2) {
			tf3.requestFocus();
			tf3.selectAll();}
			else if (e0.getSource() == tf3) {
			tf4.requestFocus();
			tf4.selectAll();}
			else if (e0.getSource() == tf4) {
			tf5.requestFocus();
			tf5.selectAll();}
			else if (e0.getSource() == tf5) {
			bt2.requestFocus();}
}
public void tips(){
	TimerTask task = new TimerTask() {
	@Override
	public void run() {
		ta3="�����ڷ������ϵ����0��λ��\nTab���������л����㣻\nShift+Tab���������л�����";//���Ըĳɶ���tipsѭ������
		ta.setText(ta1+ "\n" + "\n" +ta2+ "\n" + "\n" +ta3);
	}};
Timer timer = new Timer();
long delay = 0;
long intevalPeriod = 5 * 1000;
timer.scheduleAtFixedRate(task, delay, intevalPeriod);
}

@SuppressWarnings("unused")
public static void main(String[] args)
{
	jiemian3 s = new jiemian3();
}

@Override
public void itemStateChanged(ItemEvent e) {
	// TODO �Զ����ɵķ������
}
}
