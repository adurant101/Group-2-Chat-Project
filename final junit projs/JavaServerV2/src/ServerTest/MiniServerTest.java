//Final Project
package ServerTest;
import static org.junit.Assert.*;
import java.net.Socket;
import org.junit.Test;
import javachatserver.MainServer;
import javachatserver.MiniServer;

public class MiniServerTest {
	
	//test miniserver objects, no returnable functions
	@Test
	public void MiniServerObjTest() {
		Socket s = null;
		MiniServer ms = new MiniServer(s);
		assertNotNull("Should not be null", ms);
	}
	
	@Test 
	public void MiniServerObj2()
	{
		Socket s = null;
		assertNotSame("Should not be same", new MiniServer(s), new MiniServer(s));
	}

}
