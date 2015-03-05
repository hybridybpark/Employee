package webapp.test;

import static org.junit.Assert.*;

import java.io.ObjectInputStream.GetField;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;


import webapp.model.Emp;
import webapp.service.DeptInfoService;
import webapp.util.EmployeeDataSource;

public class InsertTest {

	private static GenericXmlApplicationContext factory;
	
	static Logger log = Logger.getLogger(InsertTest.class); 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new GenericXmlApplicationContext("classpath:/webapp/spring/beans.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		factory.close();
	}
	
	@Test
	public void testInsert() throws Exception {
		DataSource ds = factory.getBean(DataSource.class);
		
		Connection con = ds.getConnection();
		con.setAutoCommit(false);
		
		String sql = "insert into dept values (?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, 80);
		
		pstmt.setString(2, "xxx");
		
		pstmt.setString(3, "yyy");
		
		pstmt.executeUpdate();
		
		con.rollback();
		
//		con.commit();
	}

}
