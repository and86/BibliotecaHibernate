package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
public class Biblioteca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Biblioteca;

	private String nome;

	@ManyToMany(mappedBy = "utentiBiblioteca", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Utente> utenti = new HashSet<Utente>();

	@ManyToMany(mappedBy = "libriBiblioteca", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Libro> libri = new HashSet<Libro>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "biblioteca", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Prestito> prestitiBiblioteca = new HashSet<>();

	// COSTRUTTORI
	public Biblioteca() {
		this.nome = "";
	}

	public Biblioteca(String nome) {
		this.nome = nome;
	}

	//GETTER AND SETTER
	public long getId_Biblioteca() {
		return id_Biblioteca;
	}

	public void setId_Biblioteca(long id_Biblioteca) {
		this.id_Biblioteca = id_Biblioteca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}

	public Set<Libro> getLibri() {
		return libri;
	}

	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}

	public Set<Prestito> getPrestitiBiblioteca() {
		return prestitiBiblioteca;
	}

	public void setPrestitiBiblioteca(Set<Prestito> prestitiBiblioteca) {
		this.prestitiBiblioteca = prestitiBiblioteca;
	}
	
	public void addUtente(Utente u){
		utenti.add(u);
	}
	public void addLibri(Libro l){
		libri.add(l);
	}
	public void addPrestito(Prestito p){
		prestitiBiblioteca.add(p);
	}
	
}
