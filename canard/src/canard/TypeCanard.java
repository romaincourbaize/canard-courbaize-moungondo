package canard;

public enum TypeCanard {
	
	EAU,
	
	FEU,
	
	GLACE,
	
	VENT;
	
	private static final double NEUTRE = 1;
	
	private static final double FORT = 1.5;
	
	private static final double FAIBLE = 0.5;
	
	public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
		
		if (attaquant == cible) {
			return NEUTRE;
			
		}
		switch (attaquant) {
		case EAU:
			if (cible == FEU) return FORT;
			return FAIBLE;
			
		case FEU:
			if (cible == GLACE) return FORT;
			return FAIBLE;
			
		case GLACE:
			if (cible == VENT) return FORT;
			return FAIBLE;
			
		case VENT:
			if (cible == EAU) return FORT;
			return FAIBLE;
			
		default:
			return 1;
		}
	}
}
