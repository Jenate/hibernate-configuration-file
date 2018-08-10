import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.pojo.Customer;
import lti.util.HibernateUtil;

public class TestCustomer {
	@Test
	public void testSaveCustomer() {
		Session session = HibernateUtil.getSession();
		Transaction txn = session.getTransaction();
		try {
			// starting db transaction
			txn.begin();
			Customer cust = new Customer();
			cust.setCustName("jenate");
			cust.setCreditLimit(8000);
			// saving customer object
			session.save(cust);
			// ending transaction with commit
			txn.commit();
		} catch (Exception e) {
			// transaction failed hence rollback
			txn.rollback();
			e.printStackTrace();
		}

	}
	@Test
	public void testGetCustomer() {
		Session session = HibernateUtil.getSession();
		
		Customer cust = (Customer) session.get(Customer.class, 1);
		System.out.println("Name : "+ cust.getCustName());
	}
}
