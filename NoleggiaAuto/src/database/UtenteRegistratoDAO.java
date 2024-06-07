package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class UtenteRegistratoDAO {
	
	//attributi
	private int idUtente;
	private String nome;
	private String cognome;
	private String email;
	private int annoConseguimentoPatente;
	private int annoScadenzaPatente;
	private String numeroPatente;
	private ArrayList<NoleggioAutoDAO> noleggiAuto;
	
	
	public ArrayList<NoleggioAutoDAO> getNoleggiAuto() {
		return noleggiAuto;
	}

	public void setNoleggiAuto(ArrayList<NoleggioAutoDAO> noleggiAuto) {
		this.noleggiAuto = noleggiAuto;
	}

	//costruttore di defualt
	public UtenteRegistratoDAO() {
		super();
		this.noleggiAuto= new ArrayList<>();
	}
	
	//costruttore
	public UtenteRegistratoDAO(int id) {
		read(id);
		this.noleggiAuto= new ArrayList<>();
	}
	
	public UtenteRegistratoDAO(String email) {
		read(email);
		this.noleggiAuto= new ArrayList<>();

	}

	//metodo che prende in ingresso la PK id e carica il record con quella chiave
	public boolean read(int id) {
		boolean presente=false;
		try {
			
			ResultSet res=DbConnectionManager.selectQuery("select * from utentiregistrati where Id= '"+id+"'");
			
			if(res.next()){//se c'è un record da leggere
				idUtente=res.getInt("Id");
				nome=res.getString("Nome");
				cognome=res.getString("Cognome");
				email=res.getString("Email");
				annoConseguimentoPatente=res.getInt("AnnoConseguimentoPatente");
				annoScadenzaPatente=res.getInt("AnnoScadenzaPatente");
				numeroPatente=res.getString("NumeroPatente");
				presente=true;//l'utente con quel id  è presente
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return presente;
	}
	
	
	public static boolean checkEmail(String email ) {
		
		boolean presente=false;
		try {
			
			ResultSet res=DbConnectionManager.selectQuery("select * from utentiregistrati where email= '"+email+"'");
			
			if(res.next()){
			
				presente=true;
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return presente;
		
	}
	
	
	
	
	
	
	
	

	
	public boolean read(String email) {
		boolean presente=false;
		try {
			
			ResultSet res=DbConnectionManager.selectQuery("select * from utentiregistrati where email= '"+email+"'");
			
			if(res.next()){//se c'è un record da leggere
				idUtente=res.getInt("Id");
				nome=res.getString("Nome");
				cognome=res.getString("Cognome");
				email=res.getString("Email");
				annoConseguimentoPatente=res.getInt("AnnoConseguimentoPatente");
				annoScadenzaPatente=res.getInt("AnnoScadenzaPatente");
				numeroPatente=res.getString("NumeroPatente");
				presente=true;//l'utente con quel id  è presente
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return presente;
	}
	
	
	
	
	public void  readNoleggiAuto(){
		
		try {
			
			ResultSet res=DbConnectionManager.selectQuery("select n.id from utentiRegistrati u "
			+ "join noleggiAuto n on"
			+ " n.UtenteRegistrato=u.id where u.id = '"+idUtente+"'");
			
			while(res.next()) {
				noleggiAuto.add(new NoleggioAutoDAO(res.getInt("Id")));
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int create() {
		Connection conn=null;
		int ret=0;
		try {
			conn=DbConnectionManager.getConnection();//apro la connessione
			
			//preparo la query che dovrò fare
			PreparedStatement statement=conn.prepareStatement
			("insert into utentiregistrati(Id,Nome,Cognome,Email,AnnoConseguimentoPatente,"
			+ "AnnoScadenzaPatente,NumeroPatente)"+" values(?,?,?,?,?,?,?)");
			
			//accumulo i parametri da inserire mettendo a posto dei ? i parametri corrispondenti
			statement.setInt(1, idUtente);
			statement.setString(2, nome);
			statement.setString(3,cognome);
			statement.setString(4,email);
			statement.setInt(5, annoConseguimentoPatente);
			statement.setInt(6, annoScadenzaPatente);
			statement.setString(7, numeroPatente);
			
			ret=statement.executeUpdate();//eseguo l'insert
			
		}catch(SQLException | ClassNotFoundException e) {//catturo le eccezioni
			e.printStackTrace();//print dello stack delle chiamate
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

	//Getter e Setter
	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAnnoConseguimentoPatente() {
		return annoConseguimentoPatente;
	}

	public void setAnnoConseguimentoPatente(int annoConseguimentoPatente) {
		this.annoConseguimentoPatente = annoConseguimentoPatente;
	}

	public int getAnnoScadenzaPatente() {
		return annoScadenzaPatente;
	}

	public void setAnnoScadenzaPatente(int annoScadenzaPatente) {
		this.annoScadenzaPatente = annoScadenzaPatente;
	}

	public String getNumeroPatente() {
		return numeroPatente;
	}

	public void setNumeroPatente(String numeroPatente) {
		this.numeroPatente = numeroPatente;
	}
	
	@Override
	public String toString() {
		return idUtente+" "+nome+" "+cognome+" "+email+" "+annoConseguimentoPatente+" "+annoScadenzaPatente
				+" "+numeroPatente;
	}

	public static int getUniqueID() {
		int i=1;
		
		try {
			
			ResultSet res=DbConnectionManager.selectQuery("select max(id) as max from utentiregistrati");
			
			if(res.next()) {//se c'è almeno un record
				i = res.getInt("max") + 1;
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return i;
	}


}
