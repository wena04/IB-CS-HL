import javax.swing.ImageIcon;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		IDandPasswords idandPasswords = new IDandPasswords();
		String[] contacts = new String[20];
		String[] firstname = new String[20];
		String[] lastname = new String[20];
		String[] grades = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		String[] avalible = new String[20];
		int[] numbers = new int[20];
		String[] roomnames = new String[20];
		int[] roomnumber = new int[20];
		ImageIcon[] images = new ImageIcon[20];
		String[] descriptions = new String[20];
		
		firstname[0]= "Bob";
		firstname[1]="Alex";
		firstname[2]="Catherine";
		firstname[3] = "Zach";
		firstname[4] = "Wendy";
		
		lastname[0] = "Zero";
		lastname[1] = "C";
		lastname[2] = "X";
		lastname[3] = "Y";
		lastname[4] = "A";
		
		contacts[0] = firstname[0]+ " " + lastname[0];
		contacts[1] = firstname[1]+ " " + lastname[1];
		contacts[2] = firstname[2]+ " " + lastname[2];
		contacts[3] = firstname[3]+ " " + lastname[3];
		contacts[4] = firstname[4]+ " " + lastname[4];
		
		avalible[0] = "yes";
		avalible[1] = "no";
		avalible[2] = "yes";
		avalible[3] = "yes";
		avalible[4] = "no";
		
		numbers[0]=1;
		numbers[1]=2;
		numbers[2]=3;
		numbers[3]=4;
		numbers[4]=5;
		
		for(int i = 3;i<17;i++)numbers[i]=0;
		
		roomnames[0] = "Select";
		roomnames[1] = "Room 1";
		roomnames[2] = "Room 3";
		roomnames[3] = "Room 3";
		roomnames[4] = "Room 2";
		roomnames[5] = "Room 4";
		roomnames[6] = "Room 6";
		
		
		roomnumber[0] = 1000;
		roomnumber[1] = 101;
		roomnumber[2] = 202;
		roomnumber[3] = 400;
		roomnumber[4] = 103;
		roomnumber[5] = 301;
		roomnumber[6] = 400;
		for(int i = 7;i<13;i++)roomnumber[i]=0;
		
		descriptions[0] = "NULL";
		descriptions[1] = "This is room 1";
		descriptions[2] = "This is room 3";
		descriptions[3] = "This is room 3";
		descriptions[4] = "This is room 2";
		descriptions[5] = "This is room 4";
		descriptions[6] = "This is room 6";
		
		
		File room0 = new File("Room 0.png");
		images[0] = new ImageIcon(room0.getAbsolutePath());
		File room1 = new File("Room 1.png");
		images[1] = new ImageIcon(room1.getAbsolutePath());
		File room2 = new File("Room 2.png");
		images[2] = new ImageIcon(room2.getAbsolutePath());
		File room3 = new File("Room 3.png");
		images[3] = new ImageIcon(room3.getAbsolutePath());
		File room4 = new File("Room 4.png");
		images[4] = new ImageIcon(room4.getAbsolutePath());
		File room5 = new File("Room 5.png");
		images[5] = new ImageIcon(room5.getAbsolutePath());
		File room6 = new File("Room 6.png");
		images[6] = new ImageIcon(room6.getAbsolutePath());
		
		LoginPage Login = new LoginPage(idandPasswords.getSLogin(),idandPasswords.getTLogin(),contacts,firstname,lastname,grades,avalible,numbers,roomnames,roomnumber,images,descriptions);
	}
}
