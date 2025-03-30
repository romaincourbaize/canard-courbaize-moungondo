package canard;

public enum TypeCanard {

	EAU("Eau"),

	FEU("Feu"),

	GLACE("Glace"),

	VENT("Vent");

	private static final double NEUTRE = 1;

	private static final double FORT = 1.5;

	private static final double FAIBLE = 0.5;

	private static final double [][] MATRICE;

	static {
		double [][] matrice = new double[values().length][values().length];
		for (int i = 0; i < values().length; i++) {
			for (int j = 0; j < values().length; j++) {
				matrice[i][j] = NEUTRE;
			}
		}
		// Force
		matrice[0][1] = FORT; // EAU > FEU
		matrice[1][2] = FORT; // FEU > GLACE
		matrice[2][3] = FORT; // GLACE > VENT
		matrice[3][0] = FORT; // VENT > EAU

		// Faiblesse
		matrice[1][0] = FAIBLE; // EAU < FEU
		matrice[2][1] = FAIBLE; // FEU < GLACE
		matrice[3][2] = FAIBLE; // GLACE < VENT
		matrice[0][3] = FAIBLE; // VENT < EAU

		MATRICE = matrice;
	}

	private String nom;

	private TypeCanard(String pNom) {
		nom = pNom;
	}

	public String getNom() {
		return nom;
	}

	public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {

		return MATRICE[attaquant.ordinal()][cible.ordinal()];
	}
}