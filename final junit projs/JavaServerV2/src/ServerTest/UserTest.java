//Final Project
package ServerTest;

import static org.junit.Assert.*;

import org.junit.Test;

import javachatserver.User;

//Test User Class
public class UserTest {
	
	//test user objects
	@Test
	public void UserObjTest() {
		assertNotNull("Should not be null", new User("T","W"));
		
	}
	
	@Test
	public void UserObjTest2() {
		assertNotSame("Should not be same", new User("T","W"),  new User("T","W"));
		
	}
	
	//test constructor
	@Test
	public void testNormalConstructor()
	{
		User u = new User("One", "Two");
		assertEquals("Should be same", "One", u.getUsername());
		assertEquals("Should be same", "Two", u.getPassword());
	}
	
	//test setter and getter username
	@Test
	public void testSetAndGetUsername()
	{
		User u = new User("@", "W");
		u.setUsername("test");
		assertEquals("Should be same", "test", u.getUsername());
		
	}
	
	//test setter and getter password
	@Test
	public void testSetAndGetPassword()
	{
		User u = new User ("E", "S");
		u.setPassword("pass");
		assertEquals("Should be same", "pass", u.getPassword());
	}
	
	//test is valid
	@Test
	public void testValid()
	{
		User u = new User("E", "W");
		assertTrue("Should be true", u.isValid("E", "W"));
	}
	
	//test to string
	@Test
	public void testToString()
	{
		User u = new User("E", "W");
		assertEquals("Should be same", "{\"username\": \"E\"}", u.toString());
	}

}
