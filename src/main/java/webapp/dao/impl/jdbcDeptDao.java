package webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.datasource.DataSourceUtils;

import webapp.dao.DeptDao;
import webapp.model.Dept;

import webapp.model.Emp;
import webapp.util.GlobalVars;

public class jdbcDeptDao implements DeptDao{

	static Logger log = Logger.getLogger(jdbcDeptDao.class);
	
	DataSource dataSource;
	
	@Override
	public List<Dept> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> selectAllwithEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dept selectByDeptno(Integer deptno)   {
		// TODO Auto-generated method stub
//		log.info("###################################");
//		log.info("selectByDeptno("+deptno+")");
//		log.info("###################################");
		Connection con = DataSourceUtils.getConnection(dataSource);
		
//		Connection con = GlobalVars.con.get();
		System.out.println(con);
		PreparedStatement pstmt;
		Dept dept = null;
		try {
			pstmt = con.prepareStatement(SELECT_BY_DEPTNO);
		
		
		pstmt.setInt(1, deptno);
		
		ResultSet rs = pstmt.executeQuery();
		int a[] = new int[3];
		
		if(rs.next()){
			dept = new Dept();
			dept.setDeptno(rs.getInt("deptno"));
			dept.setDname(rs.getString("dname"));
			dept.setLoc(rs.getString("loc"));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block			
			throw new DataRetrievalFailureException("Fail",e);
		}
		return dept;
	}

	@Override
	public Dept selectByDeptnowithEmps(Integer deptno)   {
		// TODO Auto-generated method stub
		log.info("###################################");
		log.info("selectByDeptnowithEmps("+deptno+")");
		log.info("###################################");
		Connection con = DataSourceUtils.getConnection(dataSource);
		
		PreparedStatement pstmt;
		Dept dept = null;
		try {
			pstmt = con.prepareStatement(SELECT_BY_DEPTNO_WITH_EMP);
		
		
			pstmt.setInt(1, deptno);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			List<Emp> emps = new ArrayList<Emp>();
			while(rs.next()){
				if(dept==null){
					dept = new Dept();
					dept.setDeptno(rs.getInt("deptno"));
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
				}
				Emp emp = new Emp();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataRetrievalFailureException("Fail",e);
		}
		return dept;
	}

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		dataSource = ds;
	}

	

}
