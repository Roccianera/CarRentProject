package boundary2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.NoleggiAutoController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Hashtable;

public class RicercaAuto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2099902105948988377L;
	private JPanel contentPane;
	private JTextField dataRititoText;
	private JTextField dataConsegna;
	private JTextField segmentoText;
	private JFrame  internalFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RicercaAuto frame = new RicercaAuto();
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
	public RicercaAuto() {
		setResizable(false);
		
		setBounds(100, 100, 694, 108);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(5, 5, 846, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		dataRititoText = new JTextField();
		dataRititoText.setBounds(55, 30, 86, 20);
		panel.add(dataRititoText);
		dataRititoText.setColumns(10);
		
		dataConsegna = new JTextField();
		dataConsegna.setBounds(218, 30, 86, 20);
		panel.add(dataConsegna);
		dataConsegna.setColumns(10);
		
		segmentoText = new JTextField();
		segmentoText.setBounds(381, 30, 86, 20);
		panel.add(segmentoText);
		segmentoText.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
				ArrayList<Hashtable<String, String>> tabellaHash = new ArrayList<>() ;
				
				
				
				
				
				String dataR = dataRititoText.getText();
				String dataC  = dataConsegna.getText();
				int segmento = Integer.parseInt(segmentoText.getText());
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				 try {
					tabellaHash =  NoleggiAutoController.RicercaAuto(dataR,dataC,segmento);
					
					
					 for (Hashtable<String, String> hashtable : tabellaHash) {
						
						 System.out.println(hashtable);
					}
					 
			
					 
					
					
					
					
				} catch (Exception el) {
					
					
					
					 new Messaggio("ERRORE", el.getMessage()).setVisible(true);
					 
					
				}
				 
				 internalFrame = new RicercaAutoJinternal(tabellaHash);
				 internalFrame.setVisible(true);
				 
				 
				 
				 
				 
				
				
		
				
				
				
				
				
				
				
				
				
				
				
				
				
			
				
				
				
				
		
				
				
				
			
				
			}
		});
		btnNewButton.setBounds(545, 29, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Data Ritiro");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(62, 11, 80, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Consegna");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(218, 11, 86, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Segmento");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(381, 11, 64, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 68, 846, 506);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

	}
}
