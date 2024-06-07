package boundary2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerUtenteRegistrato;
import exceptions.EmailUtenteNonValida;
import exceptions.FormatoEmailNonValido;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AgguingiGuidatore extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2504886253833337348L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			

			
			
			 	
			
			AgguingiGuidatore dialog = new AgguingiGuidatore();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgguingiGuidatore() {
		setResizable(false);
		setBounds(100, 100, 600, 324);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(172, 121, 271, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email guidatore extra");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(40, 124, 122, 14);
		contentPanel.add(lblNewLabel);
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
						
						
						
						String email = textField.getText();
						
						
					
						try {
							ControllerUtenteRegistrato.getIstance().AggiungiGuidatore(email);
							
							
							
							new Messaggio("GOOD", "Email aggiunta").setVisible(true);
							
							
							
							new ConfermaNoleggio().setVisible(true);
							
							
							
							
							
							setVisible(false);
							
						} catch (FormatoEmailNonValido | EmailUtenteNonValida ecc ) {
						
							new Messaggio("ERROR", ecc.getMessage()).setVisible(true);;
							
						}
						
						
						
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Non Aggiungere");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						new ConfermaNoleggio().setVisible(true);
						setVisible(false);
						
						
						
						
					}
				});
	
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
