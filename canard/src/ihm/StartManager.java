package ihm;

import java.util.Scanner;

import canard.Canard;
import canard.TypeCanard;
import factory.CanardFactory;
import factory.CanardFactoryImpl;

public class StartManager {
	
	private static final String MENU_PRINCIPAL = 
			"""
			----------------------
			1. Créer des canards
			2. Lancer une bataille
			3. Quitter
			----------------------
			""";
	
	private static String MENU_CHOIX_TYPE_CANARD;
	
	private static CanardFactory canardFactory = new CanardFactoryImpl();
	
	static {
		String tmp = "Type canard :\n";
		for (int i = 0 ; i < TypeCanard.values().length ; i++) {
			tmp += (i + 1) + ". " + TypeCanard.values()[i] + "\n";
		}
		tmp += "Choix : ";
		MENU_CHOIX_TYPE_CANARD = tmp;
	}
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== CANARD FIGHTER SIMULATOR ===");
        
		boolean start = true;
		CombatManager combat = null;
		
		do {
            System.out.print(MENU_PRINCIPAL);
            
            if (scanner.hasNextInt()) {
            	
            	switch (scanner.nextInt()) {
            	
				case 1:
					combat = creerCombat();
					break;
					
				case 2:
					if (combat != null) {
						combat.demarrerCombat();
					}
					combat = null;
					break;
					
				case 3:
					start = false;
					break;
		
				default:
					break;
				}
			}
		} while (start);
        
        scanner.close();
    }
    
    private static CombatManager creerCombat() {
        return new CombatManager(choisirCanard("1"), choisirCanard("2"));
    }
    
    private static Canard choisirCanard(String pNumero) {
        System.out.println("\nCréation du canard " + pNumero + ":");
        
        System.out.print("Entrez le nom du canard: ");
        String nom = scanner.next();
        
        TypeCanard type = choisirType();
        
		double pointsDeVie = -1;
		do {
			System.out.print("Nombre de points de vie : ");
			if (scanner.hasNextDouble()) {
				pointsDeVie = scanner.nextDouble();
			}
		} while (pointsDeVie < 0);
		
		int pointsAttaque = -1;
		do {
			System.out.print("Nombre de points d'attaque : ");
			if (scanner.hasNextInt()) {
				pointsAttaque = scanner.nextInt();
			}
		} while (pointsAttaque < 0);
        
        return canardFactory.creerCanard(nom, pointsDeVie, pointsAttaque, type);
    }
    
    private static TypeCanard choisirType() {
        System.out.println(MENU_CHOIX_TYPE_CANARD);
    	int choix = -1;
		do {
			if (scanner.hasNextInt()) {
				choix = scanner.nextInt();
			}
		} while (choix < 1 || TypeCanard.values().length < choix);
        
        return TypeCanard.values()[choix - 1];
    }
}