package canard;

public enum TypeAttaque {
	NORMALE("Normale", 5),
	
	SPECIALE("Spéciale", 15);
	
	private String nom;
	
	private int cout;
	
	private TypeAttaque(String pNom, int pCout) {
		nom = pNom;
		cout = pCout;
	}
	
	public int getCout() {
		return cout;
	}
}
