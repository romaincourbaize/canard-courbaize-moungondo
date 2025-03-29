package canard;

import canard.etat.EtatGele;

public class CanardGlace extends Canard implements CapaciteSpeciale {

	public CanardGlace(String pNom, double pPointsDeVie, int pPointsAttaque) {
		super(pNom, pPointsDeVie, pPointsAttaque, TypeCanard.GLACE);
	}

	@Override
	public void attaquerSpeciale(Canard pAutreCanard) {
		pAutreCanard.ajouterEffet(new EtatGele());
	}

	@Override
	public String getCaracteristiques() {
		String s = "Nom : " + getNom() + "\n";
		s += "Nombre de points de vie : " + getPointsDeVie() + "\n";
		s += "Nombre de d�gat : " + getPointsAttaque() + "\n";
		s += "Attaque sp�ciale : G�le l'adversaire";
		return s;
	}
}
