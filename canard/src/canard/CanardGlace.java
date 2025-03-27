package canard;

public class CanardGlace extends Canard {

	public CanardGlace(String pNom, double pPointsDeVie, int pPointsAttaque) {
		super(pNom, pPointsDeVie, pPointsAttaque, TypeCanard.GLACE);
	}

	@Override
	public void attaquerSpeciale(Canard pAutreCanard) {
		pAutreCanard.setGele(true);
	}
}
