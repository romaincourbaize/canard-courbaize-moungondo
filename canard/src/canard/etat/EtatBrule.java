package canard.etat;

import canard.Canard;

public class EtatBrule extends EffetEtat {
	
	private int degat;

	public EtatBrule(int pDegat) {
		super(-1);
		degat = pDegat;
	}

	@Override
	public boolean appliquerEffets(Canard pCanard) {
		if (!estActif()) {
			return true;
		}
		pCanard.subirDegats(degat);
		return true;
	}

	@Override
	public String toString() {
		return "EtatBrule [degat=" + degat + "]";
	}
}
