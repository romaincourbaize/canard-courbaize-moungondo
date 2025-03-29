package canard.etat;

import canard.Canard;

public class EtatGele extends EffetEtat {
	
	public EtatGele() {
		super(1);
	}

	@Override
	public boolean appliquerEffets(Canard pCanard) {
		if (!estActif()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "EtatGele (Ne peut pas jouer)";
	}
}
