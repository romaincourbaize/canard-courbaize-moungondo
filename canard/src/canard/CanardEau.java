package canard;

public class CanardEau extends Canard implements CapaciteSpeciale {
	
	private static final double POINTS_DE_REGENERATION = 20;

	public CanardEau(String pNom, double pPointsDeVie, int pPointsAttaque) {
		super(pNom, pPointsDeVie, pPointsAttaque, TypeCanard.EAU);
	}

	@Override
	public void attaquerSpeciale(Canard pAutreCanard) {
		setPointsDeVie(getPointsDeVie() + 20);
	}

	@Override
	public String getCaracteristiques() {
		String s = "Nom : " + getNom() + "\n";
		s += "Nombre de points de vie : " + getPointsDeVie() + "\n";
		s += "Nombre de dégat : " + getPointsAttaque() + "\n";
		s += "Attaque spéciale : Régénération de " + POINTS_DE_REGENERATION;
		return s;
	}
}
