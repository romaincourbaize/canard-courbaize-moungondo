package canard;

public class CanardVent extends Canard {

	public CanardVent(String pNom, double pPointsDeVie, int pPointsAttaque) {
		super(pNom, pPointsDeVie, pPointsAttaque, TypeCanard.VENT);
	}

	@Override
	public void attaquerSpeciale(Canard pAutreCanard) {
		// TODO Auto-generated method stub
		
	}
}
