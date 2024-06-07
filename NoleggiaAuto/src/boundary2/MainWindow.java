package boundary2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;

public class MainWindow {

	private JFrame frmFlyyou;
	private JTextField txtFlyyou;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmFlyyou.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFlyyou = new JFrame();
		frmFlyyou.setBackground(Color.DARK_GRAY);
		frmFlyyou.setForeground(Color.DARK_GRAY);
		frmFlyyou.setTitle("FLY4YOU");
		frmFlyyou.getContentPane().setBackground(Color.WHITE);
		frmFlyyou.setBounds(100, 100, 752, 502);
		frmFlyyou.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton operatoreBottone = new JButton("Operatore");
		operatoreBottone.setBackground(Color.WHITE);
		operatoreBottone.setForeground(Color.BLACK);
		operatoreBottone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				  new BoundaryOperatore().setVisible(true);
				  frmFlyyou.setVisible(false);
				
				
				
			}
		});
		frmFlyyou.getContentPane().setLayout(new BoxLayout(frmFlyyou.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frmFlyyou.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		txtFlyyou = new JTextField();
		txtFlyyou.setEditable(false);
		txtFlyyou.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtFlyyou.setHorizontalAlignment(SwingConstants.CENTER);
		txtFlyyou.setText("Auto Noleggio Senna");
		txtFlyyou.setForeground(Color.WHITE);
		txtFlyyou.setBackground(Color.DARK_GRAY);
		panel.add(txtFlyyou);
		txtFlyyou.setColumns(10);
		frmFlyyou.getContentPane().add(operatoreBottone);
		
		JButton btnNewButton_1 = new JButton("Utente");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				
				new BoundaryUtente().setVisible(true);
				
				frmFlyyou.setVisible(false);
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		frmFlyyou.getContentPane().add(btnNewButton_1);
	}
}
