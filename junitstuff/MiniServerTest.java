package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import chat1.MiniServer;

public class MiniServerTest {

	@Test
	public void testMiniServer()
	{
		MiniServer m = new MiniServer();
		MiniServer m1 = new MiniServer();
		assertNotNull("Should not be null", m);		
		assertNotSame("Should not be null", m, m1);

	}

}
