package canard;

public interface CapaciteSpeciale {
	default void attaquerSpeciale(Canard pAutreCanard) {
		if (((Canard)this).peutAttaquer(TypeAttaque.SPECIALE)) {
			((Canard)this).consommerEnergie(TypeAttaque.SPECIALE);
		}
	}
}
