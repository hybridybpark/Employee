package webapp.dao.impl;

import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import webapp.dao.DeptDao;
import webapp.model.Dept;
import webapp.model.Emp;

public class SpringjdbcDeptDao implements DeptDao{
	
	DataSource dataSource;
	static Logger log = Logger.getLogger(SpringjdbcDeptDao.class);
	
	@Override
	public List<Dept> selectAll() {
		// TODO Auto-generated method stub
		JdbcTemplate template = new JdbcTemplate(dataSource); 		
		return template.query(SELECT_ALL, new BeanPropertyRowMapper<Dept>(Dept.class));
	}

	@Override
	public List<Dept> selectAllWithEmps() {
		// TODO Auto-generated method stub
		log.info("###################################");
		log.info("selectAllWithEmps_Spring");
		log.info("###################################");
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		List<Dept> list =  template.query(SELECT_ALL_WITH_EMP, new ResultSetExtractor<List<Dept>>(){
			
			public Emp addEmp(ResultSet rs) throws SQLException{
				Emp emp  = new Emp();
				emp.setComm(rs.getFloat("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setSal(rs.getFloat("sal"));
				return emp;
			}

			@Override
			public List<Dept> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				ArrayList<Dept> list = new ArrayList<Dept>();			
				boolean currentExist = false;
				int currentIndex =0;
				while(rs.next()){
					if(list.size()==0){
						currentExist=false;
					}else{
						for(int i=0;i<list.size();i++){
							int no = rs.getInt("deptno");
							if(	list.get(i).getDeptno()==no){
								log.info("RRRRRR"+i+no);						
								currentExist=true;
								currentIndex=i;
								break;
							}else{
								currentExist=false;
							}
						}
					}				
					if(currentExist==false){
						log.info("exist false");
						Dept dept = new Dept();
						dept.setDeptno(rs.getInt("deptno"));
						dept.setDname(rs.getString("dname"));
						dept.setLoc(rs.getString("loc"));
						ArrayList<Emp> emplist = new ArrayList<Emp>();						
						emplist.add(addEmp(rs));
						dept.setEmps(emplist);
						list.add(list.size(),dept);
					}else{
						log.info("exist true");
						Dept dept = list.get(currentIndex);
						ArrayList<Emp> emplist = (ArrayList<Emp>) dept.getEmps();						
						emplist.add(addEmp(rs));
					}
				}
				return list;
			}
			
		});	
		for(Dept d : list){
			log.info("Dept : "+d.getDname());
			for(Emp e : d.getEmps()){
				log.info(d.getDname()+"'s employee = "+e.getEname());
			}
		}
		
		return list;
		
	}

	@Override
	public Dept selectByDeptno(Integer deptno)   {
		// TODO Auto-generated method stub
		log.info("###################################");
		log.info("selectByDeptno("+deptno+")");
		log.info("###################################");		 
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		Dept dept  = template.queryForObject(SELECT_BY_DEPTNO, new BeanPropertyRowMapper<Dept>(Dept.class),deptno);
		
		return dept;
	}
	
	class DeptResultSetExtractor implements ResultSetExtractor<Dept>{

		@Override
		public Dept extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// TODO Auto-generated method stub
			
			Dept dept =null;
			List<Emp> emps = null;
			while(rs.next()){
				if(dept==null){
					dept = new Dept();
					dept.setDeptno(rs.getInt("deptno"));
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
					emps = new ArrayList<Emp>();
				}
				
				Emp emp  = new Emp();
				emp.setComm(rs.getFloat("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setSal(rs.getFloat("sal"));
				emps.add(emp);
				
				
			}
			
			if(dept!=null){
				dept.setEmps(emps);
			}
			
			return dept;
		}
		
	}

	@Override
	public Dept selectByDeptnowithEmps(Integer deptno)   {
		// TODO Auto-generated method stub
		log.info("###################################");
		log.info("selectByDeptnowithEmps("+deptno+")");
		log.info("###################################");
		
		
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		DeptResultSetExtractor extractor  = new DeptResultSetExtractor();
		
		Dept dept = template.query(SELECT_BY_DEPTNO_WITH_EMP, new Object[] {deptno},extractor);		
		
		return dept;
	}

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		dataSource = ds;
	}

}
