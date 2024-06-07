package boundary2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerUtenteRegistrato;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfermaNoleggio extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5347275786735207707L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfermaNoleggio dialog = new ConfermaNoleggio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfermaNoleggio( ) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(112, 90, 214, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
			textField.setText(Float.toString(ControllerUtenteRegistrato.getIstance().CalcolaPrezzoNoleggio()));
		}
		
		JLabel lblNewLabel = new JLabel("Prezzo Totale");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 93, 92, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Conferma");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						ControllerUtenteRegistrato.getIstance().ConfermaNoleggiaAuto();
						
						
						new Messaggio("GOOD", "Noleggio andato a buon fine");
						setVisible(false);
						
					}
				});
				okButton.setActionCommand("Ok");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						
						ControllerUtenteRegistrato.getIstance().CancellaNoleggiaAuto();
						
						
						new Messaggio("GOOD","Noleggio auto cancellata ");
						
						setVisible(false);
						
						
						
						
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
