package canard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum TypeCanard {
	
	EAU("Eau"),
	
	FEU("Feu"),
	
	GLACE("Glace"),
	
	VENT("Vent");
	
	public static final Map<String, TypeCanard> NOMS = new HashMap();
	
	static {
		for (TypeCanard type : values()) {
			NOMS.put(type.nom, type);
		}
	}
	
	private static final double NEUTRE = 1;
	
	private static final double FORT = 1.5;
	
	private static final double FAIBLE = 0.5;
	
	private String nom;
	
	private TypeCanard(String pNom) {
		nom = pNom;
	}
	
	public String getNom() {
		return nom;
	}

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
	
	public static TypeCanard fromString(String pNom) {

		TypeCanard typeCanard = NOMS.get(pNom);
		
		if (typeCanard != null) {
			return typeCanard;
		}
		throw new IllegalArgumentException(pNom + " ne fait pas parti de l'énumération");
	}
}
