package database;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class ServizioAssicurativoDAO {
	private int id;
	private String descrizione;
	private float prezzoPrefissato;
	
	//costruttore senza parametri
	public ServizioAssicurativoDAO() {
		super();
	}
	
	//costruttore che prende in ingresso la PK della tabella corrispondente
	public ServizioAssicurativoDAO(int id) {
		read(id);
	}
	
	
	//metodo create()
	public int create() {
		Connection conn=null;
		int ret=0;
		try {
			conn=DbConnectionManager.getConnection();//apro la connessione
			
			PreparedStatement statement=conn.prepareStatement
			("insert into ServiziAssicurativi(Id,Descrizione,PrezzoPrefissato)"+" values(?,?,?)");
			
			//accumulo i parametri da inserire mettendo a posto dei ? i parametri corrispondenti
			statement.setInt(1, id);
			statement.setString(2, descrizione);
			statement.setFloat(3,prezzoPrefissato);
			
			ret=statement.executeUpdate();//eseguo l'insert
			
		}catch(SQLException | ClassNotFoundException e) {//catturo le eccezioni
			e.printStackTrace();//mostro lo stack delle eccezioni
			ret=-1;
		
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	//metodo read()
	public boolean read(int id) {
		boolean presente=false;
		try {
			ResultSet res=DbConnectionManager.selectQuery
			("select * from ServiziAssicurativi where Id= '"+id+"'");
			
			if(res.next()){//se c'è  un record da leggere
				this.id=res.getInt("Id");
				
				this.descrizione=res.getString("Descrizione");
				this.prezzoPrefissato=res.getFloat("PrezzoPrefissato");
				presente=true;//il servizio assicurativo con quell'id è presente
			}
			
		}catch(SQLException | ClassNotFoundException e) {//Catturo le eccezioni
			e.printStackTrace();//mostro lo stack delle eccezioni
		
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return presente;
	}

	
	//Getter e Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public float getPrezzoPrefissato() {
		return prezzoPrefissato;
	}
	public void setPrezzoPrefissato(float prezzoPrefissato) {
		this.prezzoPrefissato = prezzoPrefissato;
	}

	@Override
	public String toString() {
		return id + " " + descrizione + " "+ prezzoPrefissato;
	}
}
