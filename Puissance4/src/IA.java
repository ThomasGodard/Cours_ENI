
public class IA {
	
	public void IAJoue(char grille[][], int profondeur) {
		int max = -10000;
		int tmp, jMax = 0, iMax = 0, pionJoue;
		int j;
		
		for (j = 0; j < grille[0].length; j++) {
			pionJoue = Puissance4.coupValide(j);
			if(pionJoue >= 0) {
				grille[pionJoue][j] = Puissance4.JOUEUR_2;
				tmp = min(grille, profondeur-1);
				
				if (tmp > max) {
					max = tmp;
					iMax = pionJoue;
					jMax = j;
				}
				
				grille[pionJoue][j] = Puissance4.VIDE;
			}
		}
		
		grille[iMax][jMax] = Puissance4.JOUEUR_2;
	}
	
	public int max(char grille[][], int profondeur) {
		if(profondeur == 0 || gagnant(grille) != 0) {
			return eval(grille);
		}
		
		int max = -10000;
		int j, pionJoue, tmp;
		
		for (j = 0; j < grille[0].length; j++) {
			pionJoue = Puissance4.coupValide(j);
			if(pionJoue >= 0) {
				grille[pionJoue][j] = Puissance4.JOUEUR_1;
				tmp = min(grille, profondeur-1);
				
				if (tmp > max) {
					max = tmp;
				}
				
				grille[pionJoue][j] = Puissance4.VIDE;
			}
		}
		
		return max;
	}
	
	public int min(char grille[][], int profondeur) {
		if(profondeur == 0 || gagnant(grille) != 0) {
			return eval(grille);
		}
		
		int min = 10000;
		int j, pionJoue, tmp;
		for (j = 0; j < grille[0].length; j++) {
			pionJoue = Puissance4.coupValide(j);
			if(pionJoue >= 0) {
				grille[pionJoue][j] = Puissance4.JOUEUR_2;
				tmp = max(grille, profondeur-1);
				
				if(tmp < min) {
					min = tmp;
				}
				grille[pionJoue][j] = Puissance4.VIDE;
			}
		}
		
		return min;
	}
	
	public int eval(char grille[][]) {
		int vainqueur, nbPion = 0;
		
		return 0;
	}
	
//	private static int[] pointColonne(char grille[][], int tailleAlign) {
//		int cptJ1 = 0;
//		int cptJ2 = 0;
//		char joueur;
//		int i = Puissance4.HAUTEUR_GRILLE;
//		
//		for(int j = 0; j < grille[0].length; j++) {
//			while(i-1 < Puissance4.HAUTEUR_GRILLE && grille[i+1][j] == joueur) {
//				cpt++;
//				i--;
//			}
//			
//			i = coordonneeJoue[0];
//			
//			while(i-1 >= 0 && cpt < 4 && grille[i-1][j] == joueur) {
//				cpt++;
//				j--;
//			}
//		}
//		return cpt == 4;
//	}
	
	public int gagnant(char grille[][]) {
		return 0;
	}
}
