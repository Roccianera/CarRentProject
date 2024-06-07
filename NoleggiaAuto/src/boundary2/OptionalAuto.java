package boundary2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerUtenteRegistrato;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OptionalAuto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5513747409192877447L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OptionalAuto dialog = new OptionalAuto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OptionalAuto( ) {
		setBounds(100, 100, 538, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(94, 118, 323, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Optional auto (id1,id2,....)");
			lblNewLabel.setBounds(94, 99, 200, 14);
			contentPanel.add(lblNewLabel);
		}
		
		
		
		
		
		JFrame frame = new ListaOptionlAuto();
		
		frame.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						
						int[] idOptionalAuto = convertiStringaInVettore(textField.getText());
						
						
						ControllerUtenteRegistrato.getIstance().SpecificaOptionalAuto(idOptionalAuto);
						
									
						
						
						
						setVisible(false);
						frame.setVisible(false);
						
						
						
						 new AgguingiGuidatore().setVisible(true);
						
						
	
						
						
						
						
						
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
	
	
	public static int[] convertiStringaInVettore(String stringa) {
        String[] numeriStringa = stringa.split(",");
        int lunghezza = numeriStringa.length;
        int[] numeri = new int[lunghezza];
        for (int i = 0; i < lunghezza; i++) {
            numeri[i] = Integer.parseInt(numeriStringa[i]);
        }
        return numeri;
    }
	

}
