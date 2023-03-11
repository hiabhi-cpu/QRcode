package emailLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.SwingConstants;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	
	JTextPane PassText = new JTextPane();
	JTextPane userText = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Librarian Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(115, 84, 160, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(37, 162, 101, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(37, 197, 101, 25);
		panel.add(lblNewLabel_2);
		
		userText = new JTextPane();
		userText.setBounds(115, 162, 168, 25);
		panel.add(userText);
		
		PassText = new JTextPane();
		PassText.setBounds(115, 197, 168, 25);
		panel.add(PassText);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setAction(action_1);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(155, 258, 101, 37);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New Here!");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(165, 319, 80, 25);
		panel.add(lblNewLabel_3);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setAction(action);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSignUp.setBounds(155, 354, 101, 37);
		panel.add(btnSignUp);
		
		JLabel lblNewLabel_4 = new JLabel("Gogte Institute of Technology");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(47, 37, 324, 37);
		panel.add(lblNewLabel_4);
	}
	
	private class SwingAction_1 extends AbstractAction {//Sign In Button
		public SwingAction_1() {
			putValue(NAME, "Sign In");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String user=userText.getText();
			String passw=PassText.getText();
			new GetData(user, passw);
			userText.setText("");
			PassText.setText("");
		}
	}
	private class SwingAction extends AbstractAction {//Sign Up Button
		public SwingAction() {
			putValue(NAME, "Sign Up");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Hello");
			SignUp signUp= new SignUp();
			userText.setText("");
			PassText.setText("");
		}
	}
}
