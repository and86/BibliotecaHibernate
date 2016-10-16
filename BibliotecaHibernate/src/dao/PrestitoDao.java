package dao;

import hibernateUtil.HibernateUtil;


import model.Prestito;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PrestitoDao {
	
	// 1-Create
	public boolean creaPrestito(Prestito p) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.persist(p);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return res;
	}

	// 2-Read (con id)
	public Prestito leggiPrestito(long id_p) {
		Prestito p = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			p = session.get(Prestito.class, id_p);

			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return p;
	}

	// 3-Update
	public boolean aggiornaPrestito(Prestito p) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.update(p);

			tx.commit();
			res = true;

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return res;
	}

	// 5-Delete
	public boolean eliminaPrestito(Prestito p) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.delete(p);

			tx.commit();
			res = true;

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return res;
	}

}
