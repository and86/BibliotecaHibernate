package dao;



import hibernateUtil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Biblioteca;

public class BibliotecaDao {
	
	// 1-Create
	public boolean creaBiblioteca(Biblioteca b) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.persist(b);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return res;
	}
	
	//2-Read (con id)
	public Biblioteca leggiBiblioteca(long id_b){
		Biblioteca b=null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			b=session.get(Biblioteca.class, id_b);

			tx.commit();
			
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return b;
	}
		
	//3- Read (con nome)
	public Biblioteca leggiBibliotecaConNome(String nome){
		Biblioteca b=null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			Query query=session.createQuery("from Biblioteca where nome=:nomeInserito");
			query.setString("nomeInserito", nome);
			b=(Biblioteca) query.uniqueResult();			

			tx.commit();
			
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return b;
	}
	
	//4-Update
	public boolean aggiornaBiblioteca(Biblioteca b){
		boolean res=false;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.update(b);
			
			tx.commit();
			res=true;
			
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return res;
	}
	
	//5-Delete
		public boolean eliminaBiblioteca(Biblioteca b){
			boolean res=false;
			
			Session session = HibernateUtil.openSession();
			Transaction tx = null;

			try {

				tx = session.getTransaction();
				tx.begin();

				session.delete(b);
				
				tx.commit();
				res=true;
				
			} catch (Exception ex) {

				tx.rollback();

			} finally {
				session.close();
			}
			return res;
		}
	
}
