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
	public List<Country> recupererListePays(int page, int size, String motCle) {
		Session session = sessionFactory.getCurrentSession();
//		 where country.codeIso ='ATA'
		
        List<Country> countryList = session.createQuery("from Country as country where country.codeIso like '%"+motCle+"%' ")
        		.setFirstResult(page).
        		setMaxResults(size).list();
        return countryList;
	}
    @Transactional(readOnly=true)
	public Long totalPays(String motCle) {
		Session session = sessionFactory.getCurrentSession();
        String countQ = "Select count (*) from Country as country where country.codeIso like '%"+motCle+"%'";
        Query countQuery = session.createQuery(countQ);
        Long countResults = (Long) countQuery.uniqueResult();
//        System.out.println("count: "+countResults);
        return countResults;
	}
}