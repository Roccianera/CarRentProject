package boundary2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerUtenteRegistrato;
import control.NoleggiAutoController;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JLabel;

public class NoleggiaAutoDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1613845529076695869L;
	private final JPanel contentPanel = new JPanel();
	private JTextField dataRitornoText;
	private JTextField dataConsegnaText;
	private JTextField segmentoText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NoleggiaAutoDialog dialog = new NoleggiaAutoDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NoleggiaAutoDialog ( ) {
		setResizable(false);
		setBounds(100, 100, 552, 371);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		dataRitornoText = new JTextField();
		dataRitornoText.setBounds(75, 127, 86, 20);
		contentPanel.add(dataRitornoText);
		dataRitornoText.setColumns(10);
		
		dataConsegnaText = new JTextField();
		dataConsegnaText.setBounds(238, 127, 86, 20);
		contentPanel.add(dataConsegnaText);
		dataConsegnaText.setColumns(10);
		
		segmentoText = new JTextField();
		segmentoText.setBounds(380, 127, 86, 20);
		contentPanel.add(segmentoText);
		segmentoText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data Ritiro");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(75, 102, 86, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Consegna");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(238, 102, 86, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Segmento");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(380, 102, 86, 14);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						String dataR= dataRitornoText.getText();
						String dataC = dataConsegnaText.getText();
						int segmento = Integer.parseInt(segmentoText.getText());
						
						ArrayList<Hashtable<String, String>> tabellaHash = new ArrayList<>() ;

						
						
						
						 try {
							tabellaHash =  NoleggiAutoController.RicercaAuto(dataR,dataC,segmento);
							
							
							ControllerUtenteRegistrato.getIstance().IniziaNoleggio(dataR, dataC);
						
							  new   RicercaAutoJinternal(tabellaHash).setVisible(true);
							  
							  new SpecificaAuto().setVisible(true);
							 
							  setVisible(false);
							  
								
							
							
						} catch (Exception el) {
							
							
							
							 new Messaggio("ERRORE", el.getMessage()).setVisible(true);
							 
							
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
