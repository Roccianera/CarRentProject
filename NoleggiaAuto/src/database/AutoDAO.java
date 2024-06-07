package database;


import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class AutoDAO {
	
	//attributo
	private int idAuto;
	private String targa;
	private int numPostiPasseggeri;
	private float priceDay;
	private String tipoAlimentazione;
	private int potenzaMotore;
	private boolean inServizio;
	private int segmento;//0-A,1-B,2-C
	private ArrayList<NoleggioAutoDAO> noleggiAuto;
	

	//costruttore di defualt
	public AutoDAO() {
		super();
		this.noleggiAuto= new ArrayList<>();
	}
	
	//metodo che prende in ingresso la PK id e carica il record con quella chiave
	public AutoDAO(int id) {
		read(id);
		this.noleggiAuto= new ArrayList<>();
	}
	
	//metodo read()
	public boolean read(int id) {
		boolean presente=false;
		try {
			ResultSet res=DbConnectionManager.selectQuery("select * from auto where id= '"+id+"'");
			
			if(res.next()){//se c'è un record da leggere
				idAuto=res.getInt("Id");
				targa=res.getString("Targa");
				numPostiPasseggeri=res.getInt("NumPostiPasseggeri");
				priceDay=res.getFloat("PriceDay");
				tipoAlimentazione=res.getString("TipoAlimentazione");
				potenzaMotore=res.getInt("PotenzaMotore");
				inServizio=res.getBoolean("InServizio");
				segmento=res.getInt("Segmento");
				presente=true;//l'auto con quell'id è presente
			}
		}catch(SQLException | ClassNotFoundException e) {//catturo le eccezioni
			e.printStackTrace();//print dello stack delle eccezioni
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return presente;
	}
	
	//metodo create()
	public int create() {
			Connection conn=null;
			int ret=0;
			try {
				conn=DbConnectionManager.getConnection();//apro la connessione
				
				PreparedStatement statement=conn.prepareStatement
				("insert into auto(Id,Targa,NumPostiPasseggeri,PriceDay,TipoAlimentazione,"
				+ "PotenzaMotore,InServizio,Segmento)"+" values(?,?,?,?,?,?,?,?)");
				
				//accumulo i parametri da inserire mettendo a posto dei ? i parametri corrispondenti
				statement.setInt(1, idAuto);
				statement.setString(2, targa);
				statement.setInt(3,numPostiPasseggeri);
				statement.setFloat(4,priceDay);
				statement.setString(5, tipoAlimentazione);
				statement.setInt(6, potenzaMotore);
				statement.setBoolean(7,inServizio);
				statement.setInt(8,segmento);
				
				ret=statement.executeUpdate();//eseguo l'insert
				
			}catch(SQLException | ClassNotFoundException e) {
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
	
	
	public void  readNoleggiAuto(){
		
		try {
			
			ResultSet res=DbConnectionManager.selectQuery("select n.id from auto a join noleggiAuto n on"
			+ " n.Auto=a.id where a.id= '"+idAuto+"'");
			
			while(res.next()) {//finche c'è un record da prelevare
				noleggiAuto.add(new NoleggioAutoDAO(res.getInt("Id")));
			}
			
		}catch(SQLException | ClassNotFoundException e) {//catturo le eccezioni
			e.printStackTrace();//print dello stack delle eccezioni
		
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	
	}
	
	
	public ArrayList<NoleggioAutoDAO> getNoleggiAuto() {
		return noleggiAuto;
	}

	public void setNoleggiAuto(ArrayList<NoleggioAutoDAO> noleggiAuto) {
		this.noleggiAuto = noleggiAuto;
	}

	public void setNumPostiPasseggeri(int numPostiPasseggeri) {
		this.numPostiPasseggeri = numPostiPasseggeri;
	}

	//Getter e Setter
	public int getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public int getNumPostiPasseggeri() {
		return numPostiPasseggeri;
	}

	public void setNumPostPasseggeri(int numPostiPasseggeri) {
		this.numPostiPasseggeri = numPostiPasseggeri;
	}

	public float getPriceDay() {
		return priceDay;
	}

	public void setPriceDay(float priceDay) {
		this.priceDay = priceDay;
	}

	public String getTipoAlimentazione() {
		return tipoAlimentazione;
	}

	public void setTipoAlimentazione(String tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}

	public int getPotenzaMotore() {
		return potenzaMotore;
	}

	public void setPotenzaMotore(int potenzaMotore) {
		this.potenzaMotore = potenzaMotore;
	}

	public boolean isInServizio() {
		return inServizio;
	}

	public void setInServizio(boolean inServizio) {
		this.inServizio = inServizio;
	}

	public int getSegmento() {
		return segmento;
	}

	public void setSegmento(int segmento) {
		this.segmento = segmento;
	}

	@Override
	public String toString() {
		return + idAuto +" "+ targa + " " + numPostiPasseggeri
				+ " " + priceDay + " " + tipoAlimentazione + " "
				+ potenzaMotore + " " + inServizio + " " + segmento;
	}
	
	public int update() {
		Connection conn=null;
		int res=0;
		try {
			conn=DbConnectionManager.getConnection();
			
			PreparedStatement statement=conn.prepareStatement(
				"update auto set targa=?,numPostiPasseggeri=?,PriceDay=?,TipoAlimentazione=?,"
				+ "PotenzaMotore=?,inServizio=?,segmento=? where id= '"+idAuto+"'");
			
			//accumulo i parametri da modificare
			statement.setString(1,targa);
			statement.setInt(2,numPostiPasseggeri);
			statement.setFloat(3, priceDay);
			statement.setString(4,tipoAlimentazione);
			statement.setInt(5, potenzaMotore);
			statement.setBoolean(6, inServizio);
			statement.setInt(7, segmento);
			
			statement.executeUpdate(); //eseguo l'update
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			res=-1;

		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	
	
	
	public static int getUniqueID() {
		int i=1;
		try {
			
			ResultSet res=DbConnectionManager.selectQuery("select max(id) as max from auto");
			
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
