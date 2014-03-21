/**
 * Classe caractérisant une Roulette du compteur. 
 * <p>
 * Cette classe étend la classe Object (voir {@link java.awt.Panel} la classe) 
 * @since 1.0
 * @see Compteur.CompteurNRoulettes
 */
package Compteur;
/**
 * @author MC
 */

public class Roulette 
{
	private int chiffre = 0;
	private boolean aFaitUnTour = false;
	

	
	public void incrementer()
	{
		this.chiffre ++;
		if (this.chiffre >= 10)
		{		
			this.aFaitUnTour = true;
			this.chiffre = 0;
		}
		else
		{
			this.aFaitUnTour = false;
		}
	}
	
	public boolean aFaitUnTour()
	{
		return(this.aFaitUnTour);
	}
	
	public void afficher()
	{
		System.out.print(String.valueOf(this.chiffre));
	}	
}
