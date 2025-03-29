package canard.etat;

import java.util.Random;

import canard.Canard;

public class EtatParalyse extends EffetEtat {
	
	private static Random RANDOM = new Random();
	
	public EtatParalyse() {
		super(-1);
	}

	@Override
	public boolean appliquerEffets(Canard pCanard) {
		if (!estActif()) {
			return true;
		}
		return RANDOM.nextBoolean();
	}

	@Override
	public String toString() {
		return "EtatParalyse (Ne peut jouer que 50% du temps)";
	}
}
