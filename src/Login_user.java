

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login_user extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;


	public Login_user() {
            super("Login/SignUp");
            
        //Color class --> Swing
        //background --> Jframe
	setBackground(Color.ORANGE);	
        setBounds(600, 300, 600, 400);
		
        panel = new JPanel();
	panel.setBackground(Color.gray);
	setContentPane(panel);
	panel.setLayout(null);

        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/logo.png")));
        l.setBounds(300, 10, 400, 300);
        panel.add(l);    
        
        
        
        
        
        
	JLabel l1 = new JLabel("Username --> ");
	l1.setBounds(124, 89, 95, 24);
        l1.setForeground(Color.black);
	panel.add(l1);

	JLabel l2 = new JLabel("Password --> ");
	l2.setBounds(124, 124, 95, 24);
        l2.setForeground(Color.black);
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(210, 93, 157, 20);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(210, 128, 157, 20);
	panel.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel.add(l3);

	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(Color.black);
	b1.setBackground(Color.green);
	b1.setBounds(149, 181, 113, 39);
	panel.add(b1);
		
        b2 = new JButton("SignUp");
	b2.addActionListener(this);
	
	b2.setForeground(Color.black);
	b2.setBackground(Color.CYAN);
	b2.setBounds(289, 181, 113, 39);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
        b3.setForeground(Color.black);
	b3.setBackground(Color.red);
	b3.setBounds(199, 231, 179, 39);
	panel.add(b3);

	

//		JPanel panel2 = new JPanel();
//		panel2.setBackground(Color.YELLOW);
//		panel2.setBounds(24, 40, 434, 263);
//		panel.add(panel2);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                Boolean status = false;
		try {
                    conn con = new conn();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, passwordField.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new Home().setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login...!.");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		Forgot forgot = new Forgot();
		forgot.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login_user().setVisible(true);
	}

}
