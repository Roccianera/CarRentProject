package database;


import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

public class ParcoAutoDAO {
	private ArrayList<AutoDAO> auto;
	
	public ParcoAutoDAO() {
		this.auto=new ArrayList<AutoDAO>();
	}

	
	public ArrayList<AutoDAO> getListaAuto(int segmento) {//metodo static

		try {
			
			//tale raccoglie quelli che sono gli id delle auto del parco Auto del segmento specificato
			ResultSet res=DbConnectionManager.selectQuery("select id as idAuto from auto where segmento="
			+ " '"+segmento+"'");
			
			while(res.next()) {//finche c'è un record da prelevare
				auto.add(new AutoDAO(res.getInt("idAuto")));/*il costruttore di AutoDAO che prende in ingresso
				la PK di fatto carica dal DB tutte le info relative a quella Auto*/
			}
			
		}catch(SQLException | ClassNotFoundException e) {//catturo le eccezioni
			e.printStackTrace();//print dello stack delle chiamate
		
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return auto;
	}
	
	
	public ArrayList<AutoDAO> getListaAuto() {

		try {
			
			//tale raccoglie quelli che sono gli id delle auto del parco Auto
			ResultSet res=DbConnectionManager.selectQuery("select id as idAuto from auto");
			
			while(res.next()) {//finche c'è un record da prelevare
				auto.add(new AutoDAO(res.getInt("idAuto")));/*il costruttore di AutoDAO che prende in ingresso
				la PK di fatto carica dal DB tutte le info relative a quella Auto*/
			}
			
		}catch(SQLException | ClassNotFoundException e) {//catturo le eccezioni
			e.printStackTrace();//print dello stack delle chiamate
		
		}finally{//Chiusura connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return auto;
	}
	
}
