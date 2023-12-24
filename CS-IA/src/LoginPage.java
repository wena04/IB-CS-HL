import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPage implements ActionListener{
		
	String[] c;
	String[] f;
	String[] l;
	String[] g;
	String[] a;
	int[] n;
	String[] r;
	int[] rn;
	ImageIcon[] i;
	String[] s;
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");		
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
		
	HashMap<String,String> Slogininfo = new HashMap<String,String>();
	HashMap<String,String> Tlogininfo = new HashMap<String,String>();
		
	LoginPage(HashMap<String,String> SloginOriginal, HashMap <String,String> TloginOriginal,
			  String[] contactsOriginal, String[] firstnameOriginal, 
			  String[] lastnameOriginal, String[] gradesOriginal, String[] avalibleOriginal,
			  int[] numbersOriginal, String[] roomnameOriginal, int[] roomnumberOriginal, 
			  ImageIcon[] imagesOriginal, String[] descriptionsOriginal){
			
		Slogininfo = SloginOriginal;
		Tlogininfo = TloginOriginal;
		c = contactsOriginal;
		f = firstnameOriginal;
		l = lastnameOriginal;
		g = gradesOriginal;
		a = avalibleOriginal;
		n = numbersOriginal;
		r = roomnameOriginal;
		rn= roomnumberOriginal;
		i = imagesOriginal;
		s = descriptionsOriginal;
			
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
			
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
			
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
			
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
			
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Log in Page");
		frame.setLocationRelativeTo(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		String userID = userIDField.getText();
		String password = String.valueOf(userPasswordField.getPassword());
		//System.out.println(password);
		//System.out.println(userID);
			
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			}
			
		if(e.getSource()==loginButton) {
				
			if(Slogininfo.containsKey(userID)) {
				if(Slogininfo.get(userID).equals(password)) {
					//System.out.println(logininfo.get(userID));
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					frame.dispose();
					StudentWelcome SwelcomePage = new StudentWelcome(userID,c,f,l,g,a,n,r,rn,i,s);
					}					
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
					}
			}
								
		if(Tlogininfo.containsKey(userID)) {
					
			if(Tlogininfo.get(userID).equals(password)) {
				//System.out.println(logininfo.get(userID));
				messageLabel.setForeground(Color.green);
				messageLabel.setText("Login successful");
				frame.dispose();
				TeacherWelcome Twelcomepage = new TeacherWelcome(userID,c,f,l,g,a,n,r,rn,i,s);
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Wrong password");
			}
		}
				
		else {
			messageLabel.setForeground(Color.red);
			messageLabel.setText("username not found");
			}
		}
	}
}