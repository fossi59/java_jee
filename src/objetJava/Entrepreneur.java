package objetJava;

import java.util.ArrayList;
import java.util.List;

public class Entrepreneur {
	private int idEntrepreneur;
	private String nomEntreprise;
	private int idPersonne;
	private List<Personne>personnes = new ArrayList<>();
	public Entrepreneur() {
		super();
		
	}
	public Entrepreneur(String nomEntreprise, int idPersonne) {
		super();

		this.nomEntreprise = nomEntreprise;
		this.idPersonne = idPersonne;
	}
	public int getIdEntrepreneur() {
		return idEntrepreneur;
	}
	public void setIdEntrepreneur(int idEntrepreneur) {
		this.idEntrepreneur = idEntrepreneur;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	

}
