package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springdemo.entity.Ledger;

@Repository
public class LedgerDaoImpl implements LedgerDAO {
	
		// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
				
		@Override
		public List<Ledger> getValues() {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			// create a query  ... sort by last name
			Query<Ledger> theQuery = 
					currentSession.createQuery("from Ledger order by status",
												Ledger.class);
			
			// execute query and get result list
			List<Ledger> ledger = theQuery.getResultList();
					
			// return the results		
			return ledger;
		}
		
}
