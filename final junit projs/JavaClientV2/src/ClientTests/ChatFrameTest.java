//Final Project
package ClientTests;
import static org.junit.Assert.*;
import org.junit.Test;
import javachat2.ChatFrame;
import javachat2.Client;
public class ChatFrameTest {
	
	//Test chat frame objects, no returnable functions
	@Test
	public void chatFrameObjTest() {
		ChatFrame cf = new ChatFrame();
		assertNotNull("Should not be null", cf);
	}
	
	@Test 
	public void chatFrameObj2()
	{
		assertNotSame("Should not be same", new ChatFrame(), new ChatFrame());
	}

}
