package dao;

import hibernateUtil.HibernateUtil;
import model.Libro;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LibroDao {

	// 1-Create
	public boolean creaLibro(Libro l) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.persist(l);

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
	public Libro leggiLibro(long id_l) {
		Libro l = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			l = session.get(Libro.class, id_l);

			tx.commit();
			
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return l;
	}

	// 3- Read (con titolo, autore)
	public Libro leggiLibroConTitoloAutore(String titolo, String autore) {
		Libro l = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from Libro where titolo=:titoloInserito and"
							+ "autore=:autoreInserito");
			query.setString("titoloInserito", titolo);
			query.setString("autoreInserito", autore);
			l = (Libro) query.uniqueResult();

			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return l;
	}

	// 4-Update
	public boolean aggiornaLibro(Libro l) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.update(l);

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
	public boolean eliminaLibro (Libro l) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.delete(l);

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
