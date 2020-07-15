package JunitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ClientTest.class, MainServerTest.class, MessageTest.class, MiniServerTest.class})
public class AllTests {

}
