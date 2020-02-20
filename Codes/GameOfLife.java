import java.util.Scanner;

public class GameOfLife {
	
	/*
	 * USE OF THE CLASS:
	 * 		Class who contain the main method able to simulate the Game of life.
	 */

	private static boolean answer;  //True if the user want to simulate a Pulsar.
	private static int n,m;         // n = the size of the grid, m = the square with random living cells.
	
	public static void main(String[] args) throws GameOfLifeException{
		
		/*
		 * USE OF THE METHOD:
		 * 		1) Ask and save the user requests.
		 *      2) Check if the statement requests are respected.
		 * 		3) Initialize the right sort of grid.
		 * 		4) Simulate the Game Of Life.
		 */
		Scanner mode;    //Use to key in the mode (if true: n = 13, m = 5).
		Scanner sc;      //Use to key in the size of the grid.
		Scanner sc2;     //Use to key in the size of the square with random living cells.
		char ansLetter;  //Variable to translate the answer of the user before convert it in a boolean.

		/* --------------------------------------------------------------------------- *
		 *                                    1)                                       *
		 * --------------------------------------------------------------------------- */
		System.out.println("**********************************************************");
		System.out.println("*                    GAME OF LIFE!                       *");
		System.out.println("**********************************************************\n");
		System.out.println("Please pick up the size which are demande by the computer.\n");
		System.out.println("**********************************************************");
		System.out.println("*                        RULES:                          *");
		System.out.println("**********************************************************");
		System.out.println("-Only use INTEGER >= 2  with the SAME PARITY. "
				+ "\n-The grid initialise CANNOT be smaller than the initialisation grid.\n");
		System.out.println("**********************************************************");
		System.out.println("*                        MODES:                          *");
		System.out.println("**********************************************************");
		System.out.println("-You can choose under create a Pular or generate a random initialization "
				+ "of living cells.");
		
		
		do{
			System.out.print("\t Would you like to use the pulsar mode? (Y/N): ");
			mode = new Scanner(System.in);
			String str = mode.nextLine();
			ansLetter = str.charAt(0);
		
			if(ansLetter == 'Y'){
				answer = true;
				n = 13;
				m = 5;
			}else if(ansLetter == 'N'){
				answer = false;
				sc = new Scanner(System.in);
				System.out.print("\tSize of the game grid: ");
				n = sc.nextInt();
				sc2 = new Scanner(System.in);
				System.out.print("\tSize of the square to initialise randoms cells: ");
				m = sc2.nextInt();
			}else{
				System.out.println("Please choose Y for YES or N for NOT. Try again.");
			}
			
		}while(ansLetter != 'N' && ansLetter != 'Y');
		
		/* --------------------------------------------------------------------------- *
		 *                                    2)                                       *
		 * --------------------------------------------------------------------------- */
		if(m>n || n < 2 || ((m%2)!=(n%2))){
			throw new GameOfLifeException(n,m);
		}else{
			
			/* --------------------------------------------------------------------------- *
			 *                                    3)                                       *
			 * --------------------------------------------------------------------------- */
			Grid game = new Grid(n);
			game.definePulsarMode(answer);
			game.gridInitialize(n,m);
			game.display();
		    System.out.println();
		    
		    	/* --------------------------------------------------------------------------- *
			 *                                    4)                                       *
			 * --------------------------------------------------------------------------- */
		    while(true) 
		    {
		        game.display();
		        System.out.println();
		        game.neighborsCounter();
		        game.updateGrid();
		        
		        //Use to wait some time under 2 display of the Game of Life.
		        try
		        {
		        Thread.sleep(1000); // 1s of waiting
		        }
		        catch(InterruptedException ex)
		        {
		        System.err.println(ex.getMessage());
		        }
		        
		    }
		}
		
	}
}
