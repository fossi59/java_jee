package objetJava;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Ouvrage {
	private int idOuvrage;
	private String typeOuvrage;
	private String dateDebut;
	private String dateFin;
	private int idEntrepreneur;
	private int idTypeOuvrage;
	private List<TypeOuvrage> typeOuvrages = new ArrayList<>();
	
	public Ouvrage() {
		super();
		
	}
	public Ouvrage( String typeOuvrage, String dateDebut, String dateFin, int idEntrepreneur, int idTypeOuvrage) {
		super();
		this.typeOuvrage = typeOuvrage;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idEntrepreneur = idEntrepreneur;
		this.idTypeOuvrage = idTypeOuvrage;
	}
	public int getIdOuvrage() {
		return idOuvrage;
	}
	public void setIdOuvrage(int idOuvrage) {
		this.idOuvrage = idOuvrage;
	}
	public String getTypeOuvrage() {
		return typeOuvrage;
	}
	public void setTypeOuvrage(String typeOuvrage) {
		this.typeOuvrage = typeOuvrage;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public int getIdEntrepreneur() {
		return idEntrepreneur;
	}
	public void setIdEntrepreneur(int idEntrepreneur) {
		this.idEntrepreneur = idEntrepreneur;
	}
	public int getIdTypeOuvrage() {
		return idTypeOuvrage;
	}
	public void setIdTypeOuvrage(int idTypeOuvrage) {
		this.idTypeOuvrage = idTypeOuvrage;
	}
	public List<TypeOuvrage> getTypeOuvrages() {
		return typeOuvrages;
	}
	public void setTypeOuvrages(List<TypeOuvrage> typeOuvrages) {
		this.typeOuvrages = typeOuvrages;
	}

}
