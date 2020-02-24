import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * Test the methods created in the DonationManager class
 * 
 * @author Hamza Mir
 * @author khandan Monshi, revised by Professor Kartchner
 */
public class DonationManagerTest {
	
	DonationManager manager;
	
	// My student test
	DonationManager managerSTUDENT;

	@Before
	public void setUp() throws Exception { 
		manager = new DonationManager();
		managerSTUDENT = new DonationManager();
	}
 
	@After
	public void tearDown() throws Exception {		 
		manager = null;
		managerSTUDENT = null;
	}
 
	@Test
	public void testManagerLoadcontainer()   {
	
		try {
			manager.ManagerLoadcontainer(new DonationPackage("Pens",12));
			manager.ManagerLoadcontainer(new DonationPackage("Books",12));
			manager.ManagerLoadcontainer(new DonationPackage("NoteBooks",11));
			manager.ManagerLoadcontainer(new DonationPackage("chairs",20));
			manager.ManagerLoadcontainer(new DonationPackage("laptop",14));
			 
		} catch (ContainerException e) {
			fail("Should not throw exception ");
		}	 	 
	}
	
	@Test
	public void testManagerLoadcontainerSTUDENT()   {
	
		try {
			managerSTUDENT.ManagerLoadcontainer(new DonationPackage("Package 1",12));
			managerSTUDENT.ManagerLoadcontainer(new DonationPackage("Package 2",15));
			managerSTUDENT.ManagerLoadcontainer(new DonationPackage("Package 3",11));
			managerSTUDENT.ManagerLoadcontainer(new DonationPackage("Package 4",16));
			managerSTUDENT.ManagerLoadcontainer(new DonationPackage("Package 5",15));
			managerSTUDENT.ManagerLoadcontainer(new DonationPackage("Package 5",15));
			 
		} catch (ContainerException e) {
			System.out.println(e);
		}	 	 
	}
	 
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.ManagerQueueVolunteer(new  Volunteer("Dickson"));
			manager.ManagerQueueVolunteer(new  Volunteer("Bruno"));
			manager.ManagerQueueVolunteer(new  Volunteer("Jeremiah"));
			manager.ManagerQueueVolunteer(new  Volunteer("Rodney"));
			manager.ManagerQueueVolunteer(new  Volunteer("Rose"));
			manager.ManagerQueueVolunteer(new  Volunteer("Clinton"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e);
		}	 
	}
	
	@Test
	public void testManagerQueueVolunteerSTUDENT() {
		try {
			managerSTUDENT.ManagerQueueVolunteer(new  Volunteer("Hamza"));
			managerSTUDENT.ManagerQueueVolunteer(new  Volunteer("Matt"));
			managerSTUDENT.ManagerQueueVolunteer(new  Volunteer("Chin"));
			managerSTUDENT.ManagerQueueVolunteer(new  Volunteer("Hannah"));
			managerSTUDENT.ManagerQueueVolunteer(new  Volunteer("Sam"));
			
		} catch (VolunteerException e) {
			 
			fail("Should not throw exception ");
		}	 
	}
	
	/**
	 * Test method for  ManagerQueueRecipient, should be implemented by students 
	 */
	@Test
	public void testManagerQueueRecipientSTUDENT() {
		
		try{
			manager.ManagerQueueRecipient(new  Recipient("MC"));
			manager.ManagerQueueRecipient(new  Recipient("CCBC"));
			manager.ManagerQueueRecipient(new  Recipient("UMCP"));
			manager.ManagerQueueRecipient(new  Recipient("UMBC"));
			manager.ManagerQueueRecipient(new  Recipient("UMD"));
			manager.ManagerQueueRecipient(new  Recipient("Brock"));
			
		} catch (RecipientException e) {
			 
			System.out.println(e);
			
		}
		 
	}

	/**
	 * Test method for donatePackage
	 */
	@Test
	public void testDonatePackage() {
	    Volunteer v1,v2;
	    Recipient r1,r2;
	    DonationPackage d1,d2;
	    
	    v1 = new Volunteer("Manny"); 
		r1 =  new Recipient("MC College");
		
		d1 =  new DonationPackage("Pens",10);
		d2 =  new DonationPackage("Books",20);
		
		try {
			manager.ManagerLoadcontainer(d1);
			manager.ManagerLoadcontainer(d2);
			assertEquals(manager.donatePackage(),1 ); 
			
			manager.ManagerQueueVolunteer(v1);
			assertEquals(manager.donatePackage(),2 );
			
			manager.ManagerQueueRecipient(r1);
			assertEquals(manager.donatePackage(),0); 
			
			//need to put volunteer back in the queue
			assertEquals(manager.donatePackage(),2); 
			
		} catch (ContainerException | VolunteerException | RecipientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		@Test
		public void testDonatePackageSTUDENT() {
		    Volunteer v1,v2;
		    Recipient r1,r2;
		    DonationPackage d1,d2;
		    
		    v1 = new Volunteer("Hamza"); 
			r1 =  new Recipient("CCBC");
			
			d1 =  new DonationPackage("Rulers",10);
			d2 =  new DonationPackage("Staplers",20);
			
			try {
				managerSTUDENT.ManagerLoadcontainer(d1);
				managerSTUDENT.ManagerLoadcontainer(d2);
				assertEquals(managerSTUDENT.donatePackage(),1 ); // will return 1, because no volunteers have been added yet
				
				managerSTUDENT.ManagerQueueVolunteer(v1);
				assertEquals(managerSTUDENT.donatePackage(),2 ); // will return 2, because no recipients were added yet
				
				managerSTUDENT.ManagerQueueRecipient(r1);
				assertEquals(managerSTUDENT.donatePackage(),0); // Will donate successfully, because there is at least one package, volunteer, and recipient
				
				//need to put volunteer back in the queue
				assertEquals(managerSTUDENT.donatePackage(),2); // will return 2, because donation successfully occurred once previously, deleting the recipient. Now there is none left. 
				
			} catch (ContainerException | VolunteerException | RecipientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	}

}