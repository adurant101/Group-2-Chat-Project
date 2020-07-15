package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import chat1.Client;
import chat1.MiniServer;

public class ClientTest {

	@Test
	public void testMiniServer()
	{
		Client m = new Client();
		Client m1 = new Client();
		assertNotNull("Should not be null", m);		
		assertNotSame("Should not be null", m, m1);

	}

}
