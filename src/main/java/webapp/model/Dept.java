package webapp.model;

import java.util.List;

public class Dept {
	private Integer deptno;
	private String dname;
	private String loc;
	private List<Emp> emps;
	public Dept() {
		// TODO Auto-generated constructor stub
	}
	public Dept(Integer deptno,String dname,String loc){
		setDeptno(deptno);
		setDname(dname);
		setLoc(loc);
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		
		if(this.getClass() != obj.getClass()){
			return false;			
		}
		
		Dept d = (Dept)obj;
		boolean rtn = true;		
		
		if(this.deptno != d.deptno){ 
			rtn = false;
		}else{
			if(this.dname == null){
				if(this.dname != d.dname)rtn = false;
			}else{
				rtn = this.dname.equals(d.dname);
			}
			if(this.loc == null){
				if(this.loc != d.loc)rtn = false;
			}else{
				rtn = this.loc.equals(d.loc);
			}
		}
		return rtn;
	}
	
}
