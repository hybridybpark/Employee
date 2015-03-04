package webapp.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {		
		
		Properties dbpro = new Properties();
		
//		FileInputStream in = new FileInputStream("db.properties");		
//		
//		dbpro.load(in);
//		
		InputStream inputStream = PropertiesTest.class.getResourceAsStream("/webapp/resource/db.properties");
		
		dbpro.load(inputStream);
		
		String classname = dbpro.getProperty("oracle.className");
		
		String url = dbpro.getProperty("oracle.url");
		
		String user = dbpro.getProperty("oracle.user");
		
		String password = dbpro.getProperty("oracle.password");
		
		System.out.println(classname+url+user+password);
		
		
	}
}
