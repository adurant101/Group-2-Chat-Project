package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import chat1.MainServer;
import chat1.MiniServer;

public class MainServerTest {
	@Test
	public void testMainServer() {
		MainServer m = new MainServer();
		MainServer m1 = new MainServer();
		assertNotNull("Should not be null", m);
		assertNotSame("Should not be null", m, m1);
	}
	


}
