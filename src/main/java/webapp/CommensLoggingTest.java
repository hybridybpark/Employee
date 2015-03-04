package webapp;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class CommensLoggingTest {
	
	static Log log = LogFactory.getLog(CommensLoggingTest.class);
	
	@Test
	public void test() {
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
	}

}
