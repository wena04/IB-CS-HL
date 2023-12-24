import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class TeacherWelcome extends JFrame implements ActionListener {
	//CONTACTS
	int count;
	ImageIcon newest = null;
	
	int[] number;
	String[] contacts;
	String[] firstname;
	String[] lastname;
	String[] grades;
	String[] avalible;
	//LOCATIONS
	ImageIcon[] roomimages;
	String[] roomname;
	int[] roomnumber;
	String[] roomdescriptions;

	JFrame frame = new JFrame();
	JButton addcontactButton = new JButton("ADD CONTACT");	
	JButton delcontactButton = new JButton("DELETE CONTACT");	
	JButton editcontactButton = new JButton("EDIT CONTACT");
	JButton uploadButton = new JButton("UPLOAD IMAGE");	
	JButton updateButton = new JButton("UPDATE");
	JButton addButton = new JButton("ADD");
	JButton backButton = new JButton("BACK");
	JLabel guideTitleLabel = new JLabel("GUIDE");
	JLabel locationTitleLabel = new JLabel("LOCATION");
	JLabel addfirstnameLabel = new JLabel("First Name: ");
	JLabel addlastnameLabel = new JLabel("Last Name: ");
	JLabel addgradelevelLabel = new JLabel("Grade Level: ");
	JLabel addavalibilityLabel = new JLabel("Avalibility:");
	JLabel delselectedcontactLabel = new JLabel("Select Edit contact:");
	JLabel delfirstnameLabel = new JLabel("First Name: ");
	JLabel dellastnameLabel = new JLabel("Last Name: ");
	JLabel deleditgradelevelLabel = new JLabel("Edit Grade Level:");
	JLabel delavailibilityLabel = new JLabel("Avalibility:");
	JLabel roomnameLabel = new JLabel("Room Name:");
	JLabel roomnumberLabel = new JLabel("Room Number:");
	JLabel locationimageLabel = new JLabel("Location Image:");
	JTextField addfirstnameField = new JTextField();
	JTextField addlastnameField = new JTextField();
	JTextField delfirstnameField = new JTextField();
	JTextField dellastnameField = new JTextField();
	JTextField roomnameField = new JTextField();
	JTextField roomnumberField = new JTextField();
	JRadioButton addyes = new JRadioButton("Yes");
	JRadioButton addno = new JRadioButton("No");
	JRadioButton delyes = new JRadioButton("Yes");
	JRadioButton delno = new JRadioButton("No");
	JComboBox addgradelevel;
	JComboBox deleditcontact;
	JComboBox delgradelevel;
	ButtonGroup add = new ButtonGroup();
	ButtonGroup del = new ButtonGroup();
	
	JLabel roomimagedisplay; 
	JTextField roomdescriptionField;
	JLabel selecteditroomLabel = new JLabel("Select Edit Room:");
	JComboBox selecteditroomComboBox = new JComboBox();
	
	TeacherWelcome(String userID, String[] contactOriginals, String[] firstnameOriginals, 
			String[] lastnameOriginals, String[] gradeOriginals, String[] avalibleOriginals, 
			int[] countOriginals, String[] roomnameOriginals, int[] roomnumberOriginals, 
			ImageIcon[] imagesOriginals, String[] descriptionOriginals){
		
		System.out.println("teacher welcome success");
		
		contacts = contactOriginals;
		firstname = firstnameOriginals;
		lastname = lastnameOriginals;
		grades = gradeOriginals;
		number = countOriginals;
		avalible = avalibleOriginals;
		roomname = roomnameOriginals;
		roomnumber = roomnumberOriginals;
		roomimages = imagesOriginals;
		roomdescriptions = descriptionOriginals;
		
		addcontactButton.setBounds(37, 157, 138, 29);
		addcontactButton.addActionListener(this);
		delcontactButton.setBounds(258, 126, 147, 29);
		delcontactButton.addActionListener(this);
		editcontactButton.setBounds(425,126,125,29);
		editcontactButton.addActionListener(this);
		uploadButton.setBounds(105,302,138,29);
		uploadButton.addActionListener(this);
		updateButton.setBounds(115,335,102,29);
		updateButton.addActionListener(this);
		addButton.setBounds(12,336,102,29);
		addButton.addActionListener(this);
		backButton.setBounds(513,3,85,54);
		backButton.addActionListener(this);
		ImageIcon backpathway = new ImageIcon("Back Sign.jpg");
		Image backimage = backpathway.getImage().getScaledInstance(95,65,Image.SCALE_SMOOTH);
		ImageIcon backresizeimage = new ImageIcon(backimage);
		backButton.setIcon(backresizeimage);
		
		addgradelevel = new JComboBox(grades);
		addgradelevel.addActionListener(this);
		deleditcontact = new JComboBox(contacts);
		deleditcontact.addActionListener(this);
		delgradelevel = new JComboBox(grades);
		delgradelevel.addActionListener(this);
		
		guideTitleLabel.setBounds(6, 0, 65, 30);
		guideTitleLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		locationTitleLabel.setBounds(6,187,111,30);
		locationTitleLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		
		addfirstnameLabel.setBounds(6, 34, 89, 16);
		addlastnameLabel.setBounds(6,67,89,16);
		addgradelevelLabel.setBounds(6,98,89,16);
		addavalibilityLabel.setBounds(6,131,72,16);
		delselectedcontactLabel.setBounds(224,34,125,16);
		delfirstnameLabel.setBounds(224,67,89,16);
		dellastnameLabel.setBounds(224,98,89,16);
		
		deleditgradelevelLabel.setBounds(428,67,111,16);
		delavailibilityLabel.setBounds(428,98,72,16);
		roomnameLabel.setBounds(6,228,89,16);
		roomnumberLabel.setBounds(6,267,111,16);
		locationimageLabel.setBounds(6,307,111,16);
		
		addfirstnameField.setBounds(83, 27, 111, 30);
		addfirstnameField.setColumns(10);
		addlastnameField.setBounds(83, 60, 111, 30);
		addlastnameField.setColumns(10);
		delfirstnameField.setBounds(305, 60, 111, 30);
		delfirstnameField.addActionListener(this);
		delfirstnameField.setColumns(10);
		dellastnameField.setBounds(305, 91, 111, 30);
		dellastnameField.setColumns(10);
		dellastnameField.addActionListener(this);
		roomnameField.setBounds(105, 221, 111, 30);
		roomnameField.setColumns(10);
		roomnumberField.setBounds(105, 260, 111, 30);
		roomnumberField.setColumns(10);
		
		addyes.setBounds(75,127,54,23);
		addyes.setActionCommand("yes");
		add.add(addyes);
		addno.setBounds(141,127,53,23);
		addno.setActionCommand("no");
		add.add(addno);
		del.add(delyes);
		delyes.setBounds(496,94,54,23);
		delyes.setActionCommand("yes");
		delno.setBounds(562,94,53,23);
		delno.setActionCommand("no");
		del.add(delno);
		
		addgradelevel.setBounds(93,94,72,27);
		addgradelevel.addActionListener(this);
		deleditcontact.setBounds(348,30,153,27);
		deleditcontact.addActionListener(this);
		delgradelevel.setBounds(530,63,65,27);
		
		selecteditroomLabel.setBounds(224, 163, 125, 16);
		selecteditroomComboBox.setBounds(348, 159, 239, 27);
		selecteditroomComboBox.setModel(new DefaultComboBoxModel(roomname));
		selecteditroomComboBox.addActionListener(this);
		
		System.out.println(selecteditroomComboBox.getSelectedIndex());
		
		roomimagedisplay = new JLabel();
		Image tempimage = roomimages[selecteditroomComboBox.getSelectedIndex()].getImage().getScaledInstance(335, 95, Image.SCALE_SMOOTH);
		ImageIcon resizedimage = new ImageIcon(tempimage);
		roomimagedisplay.setIcon(resizedimage);
		roomimagedisplay.setBackground(new Color(67, 67, 67));
		roomimagedisplay.setBounds(252, 195, 335, 95);
		
		roomdescriptionField = new JTextField(roomdescriptions[selecteditroomComboBox.getSelectedIndex()]);
		roomdescriptionField.setHorizontalAlignment(SwingConstants.LEFT);
		roomdescriptionField.setBounds(255, 297, 332, 67);
		roomdescriptionField.setColumns(30);
		
		frame.add(addcontactButton);
		frame.add(delcontactButton);
		frame.add(editcontactButton);
		frame.add(uploadButton);
		frame.add(updateButton);
		frame.add(addButton);
		frame.add(backButton);
		frame.add(guideTitleLabel);
		frame.add(locationTitleLabel);
		frame.add(addfirstnameLabel);
		frame.add(addlastnameLabel);
		frame.add(addgradelevelLabel);
		frame.add(addavalibilityLabel);
		frame.add(delselectedcontactLabel);
		frame.add(delfirstnameLabel);
		frame.add(dellastnameLabel);
		frame.add(deleditgradelevelLabel);
		frame.add(delavailibilityLabel);
		frame.add(roomnameLabel);
		frame.add(roomnumberLabel);
		frame.add(locationimageLabel);
		frame.add(addfirstnameField);
		frame.add(addlastnameField);
		frame.add(delfirstnameField);
		frame.add(dellastnameField);
		frame.add(roomnameField);
		frame.add(roomnumberField);
		frame.add(addyes);
		frame.add(addno);
		frame.add(delyes);
		frame.add(delno);
		frame.add(addgradelevel);
		frame.add(deleditcontact);
		frame.add(delgradelevel);
		frame.add(roomdescriptionField);
		frame.add(roomimagedisplay);
		frame.add(selecteditroomLabel);
		frame.add(selecteditroomComboBox);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(615,415);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("WELCOME, ADMINISTRATOR "+ userID);
		frame.setLocationRelativeTo(null);
		
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == backButton){
			frame.dispose();
			IDandPasswords id = new IDandPasswords();
			LoginPage backtologin = new LoginPage(id.getSLogin(),id.getTLogin(),contacts,
					firstname,lastname,grades,avalible,number,roomname,roomnumber,
					roomimages,roomdescriptions);
			}
		
		if(e.getSource() == addcontactButton) {
			int temp = 0;
			int count = 0;
			while(number[temp] != 0) {
				temp++;
				count++;
				System.out.println(number[temp]);
				System.out.println(count);
			}
			//System.out.println(count);
			contacts[count] = (addfirstnameField.getText()+ " " + addlastnameField.getText());
			firstname[count] = addfirstnameField.getText();
			lastname[count] = addlastnameField.getText();
			grades[count] = ((String)addgradelevel.getSelectedItem());
			avalible[count] = add.getSelection().getActionCommand();
			number[count] = count++;
		/*	System.out.println(number[count++]);
			System.out.println("Newly Added Contact Number " + number[count] + " Full Name:" + contacts[count] + 
				" with first name: " + firstname[count] + " with last name: "+ lastname[count] + 
				" in grade: " + grades[count] + " who is " + avalible[count]);
			System.out.println(number[count++]);
		*/
			deleditcontact.setModel(new DefaultComboBoxModel(contacts));
		}
		
		if(e.getSource() == delcontactButton) {
			int temp = deleditcontact.getSelectedIndex();
			int tempcount = 0;
			while(contacts[temp+tempcount+1]!=null)
			{
				contacts[tempcount+temp] = contacts[tempcount+temp+1];
				firstname[tempcount+temp] = firstname[tempcount+temp+1];
				lastname[tempcount+temp] = lastname[tempcount+temp+1];
				grades[tempcount+temp] = grades[tempcount+temp+1];
				avalible[tempcount+temp] = avalible[tempcount+temp+1];
				number[tempcount+temp] = number[tempcount+temp+1];
				tempcount++;
			} 
			contacts[temp+tempcount]=null;
			firstname[temp+tempcount]=null;
			lastname[temp+tempcount]=null;
			grades[temp+tempcount]=null;
			avalible[temp+tempcount]=null;
			number[temp+tempcount]=0;
			deleditcontact.setModel(new DefaultComboBoxModel(contacts));
		}
		
		if(e.getSource() == editcontactButton) {
			int temp = deleditcontact.getSelectedIndex();
			firstname[temp] = delfirstnameField.getText();
			lastname[temp] = dellastnameField.getText();
			grades[temp] = ((String)delgradelevel.getSelectedItem());
			avalible[temp] = del.getSelection().getActionCommand();
			contacts[temp] = firstname[temp]+ " " + lastname[temp];
			number[temp] = temp++;
			System.out.println("Newly Added Contact Number " + number[temp] + " Full Name:" + contacts[temp] + 
					" with first name: " + firstname[temp] + " with last name: "+ lastname[temp] + 
					" in grade: " + grades[temp] + " who is " + avalible[temp]);
		}
		
		if (e.getSource() == deleditcontact) {
			int temp = deleditcontact.getSelectedIndex();
			delfirstnameField.setText(firstname[temp]);
			dellastnameField.setText(lastname[temp]);
			delgradelevel.setSelectedIndex(temp);
			if (avalible[temp].equals("yes")) delyes.setSelected(true);
			else delno.setSelected(true);
		}
		
		if(e.getSource() == uploadButton) {
			JFileChooser fileChooser = new JFileChooser();
			int response = fileChooser.showOpenDialog(null); // select file to open
			if (response == JFileChooser.APPROVE_OPTION) {
				//System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
				ImageIcon imagepathway = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
				Image tempimage = imagepathway.getImage().getScaledInstance(335, 95, Image.SCALE_SMOOTH);
				ImageIcon resizedimage = new ImageIcon(tempimage);
				roomimagedisplay.setIcon(resizedimage);
				if(selecteditroomComboBox.getSelectedIndex() != 0) roomimages[selecteditroomComboBox.getSelectedIndex()] = imagepathway;
				else newest = imagepathway;
			}
			return;
		}
		
		if(e.getSource() == selecteditroomComboBox) {
			roomnameField.setText(roomname[selecteditroomComboBox.getSelectedIndex()]);
			roomnumberField.setText("" + roomnumber[selecteditroomComboBox.getSelectedIndex()]);
			Image tempimage = roomimages[selecteditroomComboBox.getSelectedIndex()].getImage().getScaledInstance(335, 95, Image.SCALE_SMOOTH);
			if (roomimages[selecteditroomComboBox.getSelectedIndex()] != newest) {
				ImageIcon resizedimage = new ImageIcon(tempimage);
				roomimagedisplay.setIcon(resizedimage);
			}
			roomdescriptionField.setText(roomdescriptions[selecteditroomComboBox.getSelectedIndex()]);
		}
		
		if(e.getSource() == updateButton) {
			roomname[selecteditroomComboBox.getSelectedIndex()] = roomnameField.getText();
			roomnumber[selecteditroomComboBox.getSelectedIndex()] = Integer.valueOf(roomnumberField.getText());
			roomdescriptions[selecteditroomComboBox.getSelectedIndex()] = roomdescriptionField.getText();
		}
		
		if(e.getSource() == addButton) {
			int temp = 0;
			int count = 0;
			while(roomnumber[temp] != 0) {
				temp++;
				count++;
				//System.out.println(roomnumber[temp]);
				System.out.println(count);
			}
			//System.out.println(count);
			roomname[count] = roomnameField.getText();
			roomnumber[count] = Integer.valueOf(roomnumberField.getText());
			roomdescriptions[count] = roomdescriptionField.getText();
			roomimages[count] = newest;
			selecteditroomComboBox.setModel(new DefaultComboBoxModel(roomname));
		}
	}
}
