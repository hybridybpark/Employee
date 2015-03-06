package webapp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import webapp.model.Dept;


public interface DeptDao {
	
	public static final String SELECT_BY_DEPTNO = "select * from dept where deptno = ?";
	
	public static final String SELECT_BY_DEPTNO_WITH_EMP = "select * from dept d left join emp e on d.deptno = e.deptno where d.deptno = ?";
	
	public static final String SELECT_ALL = "select * from dept";
	
	public static final String SELECT_ALL_WITH_EMP = "SELECT d.deptno as deptno, d.dname as dname, d.loc as loc, e.empno as empno,e.ename as ename,e.job as job,e.mgr as mgr,e.hiredate as hiredate,e.sal as sal,e.comm as comm	FROM dept d LEFT JOIN emp e ON d.deptno = e.deptno ORDER BY d.deptno asc, e.empno asc";
	
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
