package objetJava;

public class Personne {
	private int idPersonne;
	private String nom;
	private String prenom;
	private String sexe;
	private String situationMaritale;
	private int numRue;
	private String nomRue;
	private int codePostal;
	private String ville;
	private String pays;
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personne(String nom, String prenom, String sexe, String situationMaritale, int numRue, String nomRue,
			int codePostal, String ville, String pays) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.situationMaritale = situationMaritale;
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getSituationMaritale() {
		return situationMaritale;
	}
	public void setSituationMaritale(String situationMaritale) {
		this.situationMaritale = situationMaritale;
	}
	public int getNumRue() {
		return numRue;
	}
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	

}
