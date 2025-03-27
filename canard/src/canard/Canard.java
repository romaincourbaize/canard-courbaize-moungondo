package canard;

public abstract class Canard {

	private String nom;
	
	private double pointsDeVie;
	
	private int pointsAttaque;
	
	private TypeCanard type;
	
	private boolean gele;
	
	public Canard(String pNom, double pPointsDeVie, int pPointsAttaque, TypeCanard pType) {
		super();
		nom = pNom;
		pointsDeVie = pPointsDeVie;
		pointsAttaque = pPointsAttaque;
		type = pType;
		gele = false;
	}

	public void attaquer(Canard pAutreCanard) {
		pAutreCanard.subirDegats(TypeCanard.getMultiplicateur(type, pAutreCanard.getType()) * pointsAttaque);
	}
	
	public void subirDegats(double pDegats) {
		pointsDeVie -= pDegats;
	}
	
	public abstract void attaquerSpeciale(Canard pAutreCanard);
	
	public boolean estKO() {
		return pointsDeVie <= 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public double getPointsDeVie() {
		return pointsDeVie;
	}
	
	public int getPointsAttaque() {
		return pointsAttaque;
	}
	
	public TypeCanard getType() {
		return type;
	}

	void setPointsDeVie(double pPointsDeVie) {
		pointsDeVie = pPointsDeVie;
	}

	boolean isGele() {
		return gele;
	}

	void setGele(boolean pGele) {
		gele = pGele;
	}
}
