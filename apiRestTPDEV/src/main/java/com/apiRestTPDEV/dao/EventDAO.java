package com.apiRestTPDEV.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.apiRestTPDEV.model.Event;

public class EventDAO {

	private UserDAO userDAO = new UserDAO();
	public void addEvent(Event event){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(event);
			if(!tx.wasCommitted())
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	public Event getEventById(Long id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Event event = null;
		try {
			tx = session.beginTransaction();
			event = (Event) session.get(Event.class, id);
			if(!tx.wasCommitted())
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return event;
	}
	public List<Event> getAllEvents() {
		List<Event> events = new ArrayList<Event>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			events = session.createQuery("FROM Event").list();
			if(!tx.wasCommitted())
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return events;
	}
	
	public void deleteEvent(Long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Event event = (Event) session.get(Event.class, id);
			session.delete(event);
			if(!tx.wasCommitted())
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
