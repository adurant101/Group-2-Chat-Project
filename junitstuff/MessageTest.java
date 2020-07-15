package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import chat1.Message;

public class MessageTest {

	@Test
	public void testMessage() {
		assertNotNull("Should not be null", new Message());
		assertNotSame("Should not be the same", new Message(), new Message());
	}
	
	@Test
	public void testSetAndGetText()
	{
		Message m = new Message();
		m.setText("HI");
		assertEquals("Should be same", "HI", m.getText());
	}
	
	@Test
	public void testSetAndGetID()
	{
		Message m = new Message();
		m.setId(11);
		assertSame("Should be equal", 11, m.getID());
	}
	
	@Test
	public void testSetAndGetType()
	{
		Message m = new Message();
		m.setType("THE");
		assertEquals("Should be same", "THE", m.getType());
	}
	
	

}
