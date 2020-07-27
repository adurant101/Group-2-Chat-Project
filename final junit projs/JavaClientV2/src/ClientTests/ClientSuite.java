//Client test suite 
//Final Project
package ClientTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//test all client classes
@RunWith(Suite.class)
@SuiteClasses({ChatFrameTest.class, ClientTest.class, JavaChat2Test.class})
public class ClientSuite {

}
