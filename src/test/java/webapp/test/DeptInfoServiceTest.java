package webapp.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import webapp.dao.impl.jdbcDeptDao;
import webapp.model.Dept;
import webapp.service.DeptInfoService;
import webapp.util.EmployeeDataSource;

public class DeptInfoServiceTest {
	
	Properties dbpro;
	
	DeptInfoService service;
	
	public DeptInfoService getService() {
		return service;
	}

	public void setService(DeptInfoService service) {
		this.service = service;
	}

	public Properties getDbpro() {
		return dbpro;
	}

	public void setDbpro(Properties dbpro) {
		this.dbpro = dbpro;
	}
	
	public void print() throws SQLException{
		
		Dept d = service.getDeptInfo(10);
		
		System.out.println(d.getDeptno()+d.getDname()+d.getLoc());
		
	}

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub

		DeptInfoServiceTest t = new DeptInfoServiceTest();
		
		EmployeeDataSource ds = new EmployeeDataSource();
		
		InputStream inputStream = PropertiesTest.class.getResourceAsStream("/webapp/resource/db.properties");
		
		Properties pro = new Properties();
		
		jdbcDeptDao dao = new jdbcDeptDao();
		
		pro.load(inputStream);
		
		DeptInfoService s = new DeptInfoService();
		
		String classname = pro.getProperty("oracle.className");
		String url = pro.getProperty("oracle.url");
		String user = pro.getProperty("oracle.user");
		String password = pro.getProperty("oracle.password");	
		
		ds.setClassname(classname);
		ds.setPassword(password);
		ds.setUrl(url);
		ds.setUser(user);	
		
		t.setDbpro(pro);	
		
		s.setDataSource(ds);
		s.setDeptdao(dao);
		
		t.setService(s);
		t.print();
	}

}
