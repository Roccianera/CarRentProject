package entity;

import java.time.LocalDate;
import database.UtenteRegistratoDAO;
import exceptions.EmailUtenteNonValida;

public class EntityUtenteRegistrato {
	
	
	
	
	
	public int idUtenteRegistrato;
	
	public String nome ;
	public String cognome ;
	public String email;
	
	
	
	public int annoConseguimentoPatente;
	public int annoScadenzaPatente;
	public String numeroPatente;
	
	

	

	
	

	public EntityUtenteRegistrato () {
		
		super();
	
		
		//Costruttore per la creazione di utente da regsitrare
		
	
	}
	
	public EntityUtenteRegistrato (int id) {
		
		
		//Costruttore per la lettura di un utente registrato nel DB per id 
		
		UtenteRegistratoDAO utente = new UtenteRegistratoDAO(id);
		
		this.idUtenteRegistrato= utente.getIdUtente();
		this.email= utente.getEmail();
		this.annoConseguimentoPatente= utente.getAnnoConseguimentoPatente();
		this.annoScadenzaPatente= utente.getAnnoScadenzaPatente();
		this.numeroPatente = utente.getNumeroPatente();
		this.cognome = utente.getCognome();
		this.nome= utente.getNome();
		

		
		
		
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	public EntityUtenteRegistrato (String email) {
		
		
		UtenteRegistratoDAO utente = new UtenteRegistratoDAO(email);
		
		//Costruttore per la lettura di un utente registrato nel DB per id 
		
	
	
		
		this.idUtenteRegistrato= utente.getIdUtente();
		this.email= utente.getEmail();
		this.annoConseguimentoPatente= utente.getAnnoConseguimentoPatente();
		this.annoScadenzaPatente= utente.getAnnoScadenzaPatente();
		this.numeroPatente = utente.getNumeroPatente();
		this.cognome = utente.getCognome();
		this.nome= utente.getNome();

		
		
	}
	
		
	
	
	
	private EntityUtenteRegistrato(UtenteRegistratoDAO utente) {
		
		
		
		this.idUtenteRegistrato= utente.getIdUtente();
		this.email= utente.getEmail();
		this.annoConseguimentoPatente= utente.getAnnoConseguimentoPatente();
		this.annoScadenzaPatente= utente.getAnnoScadenzaPatente();
		this.numeroPatente = utente.getNumeroPatente();
		this.cognome = utente.getCognome();
		this.nome= utente.getNome();

		
		
	}





	public  void    Registrazione() throws Exception {
		//Funzione per il cariacamento dell utente registrato  nel DB
		
		
		
		if(UtenteRegistratoDAO.checkEmail(email)) {
			throw new Exception("Email gia esistente");
		}
		
		this.idUtenteRegistrato = UtenteRegistratoDAO.getUniqueID();
			
		UtenteRegistratoDAO  utente = new UtenteRegistratoDAO();
				
		utente.setAnnoConseguimentoPatente(this.annoConseguimentoPatente);
		utente.setEmail(this.email);
		utente.setAnnoScadenzaPatente(this.annoScadenzaPatente);
		utente.setCognome(this.cognome);
		utente.setIdUtente(this.idUtenteRegistrato);
		utente.setNome(this.nome);
		utente.setNumeroPatente(this.numeroPatente);
		
		utente.create();
										

	}
	
	
	public static EntityUtenteRegistrato  Autenteticazione(String emailUtente) throws EmailUtenteNonValida {
		
		//Funzione che ritorna un utente gia resgistato prensente nel DB 
		
		
		if(!UtenteRegistratoDAO.checkEmail(emailUtente))
			throw new EmailUtenteNonValida();
		EntityUtenteRegistrato utente = new EntityUtenteRegistrato(new UtenteRegistratoDAO(emailUtente));
				
		return utente ;					
		
		
		
		
	}
	

	
	

	
	
	



	public int getIdUtenteRegistrato() {
		return idUtenteRegistrato;
	}

	public void setIdUtenteRegistrato(int idUtenteRegistrato) {
		this.idUtenteRegistrato = idUtenteRegistrato;
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

	public void setNumeroPatente( String numeroPatente) {
		this.numeroPatente = numeroPatente;
	}



	public EntityNoleggioAuto IniziaNoleggio(LocalDate dataR, LocalDate dataC ) {
			/*
			 * Instanziamento di un oggetto di tipo Noleggia Auto 
			 */
		
			
		
			EntityNoleggioAuto noleggio = new EntityNoleggioAuto();
			
			noleggio.setDataConsengnaAuto(dataC);
			noleggio.setDataRitiroAuto(dataR);
			noleggio.setNoleggiatore(this);
		
		
		
		return noleggio;
	}
	
	
	public static EntityUtenteRegistrato  ControllaEsistenzaEmail(String email) throws EmailUtenteNonValida {
		//Metodo di Classe per il controllo e resistuzione in caso positivo di un email di un utente registrato nel DB
		
		if(!UtenteRegistratoDAO.checkEmail(email))
			throw new EmailUtenteNonValida();
		EntityUtenteRegistrato utente = new EntityUtenteRegistrato(new UtenteRegistratoDAO(email));
				
		return utente ;	
		
		
		
	}
	
	
	
	
	

	
	
	
	
	
	

}
