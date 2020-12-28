package com.lovecode.spring.restful.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lovecode.spring.restful.entity.Customer;



@Repository
public class CustomerDAOImp implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		//get current session
		Session session	=	sessionFactory.getCurrentSession();
		//create query
		Query <Customer> query =session.createQuery("from Customer order by lname",Customer.class);
		
		List<Customer> clist=query.getResultList();
	
		return clist;
	}



@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session session	=	sessionFactory.getCurrentSession();
		    session.saveOrUpdate(theCustomer);
		}



@Override
public Customer getCustomer(int id) {
	// TODO Auto-generated method stub
	Session session	=	sessionFactory.getCurrentSession();
	    Customer custmer=        session.get(Customer.class, id);
	return custmer;
}



@Override
public void deleteCustomer(int id) {
	// TODO Auto-generated method stub

	Session session	=	sessionFactory.getCurrentSession();
	Query query=session.createQuery("delete from Customer where id=:theid");
	query.setParameter("theid",id);
	query.executeUpdate();


}

}
