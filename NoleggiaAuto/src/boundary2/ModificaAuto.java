package boundary2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.NoleggiAutoController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ModificaAuto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2959301699426793401L;
	private final JPanel contentPanel = new JPanel();
	private JTextField idAutoText;
	private JTextField targaText;
	private JTextField numPassengeriText;
	private JTextField alimentazioneText;
	private JTextField segmentoText;
	private JTextField prezzoText;
	private JTextField potenzaText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificaAuto dialog = new ModificaAuto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificaAuto() {
		setResizable(false);
		setBounds(100, 100, 870, 493);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("idAuto");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(46, 62, 102, 14);
			contentPanel.add(lblNewLabel);
		}
		
		idAutoText = new JTextField();
		idAutoText.setBounds(178, 59, 86, 20);
		contentPanel.add(idAutoText);
		idAutoText.setColumns(10);
		
		targaText = new JTextField();
		targaText.setBounds(527, 59, 86, 20);
		contentPanel.add(targaText);
		targaText.setColumns(10);
		
		JLabel targa = new JLabel("targa");
		targa.setForeground(Color.WHITE);
		targa.setBounds(378, 62, 94, 14);
		contentPanel.add(targa);
		
		numPassengeriText = new JTextField();
		numPassengeriText.setBounds(178, 122, 86, 20);
		numPassengeriText.setText("4");
		contentPanel.add(numPassengeriText);
		numPassengeriText.setColumns(10);
		
		alimentazioneText = new JTextField();
		alimentazioneText.setBounds(178, 176, 86, 20);
		contentPanel.add(alimentazioneText);
		alimentazioneText.setColumns(10);
		
		segmentoText = new JTextField();
		segmentoText.setBounds(178, 231, 86, 20);
		segmentoText.setText("1");
		contentPanel.add(segmentoText);
		segmentoText.setColumns(10);
		
		prezzoText = new JTextField();
		prezzoText.setBounds(527, 122, 86, 20);
		prezzoText.setText("30");
		contentPanel.add(prezzoText);
		prezzoText.setColumns(10);
		
		potenzaText = new JTextField();
		potenzaText.setBounds(527, 176, 86, 20);
		potenzaText.setText("100");
		contentPanel.add(potenzaText);
		potenzaText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("numero Passengeri");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(46, 125, 122, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("tipo di alimentazione");
		lblNewLabel_3.setBounds(46, 179, 122, 14);
		lblNewLabel_3.setForeground(Color.WHITE);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Segmento");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(46, 234, 102, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Prezzo per giorno");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(378, 125, 102, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("potenza Motore");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(377, 179, 115, 14);
		contentPanel.add(lblNewLabel_6);
		
		JRadioButton inServizioButton = new JRadioButton("In Servizio");
		inServizioButton.setForeground(Color.WHITE);
		inServizioButton.setBounds(527, 234, 109, 23);
		inServizioButton.setBackground(Color.DARK_GRAY);
		inServizioButton.setSelected(true);
		contentPanel.add(inServizioButton);
		{
			JPanel buttonPane = new JPanel();

			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						
						int idAuto =  Integer.parseInt( idAutoText.getText()); 
						
						String targa= targaText.getText();
						int numPassengeri = Integer.parseInt(numPassengeriText.getText());
						float PriceForDay = Float.parseFloat(prezzoText.getText());
						String alimentazione = alimentazioneText.getText();
						int potenzaMotore = Integer.parseInt(potenzaText.getText());
						boolean inServizio = inServizioButton.isSelected();
						int segmento = Integer.parseInt(segmentoText.getText());

						
						
						int result=0;
						try {
							result =NoleggiAutoController.ModificaDatiAuto( idAuto , targa ,numPassengeri , PriceForDay ,alimentazione , potenzaMotore,segmento ,inServizio  );
							if (result ==-1) {
								
								new Messaggio("ERRORE", "Fallimento INSERIMENTO").setVisible(true);
							}else {
								
								new Messaggio("GOOD", "GOOD INSERIMENTO").setVisible(true);
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
								new Messaggio("ERRORE", e1.toString()).setVisible(true);;
						}
						
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						
						 idAutoText.setText("");
						 targaText.setText("");
						 numPassengeriText.setText("4");
						 alimentazioneText.setText("benzina");
						 segmentoText.setText("1");
						 prezzoText.setText("30");
						 potenzaText.setText("100");
						
						
						
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		

		
	}
}
