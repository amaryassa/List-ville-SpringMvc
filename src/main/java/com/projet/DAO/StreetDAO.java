package com.projet.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.Street;

public class StreetDAO implements IStreetDAO {

		private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
        }
    @Transactional(readOnly=true)
	public List<Street> recupererListeStreet(int page, int size) {
    	
    		Session session = sessionFactory.getCurrentSession();
            List<Street> StreetList = session.createQuery("from Street").setFirstResult(page).setMaxResults(size).list();
            return StreetList;
	}
    
    @Transactional(readOnly=true)
	public Long totalStreet() {
    	Session session = sessionFactory.getCurrentSession();
        String countQ = "Select count (f.id) from Street f";
        Query countQuery = session.createQuery(countQ);
        Long countResults = (Long) countQuery.uniqueResult();
        return countResults;
	}
	
}