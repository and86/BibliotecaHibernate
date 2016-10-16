package servizi;

import model.Biblioteca;
import model.Libro;
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
	
	

}
