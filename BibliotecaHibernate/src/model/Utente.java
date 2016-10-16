package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Utente;
	
	private String nome;
	private String cognome;
	private String codiceFiscale;
	
	@ElementCollection(fetch=FetchType.EAGER)
	Set<Libro> libriUtente=new HashSet<Libro>();
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="utente",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Prestito> prestito=new HashSet<>();
	
	@ManyToMany
	private Set<Biblioteca> utentiBiblioteca=new HashSet<>();

	
	//COSTRUTTORI
	public Utente() {
		this.nome="";
		this.cognome="";
		this.codiceFiscale="";		
	}

	public Utente(String nome, String cognome,
			String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}
	
	//GETTER AND SETTER
	public long getId_Utente() {
		return id_Utente;
	}

	public void setId_Utente(long id_Utente) {
		this.id_Utente = id_Utente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Set<Libro> getLibriUtente() {
		return libriUtente;
	}

	public void setLibriUtente(Set<Libro> libriUtente) {
		this.libriUtente = libriUtente;
	}

	public Set<Prestito> getPrestito() {
		return prestito;
	}

	public void setPrestito(Set<Prestito> prestito) {
		this.prestito = prestito;
	}

	public Set<Biblioteca> getUtentiBiblioteca() {
		return utentiBiblioteca;
	}

	public void setUtentiBiblioteca(Set<Biblioteca> utentiBiblioteca) {
		this.utentiBiblioteca = utentiBiblioteca;
	}
	
	public void addLibriUtente(Libro l){
		libriUtente.add(l);
	}
	
	public void addPrestito(Prestito p){
		prestito.add(p);
	}
	public void addUtentiBiblioteca(Biblioteca b){
		utentiBiblioteca.add(b);
	}

	

	
}
