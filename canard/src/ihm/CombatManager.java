package ihm;

import java.util.Scanner;

import canard.Canard;
import canard.TypeAttaque;

/**
 * Gere le déroulement d'un combat
 */
public class CombatManager {
	
	private static String MENU_CHOIX_TYPE_ATTAQUE;
	
	static {
		String tmp = "\nAttaque :\n";
		for (int i = 0 ; i < TypeAttaque.values().length ; i++) {
			tmp += (i + 1) + ". " + TypeAttaque.values()[i] + "\n";
		}
		tmp += "Choix : ";
		MENU_CHOIX_TYPE_ATTAQUE = tmp;
	}
	
    private final Canard joueur;
    private final Canard adversaire;
    private final Scanner scanner;
    
    public CombatManager(Canard joueur, Canard adversaire) {
        this.joueur = joueur;
        this.adversaire = adversaire;
        this.scanner = new Scanner(System.in);
    }
    
    public void demarrerCombat() {
        System.out.println("Début du combat !");
        System.out.println(joueur.getNom() + " vs " + adversaire.getNom());
        
        while (!joueur.estKO() && !adversaire.estKO()) {
            tourDeCombat(joueur, adversaire);
            if (!adversaire.estKO()) {
                tourDeCombat(adversaire, joueur);
            }
        }
        
        afficherResultat();
    }
    
    private void tourDeCombat(Canard attaquant, Canard defenseur) {
        System.out.println("\n--- Tour de " + attaquant.getNom() + " ---");
        afficherStatuts(attaquant, defenseur);
        
        attaquant.regenererEnergie();
        boolean peutAgir = attaquant.appliquerEffets();
        
        if (peutAgir && !attaquant.estKO()) {
            executerAction(attaquant, defenseur);
        }
        
    }
    
    private void executerAction(Canard attaquant, Canard defenseur) {
        System.out.println(MENU_CHOIX_TYPE_ATTAQUE);
    	int choix = -1;
		do {
			if (scanner.hasNextInt()) {
				choix = scanner.nextInt();
			}
		} while (choix < 1 || TypeAttaque.values().length < choix);
        
		if (attaquant.peutAttaquer(TypeAttaque.values()[choix - 1])) {
			attaquant.attaquer(defenseur, TypeAttaque.values()[choix - 1]);
		} else {
			System.out.println("Pas assez d'énergie !");
		}
    }
    
    private void afficherStatuts(Canard canard1, Canard canard2) {
        System.out.println("\nStatut :");
        System.out.println(canard1);
        afficherEffets(canard1);
        System.out.println(canard2);
        afficherEffets(canard2);
    }
    
    private void afficherEffets(Canard canard) {
        if (!canard.getEffets().isEmpty()) {
            System.out.println("Effets actifs :");
            canard.getEffets().forEach(System.out::println);
        }
    }
    
    private void afficherResultat() {
        System.out.println("\n--- Combat terminé ---");
        if (joueur.estKO() && adversaire.estKO()) {
            System.out.println("Egalité !");
        } else if (joueur.estKO()) {
            System.out.println(adversaire.getNom() + " gagne !");
        } else {
            System.out.println(joueur.getNom() + " gagne !");
        }
    }
}