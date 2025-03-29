package factory;

import canard.Canard;
import canard.CanardEau;
import canard.CanardFeu;
import canard.CanardGlace;
import canard.CanardVent;
import canard.TypeCanard;

public class CanardFactoryImpl implements CanardFactory {

	@Override
	public Canard creerCanard(String pNom, double pPointsDeVie, int pPointsAttaque, TypeCanard pType) {
		switch (pType) {
		case EAU:
			return new CanardEau(pNom, pPointsDeVie, pPointsAttaque);
		case VENT:
			return new CanardVent(pNom, pPointsDeVie, pPointsAttaque);
		case FEU:
			return new CanardFeu(pNom, pPointsDeVie, pPointsAttaque);
		case GLACE:
			return new CanardGlace(pNom, pPointsDeVie, pPointsAttaque);
		default:
			break;
		}
		return null;
	}
}
