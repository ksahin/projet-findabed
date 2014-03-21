/**
 * Classe contenant le point d'entrée
 */

/**
 * @author MC
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Création du compteur
		Compteur.CompteurNRoulettes c = new Compteur.CompteurNRoulettes(5);
		
		// Incrémente le compteur 250 fois
		for (int i=0; i<250; i++)
		{
			c.incrementer();
		}
		// Affiche la valeur du compteur
		c.afficher();
	}

}
