package database;

import java.util.ArrayList;


import java.sql.ResultSet;
import java.sql.SQLException;


public class CatalogoDAO {
	private ArrayList<ServizioAssicurativoDAO> serviziAssicurativi;
	private ArrayList<OptionalAutoDAO> optionalAuto;

	public CatalogoDAO() {
		serviziAssicurativi=new ArrayList<ServizioAssicurativoDAO>();
		optionalAuto=new ArrayList<OptionalAutoDAO>();
	}
	
	
	
	public ArrayList<ServizioAssicurativoDAO> getListaServiziAssicurativi(){
		
		try {
			
			//prelevo i vari servizi assicurativi dal catalogo
			ResultSet res=DbConnectionManager.selectQuery("select id from serviziAssicurativi");
			
			while(res.next()) {//finche ci sono record
				serviziAssicurativi.add(new ServizioAssicurativoDAO(res.getInt("id")));
			}
		}catch(SQLException | ClassNotFoundException e) {//catturo le eccezioni
			e.printStackTrace();//print dello stack delle eccezioni
		
		}finally{//Chiusura Connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return serviziAssicurativi;
	}
	
	
	//metodo che restituisce la lista degli optional auto presenti nel catalogo
	public ArrayList<OptionalAutoDAO> getListaOptionalAuto(){
		
	try {
			
		//prelevo i vari servizi assicurativi dal catalogo
		ResultSet res=DbConnectionManager.selectQuery("select id from optionalauto");
			
			while(res.next()) {//finche ci sono record
				optionalAuto.add(new OptionalAutoDAO(res.getInt("id")));
			}
		}catch(SQLException | ClassNotFoundException e) {//catturo le eccezioni
			e.printStackTrace();//print dello stack delle eccezioni
		
		}finally{//Chiusura Connessione
			try{
				DbConnectionManager.closeConnection();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return optionalAuto;
	}
}
