package canard;

import java.util.HashMap;
import java.util.Map;

public enum TypeAttaque {
	NORMALE("Normale"),
	
	SPECIALE("Spéciale");
	
	public static final Map<String, TypeAttaque> NOMS = new HashMap();
	
	static {
		for (TypeAttaque type : values()) {
			NOMS.put(type.nom, type);
		}
	}
	
	private String nom;
	
	private TypeAttaque(String pNom) {
		nom = pNom;
	}
	
	public static TypeAttaque fromString(String pNom) {

		TypeAttaque typeAttaque = NOMS.get(pNom);
		
		if (typeAttaque != null) {
			return typeAttaque;
		}
		throw new IllegalArgumentException(pNom + " ne fait pas parti de l'énumération");
	}
}
