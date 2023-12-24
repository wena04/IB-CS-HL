import java.util.HashMap;

public class IDandPasswords {

	HashMap <String,String> SLogin = new HashMap <String,String>();
	HashMap <String,String> TLogin = new HashMap <String,String>();
	
	IDandPasswords(){
		SLogin.put("s","s");
		TLogin.put("t","t");
	}
	
	protected HashMap getSLogin(){
		return SLogin;
	}
	
	protected HashMap getTLogin() {
		return TLogin;
	}
	
	protected void setSLogin(String a, String b) {
		SLogin.put(a,b);
	}
	
	protected void setTLogin(String a, String b) {
		TLogin.put(a, b);
	}
	
}
