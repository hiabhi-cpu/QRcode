package dataBaseconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertIntoDB {
	Connection myConn;
	Statement mystmt;
	ResultSet myResultSet;
	String flg;
	String rollno;
	public InsertIntoDB(String text)throws Exception {
		// TODO Auto-generated constructor stub
		rollno=text;
		myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_database","root","5004@Abhi");
		mystmt=myConn.createStatement();
		if(preInstd()) {
			if(ifExist()) {
				//out code
				System.out.println(text);
				flg="out";
				String usn="";
				String name="";
				String date="";
				String time_in="";
				myResultSet=mystmt.executeQuery("select * from in_students where rollno='"+rollno+"'");
				while(myResultSet.next()) {
					usn=myResultSet.getString("rollno");
					name=myResultSet.getString("std_name");
					date=myResultSet.getString("date_entry");
					time_in=myResultSet.getString("time_entry");
					System.out.println(usn+"  "+name+"  "+date+"  "+time_in);
				}
				addDataOUT(usn, name, date, time_in);
				mystmt.execute("DELETE FROM in_students WHERE rollno='"+text+"'");
				
			}
			else {
				//In code
				flg="in";
				String usn="";
				String name="";
				myResultSet=mystmt.executeQuery("select * from Students where rollno='"+rollno+"'");
				while(myResultSet.next()) {
					usn=myResultSet.getString("rollno");
					name=myResultSet.getString("std_name");
					System.out.println(usn+"  "+name);
				}
				if(usn.compareTo("")!=0) {
					addDataIN(usn, name);
				}
			}
		}
		else {
			flg="Doesn't Exist";
		}
		

	}
	
	public String getFlaString() {
		return flg;
	}
	
	boolean ifExist() throws Exception{
		myResultSet=mystmt.executeQuery("select * from in_students where rollno='"+rollno+"'");
		String reString="";
		while(myResultSet.next()) {
			reString=myResultSet.getString("rollno");
		}
		return(reString.compareTo("")!=0);
	}
	
	public boolean preInstd() throws Exception{
		myResultSet=mystmt.executeQuery("select * from students where rollno='"+rollno+"'");
		String reString="";
		while(myResultSet.next()) {
			reString=myResultSet.getString("rollno");
		}
		return(reString.compareTo("")!=0);
	}
	
	void addDataIN(String usn,String name)throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss"); 
	    Date date = new Date();  
	    System.out.println(formatter.format(date));
	    System.out.println(formatter1.format(date));
	    mystmt.execute("insert into in_students values('"+usn+"','"+name+"','"+formatter.format(date)+"','"+formatter1.format(date)+"')");
	}
	void addDataOUT(String usn,String name,String date_in,String time_in)throws Exception {
	    SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss"); 
	    Date date = new Date();
	    System.out.println(formatter1.format(date));
	    mystmt.execute("insert into out_students values('"+usn+"','"+name+"','"+date_in+"','"+time_in+"','"+formatter1.format(date)+"')");
	    System.out.println("Added in Out");
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		new InsertIntoDB("2GI20CS005");
	}

}
