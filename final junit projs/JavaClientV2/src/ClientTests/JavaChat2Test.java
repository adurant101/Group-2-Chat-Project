//Final Project

package ClientTests;
import static org.junit.Assert.*;
import org.junit.Test;
import javachat2.Client;
import javachat2.JavaChat2;

//test javachat2 objects
public class JavaChat2Test {

	//test objects, no functions
	@Test
	public void javaChatObjTest() {
		JavaChat2 jc = new JavaChat2();
		assertNotNull("Should not be null", jc);
	}
	
	@Test 
	public void javaChatObj2()
	{
		assertNotSame("Should not be same", new JavaChat2(), new JavaChat2());
	}

}
