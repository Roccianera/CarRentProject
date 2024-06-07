package control;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerUtenteRegistratoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testControllerUtenteRegistrato() {
		fail("Not yet implemented");
	}

	@Test
	public void testIniziaNoleggio() {
		fail("Not yet implemented");
	}

	@Test
	public void testSpecificServizioAssicurativo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSpecificaOptionalAuto() {
		fail("Not yet implemented");
	}

	@Test
	public void testAggiungiGuidatore() {
		
		
		
		
	}

	@Test
	public void testGetOptionalsAuto() {
		/*
		
		try {
			ControllerUtenteRegistrato controller =   NoleggiAutoController.Autenticazione("mariorossi@libero.it");
			
			ArrayList<Hashtable<String, String>> attrs=  controller.getOptionalsAuto();
			
			
			
			for (Hashtable<String, String> hash : attrs) {
				
				System.out.println(hash.get("id")+" "+ hash.get("text")+" " +hash.get("price"));
				
			}
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		*/
		
		
		
	}

	@Test
	public void testGetServiziAssicurativi() {
		/*
		try {
			ControllerUtenteRegistrato controller =   NoleggiAutoController.Autenticazione("mariorossi@libero.it");
			
			ArrayList<Hashtable<String, String>> attrs=  controller.getServiziAssicurativi();
			
			
			
			for (Hashtable<String, String> hash : attrs) {
				
				System.out.println(hash.get("id")+" "+ hash.get("text")+" " +hash.get("price"));
				
			}
	
					
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		*/
		
	}

	@Test
	public void testSpecificaAuto() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcolaPrezzoNoleggio() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfermaNoleggiaAuto() {
		
		
		
		try {
			ControllerUtenteRegistrato controller =   NoleggiAutoController.Autenticazione("mariorossi@libero.it");
			
			String dataR="2080-02-02";
			String dataC="2081-04-09";

			
			
			controller.IniziaNoleggio(dataR, dataC);
			
		//	controller.SpecificaAuto(2);
			
			//controller.SpecificServizioAssicurativo(4);
			
			controller.AggiungiGuidatore("hamzasdfd");
			
			System.out.println("aggiunto");
			
			//int[] array = new int[2];
			
		//	array[0]=1;
			//array[1]=2;
			
			
			
			//controller.SpecificaOptionalAuto(array);
			
			
			
			
			
			
			
			
			
			//System.out.println(controller.CalcolaPrezzoNoleggio());
			
		
			//controller.ConfermaNoleggiaAuto();
			
				
	
					
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
	
	}
	

}
