//Final Project
package ClientTests;
import static org.junit.Assert.*;
import org.junit.Test;
import javachat2.Client;
//test client class
public class ClientTest {

	//test client objects, functions dont return anything testable
	@Test
	public void clientObjTest() {
		Client cl = new Client();
		assertNotNull("Should not be null", cl);
	}
	
	@Test 
	public void clientObj2()
	{
		assertNotSame("Should not be same", new Client(), new Client());
	}

}
