package com.projet.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.City;
import com.projet.model.Country;

public class CityDAO implements ICityDAO {
	

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @Transactional(readOnly=true)
	public List<City> recupererListeCity(int page, int size) {
		Session session = sessionFactory.getCurrentSession();
        List<City> cityList = session.createQuery("from City").setFirstResult(page).setMaxResults(size).list();
        System.out.println("\n \n \n"+cityList+"\n\n\n");
        return cityList;
	}
    @Transactional(readOnly=true)
	public Long totalCity() {
    	Session session = sessionFactory.getCurrentSession();
        String countQ = "Select count (f.id) from City f";
        Query countQuery = session.createQuery(countQ);
        Long countResults = (Long) countQuery.uniqueResult();
        System.out.println("\n \n \n"+countResults+"\n\n\n");
        return countResults;
	}
}
