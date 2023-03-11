package emailLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import qrTrying.Write_Class_Try;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Action;

public class AddStudent extends JFrame {
	AddStudent temp;
	private JPanel contentPane;
	private JTextField nametextField;
	private JTextField USNtextField;
	private JTextField BratextField;
	private JTextField gamiltextField;
	private JTextField datetextField;
	private JTextField montextField;
	private JTextField yeartextField;
	Connection myConn;
	Statement mystmt;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddStudent() {
		try {
			myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_database","root","5004@Abhi");
			mystmt=myConn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(139, 55, 364, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(85, 130, 103, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("USN:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(85, 190, 103, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Branch:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(85, 247, 103, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("DOB:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_3.setBounds(85, 298, 103, 29);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gmail:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4.setBounds(85, 349, 103, 29);
		contentPane.add(lblNewLabel_1_4);
		
		nametextField = new JTextField();
		nametextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nametextField.setBounds(229, 130, 210, 29);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		USNtextField = new JTextField();
		USNtextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		USNtextField.setColumns(10);
		USNtextField.setBounds(229, 190, 210, 29);
		contentPane.add(USNtextField);
		
		BratextField = new JTextField();
		BratextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BratextField.setColumns(10);
		BratextField.setBounds(229, 247, 210, 29);
		contentPane.add(BratextField);
		
		gamiltextField = new JTextField();
		gamiltextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gamiltextField.setColumns(10);
		gamiltextField.setBounds(229, 349, 210, 29);
		contentPane.add(gamiltextField);
		
		datetextField = new JTextField();
		datetextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		datetextField.setBounds(229, 298, 38, 29);
		contentPane.add(datetextField);
		datetextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("/");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(277, 298, 38, 29);
		contentPane.add(lblNewLabel_2);
		
		montextField = new JTextField();
		montextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		montextField.setColumns(10);
		montextField.setBounds(320, 300, 38, 29);
		contentPane.add(montextField);
		
		JLabel lblNewLabel_2_1 = new JLabel("/");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2_1.setBounds(366, 298, 38, 29);
		contentPane.add(lblNewLabel_2_1);
		
		yeartextField = new JTextField();
		yeartextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		yeartextField.setColumns(10);
		yeartextField.setBounds(414, 298, 68, 29);
		contentPane.add(yeartextField);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setAction(action);
		btnNewButton.setBounds(246, 400, 177, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(246, 464, 177, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setAction(action_2);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(246, 520, 177, 43);
		contentPane.add(btnNewButton_1_1);
		this.setVisible(true);
		temp=this;
	}
	private class SwingAction extends AbstractAction {		//Save data
		public SwingAction() {
			putValue(NAME, "Save Data");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(addStdData()) {
				System.out.println("DONE");
			}
			
		}
	}
	private class SwingAction_1 extends AbstractAction {		//reset button
		public SwingAction_1() {
			putValue(NAME, "Reset");
			putValue(SHORT_DESCRIPTION, "Some short description");
			
		}
		public void actionPerformed(ActionEvent e) {
			nametextField.setText("");
			USNtextField.setText("");
			BratextField.setText("");
			gamiltextField.setText("");
			datetextField.setText("");
			montextField.setText("");
			yeartextField.setText("");
		}
	}
	
	private class SwingAction_2 extends AbstractAction {		//Back button
		public SwingAction_2() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			temp.setVisible(false);
		}
	}
	
	
	boolean addStdData() {
		System.out.println("hello");
		String name=nametextField.getText();
		String usn=USNtextField.getText();
		String branch=BratextField.getText();
		String date=datetextField.getText();
		String mon=montextField.getText();
		String year=yeartextField.getText();
		String mail=gamiltextField.getText();
		
		if(checkname(name)&&checkusn(usn)&&checkbra(branch)&&checkMail(mail)) {
			try {
				mystmt.execute("insert into students values('"+name+"','"+usn+"','"+branch+"','"+year+"-"+mon+"-"+date+"','"+mail+"');");
				System.out.println("No error occured");
				new Write_Class_Try(usn);
				new MsgText("Successfully Entered Details");
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error occured......");
				new MsgText("Incorrect Data Entered");
				return false;
			}
		}
		else {
			System.out.println("Incorrect Data Entered");
			new MsgText("Incorrect Data Entered");
			return false;
		}
		
	}
	
	boolean checkname(String name) {
		if(name.compareTo("")!=0) {
			System.out.println("Correct name");
			return true;
		}
		else {
			System.out.println("Incorrect name");
			return false;
		}
	}
	boolean checkusn(String usn) {
		Pattern pattern=Pattern.compile("2GI2[0-9][CS]|[ME]|[CV]|[AE]|[EC]|[EE]|[IS][0-9][0-9][0-9]");
		Matcher matcher=pattern.matcher(usn);
		boolean fou=matcher.find();
		if(fou) {
			System.out.println("Found the match");
			return true;
		}
		else {
			System.out.println("Match not found");
			return false;
		}
	}
	boolean checkbra(String branch) {
		Pattern pattern=Pattern.compile("[CSE]|[CIV]|[EEE]|[ECE]|[AERO]|[MECH]|[IS]");
		Matcher matcher=pattern.matcher(branch);
		boolean fou=matcher.find();
		if(fou) {
			System.out.println("Branch the match");
			return true;
		}
		else {
			System.out.println("Branch not found");
			return false;
		}
	}
	boolean checkMail(String mail) {
		Pattern pattern=Pattern.compile("[a-zA-Z0-9]+@gmail.com");
		Matcher matcher=pattern.matcher(mail);
		boolean fou=matcher.find();
		if(fou) {
			System.out.println("correct mail");
			return true;
		}
		else {
			System.out.println("Incorrect mail");
			return false;
		}
	}
	
}
