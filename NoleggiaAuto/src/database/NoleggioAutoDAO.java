package database;

import java.util.ArrayList;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class NoleggioAutoDAO {
	private int idNoleggio;
	private String dataRitiro;
	private String dataConsegna;
	private float prezzo;
	private int idAuto;
	private int idUtente;
	private int idServizioAssicurativo;
	private int idGuidatoreSupplementare;
	private ArrayList<OptionalAutoDAO> optionalAuto;
	
	
	public NoleggioAutoDAO() {
		this.optionalAuto=new ArrayList<OptionalAutoDAO>();
	}
	
	
	public NoleggioAutoDAO(int id) {
		//istanzio i vari oggetti
		read(id);
		this.optionalAuto= new ArrayList<>();
	}
	
	//metodo read()
	public boolean read(int id) {
		boolean presente=false;
		try {
			
			//prelevo il noleggio
			ResultSet res=DbConnectionManager.selectQuery(
			"select * from noleggiAuto where id= '"+id+"'");
	
			if(res.next()) {//se c'e un record da prelevare
				idNoleggio=res.getInt("Id");
				dataRitiro=res.getString("DataRitiroAuto");
				dataConsegna=res.getString("DataConsegnaAuto");
				prezzo=res.getFloat("PrezzoNoleggio");
				idAuto=res.getInt("Auto");
				idUtente=res.getInt("UtenteRegistrato");
				idGuidatoreSupplementare=res.getInt("GuidatoreSupplementare");
				idServizioAssicurativo=res.getInt("ServizioAssicurativo");
				presente=true;//il noleggio con quell'id è presente
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
	
	public String getEmailGuidatoreSupplementare() {
		String email=null;
		try {
			
			/*query che mi va a prendere l'email del guidatore supplementare associato al noleggio
			corrente*/
			ResultSet res=DbConnectionManager.selectQuery
			("SELECT U.Email FROM UTENTIREGISTRATI U JOIN NOLEGGIAUTO N ON"
			+ " U.Id=N.GuidatoreSupplementare"
			+ " WHERE N.Id= '"+idNoleggio+"'");
			
			if(res.next()) {//se c'è un record (che sarà una stringa in questo caso
				email=res.getString(1);
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
		return email;
	}
	
	//metodo create() che crea un record noleggio nella tabella NoleggiAuto
	public int create() {
		int ret=0;
		String query;
		
		if(idGuidatoreSupplementare == 0) {//se non è specificato il guidatore
			
			if(idServizioAssicurativo==0)//e neanche il servizio

				query="insert into NoleggiAuto(Id,DataRitiroAuto,DataConsegnaAuto,PrezzoNoleggio,Auto,"
					+ "UtenteRegistrato,GuidatoreSupplementare,ServizioAssicurativo)"
					+" values("+idNoleggio+","+"'"+dataRitiro+"',"+"'"+dataConsegna+"',"+prezzo+","+idAuto+
					","+idUtente+","+"null"+","+"null"+")";//null a entrambi i campi
			else//altrimenti
				 query="insert into NoleggiAuto(Id,DataRitiroAuto,DataConsegnaAuto,PrezzoNoleggio,Auto,"
						+ "UtenteRegistrato,GuidatoreSupplementare,ServizioAssicurativo)"
						+" values("+idNoleggio+","+"'"+dataRitiro+"',"+"'"+dataConsegna+"',"+prezzo+","+idAuto+
						","+idUtente+","+"null"+","+idServizioAssicurativo+")";//null solo al primo
		}else {//altrimenti se è specificato il guidatore
			
			if(idServizioAssicurativo==0)//e non è specificato il servizio assicurativo
				query="insert into NoleggiAuto(Id,DataRitiroAuto,DataConsegnaAuto,PrezzoNoleggio,Auto,"
						+ "UtenteRegistrato,GuidatoreSupplementare,ServizioAssicurativo)"
						+" values("+idNoleggio+","+"'"+dataRitiro+"',"+"'"+dataConsegna+"',"+prezzo+","+idAuto+
						","+idUtente+","+idGuidatoreSupplementare+","+"null"+")";//null al secondo campo
			else//altrimenti
				query="insert into NoleggiAuto(Id,DataRitiroAuto,DataConsegnaAuto,PrezzoNoleggio,Auto,"
						+ "UtenteRegistrato,GuidatoreSupplementare,ServizioAssicurativo)"
						+" values("+idNoleggio+","+"'"+dataRitiro+"',"+"'"+dataConsegna+"',"+prezzo+","+idAuto+
						","+idUtente+","+idGuidatoreSupplementare+","+idServizioAssicurativo+")";
		}
		
		try {
			ret=DbConnectionManager.updateQuery(query);//eseguo l'insert
				
		}catch(SQLException |  ClassNotFoundException e) {
			e.printStackTrace();
			ret=-1;
		
		}finally{//chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	/*metodo che consente di associare un optional auto al noleggio sfruttando gli id di entrambi*/
	public int associaOptionalAutoNoleggio(int idOptionalAuto) {
		int ret=0;
		Connection conn=null;
		try {
				conn=DbConnectionManager.getConnection();//apro la connessione
				
				PreparedStatement statement=conn.prepareStatement
				("insert into OptionalAuto_has_NoleggiAuto(OptionalAuto,NoleggioAuto) values(?,?)");
				
				//accumulo i parametri da inserire mettendo a posto dei ? i parametri corrispondenti
				statement.setInt(1, idOptionalAuto);
				statement.setInt(2, idNoleggio);

				ret=statement.executeUpdate();//eseguo l'insert
			
		}catch(SQLException |  ClassNotFoundException e) {
			e.printStackTrace();
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
	
	
	public ArrayList<OptionalAutoDAO> getOptionalAuto() {
		return optionalAuto;
	}


	public void setOptionalAuto(ArrayList<OptionalAutoDAO> optionalAuto) {
		this.optionalAuto = optionalAuto;
	}


	//restituisce la lista dei DAO degli optionalAuto specificati per il noleggi
	public ArrayList<OptionalAutoDAO>  getListaOptionalAuto(){
		try {
			/*tale query determinar gli id degli optionalAuto associati al noleggio attuale*/
			ResultSet res=DbConnectionManager.selectQuery("SELECT O.Id"
			+ " FROM OPTIONALAUTO_HAS_NOLEGGIAUTO NO JOIN OPTIONALAUTO O ON NO.OptionalAuto=O.Id"
			+ " WHERE NO.NoleggioAuto = '"+idNoleggio+"'");
			
			while(res.next()) {//finche vi è almeno un record
				optionalAuto.add(new OptionalAutoDAO(res.getInt(1)));/*aggiungo
				il DAO dell'optionalAuto corrispondente nella lista con il metodo add()*/
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

		return optionalAuto;
	}

	//Getter e Setter
	public int getIdNoleggio() {
		return idNoleggio;
	}

	public void setIdNoleggio(int idNoleggio) {
		this.idNoleggio = idNoleggio;
	}

	public String getDataRitiro() {
		return dataRitiro;
	}

	public void setDataRitiro(String dataRitiro) {
		this.dataRitiro = dataRitiro;
	}

	public String getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(String dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdServizioAssicurativo() {
		return idServizioAssicurativo;
	}

	public void setIdServizioAssicurativo(int idServizioAssicurativo) {
		this.idServizioAssicurativo = idServizioAssicurativo;
	}

	public int getIdGuidatoreSupplementare() {
		return idGuidatoreSupplementare;
	}

	public void setIdGuidatoreSupplementare(int idGuidatoreSupplementare) {
		this.idGuidatoreSupplementare = idGuidatoreSupplementare;
	}

	@Override
	public String toString() {
		return  idNoleggio + " " + dataRitiro + " "
				+ dataConsegna + " " + prezzo + " " + idAuto + " " + idUtente
				+ " " + idServizioAssicurativo + " "
				+ idGuidatoreSupplementare;
	}

	
	
	
	public static int getUniqueID() {
		int i=1;
		try {
			
			ResultSet res=DbConnectionManager.selectQuery("select max(id) as max from noleggiauto");
			
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

	
	public int getNumeroGiorniNoleggio() {
		int i =0;
		try {
			ResultSet res=DbConnectionManager.selectQuery(
			"select datediff(DataConsegnaAuto,DataRitiroAuto)"
					+" from noleggiauto where id= '"+idNoleggio+"'");
			
			if(res.next()) {//se c'è almeno un record
				i=res.getInt(1);
			}
		}catch(SQLException | ClassNotFoundException e ){
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
