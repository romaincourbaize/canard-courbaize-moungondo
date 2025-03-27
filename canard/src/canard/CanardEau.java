package canard;

public class CanardEau extends Canard {
	
	private static final double POINTS_DE_REGENERATION = 20;

	public CanardEau(String pNom, double pPointsDeVie, int pPointsAttaque) {
		super(pNom, pPointsDeVie, pPointsAttaque, TypeCanard.EAU);
	}

	@Override
	public void attaquerSpeciale(Canard pAutreCanard) {
		setPointsDeVie(getPointsDeVie() + 20);
	}
}
