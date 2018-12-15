package com.projet.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.Area;
import com.projet.model.Country;

public class AreaDAO  implements IAreaDAO{
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Transactional(readOnly=true)
	public List<Area> recupererListeArea(int page, int size, String motCle) {
		Session session = sessionFactory.getCurrentSession();
		  List<Area> areaList = session.createQuery("from Area as a where a.areaLabel like '%"+motCle+"%'")
				  .setFirstResult(page).setMaxResults(size).list();
	        return areaList;
	}
    
    @Transactional(readOnly=true)
  	public Long totalArea(String motCle) {
  		Session session = sessionFactory.getCurrentSession();
          String countQ = "Select count (*) from Area as a where a.areaLabel like '%"+motCle+"%'";
          Query countQuery = session.createQuery(countQ);
          Long countResults = (Long) countQuery.uniqueResult();
          return countResults;
  	}
}
