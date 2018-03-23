/**
 * 
 */
package application;

import java.util.GregorianCalendar;
import java.util.Scanner;

import fr.eni.centreculturel.model.Auteur;
import fr.eni.centreculturel.model.Catalogue;
import fr.eni.centreculturel.model.Cd;
import fr.eni.centreculturel.model.Editeur;
import fr.eni.centreculturel.model.Livre;
import fr.eni.centreculturel.model.Produit;

/**
 * @author bmartin
 *
 */
public class ModuleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//A vous de constituer votre module de test afin d'obtenir le résultats attendus
		
		//creation de 2,3 auteurs
		//TODO Votre code ici...
		
		
		System.out.println("** Les auteurs");
		System.out.println("**************");
		//TODO Votre code ici...
		
		
		//creation de 2,3 editeurs
		//TODO Votre code ici...
		
		
		System.out.println("** Les editeurs");
		System.out.println("***************");
		//TODO Votre code ici...
		
		
		//creation de 2,3 livres
		//TODO Votre code ici...
		
		
		System.out.println("** Les livres");
		System.out.println("*************");
		//TODO Votre code ici...
		
		
		//creation de 2,3 cd
		//TODO Votre code ici...
		
		System.out.println("** Les cd");
		System.out.println("*********");
		//TODO Votre code ici...
		
		
		//ajouter les produits au catalogue
		//TODO Votre code ici...
		
		
		//tester le polymorphisme (en affichant un livre issu du catalogue avec son prix de vente)
		System.out.println("** polymorphisme");
		System.out.println("****************");
		//TODO Votre code ici...
		
		
		//ajouter une piste à un cd issu du catalogue
		//TODO Votre code ici...
		
		
		//lister l'intégralité du catalogue
		System.out.println("** Le catalogue complet");
		System.out.println("***********************");
		//TODO Votre code ici...
		
		
		//extraire les produits par type du catalogue
		System.out.println("** Les livres au catalogue");
		System.out.println("**************************");
		//TODO Votre code ici...
		
		
		//extraire les produits par type du catalogue
		System.out.println("** Les cds au catalogue");
		System.out.println("***********************");
		//TODO Votre code ici...
		

		
		System.out.println("Appuyez sur entrée pour sortir du test...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
	}

}
