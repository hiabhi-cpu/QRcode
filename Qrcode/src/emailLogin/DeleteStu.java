package emailLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Action;

public class DeleteStu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	DeleteStu temp;
	Connection myConn;
	Statement mystmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStu frame = new DeleteStu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteStu() {
		try {
			myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_database","root","5004@Abhi");
			mystmt=myConn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Student");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(136, 41, 266, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USN:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(108, 127, 56, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(174, 126, 185, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setAction(action);
		btnNewButton.setBounds(192, 198, 155, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(192, 265, 155, 31);
		contentPane.add(btnNewButton_1);
		this.setVisible(true);
		temp=this;
	}
	private class SwingAction extends AbstractAction {		//delete button
		public SwingAction() {
			putValue(NAME, "Delete Student");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			deleStud();
			System.out.println();
		}
	}
	private class SwingAction_1 extends AbstractAction {		//back button
		public SwingAction_1() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			temp.setVisible(false);
		}
	}
	void deleStud() {
		String usn=textField.getText();
		if(checkusn(usn)) {
			try {
				mystmt.execute("delete from students where rollno='"+usn+"';");
				new MsgText("Student Details deleted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				new MsgText("Incorrect data");
			}
		}
		else {
			new MsgText("Enter correct usn");
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
}
