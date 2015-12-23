package com.apiRestTPDEV.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.apiRestTPDEV.model.Museum;

public class MuseumDAO {

	public void addMuseum(Museum museum) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(museum);
			if (!tx.wasCommitted())
				tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public Museum getMuseumById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Museum museum = null;
		try {
			tx = session.beginTransaction();
			museum = (Museum) session.get(Museum.class, id);
			if (!tx.wasCommitted())
				tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return museum;
	}

	public List<Museum> getAllMuseums() {
		List<Museum> museums = new ArrayList<Museum>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			museums = session.createQuery("FROM Museum").list();
			if (!tx.wasCommitted())
				tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return museums;
	}

	public void deleteMuseum(Long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Museum museum = (Museum) session.get(Museum.class, id);
			session.delete(museum);
			if (!tx.wasCommitted())
				tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
