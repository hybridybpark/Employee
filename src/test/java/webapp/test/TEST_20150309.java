package webapp.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.WebApplicationContextUtils;

import webapp.model.Dept;
import webapp.model.Emp;
import webapp.service.DeptInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/webapp/spring/beans.xml")
public class TEST_20150309 {
	
	@Autowired
	ApplicationContext factory;
	
	static Logger log = Logger.getLogger(TEST_20150309.class);
	
	@Test
	public void test_GetDeptInfoAllWithEmps() throws Exception {
		log.info("SELECT_ALL_WITH_EMPS");
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
