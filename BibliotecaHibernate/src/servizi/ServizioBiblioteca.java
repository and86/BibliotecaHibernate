package servizi;

import java.util.Calendar;
import java.util.Date;

import mioDate.DateUtility;
import model.Biblioteca;
import model.Libro;
import model.Prestito;
import model.Utente;
import dao.BibliotecaDao;
import dao.LibroDao;
import dao.PrestitoDao;
import dao.UtenteDao;

public class ServizioBiblioteca {

	// Riferimenti ai DAO
	private BibliotecaDao bDao = new BibliotecaDao();
	private LibroDao lDao = new LibroDao();
	private PrestitoDao pDao = new PrestitoDao();
	private UtenteDao uDao = new UtenteDao();
	
	public boolean registraLibro(Biblioteca b,String titolo,String autore,int copie ){
		boolean res=false;
		
		Libro l=lDao.leggiLibroConTitoloAutore(titolo, autore);
		
		if (l==null){	//Se l è null significa che nn ho trovato il libro 
			l=new Libro(titolo, autore,copie,copie);
			lDao.creaLibro(l);
			l.addLibri(b);
			b.addLibri(l);
			bDao.aggiornaBiblioteca(b);
			res=true;			
		} else {	//Il libro esiste, aggiorno il numero di copie
			l.setCopieDisponibili(l.getCopieDisponibili()+copie);
			l.setCopieTotali(l.getCopieTotali()+copie);
			res=true;
		}		
		return res;
		
	}
	
	public boolean registraUtente(Biblioteca b, String nome, String cognome,
			String codiceFiscale) {
		boolean res = false;

		Utente u = uDao.leggiUtenteConNomeCognomeCf(nome, cognome,
				codiceFiscale);

		if (u == null) { // Se u è null significa che nn ho trovato l'utente
			u = new Utente(nome, cognome, codiceFiscale);
			uDao.creaUtente(u);
			b.addUtente(u);
			bDao.aggiornaBiblioteca(b);
			res = true;
		}
		return res;
	}
	
	public boolean prestaLibro(Biblioteca b, Utente u ,Libro l){
		boolean res=false;
		
		if(u.getPrestito().size()<3 && l.getCopieDisponibili()>0){
			
			DateUtility dt=new DateUtility();
			Date dataPrestito=new Date();
			Calendar cal= dt.convertJavaDateToCalendar(dataPrestito);
			cal.add(Calendar.DAY_OF_MONTH, 14);
			
			Date dataScadenza= dt.convertCalendarToJavaDate(cal);
			
			Prestito p=new Prestito(dataPrestito,dataScadenza,u,b,l);
			pDao.creaPrestito(p);
			u.addPrestito(p);
			l.addPrestito(p);
			l.setCopieDisponibili(l.getCopieDisponibili()-1);
			uDao.aggiornaUtente(u);
			lDao.aggiornaLibro(l);
			bDao.aggiornaBiblioteca(b);
			res=true;			
		}
		
		return res;		
	}
	
	public boolean restituisciLibro(Biblioteca b,Utente u,Libro l,Prestito p){
		boolean res=false;
		
		
		
		
		return res;
	}
	
	
	
	
	

}
