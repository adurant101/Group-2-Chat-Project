//Final Project

package ServerTest;
import static org.junit.Assert.*;
import org.junit.Test;
import javachatserver.MainServer;
import javachatserver.User;

public class MainServerTest {

	//test mainserver objects, no returnable functions
	@Test
	public void MainServerObjTest() {
		MainServer ms = new MainServer();
		assertNotNull("Should not be null", ms);
	}
	
	@Test 
	public void MainServerObj2()
	{
		assertNotSame("Should not be same", new MainServer(), new MainServer());
	}
	
	//test get user, in main function adds users, default constructor not needed
	@Test
	public void getUserTest()
	{
		MainServer ms = new MainServer();
		//cant load users because not running mainserver, private for authentication
		assertNull("Should be null", ms.getUser("andre", "123"));
		
	}

}
