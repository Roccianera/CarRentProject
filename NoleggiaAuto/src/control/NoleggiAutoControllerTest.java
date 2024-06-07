package control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.EntityAuto;

public class NoleggiAutoControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegistrazione() {
		/*
		
		try {
			NoleggiAutoController.Registrazione("Youssef","EnNakhly","youssef@gmail.it",2009,2030,"FDSDFASd");
			

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		*/
		
		
	}

	@Test
	public void testAutenticazione() {
		/*
		try {
			NoleggiAutoController.Autenticazione("hamza34@gmail.it");
			
			
			System.out.println("Autenticazione GOOD");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		*/
		
	}

	@Test
	public void testVisualizzaParcoAuto() {
		
		try {
			ArrayList<Hashtable<String, String>>  parco =  NoleggiAutoController.VisualizzaParcoAuto();
			

			for (Hashtable<String, String> hashtable : parco) {
				
				
				System.out.println("id auto disponibile "+ hashtable.get("idAuto")+" segmento " +hashtable.get("segmento")  );
			}
				
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	@Test
	public void testRicercaAuto() {
		
		try {
			System.out.println("MetodoRicercaAuto");
			ArrayList<Hashtable<String, String>>  parco =  NoleggiAutoController.RicercaAuto("2080-05-03","2081-02-09",1);
			
			
			

			for (Hashtable<String, String> hashtable : parco) {
				
				
				System.out.println("id auto disponibile "+ hashtable.get("idAuto")  );
				
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
					}
			
		
		
	}
		
		
		
	
	
	
	
	
	@Test
	public void testNoleggiaAuto() {
		fail("Not yet implemented");
	}
	
	
	

	@Test
	public void testModificaDatiAuto() {
		
	/*	
		
		int result;
		try {
			result = NoleggiAutoController.ModificaDatiAuto(5,"GentileEnrico", 5, 23, "culi", 5345345, EntityAuto.LARGE_SEGMENTO,false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(result==-1)
				System.out.println("FALLITO");
			
			e.printStackTrace();
		}
		
		System.out.println("GOOD");
		*/
	
	

	}

	@Test
	public void testAggiunggiDatiAuto() {
		/*
		int result =NoleggiAutoController.AggiunggiDatiAuto("Prova8", 5, 23, "peti", 200, EntityAuto.SMALL_SEGMENTO);
		
		System.out.println("Inserimento good");
	
		if(result==-1)
			System.out.println("FALLITO");
			*/	
	
	}

	@Test
	public void testSpecificServizioAssicurativo() {
		fail("Not yet implemented");
	}

}
