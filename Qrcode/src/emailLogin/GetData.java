package emailLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetData {
	
	public GetData(String user,String passw) {
		// TODO Auto-generated constructor stub
		try {
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/maildatabase","root","5004@Abhi");
			Statement mystmt=myConn.createStatement();
			ResultSet myResultSet=mystmt.executeQuery("select * from mail where username='"+user+"'");
			String resUser="";
			String resPass="";
			String name="";
			while(myResultSet.next()) {
				resUser=myResultSet.getString("username");
				resPass=myResultSet.getString("pass");
				name=myResultSet.getString("uname");
			}
			if(resUser.isBlank() || resPass.compareTo(passw)!=0) {
				System.out.println("User Not Found");
				new MsgText("Credintals are Wrong");
			}else {
				System.out.println("Welcome "+user);
				new LoginPage(name);
			}
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GetData("Rahul123","4982");
	}

}
