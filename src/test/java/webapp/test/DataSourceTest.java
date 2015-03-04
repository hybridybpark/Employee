package webapp.test;


import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webapp.util.EmployeeDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/webapp/spring/beans.xml")
public class DataSourceTest {
	
	@Autowired
	ApplicationContext factory;
	
	static Logger log = Logger.getLogger(DataSourceTest.class);
	
	@Test
	public void testDataSource() throws Exception {
		String classname = "oracle.jdbc.OracleDriver";
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
		
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName(classname);
		
		ds.setUrl(url);
		
		ds.setUsername(user);
		
		ds.setPassword(password);
		
		Connection con = ds.getConnection(ds.getUsername(),ds.getPassword());
		
		Statement stmt = con.createStatement();		
		
		ResultSet rs = stmt.executeQuery("select 1+1 from dual");
		
		rs.next();
		
		Integer num = rs.getInt(1);
		
		log.info("num : "+num);
	}
	
	public static void test1() throws IOException, SQLException {
		
//		Properties dbpro = new Properties();
//		
////		FileInputStream in = new FileInputStream("db.properties");		
////		
////		dbpro.load(in);
////		
//		InputStream inputStream = DataSourceTest.class.getResourceAsStream("main/resources/webapp/resource/db.properties");
//		
//		dbpro.load(inputStream);
		
		String classname = "oracle.jdbc.OracleDriver";
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
		
		
		DriverManagerDataSource eds = new DriverManagerDataSource();
		
		eds.setDriverClassName(classname);
		
		eds.setUrl(url);
		
		eds.setUsername(user);
		
		eds.setPassword(password);
		
		Connection con = eds.getConnection(eds.getUsername(),eds.getPassword());
		
		Statement stmt = con.createStatement();		
		
		ResultSet rs = stmt.executeQuery("select 1+1 from dual");
		
		rs.next();
		
		Integer num = rs.getInt(1);
		
		System.out.println(num);
	}
}
