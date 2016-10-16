package dao;

import hibernateUtil.HibernateUtil;
import model.Utente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UtenteDao {

	// 1-Create
	public boolean creaUtente(Utente u) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.persist(u);

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
	public Utente leggiUtente(long id_u) {
		Utente u = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			u = session.get(Utente.class, id_u);

			tx.commit();
			
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return u;
	}

	// 3- Read (con nome, cognome, codiceFiscale)
	public Utente leggiUtenteConNomeCognomeCf(String nome, String cognome,String codiceFiscale) {
		Utente u = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from Utente where nome=:nomeInserito and"
							+ "cognome=:cognomeInserito and"
							+ "codiceFiscale=:codiceInserito");
			query.setString("nomeInserito", nome);
			query.setString("congnomeInserito", cognome);
			query.setString("codiceInserito", codiceFiscale);
			u = (Utente) query.uniqueResult();

			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return u;
	}

	// 4-Update
	public boolean aggiornaUtente(Utente u) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.update(u);

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
	public boolean eliminaUtente(Utente u) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.delete(u);

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
