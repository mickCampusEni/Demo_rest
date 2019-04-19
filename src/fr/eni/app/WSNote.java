package fr.eni.app;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("/notes")
public class WSNote {
	
	public static List<Note> listeNotes = new ArrayList<Note>();
	
	@GET
	public List<Note> getNotes(){
		return listeNotes;
	}
	
	@POST
	public Note ajouterNote(@FormParam("paramContenu") String paramContenu) {
		
		Note note = new Note(paramContenu);

		listeNotes.add(note);
		
		System.out.println("----------Liste des notes--------");
		for (Note n : listeNotes) {
			System.out.println(n.toString());
		}		
		return note;		
	}

	@PUT
	@Path("/{id:\\d+}")
	public boolean modifierNote(@PathParam("id") int id, @FormParam("paramContenu") String paramContenu) {
		
		boolean trouve = false;
		int indice = 0;
		Note noteTrouve = null;
		
		while(!trouve || indice < listeNotes.size()) {
			// une modif
			if(listeNotes.get(indice).getId() == id) {
				noteTrouve = listeNotes.get(indice);
				noteTrouve.setContenu(paramContenu);
				listeNotes.set(indice, noteTrouve);
				trouve = true;
			}
			else {
				indice++;
			}
		}
		return trouve;	
	}

	@DELETE
	@Path("/{id:\\d+}")
	public boolean supprimerNote(@PathParam("id") int id) {
		
		boolean trouve = false;
		int indice = 0;
		Note noteTrouve = null;
		
		while(!trouve || indice < listeNotes.size()) {
			
			if(listeNotes.get(indice).getId() == id) {
				noteTrouve = listeNotes.get(indice);
				listeNotes.remove(indice);
				trouve = true;
			}
			else {
				indice++;
			}
		}
		return trouve;
		}
}
