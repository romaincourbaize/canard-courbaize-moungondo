package canard;

public class CanardFeu extends Canard {

	public CanardFeu(String pNom, double pPointsDeVie, int pPointsAttaque) {
		super(pNom, pPointsDeVie, pPointsAttaque, TypeCanard.FEU);
	}

	@Override
	public void attaquerSpeciale(Canard pAutreCanard) {
		// TODO Auto-generated method stub
		
	}
}
