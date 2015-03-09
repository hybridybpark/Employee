package webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class MyListener implements ServletContextListener {
	static Logger log = Logger.getLogger(MyListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		log.info("##############################");
		log.info("contextDestroyed");
		log.info("##############################");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		log.info("##############################");
		log.info("contextInitialized");
		log.info("##############################");
		
		
		
	}

}
