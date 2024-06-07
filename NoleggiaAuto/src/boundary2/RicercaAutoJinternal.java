package boundary2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class RicercaAutoJinternal extends JFrame {
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6352678293699606111L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RicercaAutoJinternal frame = new RicercaAutoJinternal(null);
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
	public RicercaAutoJinternal(ArrayList<Hashtable<String, String>> tabellaHash) {
		setBounds(100, 100, 450, 300);

		setBounds(100, 100, 563, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "name_59010833499600");
		
		
		
		
		
		

		 
		 
		 		Object [][] tabella= new Object[tabellaHash.size()][8]; 
		 
	
		 
		 			int i=0; 
		 	
		 
		 			for (Hashtable<String, String> hashtable : tabellaHash) {
		 				
		 				
		 				
		 					//DA RIFARE 
		 		
		 			

		 		
		 			
		 				
						
		 				tabella[i][0]=hashtable.get("idAuto");
		 				tabella[i][1]=hashtable.get("targa");
		 				tabella[i][2]=hashtable.get("segmento");
		 				tabella[i][3]=hashtable.get("tipoAlimentazione");
		 				tabella[i][4]=hashtable.get("potenzaMotore");
		 				tabella[i][5]=hashtable.get("prezzo");
		 				tabella[i][6]=hashtable.get("numeroPostiPassengeri");
		 				tabella[i][7]=hashtable.get("isInServizio");
		 				
		 				i++;
		 			
		 			
					
				}
				
		 		
		 		
		 		
			
		 
		 
		
		

		
		
		
		
		
		
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				tabella
		,
			new String[] {
				"idAuto", "Targa", "Segmento", "Tipo di Alimentazione", "Potenza del Motore", "Prezzo giornaliero ","Numero di Passengeri", "In Servizio"
			}
		));
		table.getColumnModel().getColumn(6).setMinWidth(18);

	}

}
