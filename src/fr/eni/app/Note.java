package fr.eni.app;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Note implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int idClasse = 0;
	private int id;
	private String contenu;
	private String date;
	private LocalDate localDate;

	public Note() {
		this.id = idClasse;
		idClasse++;
	}

	public Note(String texte) {
		this.id = idClasse;
		idClasse++;		
		this.contenu = texte;
		this.localDate = LocalDate.now();
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.date = localDate.format(formatter);
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", contenu=" + contenu + ", date=" + this.getDate() + "]";
	}


}
