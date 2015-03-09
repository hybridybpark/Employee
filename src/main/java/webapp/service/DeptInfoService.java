package webapp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import webapp.dao.DeptDao;
import webapp.exception.ConnectionFailException;
import webapp.exception.DeptAccessException;
import webapp.exception.DeptNotFoundException;
import webapp.model.Dept;
import webapp.util.GlobalVars;

public class DeptInfoService {
	
	DeptDao deptdao;
	
	DataSource dataSource;	
	
	public DeptDao getDeptdao() {
		return deptdao;
	}

	public void setDeptdao(DeptDao deptdao) {
		this.deptdao = deptdao;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}	
	
	public Dept getDeptInfoWithEmps(Integer deptno){		
		
		Dept dept = deptdao.selectByDeptnowithEmps(deptno);		
		
		return dept;
	}
	
	public Dept getDeptInfo(Integer deptno){			
		
		Dept dept = deptdao.selectByDeptno(deptno);		
		
		return dept;
	}
	
	public List<Dept> getDeptInfoAll(){
		List<Dept> list = deptdao.selectAll();
		return list;
	}
	public List<Dept> getDeptInfoAllWithEmps(){
		List<Dept> list = deptdao.selectAllWithEmps();
		return list;
	}
}
