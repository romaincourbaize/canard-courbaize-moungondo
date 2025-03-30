package canard;

import java.util.ArrayList;
import java.util.List;

import canard.etat.EffetEtat;

public abstract class Canard implements CapaciteSpeciale {

	private String nom;
	
	private double pointsDeVie;

	private final double POINTS_DE_VIE_MAX;
	
	private int pointsAttaque;
	
	private int pointsEnergie;
	
	private final int POINTS_ENERGIE_MAX;
	
	private TypeCanard type;
	
	private List<EffetEtat> effets;
	
	public Canard(String pNom, double pPointsDeVie, int pPointsAttaque, TypeCanard pType, int pPointsEnergie) {
		super();
		nom = pNom;
		pointsDeVie = pPointsDeVie;
		POINTS_DE_VIE_MAX = pPointsDeVie;
		pointsAttaque = pPointsAttaque;
		type = pType;
		effets = new ArrayList<>();
		pointsEnergie = pPointsEnergie;
		POINTS_ENERGIE_MAX = pPointsEnergie;
	}

	public void attaquer(Canard pAutreCanard, TypeAttaque pTypeAttaque) {
		consommerEnergie(pTypeAttaque);
		switch (pTypeAttaque) {
		case NORMALE:
			double degat = TypeCanard.getMultiplicateur(type, pAutreCanard.getType()) * pointsAttaque;
			pAutreCanard.subirDegats(Math.random() < 0.1 ? degat * 2 : degat);
			break;

		case SPECIALE:
			attaquerSpeciale(pAutreCanard);
			break;

		default:
			break;
		}
	}
	
	public boolean peutAttaquer(TypeAttaque pTypeAttaque) {
		return pointsEnergie > pTypeAttaque.getCout();
	}
	
	public void consommerEnergie(TypeAttaque pTypeAttaque) {
		pointsEnergie -= pTypeAttaque.getCout();
	}
	
	/**
	 * Regenere de manière aleatoire les points d'energie ([0;POINTS_ENERGIE_MAX - pointsEnergie])
	 */
	public void regenererEnergie() {
		pointsEnergie += (int)(Math.random() * ((POINTS_ENERGIE_MAX - pointsEnergie) + 1));
	}
	
	public boolean appliquerEffets() {
		boolean peutJouer = true;
		for (int i = 0 ; i < effets.size() ; i++) {
			peutJouer &= effets.get(i).appliquerEffets(this);
			effets.get(i).decrementerDuree();
			if (!effets.get(i).estActif()) {
				effets.remove(effets.get(i));
				i--;
			}
		}
		return peutJouer;
	}
	
	public void subirDegats(double pDegats) {
		pointsDeVie -= pDegats;
	}

	public void regenererPointsDeVie(double pPointsDeVie) {
		if (pointsDeVie + pPointsDeVie > POINTS_DE_VIE_MAX) {
			pointsDeVie = POINTS_DE_VIE_MAX;
		} else {
			pointsDeVie += pPointsDeVie;
		}
	}
	
	public void ajouterEffet(EffetEtat pEffet) {
		effets.add(pEffet);
	}
	
	public abstract String getCaracteristiques();
	
	@Override
	public String toString() {
		return "Nom : " + getNom() + "\n" + "Nombre de points de vie : " + getPointsDeVie();
	}

	public boolean estKO() {
		return pointsDeVie <= 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public double getPointsDeVie() {
		return pointsDeVie;
	}
	
	public int getPointsAttaque() {
		return pointsAttaque;
	}
	
	public TypeCanard getType() {
		return type;
	}

	public List<EffetEtat> getEffets() {
		return effets;
	}

	public void setEffets(List<EffetEtat> pEffets) {
		effets = pEffets;
	}
}
