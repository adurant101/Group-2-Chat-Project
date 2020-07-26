//Test suite for server classes
//Final Project Junit

package ServerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MainServerTest.class, MiniServerTest.class, UserTest.class })
public class ServerSuite {

}
