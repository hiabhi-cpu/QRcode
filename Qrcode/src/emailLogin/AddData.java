package emailLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddData {
	public AddData(String name,String user,String passw) {
		// TODO Auto-generated constructor stub
		try {
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/maildatabase","root","5004@Abhi");
			Statement mystmt=myConn.createStatement();
			String inp="insert into mail values('"+name+"','"+user+"','"+passw+"');";
			mystmt.execute(inp);
			ResultSet myResultSet=mystmt.executeQuery("select * from mail");
			while(myResultSet.next()) {
				System.out.println(myResultSet.getString("uname"));
			}
			System.out.println("Hello");
		}
		catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			new MsgText("Wrong Entry");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/maildatabase","root","5004@Abhi");
			Statement mystmt=myConn.createStatement();
			ResultSet myResultSet=mystmt.executeQuery("select * from mail");
			while(myResultSet.next()) {
				System.out.println(myResultSet.getString("username"));
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

