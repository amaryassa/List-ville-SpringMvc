package com.projet.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.Country;

public class CountryDAO implements ICountryDAO {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Transactional(readOnly=true)
	public List<Country> recupererListePays(int page, int size) {
		Session session = sessionFactory.getCurrentSession();
        List<Country> countryList = session.createQuery("from Country").setFirstResult(page).setMaxResults(size).list();
//        String countQ = "Select count (f.id) from Country f";
//        Query countQuery = session.createQuery(countQ);
//        Long countResults = (Long) countQuery.uniqueResult();
//        
//        System.out.println(countResults);
       
        return countryList;
	}
    @Transactional(readOnly=true)
	public Long totalPays() {
		Session session = sessionFactory.getCurrentSession();
        String countQ = "Select count (f.id) from Country f";
        Query countQuery = session.createQuery(countQ);
        Long countResults = (Long) countQuery.uniqueResult();
        
//        System.out.println(countResults);
        return countResults;
	}

//	public Page<Country> findAllPays(Pageable pageable) {
//		Session session = sessionFactory.getCurrentSession();
//		Page<Country> countryPageList = session.createQuery("from Country").setFirstResult(x).setMaxResults(y).list();
//		return countryPageList;
//	}
    
}