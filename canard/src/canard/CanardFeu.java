package canard;

public class CanardFeu extends Canard implements CapaciteSpeciale {
	
	private static final double DEGATS_SUPPLEMENTAIRE_SPECIALE = 10;

	public CanardFeu(String pNom, double pPointsDeVie, int pPointsAttaque) {
		super(pNom, pPointsDeVie, pPointsAttaque, TypeCanard.FEU);
	}

	@Override
	public void attaquerSpeciale(Canard pAutreCanard) {
		attaquer(pAutreCanard);
		pAutreCanard.subirDegats(DEGATS_SUPPLEMENTAIRE_SPECIALE);
	}

	@Override
	public String getCaracteristiques() {
		String s =  "Nom : " + getNom() + "\n";
		s += "Nombre de points de vie : " + getPointsDeVie() + "\n";
		s += "Nombre de d�gat : " + getPointsAttaque() + "\n";
		s += "Attaque sp�ciale : " + DEGATS_SUPPLEMENTAIRE_SPECIALE + " suppl�mentaire";
		return s;
	}
}
