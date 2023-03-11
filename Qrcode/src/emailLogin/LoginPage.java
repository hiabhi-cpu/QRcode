package emailLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import cameraRead.QRCodeReader;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	LoginPage log;
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	Thread thread;
	private final Action action_6 = new SwingAction_6();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage("Rhsdfuisdhuf");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage(String uname) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome "+uname);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(111, 30, 318, 52);
		panel.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(action_3);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(187, 284, 179, 35);
		panel.add(btnBack);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setAction(action_4);
		btnNewButton_1.setBounds(187, 107, 179, 35);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setAction(action_5);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(187, 169, 179, 35);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("New button");
		btnNewButton_1_1_1.setAction(action_6);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBounds(187, 227, 179, 35);
		panel.add(btnNewButton_1_1_1);
		this.setVisible(true);
		log=this;
	}
	private class SwingAction extends AbstractAction {		//change Name
		public SwingAction() {
			putValue(NAME, "Change Name");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Change Name");
		}
	}
	private class SwingAction_1 extends AbstractAction {	//change User name
		public SwingAction_1() {
			putValue(NAME, "Change Username");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Change UserName");
		}
	}
	private class SwingAction_2 extends AbstractAction {	//change password
		public SwingAction_2() {
			putValue(NAME, "Change Password");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Change Password");
		}
	}
	private class SwingAction_3 extends AbstractAction {	//Back button
		public SwingAction_3() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("User");
			log.setVisible(false);
		}
	}
	private class SwingAction_4 extends AbstractAction {	//add student
		public SwingAction_4() {
			putValue(NAME, "Add student");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Add student");
			new AddStudent();
		}
	}
	private class SwingAction_5 extends AbstractAction {	//start session
		public SwingAction_5() {
			putValue(NAME, "Start Session");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Start session");
			new QRCodeReader();
			
		}
	}
	
	private class SwingAction_6 extends AbstractAction {		//delete student
		public SwingAction_6() {
			putValue(NAME, "Delete Student");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Delete student");
			new DeleteStu();
		}
	}
}
