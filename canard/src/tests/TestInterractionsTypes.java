package tests;

import canard.CanardEau;
import canard.CanardFeu;
import canard.CanardGlace;
import canard.CanardVent;
import canard.TypeAttaque;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestInterractionsTypes {

    @Test
    void testEauVsFeu() {
        CanardEau canardEau = new CanardEau("Canard Eau", 100, 20);
        CanardFeu canardFeu = new CanardFeu("Canard Feu", 100, 20);

        double pointsDeVieAvant = canardFeu.getPointsDeVie();
        canardEau.attaquer(canardFeu, TypeAttaque.NORMALE);

        assertTrue(canardFeu.getPointsDeVie() < pointsDeVieAvant);
    }

    @Test
    void testFeuVsGlace() {
        CanardFeu canardFeu = new CanardFeu("Canard Feu", 100, 20);
        CanardGlace canardGlace = new CanardGlace("Canard Glace", 100, 20);

        double pointsDeVieAvant = canardGlace.getPointsDeVie();
        canardFeu.attaquer(canardGlace, TypeAttaque.NORMALE);

        assertTrue(canardGlace.getPointsDeVie() < pointsDeVieAvant);
    }

    @Test
    void testGlaceVsVent() {
        CanardGlace canardGlace = new CanardGlace("Canard Glace", 100, 20);
        CanardVent canardVent = new CanardVent("Canard Vent", 100, 20);

        double pointsDeVieAvant = canardVent.getPointsDeVie();
        canardGlace.attaquer(canardVent, TypeAttaque.NORMALE);

        assertTrue(canardVent.getPointsDeVie() < pointsDeVieAvant);
    }

    @Test
    void testVentVsEau() {
        CanardVent canardVent = new CanardVent("Canard Vent", 100, 20);
        CanardEau canardEau = new CanardEau("Canard Eau", 100, 20);

        double pointsDeVieAvant = canardEau.getPointsDeVie();
        canardVent.attaquer(canardEau, TypeAttaque.NORMALE);

        assertTrue(canardEau.getPointsDeVie() < pointsDeVieAvant);
    }
}
