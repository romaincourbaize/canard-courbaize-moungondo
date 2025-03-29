package jeu;

import canard.Canard;
import canard.TypeAttaque;

public class Jeu {
	private Canard canard1;
	
	private Canard canard2;
	
	private boolean auTourDe1;
	
	private boolean estFini;

	public Jeu(Canard pCanard1, Canard pCanard2) {
		super();
		estFini = false;
		auTourDe1 = true;
		canard1 = pCanard1;
		canard2 = pCanard2;
	}
	
	public void jouer(Canard pCanard, TypeAttaque pTypeAttaque) {
		if (estFini) {
			throw new IllegalStateException("Le jeu est terminé");
		}
		
		Canard attaquant = auTourDe1 ? canard1 : canard2;
		Canard defenseur = auTourDe1 ? canard2 : canard1;
		
		if (!pCanard.equals(attaquant)) {
			throw new IllegalArgumentException("Ce n'est pas à son tour");
		}
		
		switch (pTypeAttaque) {
		case NORMALE:
			attaquant.attaquer(defenseur);
			break;
		case SPECIALE:
			attaquant.attaquerSpeciale(defenseur);
			break;
		}
		
		auTourDe1 = !auTourDe1;
		
		if (defenseur.estKO()) {
			estFini = true;
		}
	}
	
	/**
	 * Applique les effets pour le canard qui doit jouer
	 * @return true s'il peut jouer, false sinon
	 */
	public boolean appliquerEffets() {
		Canard attaquant = auTourDe1 ? canard1 : canard2;
		if (!attaquant.appliquerEffets()) {
			auTourDe1 = !auTourDe1;
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		String s = "----------------------\n";
		if (estFini) {
			s += "Le jeu est terminé\nCanard " + (canard1.estKO() ? canard2.getNom() : canard1.getNom()) + " a gagner";
		} else {
			s += "Le jeu est en cours";
		}
		s += "\n----------------------\nCaractéristiques des canards\n----------------------\n";
		s += canard1.getCaracteristiques();
		s += "\n----------------------\n";
		s += canard2.getCaracteristiques();
		s += "\n----------------------\n";
		return s;
	}

	public Canard getCanard1() {
		return canard1;
	}

	public Canard getCanard2() {
		return canard2;
	}

	public boolean auTourDeCarnard1() {
		return auTourDe1;
	}
	
	public boolean estFini() {
		return estFini;
	}
}
