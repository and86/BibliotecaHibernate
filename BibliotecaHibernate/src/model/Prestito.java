package model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Prestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Prestito;
	
	private Date dataPrestito;
	private Date dataRestituzione;
	private Date dataScadenza;
	
	@ManyToOne
	@JoinColumn(name="id_Utente")
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name="id_Biblioteca")
	private Biblioteca biblioteca;
	
	@ManyToOne
	@JoinColumn(name="id_Libro")
	private Libro libro;

	//COSTRUTTORE
public Prestito() {
	}
	
	public Prestito(Date dataPrestito, Date dataScadenza,
			Utente utente, Biblioteca biblioteca, Libro libro) {
		
		this.dataPrestito = dataPrestito;
		this.setDataScadenza(dataScadenza);
		this.utente = utente;
		this.biblioteca = biblioteca;
		this.libro = libro;
	}

	//GETTER AND SETTER
	public long getId_Prestito() {
		return id_Prestito;
	}

	public void setId_Prestito(long id_Prestito) {
		this.id_Prestito = id_Prestito;
	}

	public Date getDataPrestito() {
		return dataPrestito;
	}

	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	public Date getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
