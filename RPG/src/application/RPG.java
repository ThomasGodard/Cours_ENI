package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import beans.Archer;
import beans.Guerrier;
import beans.Monstre;
import beans.Personnage;
import beans.Soigneur;
import enums.Soins;

public class RPG {
	static Random rand = new Random();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Monstre monstre = new Monstre();
		Archer archer = new Archer();
		Guerrier guerrier = new Guerrier();
		Soigneur soigneur = new Soigneur();
		
		List<Personnage> personnages = new ArrayList<Personnage>();
		personnages.add(monstre);
		personnages.add(archer);
		personnages.add(guerrier);
		personnages.add(soigneur);
		
		boolean finDePartie = false;
		String joueur;
		int tour = 0;
		do {
			for(Personnage personnage : personnages){
			
			// AFFICHAGE //
			System.out.println("------------------------------------------");
			System.out.println("Archer :");
			System.out.println(archer.getPv() + "/" + archer.getPvTotal());
			System.out.println("Guerrier :                   Monstre :");
			System.out.println(guerrier.getPv() + "/" + guerrier.getPvTotal() + "                      " + monstre.getPv() + "/" + monstre.getPvTotal());
			System.out.println("Soigneur :");
			System.out.println(soigneur.getPv() + "/" + soigneur.getPvTotal());
			System.out.println("------------------------------------------");
			// FIN AFFICHAGE //
			
			joueur = personnage.getClass().getSimpleName();
			System.out.println(joueur + " joue.");
				switch (joueur) {
					case "Monstre":
						monstreJoue(personnages);
						break;
					case "Archer":
						joueurJoue(archer, personnages);
						break;
					case "Guerrier":
						joueurJoue(guerrier, personnages);
						break;
					case "Soigneur":
						joueurJoue(soigneur, personnages);
						break;
					}
			}
			tour++;
		}while(tour < 5);
		
	}

	private static void monstreJoue(List<Personnage> personnages) {
		Monstre monstre = (Monstre) personnages.get(0);
		int max = personnages.size();
		int random = rand.nextInt(2);
		
		if(random == 0) {
			random = rand.nextInt(max-1) + 1;
			switch (random) {
			case 1:
				monstre.attaqueCible(personnages.get(1));
				System.out.println("Monstre attaque " + personnages.get(1).getClass().getSimpleName());
				break;
			case 2:
				monstre.attaqueCible(personnages.get(2));
				System.out.println("Monstre attaque " + personnages.get(2).getClass().getSimpleName());
				break;
			case 3:
				monstre.attaqueCible(personnages.get(3));
				System.out.println("Monstre attaque " + personnages.get(3).getClass().getSimpleName());
				break;
			}		
		} else {
			monstre.attaqueZone(personnages);
			System.out.println("Monstre Attaque de zone.");
		}
	}
	
	private static void joueurJoue(Personnage personnage, List<Personnage> personnages) {
		int option = 0;
		if(personnage instanceof Archer) {
				System.out.println("1-/ Attaque sur monstre");
				System.out.println("2-/ Attaque de zone");
				do {
					if(sc.hasNextInt()) {
						option = sc.nextInt();
					} else {
						System.out.println("choisir entre 1 et 2");
					}
				}while(option != 1 && option != 2);
				
				switch (option) {
					case 1 :
						((Archer) personnage).attaqueCible(personnages.get(0));
						break;
					case 2 : 
						((Archer) personnage).attaqueZone(personnages);
						break;
					}
				
		} else if (personnage instanceof Guerrier) {	
				System.out.println("1-/ Attaque sur monstre");
				System.out.println("2-/ Attaque sur monstre avec saignement");
				do {
					if(sc.hasNextInt()) {
						option = sc.nextInt();
					} else {
						System.out.println("choisir entre 1 et 2");
					}
				}while(option != 1 && option != 2);
				
				switch (option) {
					case 1 :
						((Guerrier) personnage).attaqueCible(personnages.get(0));
						break;
					case 2 : 
						((Guerrier) personnage).attaqueCibleDST(personnages.get(0));
						break;
					}
				
		} else if (personnage instanceof Soigneur) {
				System.out.println("1-/ Attaque sur monstre");
				System.out.println("2-/ Soin sur équipier");
				System.out.println("3-/ Soin sur toute l'équipe");
				do {
					if(sc.hasNextInt()) {
						option = sc.nextInt();
					} else {
						System.out.println("choisir entre 1 et 3");
					}
				}while(option < 1 || option > 3);
				
				switch (option) {
					case 1 :
						((Soigneur) personnage).attaqueCible(personnages.get(0));
						break;
					case 2 : 
						((Soigneur) personnage).soigneCible(personnage);
						break;
					case 3 :
						((Soigneur) personnage).soigneZone(personnages);
						break;
				}
		}
	}
}
