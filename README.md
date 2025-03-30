Alberto MOUNGONDO & Romain COURBAIZE

# 1. Quelles classes pourraient être abstraites ?
La classe Canard pourrait être une classe abstraite, car elle définit des comportements communs (attaquer, subir des dégâts) mais ne devrait pas être instanciée directement.
# 2. Quels comportements communs pourraient être définis dans une interface ?
Une interface CapaciteSpeciale pourrait être créée pour définir la méthode d'attaque spéciale (chaque canard en a une différente). Elle a un défaut pour consommer l'énergie.
# 3. Comment représenter un changement de statut (par exemple, brûlé ou paralysé) dans la modélisation ?
Une classe abstraite Statut pourrait permettre de gérer les statuts. Chaque statut pourrait être une sous-classe concrète de Statut, ce qui permettrait de gérer leurs effets sans modifier le code du jeu.
Une méthode appliquerEffets() pourrait être ajoutée à la classe Canard pour gérer ces états. 
# 4. Quels seraient les avantages d’utiliser une classe ou une interface supplémentaire pour gérer les capacités spéciales ?
Une interface CapaciteSpeciale permettrait de séparer la logique des capacités spéciales du comportement de base des canards. Cela faciliterait l’ajout de nouvelles capacités sans modifier les classes existantes.
# 5. Quels défis sont associés à l’extensibilité de votre modèle pour ajouter de nouveaux types de canards ou de nouvelles capacités ?
Gestion des interactions entre types : Ajouter un nouveau type nécessiterait de mettre à jour la logique des forces/faiblesses. 

# Liste des réalisation bonus
- Gestion avancée des combats
- Personnalisation et progression (Création de canards personnalisés)

# Diagramme UML
![diagram](https://github.com/user-attachments/assets/6b3ebc85-fb93-49e4-af37-618d11021f8c)
