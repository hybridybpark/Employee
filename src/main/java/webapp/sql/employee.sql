
select * from DEPT where deptno = 10;
select * from EMP where deptno = 10;
select * from dept d inner join emp e on d.deptno = e.deptno where d.deptno = 10;
select * from dept d, emp e where d.deptno = e.deptno and d.deptno = 10;
select * from dept d left join emp e on d.deptno = e.deptno where d.deptno = 10;

select * from dept d left join emp e on d.deptno = e.deptno;
select * from dept;

SELECT 
d.deptno as deptno,
d.dname as dname,
d.loc as loc,
e.empno as empno,
e.ename as ename,
e.job as job,
e.mgr as mgr,
e.hiredate as hiredate,
e.sal as sal,
e.comm as comm
FROM dept d LEFT JOIN emp e 
ON d.deptno = e.deptno 
ORDER BY d.deptno asc, e.empno asc;

SELECT d.deptno as deptno, d.dname as dname, d.loc as loc, e.empno as empno,e.ename as ename,e.job as job,e.mgr as mgr,e.hiredate as hiredate,e.sal as sal,e.comm as comm	FROM dept d LEFT JOIN emp e ON d.deptno = e.deptno ORDER BY d.deptno asc, e.empno asc;


SELECT d.deptno,d.dname,d.loc,e.empno,e.ename,e.job,e.mgr,e.hiredate,e.sal,e.comm FROM dept d LEFT JOIN emp e ON d.deptno = e.deptno ORDER BY d.deptno asc, e.empno asc;

SELECT d.deptno as deptno, d.dname as dname, d.loc as loc, e.empno as empno,e.ename as ename,e.job as job,e.mgr as mgr,e.hiredate as hiredate,e.sal as sal,e.comm as comm	FROM dept d LEFT JOIN emp e ON d.deptno = e.deptno ORDER BY d.deptno asc, e.empno asc;