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
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Libro;
	
	private String titolo;
	private String autore;
//	private String serialNumber;
	private int copieTotali;
	private int copieDisponibili;
	
	@ManyToMany
	private Set<Biblioteca>libriBiblioteca=new HashSet<Biblioteca>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "libro", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Prestito> prestitiLibri = new HashSet<>();
	
	//COSTRUTTORI
	public Libro() {
		
		this.titolo = "";
		this.autore = "";
		this.copieTotali = 0;
		this.copieDisponibili = 0;
	}
	
	public Libro(String titolo, String autore, int copieTotali,
			int copieDisponibili) {
		
		this.titolo = titolo;
		this.autore = autore;
		this.copieTotali = copieTotali;
		this.copieDisponibili = copieDisponibili;
	}

	//GETTER AND SETTER
	public long getId_Libro() {
		return id_Libro;
	}

	public void setId_Libro(long id_Libro) {
		this.id_Libro = id_Libro;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getCopieTotali() {
		return copieTotali;
	}

	public void setCopieTotali(int copieTotali) {
		this.copieTotali = copieTotali;
	}

	public int getCopieDisponibili() {
		return copieDisponibili;
	}

	public void setCopieDisponibili(int copieDisponibili) {
		this.copieDisponibili = copieDisponibili;
	}

	public Set<Biblioteca> getLibriBiblioteca() {
		return libriBiblioteca;
	}

	public void setLibriBiblioteca(Set<Biblioteca> libriBiblioteca) {
		this.libriBiblioteca = libriBiblioteca;
	}

	public Set<Prestito> getPrestitiLibri() {
		return prestitiLibri;
	}

	public void setPrestitiLibri(Set<Prestito> prestitiLibri) {
		this.prestitiLibri = prestitiLibri;
	}
	
	public void addLibri(Biblioteca b){
		libriBiblioteca.add(b);		
	}
	
	public void addPrestito(Prestito p){
		prestitiLibri.add(p);
	}

}
