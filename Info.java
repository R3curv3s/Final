import java.util.ArrayList;
public class Info {	
	private final String userName = "";
	private final String userEmail = "";
	private final String userFirstName = "";
	private final String userLastName = "";
	private final String userDept = "";
	private String freshUser = "";
	public final String getUserName() {
		return userName;
	}

	public final String getUserEmail() {
		return userEmail;
	}

	public final String getUserFirstName() {
		return userFirstName;
	}

	public final String getUserLastName() {
		return userLastName;
	}

	@Override
	public String toString() {
		return "Info [userName=" + userName + ", userEmail=" + userEmail + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userDept=" + userDept + ", freshUser=" + freshUser + "]";
	}
	public static ArrayList<String> Users = new ArrayList<String>();
	public static boolean updateOnce = true;
	public ArrayList<String> myUsers(){
	
			return Users;
	   }
	
	public void getNewUser(String a) {
		freshUser = a;
	
	}
	public void updateUsers(){
			Users.add("Person1 , Password1 , Email1 , Name1 , Lname1");
			Users.add("Person2 , Password2 , Email2 , Name3 , Lname3");
			Users.add("Person3 , Password3 , Email3 , Name2 , Lname2");
		
			Users.add("x,x, x, Raul , Mendes ");
			
			
	
	
}
}