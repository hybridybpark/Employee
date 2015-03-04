package webapp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import webapp.model.Dept;


public interface DeptDao {
	
	public static final String SELECT_BY_DEPTNO = "select * from dept where deptno = ?";
	
	public static final String SELECT_BY_DEPTNO_WITH_EMP = "select * from dept d left join emp e on d.deptno = e.deptno where d.deptno = ?";
	
	public void setDataSource(DataSource ds);
	/*
	 * multiple row
	 */
	public List<Dept> selectAll();
	public List<Dept> selectAllwithEmps();
	
	/*
	 * single row by primary key
	 */	
	public Dept selectByDeptno(Integer deptno);
	public Dept selectByDeptnowithEmps(Integer deptno);

}
