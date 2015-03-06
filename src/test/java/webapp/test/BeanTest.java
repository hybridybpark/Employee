package webapp.test;

import static org.junit.Assert.*;

import java.io.ObjectInputStream.GetField;




import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webapp.model.Dept;

import webapp.model.Emp;
import webapp.service.DeptInfoService;
import webapp.util.EmployeeDataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/webapp/spring/beans.xml")
public class BeanTest {
	
	@Autowired
	ApplicationContext factory;
	
	static Logger log = Logger.getLogger(BeanTest.class);
	
	@Test
	public void testGetDeptInfo() throws Exception {
		log.info("### testGetDeptInfo");
		DeptInfoService service = factory.getBean(DeptInfoService.class);
		
		Dept dept = service.getDeptInfo(10);
		
		assertNotNull(dept);
		
		log.info(dept.getDeptno());
		log.info(dept.getDname());
		log.info(dept.getLoc());
		
	}
	@Test
	public void testGetDeptInfoWithEmps() throws Exception {
		log.info("### testGetDeptInfoWithEmps");
		
		DeptInfoService service = factory.getBean(DeptInfoService.class);
		
		Dept dept = service.getDeptInfoWithEmps(10);
		
		assertNotNull(dept);
		
		log.info("DEPT : "+dept.getDeptno()+" "+dept.getDname());
		
		List<Emp> emps = dept.getEmps();
		if(emps != null){
			for(Emp e : emps){
				
				log.info("EMP : "+e.getEmpno()+" "+e.getEname()+" "+e.getJob()+" "+e.getMgr()+" "+e.getHiredate()+" "+e.getSal()+" "+e.getComm()+" "+e.getDeptno());
			}
		}
		
	}
	@Test
	public void testGetDeptinfoAll() throws Exception {
		log.info("### testGetDeptInfoAll");
		
		DeptInfoService service = factory.getBean(DeptInfoService.class);
		
		List<Dept> list = service.getDeptInfoAll();	
		assertNotNull(list);
		for(Dept dept : list){
			log.info("DEPT : "+dept.getDeptno()+" "+dept.getDname());			
		}		
	}
	@Test
	public void testGetDeptInfoAllWithEmps() throws Exception {
		log.info("### testGetDeptInfoAllWithEmps");
		
		DeptInfoService service = factory.getBean(DeptInfoService.class);
		
		List<Dept> list = service.getDeptInfoAllWithEmps();	
		assertNotNull(list);
		for(Dept dept : list){
			log.info("DEPT : "+dept.getDeptno()+" "+dept.getDname());
			List<Emp> emps = dept.getEmps();
			if(emps != null){
				for(Emp e : emps){
					
					log.info("EMP : "+e.getEmpno()+" "+e.getEname()+" "+e.getJob()+" "+e.getMgr()+" "+e.getHiredate()+" "+e.getSal()+" "+e.getComm()+" "+e.getDeptno());
				}
			}
		}		
	}

}
