package factory;

import canard.Canard;
import canard.TypeCanard;

public interface CanardFactory {

	public Canard creerCanard(String pNom, double pPointsDeVie, int pPointsAttaque, TypeCanard pType);
}
