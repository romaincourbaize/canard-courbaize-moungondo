package canard;

public class CanardVent extends Canard implements CapaciteSpeciale {
	
	private static final int NOMBRE_ATTAQUES_SPECIALE = 3;

	public CanardVent(String pNom, double pPointsDeVie, int pPointsAttaque) {
		super(pNom, pPointsDeVie, pPointsAttaque, TypeCanard.VENT, 50);
	}

	@Override
	public void attaquerSpeciale(Canard pAutreCanard) {
		for (int i = 0 ; i < NOMBRE_ATTAQUES_SPECIALE ; i++) {
			attaquer(pAutreCanard, TypeAttaque.NORMALE);
		}
	}

	@Override
	public String getCaracteristiques() {
		String s = "Nom : " + getNom() + "\n";
		s += "Nombre de points de vie : " + getPointsDeVie() + "\n";
		s += "Nombre de dégat : " + getPointsAttaque() + "\n";
		s += "Attaque spéciale : X" + NOMBRE_ATTAQUES_SPECIALE + " attaques";
		return s;
	}
}
