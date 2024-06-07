package boundary2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerUtenteRegistrato;
import control.NoleggiAutoController;
import exceptions.EmailUtenteNonValida;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Autenticazione extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8778970913707254042L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Autenticazione dialog = new Autenticazione();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Autenticazione() {
		setResizable(false);
		setBounds(100, 100, 557, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Email");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(69, 128, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(167, 125, 288, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
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
						
						
						
						
						String email =textField.getText();
						
						
						try {
							 ControllerUtenteRegistrato controllerUtenteRegistrato=   NoleggiAutoController.Autenticazione(email);
							 
							 
							 
							
							new Messaggio("GOOD", "Autenticazione andata a buon fine ").setVisible(true);
							
							new BoundaryUtenteRegistrato().setVisible(true);
							
							
							setVisible(false);
							
							
							
							
						} catch (EmailUtenteNonValida el) {
							
							new Messaggio("ERRORE", el.toString()).setVisible(true);

							
						
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
