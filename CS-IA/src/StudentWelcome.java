import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Arrays;

public class StudentWelcome implements ActionListener {

	int count = 1;
	int start;
	int end;
	int max;
	int next;
	int[] yesnumber;
	int[] nonumber;
	int[] numbers;
	String[] firstname;
	String[] lastname;
	String[] yesname;
	String[] noname;
	String[] contacts;
	String[] yesavalible;
	String[] noavalible;
	String[] grades;
	String[] avalible;
	String contactdisplayyes = "";
	String contactdisplayno = "";
	//LOCATIONS
	ImageIcon[] roomimages;
	String[] roomname;
	int[] roomnumber;
	String[] roomdescriptions;
	String displaycontact;
	
	JFrame frame = new JFrame();
	JPanel imagePane = new JPanel();
	JPanel descriptionPane = new JPanel();
	JLabel imagedisplayPane = new JLabel();
	JLabel descriptiondisplayPane = new JLabel();
	JTextArea contactdisplayPane = new JTextArea();
	JComboBox startComboBox;
	JComboBox endComboBox;
	JButton goButton = new JButton("GO");
	JButton gradesortButton = new JButton("Sort by Grade");
	JButton backButton = new JButton("");
	JButton nextButton = new JButton(">");
	
	StudentWelcome(String userID, String[] contactOriginals, String[] firstnameOriginals, 
			String[] lastnameOriginals, String[] gradeOriginals, String[] avalibleOriginals, 
			int[] countOriginals, String[] roomnameOriginals, int[] roomnumberOriginals, 
			ImageIcon[] imagesOriginals, String[] descriptionOriginals){
		
		System.out.println("student welcome success");
		delRoom(roomnameOriginals,roomnumberOriginals,imagesOriginals,descriptionOriginals);
		sortRoom(roomname,roomnumber,roomimages,roomdescriptions);
		
		contacts = contactOriginals;
		grades = gradeOriginals;
		avalible = avalibleOriginals;
		firstname = firstnameOriginals;
		lastname = lastnameOriginals;
		numbers = countOriginals;
	
		imagedisplayPane.setBounds(10,10,327,210);
		descriptiondisplayPane.setBounds(10,237,356,75);
		contactdisplayPane.setBounds(378,69,220,301);
		contactdisplayPane.setText(setDefaultContactText());
		imagePane.setBounds(10,10,327,210);
		imagePane.setVisible(true);
		imagePane.setBackground(Color.gray);
		descriptionPane.setBounds(10,237,356,75);
		descriptionPane.setVisible(true);
		descriptionPane.setBackground(Color.gray);
		goButton.setBounds(127,352,117,29);
		goButton.addActionListener(this);

		gradesortButton.setBounds(372,25,117,29);
		gradesortButton.addActionListener(this);
		backButton.setBounds(513,10,85,54);
		backButton.addActionListener(this);
		ImageIcon backpathway = new ImageIcon("Back Sign.jpg");
		Image backimage = backpathway.getImage().getScaledInstance(95,65,Image.SCALE_SMOOTH);
		ImageIcon backresizeimage = new ImageIcon(backimage);
		backButton.setIcon(backresizeimage);
		nextButton.setBounds(340,107,27,21);
		nextButton.addActionListener(this);
		
		frame.add(imagePane);
		frame.add(descriptionPane);
		frame.add(imagedisplayPane);
		frame.add(descriptiondisplayPane);
		frame.add(contactdisplayPane);
		frame.add(goButton);
		frame.add(gradesortButton);
		frame.add(backButton);
		frame.add(nextButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(615, 415);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("WELCOME, STUDENT " + userID);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == backButton){
			frame.dispose();
			IDandPasswords id = new IDandPasswords();
			LoginPage backtologin = new LoginPage(id.getSLogin(),id.getTLogin(),contacts,
					firstname,lastname,grades,avalible,numbers,roomname,roomnumber,
					roomimages,roomdescriptions);
			}
		
		if (e.getSource()==goButton) {
			System.out.println("GO BUTTON CLICKED");
			Image tempimage = roomimages[startComboBox.getSelectedIndex()].getImage().getScaledInstance(327,210,Image.SCALE_SMOOTH);
			ImageIcon resizedimage = new ImageIcon(tempimage);
			imagedisplayPane.setIcon(resizedimage);
			imagePane.setVisible(false);
			descriptiondisplayPane.setText(roomdescriptions[startComboBox.getSelectedIndex()]);
			descriptionPane.setVisible(false);
			start = startComboBox.getSelectedIndex();
			end = endComboBox.getSelectedIndex();
			if (start>end) max = start-end;
			if(end>start) max = end-start;
			next = 0;
		}
		
		if(e.getSource()==nextButton) {
			if(max == next) {
				next = 0;
				changeDisplay(start);
			}
			goDisplay();
		}
	
		if(e.getSource()==gradesortButton) setGradeContactText();
	}

	public void setGradeContactText(){
		String string = "";
		for(int i=0;i<yesnumber.length;i++)
			for(int j = 0;j<yesnumber.length-i-1;j++) {
				if(yesnumber[j]<yesnumber[j+1]) {
					int tempa = yesnumber[j];
					String tempb = yesname[j];
					String tempc = yesavalible[j];
					yesnumber[j]=yesnumber[j+1];
					yesname[j]=yesname[j+1];
					yesavalible[j]=yesavalible[j+1];
					yesnumber[j+1]=tempa;
					yesname[j+1]=tempb;
					yesavalible[j+1]=tempc;
				}
			}
		for(int i=0;i<yesnumber.length;i++) string+=yesname[i] + " G(" + yesnumber[i] + ") is "+ yesavalible[i] +"\n";
		string += "\n";
		for(int i=0;i<nonumber.length;i++)
			for(int j = 0;j<nonumber.length-i-1;j++) {
				if(nonumber[j]<nonumber[j+1]) {
					int tempa = nonumber[j];
					String tempb = noname[j];
					String tempc = noavalible[j];
					nonumber[j]=nonumber[j+1];
					noname[j]=noname[j+1];
					noavalible[j]=noavalible[j+1];
					nonumber[j+1]=tempa;
					noname[j+1]=tempb;
					noavalible[j+1]=tempc;
				}
			}
		for(int i = 0;i<nonumber.length;i++) string+=noname[i]+ " G(" + nonumber[i] + ") is "+ noavalible[i] +"\n";;
		contactdisplayPane.setText(string);
	}
	
	
	public String setDefaultContactText() {
		int smallcount = 0;
		int count1 = 0;
		int count2 = 0;
		boolean check;
		String string;
		int tempa = 0;
		int tempb = 0;
		
		while(contacts[smallcount] != null && smallcount != 18) {
			if(avalible[smallcount].equals("yes")) check = true;
			else check = false;
			if(check) {
				string = "avalible";
				contactdisplayyes += contacts[smallcount]+ " G(" + grades[smallcount] + ") is "+ string + "\n";
				tempa++;
				count1++;
			}
			else{
				string = "not avalible";
				contactdisplayno += contacts[smallcount]+ " G(" + grades[smallcount]+") is "+ string + "\n";
				tempb++;
				count2++;
			}
			smallcount++;
		}
		
		yesname = new String[count1];
		yesnumber = new int[count1];
		yesavalible = new String [count1];
		noname = new String[count2];
		nonumber = new int[count2];
		noavalible = new String[count2];
		int bigcount = 0;
		tempa = 0;
		tempb = 0;
		
		while(contacts[bigcount] != null && bigcount !=18) {
			if(avalible[bigcount].equals("yes")) check = true;
			else check = false;
			if(check) {
				string = "avalible";
				yesnumber[tempa]= Integer.valueOf(grades[bigcount]);
				yesname[tempa]= contacts[bigcount];
				yesavalible[tempa]=string;
				tempa++;
			}
			else{
				string = "not avalible";
				nonumber[tempb]= Integer.valueOf(grades[bigcount]);
				noname[tempb]= contacts[bigcount];
				noavalible[tempb] = string;
				tempb++;
			}
			bigcount++;
		}
		return contactdisplayyes+"\n"+contactdisplayno;
	}
	
	// delete rooms that are larger than three digits or smaller than two digits
	public void delRoom(String[] a, int[] b, ImageIcon[] c, String[] d){
		int temp = 0;
		while (count != 20) {
			if(b[count]>99 && b[count]<400) temp++;
			count++;
		}
		roomname = new String[temp];
		roomnumber = new int[temp];
		roomimages = new ImageIcon[temp];
		roomdescriptions = new String[temp];
		int counter = 0;
		int tempcounter = 0;
		while(tempcounter != roomnumber.length) {
			if(b[counter]>99 && b[counter]<400) {
				roomname[tempcounter] = a[counter];
				roomnumber[tempcounter] = b[counter];
				roomimages[tempcounter] = c[counter];
				roomdescriptions[tempcounter] = d[counter];
				tempcounter++;
			}
			counter++;
		}
	}
	
	
	//bubble sort from smallest to largest room 
	public void sortRoom(String[] a,int[] b, ImageIcon[] c, String[] d){
		//System.out.println(b);
		for(int i = 0;i<b.length;i++) System.out.println(b[i]);
		System.out.println("-----------------");
		for (int i = 0;i<b.length-1;i++) {
			for (int j = 0;j<b.length-i-1;j++) {
				if(b[j]>b[j+1]) {
					String tempa = a[j];
					int tempb = b[j];
					ImageIcon tempc = c[j];
					String tempd = d[j];
					a[j] = a[j+1];
					b[j] = b[j+1];
					c[j] = c[j+1];
					d[j] = d[j+1];
					a[j+1] = tempa;
					b[j+1] = tempb;
					c[j+1] = tempc;
					d[j+1] = tempd;
				}
			}
		}
		roomname = a;
		roomnumber = b;
		roomimages = c;
		roomdescriptions = d;
		
		for(int i = 0;i<b.length;i++) System.out.println(b[i]);
		System.out.println("-----------------");
		
		startComboBox = new JComboBox(roomname);
		startComboBox.setBounds(10,324,172,27);
		endComboBox = new JComboBox(roomname);
		endComboBox.setBounds(194,324,172,27);
		frame.add(startComboBox);
		frame.add(endComboBox);
	}
	
	
	public void goDisplay() {
		
		if(start == end) {
			System.out.println("YOUR ARE THERE ALREADY");
		}
		
		if (start>end) {
			next++;
			changeDisplay(start-next);
		}
		
		if (end>start) {
			next++;
			changeDisplay(start+next);
		}
	}
	
	
	public void changeDisplay(int num) {
		Image tempimage = roomimages[num].getImage().getScaledInstance(327,210,Image.SCALE_SMOOTH);
		ImageIcon resizedimage = new ImageIcon(tempimage);
		imagedisplayPane.setIcon(resizedimage);
		imagePane.setVisible(false);
		descriptiondisplayPane.setText(roomdescriptions[num]);
		descriptionPane.setVisible(false);
	}
}

