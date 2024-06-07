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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InsericiAuto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6224437569840169457L;
	private final JPanel contentPanel = new JPanel();
	private JTextField targaText;
	private JTextField numeroPassengeriText;
	private JTextField priceForDayText;
	private JTextField tipoAlimentazioneText;
	private JTextField potenzaMotoreText;
	private JTextField SegmentoText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsericiAuto dialog = new InsericiAuto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsericiAuto() {
		setResizable(false);
		setBounds(100, 100, 738, 493);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel TargaLabel = new JLabel("Targa");
			TargaLabel.setForeground(Color.WHITE);
			TargaLabel.setBounds(27, 58, 104, 14);
			contentPanel.add(TargaLabel);
		}
		{
			JLabel numeroPassengeriLabel = new JLabel("Numero di passengeri");
			numeroPassengeriLabel.setForeground(Color.WHITE);
			numeroPassengeriLabel.setBounds(27, 99, 104, 14);
			contentPanel.add(numeroPassengeriLabel);
		}
		
		targaText = new JTextField();
		targaText.setBounds(195, 55, 273, 20);
		contentPanel.add(targaText);
		targaText.setColumns(10);
		
		numeroPassengeriText = new JTextField();
		numeroPassengeriText.setBounds(195, 99, 273, 20);
		contentPanel.add(numeroPassengeriText);
		numeroPassengeriText.setColumns(10);
		
		priceForDayText = new JTextField();
		priceForDayText.setBounds(195, 146, 273, 20);
		contentPanel.add(priceForDayText);
		priceForDayText.setColumns(10);
		
		tipoAlimentazioneText = new JTextField();
		tipoAlimentazioneText.setBounds(195, 192, 273, 20);
		contentPanel.add(tipoAlimentazioneText);
		tipoAlimentazioneText.setColumns(10);
		
		potenzaMotoreText = new JTextField();
		potenzaMotoreText.setBounds(195, 237, 273, 20);
		contentPanel.add(potenzaMotoreText);
		potenzaMotoreText.setColumns(10);
		
		JLabel priceForDayLabel = new JLabel("Prezzo per Giorno ");
		priceForDayLabel.setForeground(Color.WHITE);
		priceForDayLabel.setBounds(27, 149, 104, 14);
		contentPanel.add(priceForDayLabel);
		
		JLabel tipoAlimentazioneLabel = new JLabel("tipo di alimentazione");
		tipoAlimentazioneLabel.setForeground(Color.WHITE);
		tipoAlimentazioneLabel.setBounds(27, 195, 104, 14);
		contentPanel.add(tipoAlimentazioneLabel);
		
		JLabel potenzaMotoreLabel = new JLabel("Potenza Motore");
		potenzaMotoreLabel.setForeground(Color.WHITE);
		potenzaMotoreLabel.setBounds(27, 240, 104, 14);
		contentPanel.add(potenzaMotoreLabel);
		
		JLabel SegmentoLabel = new JLabel("Segmento");
		SegmentoLabel.setForeground(Color.WHITE);
		SegmentoLabel.setBounds(28, 302, 88, 14);
		contentPanel.add(SegmentoLabel);
		
		SegmentoText = new JTextField();
		SegmentoText.setBounds(195, 299, 273, 20);
		contentPanel.add(SegmentoText);
		SegmentoText.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						
						String targa = targaText.getText();
						
						int passengeri = Integer.parseInt(numeroPassengeriText.getText());
						int potenzaMotore = Integer.parseInt(potenzaMotoreText.getText());
						String tipoDiAlimentazione= tipoAlimentazioneText.getText();
						float priceForDay= Float.parseFloat(priceForDayText.getText());
						int segmento = Integer.parseInt(SegmentoText.getText());
						
						
						
						int result;
						try {
							result = NoleggiAutoController.AggiunggiDatiAuto(targa, passengeri, priceForDay, tipoDiAlimentazione, potenzaMotore, segmento);
							
							if (result ==-1) {
								
								new Messaggio("ERRORE", "Fallimento INSERIMENTO").setVisible(true);;
							}else {
								
								
								
								
								new Messaggio("GOOD", "GOOD INSERT").setVisible(true);
								
								
							}
							
						} catch (Exception e1) {
							
								new Messaggio("ERROR", e1.toString()).setVisible(true);;
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
						
						//TODO cancella tutti i textField
					
						
						
						
						
						
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
