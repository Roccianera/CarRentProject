package boundary2;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.ControllerUtenteRegistrato;

public class ListaServiziAssicurativi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -541089028553692262L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaServiziAssicurativi frame = new ListaServiziAssicurativi();
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
	public ListaServiziAssicurativi() {
		setTitle("Servizi Assicurativi");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "name_258333477351300");
		
		table = new JTable();
		
		ArrayList<Hashtable<String, String >> tabellaHash = new ArrayList<>();
		
		

		
		tabellaHash = ControllerUtenteRegistrato.getIstance().getServiziAssicurativi();


	
		
		
		Object [][] tabella = new Object[tabellaHash.size()][3];
		
		
		
		int i=0;
		
		
		for (Hashtable<String, String> hashtable : tabellaHash) {
		
		
			
			tabella[i][0] =hashtable.get("id");
			tabella[i][1] =hashtable.get("text");
			tabella[i][2] =hashtable.get("price");

		
		
		
			i++;
		
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		table.setModel(new DefaultTableModel(
			
				tabella
				,
			new String[] {
				"id ", "Descrizione", "Prezzo"
			}
		));
		scrollPane.setViewportView(table);
	
	}

}
