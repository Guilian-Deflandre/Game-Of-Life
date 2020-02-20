/*
 * INFO0062 - Object-oriented programming
 * Project 1
 *
 * @author: Guilian Deflandre
 */

public class GameOfLifeException extends Exception {
	
	/**
	 * USE OF THE CLASS:
	 * 		1) Detected size grid errors.
	 * 		2) Detected parity of size grid and square life errors.
	 */
	
	private static final long serialVersionUID = 1L;

	public GameOfLifeException(int n,int m) {
		/*******************************************************************************
		 *                                    1)                                       *
		 *******************************************************************************/
		if(m > n || n < 2){
			System.out.println("Size rules are not respected. Please try again.");
		}
		
		/*******************************************************************************
		 *                                    2)                                       *
		 *******************************************************************************/
		else if(((m%2)!=(n%2))){
			System.out.println("Parity rule is not respect.");
		}
	}
}
