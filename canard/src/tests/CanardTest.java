package tests;

import canard.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CanardTest {

    @Test
    void testAttaquer() {
        Canard canardEau = new CanardEau("CanardEau", 100, 10);
        Canard canardFeu = new CanardFeu("CanardFeu", 100, 10);

        canardEau.attaquer(canardFeu, TypeAttaque.NORMALE);

        assertTrue(canardFeu.getPointsDeVie() < 100, "Les points de vie du canardFeu n'ont pas diminué correctement.");
    }

    @Test
    void testAttaquerSpeciale() {
        Canard canardEau = new CanardEau("CanardEau", 100, 10);
        Canard canardFeu = new CanardFeu("CanardFeu", 100, 10);
        canardFeu.attaquerSpeciale(canardEau);
        assertEquals(85, canardEau.getPointsDeVie());
        canardEau.attaquerSpeciale(canardFeu);

        assertEquals(100,canardEau.getPointsDeVie() ,"Les points de vie du canardEau n'ont pas été régénérés.");
    }

    @Test
    void testToString() {
        Canard canardFeu = new CanardFeu("CanardFeu", 100, 10);

        String caracteristiques = canardFeu.toString();
        assertTrue(caracteristiques.contains("Nom : CanardFeu"), "Le nom du canard n'est pas correct.");
        assertTrue(caracteristiques.contains("Attaque spéciale : 10.0 supplémentaire"), "Les caractéristiques de l'attaque spéciale ne sont pas correctes.");
    }

    @Test
    void testEstKO() {
        Canard canardFeu = new CanardFeu("CanardFeu", 50, 10);

        canardFeu.subirDegats(50);
        assertTrue(canardFeu.estKO(), "Le canardFeu ne devrait pas être KO.");

        canardFeu.subirDegats(10);
        assertTrue(canardFeu.estKO(), "Le canardFeu devrait rester KO.");
    }

    @Test
    void testSubirDegats() {
        Canard canardFeu = new CanardFeu("CanardFeu", 100, 10);

        double pointsDeVieAvant = canardFeu.getPointsDeVie();
        canardFeu.subirDegats(10);

        assertTrue(canardFeu.getPointsDeVie() == pointsDeVieAvant - 10, "Les points de vie n'ont pas diminué correctement.");
    }

    @Test
    void testRegenererPointsDeVie() {
        Canard canardEau = new CanardEau("CanardEau", 50, 10);


        canardEau.regenererPointsDeVie(30);
        assertTrue(canardEau.getPointsDeVie() <= 50, "Les points de vie ne doivent pas dépasser le maximum.");
        canardEau.subirDegats(20);
        double pointsDeVieAvant = canardEau.getPointsDeVie();
        canardEau.regenererPointsDeVie(10);
        assertTrue(canardEau.getPointsDeVie() > pointsDeVieAvant, "Les points de vie n'ont pas été régénérés correctement.");
    }
}
