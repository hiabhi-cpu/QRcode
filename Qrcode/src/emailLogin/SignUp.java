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

public class SignUp extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	JTextPane nameText;
	JTextPane userText;
	JTextPane passText;
	
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up Here");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(142, 84, 133, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(49, 150, 101, 25);
		panel.add(lblNewLabel_1);
		
		nameText = new JTextPane();
		nameText.setBounds(127, 150, 168, 25);
		panel.add(nameText);
		
		JLabel lblNewLabel_2 = new JLabel("Userame:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(49, 185, 101, 25);
		panel.add(lblNewLabel_2);
		
		userText = new JTextPane();
		userText.setBounds(127, 185, 168, 25);
		panel.add(userText);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setAction(action);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(162, 264, 101, 37);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(49, 220, 101, 25);
		panel.add(lblNewLabel_2_1);
		
		passText = new JTextPane();
		passText.setBounds(127, 220, 168, 25);
		panel.add(passText);
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(action_1);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(162, 324, 101, 37);
		panel.add(btnBack);
		this.setVisible(true);
	}
	void close() {
		this.setVisible(false);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Sign Up");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(nameText.getText());
			System.out.println(userText.getText());
			System.out.println(passText.getText());
			new AddData(nameText.getText(), userText.getText(), passText.getText());
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			close();
		}
	}
}
