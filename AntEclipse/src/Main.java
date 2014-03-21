/**
 * Classe contenant le point d'entr�e
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
		// Cr�ation du compteur
		Compteur.CompteurNRoulettes c = new Compteur.CompteurNRoulettes(5);
		
		// Incr�mente le compteur 250 fois
		for (int i=0; i<250; i++)
		{
			c.incrementer();
		}
		// Affiche la valeur du compteur
		c.afficher();
	}

}
