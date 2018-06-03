package objetJava;

public class TypeOuvrage {
	private int idTypeOuvrage;
	private String nomTypeOuvrage;
	
	public TypeOuvrage() {
		super();
		
	}
	public TypeOuvrage(String nomtypeOuvrage) {
		super();
		nomTypeOuvrage = nomtypeOuvrage;
	}
	public int getIdTypeOuvrage() {
		return idTypeOuvrage;
	}
	public void setIdTypeOuvrage(int idTypeOuvrage) {
		this.idTypeOuvrage = idTypeOuvrage;
	}
	public String getNomTypeOuvrage() {
		return nomTypeOuvrage;
	}
	public void setNomTypeOuvrage(String typeOuvrage) {
		nomTypeOuvrage = typeOuvrage;
	}
}
