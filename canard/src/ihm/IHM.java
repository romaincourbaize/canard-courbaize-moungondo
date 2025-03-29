package ihm;

import java.util.Map;
import java.util.Scanner;

import canard.Canard;
import canard.TypeAttaque;
import canard.TypeCanard;
import factory.CanardFactory;
import factory.CanardFactoryImpl;
import jeu.Jeu;

public class IHM {
	
	private static final String MENU_PRINCIPAL = 
			"""
			----------------------
			1. Créer des canards
			2. Lancer une bataille
			3. Quitter
			----------------------
			""";
	
	private static final String MENU_CREER_CANARDS = 
			"""
			----------------------
			1. Créer un canard
			2. Retour
			----------------------
			""";
	
	private static String MENU_CHOIX_TYPE_CANARD;
	
	private static String MENU_CHOIX_TYPE_ATTAQUE;
	
	static {
		String tmp = "Type :\n";
		for (Map.Entry<String, TypeCanard> entry : TypeCanard.NOMS.entrySet()) {
			tmp += "- " + entry.getKey() + "\n";
		}
		MENU_CHOIX_TYPE_CANARD = tmp;
		
		tmp = "Type :\n";
		for (Map.Entry<String, TypeAttaque> entry : TypeAttaque.NOMS.entrySet()) {
			tmp += "- " + entry.getKey() + "\n";
		}
		MENU_CHOIX_TYPE_ATTAQUE = tmp;
	}
	
	private static final CanardFactory CANARD_FACTORY = new CanardFactoryImpl();
	
	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		lancerChoix();
	}

	private static void lancerChoix() {
		boolean start = true;
		Jeu jeu = null;
		do {
            System.out.print(MENU_PRINCIPAL);
            if (SCANNER.hasNextInt()) {
            	switch (SCANNER.nextInt()) {
				case 1:
					jeu = creerJeu();
					break;
				case 2:
					if (jeu != null) {
						lancerBataille(jeu);
					}
					jeu = null;
					break;
				case 3:
					start = false;
					break;
		
				default:
					break;
				}
			}
		} while (start);
		SCANNER.close();
	}
	
	private static void lancerBataille(Jeu pJeu) {
		while (!pJeu.estFini()) {
			if (pJeu.auTourDeCarnard1()) {
				System.out.println("Au tour du canard " + pJeu.getCanard1().getNom());
				System.out.println("----------------------\n" + pJeu.getCanard1().afficherEffets());
				if (pJeu.appliquerEffets()) {
					System.out.println("----------------------\n" + pJeu.getCanard2());
					choisirCoupCanard(pJeu, pJeu.getCanard1());
				} else {
					System.out.println("\nLe canard " + pJeu.getCanard1().getNom() + " ne peut pas jouer");
				}
			} else {
				System.out.println("Au tour du canard " + pJeu.getCanard2().getNom());
				System.out.println("----------------------\n" + pJeu.getCanard2().afficherEffets());
				if (pJeu.appliquerEffets()) {
					System.out.println("----------------------\n" + pJeu.getCanard1());
					choisirCoupCanard(pJeu, pJeu.getCanard2());
				} else {
					System.out.println("\nLe canard " + pJeu.getCanard2().getNom() + " ne peut pas jouer");
				}
			}
		}
		System.out.println(pJeu);
	}

	private static void choisirCoupCanard(Jeu pJeu, Canard pCanard) {
		System.out.println("----------------------\n" + pCanard.getCaracteristiques() + "\n----------------------");
		System.out.println(MENU_CHOIX_TYPE_ATTAQUE);
		String type = "";
		do {
			type = SCANNER.next();
		} while (!TypeAttaque.NOMS.containsKey(type));
		pJeu.jouer(pCanard, TypeAttaque.fromString(type));
	}

	private static Jeu creerJeu() {
		
		System.out.println("----------------------\nCaractéristiques du canard n°1\n----------------------");
		Canard canard1 = creerCanard();
		System.out.println("----------------------\nCaractéristiques du canard n°2\n----------------------");
		Canard canard2 = creerCanard();
		
		return new Jeu(canard1, canard2);
	}
	
	private static Canard creerCanard() {
		System.out.print("Nom : ");
		String nom = SCANNER.next();
		
		System.out.println(MENU_CHOIX_TYPE_CANARD);
		String type = "";
		do {
			type = SCANNER.next();
		} while (!TypeCanard.NOMS.containsKey(type));
		
		double pointsDeVie = -1;
		do {
			System.out.print("Nombre de points de vie : ");
			if (SCANNER.hasNextDouble()) {
				pointsDeVie = SCANNER.nextDouble();
			}
		} while (pointsDeVie < 0);
		
		int pointsAttaque = -1;
		do {
			System.out.print("Nombre de points d'attaque : ");
			if (SCANNER.hasNextInt()) {
				pointsAttaque = SCANNER.nextInt();
			}
		} while (pointsAttaque < 0);
		
		return CANARD_FACTORY.creerCanard(nom, pointsDeVie, pointsAttaque, TypeCanard.fromString(type));
	}
}
