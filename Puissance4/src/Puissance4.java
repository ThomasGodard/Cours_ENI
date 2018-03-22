import java.util.Scanner;

public class Puissance4 {
	static final int HAUTEUR_GRILLE = 6;
	static final int LONGUEUR_GRILLE = 7;
	static final int NB_MODE = 2;
	static final char JOUEUR_1 = 'X';
	static final char JOUEUR_2 = 'O';
	static final char VIDE = ' ';
	static char grille[][] = new char[HAUTEUR_GRILLE][LONGUEUR_GRILLE];
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int mode;
		afficherTitre();
		do {
			afficherMenu();
			mode = saisir(NB_MODE);
			initGrille();
			switch (mode) {
			case 0:
				jouerCJoueur();
				break;
			case 2:
				joueurCOrdi();
				break;
			}
			affichageFinPartie();				
		}while (rejouer());
		
		System.out.println("C'etait sympa ! à bientôt ;)");
	}

	


	private static void joueurCOrdi() {
		System.out.println("/!\\ mode de jeu actuellement en traveaux /!\\");
	}




	private static void jouerCJoueur() {
		String nomJoueur1;
		String nomJoueur2;
		boolean gagne;
		char joueurActif = '*';
		int nbCoup = 0;
		int coordonneeJoue[] = new int[2];
		
		System.out.println("Nom du joueur 1 :");
		nomJoueur1=sc.nextLine();
		if(nomJoueur1.trim().isEmpty()) {
			nomJoueur1 = "Joueur 1";
		}
		
		System.out.println("Nom du joueur 2 :");
		nomJoueur2=sc.nextLine();
		if(nomJoueur2.trim().isEmpty()) {
			nomJoueur2 = "Joueur 2";
		}
		
		afficherGrille();
		
		do {
			joueurActif = selectionJoueur(joueurActif, nomJoueur1, nomJoueur2);
			
			if(joueurActif == JOUEUR_1) {
				System.out.println(nomJoueur1+ " joue (X).");
			} else {
				System.out.println(nomJoueur2+ " joue (O).");
			}
			
			coordonneeJoue = placeUnPion(joueurActif);
			nbCoup++;
			afficherGrille();
			gagne = victoire(coordonneeJoue, joueurActif);
			
		}while(!gagne && nbCoup < 42);
		
		if (gagne && joueurActif == JOUEUR_1) {
			System.out.println("Vainqueur "+ nomJoueur1);
		} else if (gagne && joueurActif == JOUEUR_2) {
			System.out.println("Vainqueur "+ nomJoueur2);
		} else {
			System.out.println("Egalité !");
		}
	}


	private static boolean rejouer() {
		int choix = saisir(2);
		
		return (choix == 0 ? true : false);
	}


	 private static void affichageFinPartie() {
		 System.out.println("Souhaitez vous rejouer ?");
		 System.out.println("\t1 - Oui");
		 System.out.println("\t2 - Non");
	}


	private static boolean victoire(int[] coordonneeJoue, char joueurActif) {
		 
		return testLigne(coordonneeJoue, joueurActif) || testColonne(coordonneeJoue, joueurActif) || testDiagDroite(coordonneeJoue, joueurActif) || testDiagGauche(coordonneeJoue, joueurActif);
	}


	private static boolean testDiagDroite(int[] coordonneeJoue, char joueurActif) {
		int i = coordonneeJoue[0];
		int j = coordonneeJoue[1];
		int cpt = 1;
		
		while(i+1 < HAUTEUR_GRILLE && j+1 < LONGUEUR_GRILLE && cpt < 4 && grille[i+1][j+1] == joueurActif) {
			cpt++;
			i++;
			j++;
		}
		
		i = coordonneeJoue[0];
		j = coordonneeJoue[1];
		
		while(i-1 >= 0 && j-1 >= 0 && cpt < 4 && grille[i-1][j-1] == joueurActif) {
			cpt++;
			i--;
			j--;		
		}
		
		return cpt == 4;
	}
	
	private static boolean testDiagGauche(int[] coordonneeJoue, char joueurActif) {
		int i = coordonneeJoue[0];
		int j = coordonneeJoue[1];
		int cpt = 1;
		
		while(i-1 >= 0 && j+1 < LONGUEUR_GRILLE && cpt < 4 && grille[i-1][j+1] == joueurActif) {
			cpt++;
			i--;
			j++;
		}
		
		i = coordonneeJoue[0];
		j = coordonneeJoue[1];
		
		while(i+1 < HAUTEUR_GRILLE && j-1 >= 0 && cpt < 4 && grille[i+1][j-1] == joueurActif) {
			cpt++;
			i++;
			j--;		
		}
		
		return cpt == 4;
	}


	private static boolean testColonne(int[] coordonneeJoue, char joueurActif) {
		int i = coordonneeJoue[0];
		int j = coordonneeJoue[1];
		int cpt = 1;
		
		while(i+1 < HAUTEUR_GRILLE && cpt < 4 && grille[i+1][j] == joueurActif) {
			cpt++;
			i++;
		}
		
		i = coordonneeJoue[0];
		
		while(i-1 >= 0 && cpt < 4 && grille[i-1][j] == joueurActif) {
			cpt++;
			j--;
		}
		
		return cpt == 4;
	}


	private static boolean testLigne(int[] coordonneeJoue, char joueurActif) {
		int i = coordonneeJoue[0];
		int j = coordonneeJoue[1];
		int cpt = 1;
		
		while(j+1 < LONGUEUR_GRILLE && cpt < 4 && grille[i][j+1] == joueurActif) {
			cpt++;
			j++;
		}
		
		j = coordonneeJoue[1];
		
		while(j-1 >= 0 && cpt < 4 && grille[i][j-1] == joueurActif) {
			cpt++;
			j--;
		}
		
		return cpt == 4;
	}


	public static int[] placeUnPion(char joueurActif) {
		 int colonneSaisie;
		 int coordonneeJoue[] = new int[2];
		 int pionJoue;
		 do {
			 System.out.println("Dans quelles colonne souhaitez-vous placer votre pion ?");
			 colonneSaisie = saisir(LONGUEUR_GRILLE);
			 pionJoue = coupValide(colonneSaisie);
			 if(pionJoue < 0) {
				 System.out.println("Cette colonne est pleine, veuillez en selectionner une autre.");
			 } 
		 }while(pionJoue < 0);
		 
		 grille[pionJoue][colonneSaisie] = joueurActif;
		 
		 coordonneeJoue[0] = pionJoue;
		 coordonneeJoue[1] = colonneSaisie;
		 
		 return coordonneeJoue;
	}


	static int coupValide(int colonneSaisie) {
		for (int i = grille.length-1; i >= 0; i--) {
			if (grille[i][colonneSaisie] == ' ') {
				return i;
			}
		}
		
		return - 1;
	}


	private static char selectionJoueur(char joueurActif, String nomJoueur1, String nomJoueur2) {
		switch (joueurActif) {
			case JOUEUR_1:
				return JOUEUR_2;
			case JOUEUR_2:
				return JOUEUR_1;
			default:
				if(Math.random()*100 >= 50) {
					return JOUEUR_1;
				} else {
					return JOUEUR_2;					
				}
		}
	}


	private static void afficherTitre() {
		System.out.println("    #######################################");
		System.out.println("    #                                     #");
		System.out.println("    #             PUISSANCE 4             #");
		System.out.println("    #                                     #");
		System.out.println("    #######################################");
	} 
	
	private static void afficherMenu() {
		System.out.println();
		System.out.println("Choisissez un mode de jeu :");
		System.out.println("\t1 - Joueur VS Joueur");
		System.out.println("\t2 - Joueur VS Ordi");
	}
	
	private static void initGrille() {
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				grille[i][j] = ' ';
			}
		}
	}
	
	private static void afficherGrille() {
		System.out.println();
		for (int i = 0; i < grille.length; i++) {
			System.out.print("\t");
			for (int j = 0; j < grille[i].length; j++) {
				System.out.print("|"+grille[i][j]);
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("\t~1~2~3~4~5~6~7~");
	}
	
	private static int saisir(int nbChoix) {
		boolean saisieOK;
		String saisie;
		int saisieEnInt;
		
		do {
			saisie = sc.nextLine();
			try {
				saisieEnInt = Integer.parseInt(saisie);
			} catch (NumberFormatException e) {
				saisieEnInt = nbChoix + 1;
			}
			
			if(saisieEnInt < 1 || saisieEnInt > nbChoix) {
				System.out.println("Vous devez entrer un chiffre entre 1 et " +nbChoix+ ".");
				saisieOK = false;
			} else {
				saisieOK = true;
			}
			
		}while(!saisieOK);
		return saisieEnInt-1;
	}


}
