package boundary2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.NoleggiAutoController;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registrazione extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7149844192883115124L;
	private final JPanel contentPanel = new JPanel();
	private JTextField emailText;
	private JTextField AnnoScadenzaText;
	private JTextField nomeText;
	private JTextField cognomeText;
	private JTextField numeroPatenteText;
	private JTextField AnnoConsText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registrazione dialog = new Registrazione();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registrazione() {
		setBounds(100, 100, 599, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		emailText = new JTextField();
		emailText.setBounds(148, 41, 280, 20);
		contentPanel.add(emailText);
		emailText.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Email ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(22, 44, 46, 14);
		contentPanel.add(lblNewLabel);
		
		AnnoScadenzaText = new JTextField();
		AnnoScadenzaText.setBounds(148, 246, 97, 20);
		contentPanel.add(AnnoScadenzaText);
		AnnoScadenzaText.setColumns(10);
		
		nomeText = new JTextField();
		nomeText.setBounds(148, 95, 280, 20);
		contentPanel.add(nomeText);
		nomeText.setColumns(10);
		
		cognomeText = new JTextField();
		cognomeText.setBounds(148, 146, 280, 20);
		contentPanel.add(cognomeText);
		cognomeText.setColumns(10);
		
		numeroPatenteText = new JTextField();
		numeroPatenteText.setBounds(148, 192, 280, 20);
		contentPanel.add(numeroPatenteText);
		numeroPatenteText.setColumns(10);
		
		AnnoConsText = new JTextField();
		AnnoConsText.setBounds(325, 246, 103, 20);
		contentPanel.add(AnnoConsText);
		AnnoConsText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(22, 98, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cognome");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(22, 149, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero Patente");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(Color.DARK_GRAY);
		lblNewLabel_3.setBounds(22, 195, 97, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Anno Scadenza P.");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(22, 249, 87, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Anno Conseguimento P.");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(448, 249, 125, 14);
		contentPanel.add(lblNewLabel_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						
						String email = emailText.getText();
						
						String nome = nomeText.getText();
						String cognome = cognomeText.getText();
						
						String numeroPatente = numeroPatenteText.getText();
						
						int annoScadenza = Integer.parseInt(AnnoScadenzaText.getText());
						int annoCons = Integer.parseInt(AnnoConsText.getText());
						
						
						
						try {
							NoleggiAutoController.Registrazione(nome, cognome, email, annoCons, annoScadenza, numeroPatente);
							
							new Messaggio("GOOD", "Regitrazione a buon fine").setVisible(true);
							
						} catch (Exception ecc) {
							
							
							new Messaggio("ERROR", ecc.getMessage() ).setVisible(true);

							
							
							
						}
						
					
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
