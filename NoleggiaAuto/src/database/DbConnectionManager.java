package database;

//import di alcune funzionalità del package DB
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DbConnectionManager {//Manager che si occupa di aprire e chiudere una
	
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/dbnoleggioauto";
	private static String username="root";
	private static String password="PeerToPeer256@";
	
	private static Connection connection;
	
	//metodo per aprire una connessione verso il DB
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		
		connection=null;
		Class.forName(driver);//caricamento del driver
		
		connection=DriverManager.getConnection(url,username,password);
		
		return connection;
	}
	

	//metodo per chiudere una connessione aperta verso il DB
	public static void closeConnection() throws SQLException{
		if(connection!=null) {
			connection.close();
		}
	}


	//metodo per effettuare una query di tipo select
	public static ResultSet selectQuery(String query) throws SQLException,ClassNotFoundException{
			
			Connection conn= DbConnectionManager.getConnection();//apro la connessione
			
			Statement statement=conn.createStatement();//creo un statement
			
			ResultSet ret=statement.executeQuery(query);//restituisce un unico result set
	
			return ret;
	}
	
	//metodo per effettuare una query di tipo update (inserimento,modifica,cancellazione)
	public static int updateQuery(String query) throws SQLException,ClassNotFoundException{
			Connection conn=DbConnectionManager.getConnection();//apro la connessione
			
			Statement statement = conn.createStatement();//creo uno statement
			
			int ret=statement.executeUpdate(query);//restituisce il numero di record modificati

			return ret;
	}
}
