package boundary2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Messaggio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4792632394063101627L;
	private JPanel contentPane;
	private JTextField typeMessageText;
	private JTextField MessageText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messaggio frame = new Messaggio("Prova","IO");
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
	public Messaggio(String typeMessage, String message) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		typeMessageText = new JTextField();
		typeMessageText.setHorizontalAlignment(SwingConstants.CENTER);
		typeMessageText.setBounds(54, 5, 309, 20);
		typeMessageText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		typeMessageText.setEditable(false);
		contentPane.add(typeMessageText);
		typeMessageText.setColumns(10);
		
		
		typeMessageText.setText(typeMessage);
		
		
		
		
		
		MessageText = new JTextField();
		MessageText.setHorizontalAlignment(SwingConstants.CENTER);
		MessageText.setEditable(false);
		MessageText.setBounds(54, 57, 309, 156);
		contentPane.add(MessageText);
		MessageText.setColumns(10);
		
		MessageText.setText(message);
	
		
		
		
		
		
		
		
		
		
	}

}
