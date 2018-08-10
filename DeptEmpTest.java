import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.pojo.one2many.Department;
import lti.pojo.one2many.Employee;
import lti.util.HibernateUtil;

public class DeptEmpTest {
@Test
public void testCase1() {
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	
	Department dept = new Department();
	dept.setDeptno(10);
	dept.setName("admin");
	dept.setLocation("andheri,mumbai");
	session.save(dept);
	tx.commit();
}
	
	@Test
	public void testCase2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Department dept= (Department) session.get(Department.class, 10);
		Employee emp = new Employee();
		emp.setEmpno(1002);
		emp.setName("vishal");
		emp.setSalary(2000.0);
		emp.setDept(dept);
		
		
		
		session.save(emp);
		tx.commit();
	}
}

