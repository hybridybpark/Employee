
select * from DEPT where deptno = 10;
select * from EMP where deptno = 10;
select * from dept d inner join emp e on d.deptno = e.deptno where d.deptno = 10;
select * from dept d, emp e where d.deptno = e.deptno and d.deptno = 10;
select * from dept d left join emp e on d.deptno = e.deptno where d.deptno = 10;