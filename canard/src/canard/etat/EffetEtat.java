package canard.etat;

import canard.Canard;

public abstract class EffetEtat {

	private int duree;
	
	public EffetEtat(int pDuree) {
		duree = pDuree;
	}
	
	public boolean estActif() {
		return duree > 0;
	}
	
	public void decrementerDuree() {
		duree--;
	}
	
	/**
	 * Applique les effets sur le canard. 
	 * @param pCanard Canard sur lequel sont appliqués les effets
	 * @return true, si il peut jouer, false sinon
	 */
	public abstract boolean appliquerEffets(Canard pCanard);

	@Override
	public abstract String toString();
}
