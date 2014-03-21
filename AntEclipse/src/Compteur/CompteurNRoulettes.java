/**
 * Classe caractérisant un compteur de Roulette. 
 * @since 1.0
 */
package Compteur;

/**
 * @author MC
 *
 */
public class CompteurNRoulettes 
{
	// Attributs
	private int nbchiffres ;
	private Roulette [] valeurcompteur ; 
	
	// Méthodes
	// Constructeur : Inutile sauf si l'initialisation du compteur a 0
	public CompteurNRoulettes(int n)
	{
		this.nbchiffres = n;
		// Crée autant de roulettes que de chiffres necessaires
		this.valeurcompteur = new Roulette [n];	
		// Creation effective des roulettes
		for (int i = 0 ; i<n; i++)
			this.valeurcompteur[i] = new Roulette();
	}
	
	public void afficher()
	{
		for (int i=0; i<this.nbchiffres; i++)
		{
			this.valeurcompteur[i].afficher();				
		}
		System.out.println();
	}
	
	public void incrementer()
	{
		// les unites se trouvent à droite du tableau
		// l'autre solution est envisageable : Attention au afficher!
		boolean continuer = true;
		int i = this.nbchiffres - 1;
		while (i >= 0 && continuer)
		{
			this.valeurcompteur[i].incrementer();
			continuer = this.valeurcompteur[i].aFaitUnTour();
			i--;
		} 				
	}

}
