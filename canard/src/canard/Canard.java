package canard;

import java.util.ArrayList;
import java.util.List;

import canard.etat.EffetEtat;

public abstract class Canard implements CapaciteSpeciale {

	private String nom;
	
	private double pointsDeVie;
	
	private int pointsAttaque;
	
	private TypeCanard type;
	
	private List<EffetEtat> effets;
	
	public Canard(String pNom, double pPointsDeVie, int pPointsAttaque, TypeCanard pType) {
		super();
		nom = pNom;
		pointsDeVie = pPointsDeVie;
		pointsAttaque = pPointsAttaque;
		type = pType;
		effets = new ArrayList<>();
	}

	public void attaquer(Canard pAutreCanard) {
		pAutreCanard.subirDegats(TypeCanard.getMultiplicateur(type, pAutreCanard.getType()) * pointsAttaque);
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
	
	public String afficherEffets() {
		String s = "";
		for (EffetEtat effet : effets) {
			s += effet;
		}
		return s;
	}
	
	public void subirDegats(double pDegats) {
		pointsDeVie -= pDegats;
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

	void setPointsDeVie(double pPointsDeVie) {
		pointsDeVie = pPointsDeVie;
	}
}
