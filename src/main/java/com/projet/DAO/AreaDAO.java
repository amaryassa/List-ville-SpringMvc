package com.projet.DAO;

import java.util.List;

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
	public List<Area> recupererListeArea() {
		Session session = sessionFactory.getCurrentSession();
		  List<Area> areaList = session.createQuery("from Area").list();
	        return areaList;
	}

}
