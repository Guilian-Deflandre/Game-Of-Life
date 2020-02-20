/*
 * INFO0062 - Object-oriented programming
 * Project 1
 *
 * @author: Guilian Deflandre
 */

import java.util.Random;

public class Grid {
	
	/*
	 * USE OF THE CLASS:
	 * 		Class who build the Game of Life represented by an array of living Cells (*)
	 * 		and dead Cells (-).
	 */
	
	private Cell[][] grid;         //Array of two dimension which simulate the Game of Life.
	protected boolean pulsarMode;  //True if a Pulsar would be simulate by the user

	/* --------------------------------------------------------------------------- *
	 *                           BUILDING OF THE GRID                              *
	 * ARGUMENTS:                                                                  *
	 * n: The dimension of the Game of Life array.                                 *  
	 * --------------------------------------------------------------------------- */
	public Grid(int n){

		grid = new Cell[n][n];
		for(int row = 0;row < n; row++) {
			for(int column = 0; column < n; column++) {
				if(column == 0 || column == n-1){
					grid[row][column] = new Border(row,column);
				}else{
					grid[row][column] = new Cell(row,column);
				}
			}
		}
	}
	
	/* --------------------------------------------------------------------------- *
	 *                        INITIALIZATION OF THE GRID                           *
	 * ARGUMENTS:                                                                  *
	 * n: The dimension of the Game of Life array.                                 * 
	 * m: The dimension of the square in which we will initialize living Cells.    * 
	 * --------------------------------------------------------------------------- */
    public void gridInitialize(int n, int m){
	    	if(this.pulsarMode){
				/* ------------------------------------------------------- *
				 *                        Pulsar Test                      *
				 * ------------------------------------------------------- */
				for(int row = (n-m)/2;row < ((n-m)/2) + m; row++){
					for(int column = ((n-m)/2); column < ((n-m)/2) + m; column++){
						if(column == (n-m)/2 || column == (((n-m)/2)+m-1) || (column == n/2 && row==((n-m)/2)) 
								|| (column == n/2 && row==(((n-m)/2)+m-1))){
							grid[row][column].setState(true);
						}
					}
				}
				
			}else{
				/* --------------------------------------------------------- *
				 *   Random initialization of the alive/death cells in the   *
				 *                     m x m square.                         *
				 * --------------------------------------------------------- */
				for(int row = (n-m)/2;row < ((n-m)/2) + m; row++) {
					for(int column = ((n-m)/2); column < ((n-m)/2) + m; column++) {
						Random rand = new Random();
					    boolean lifeOrDead = rand.nextBoolean();
					    if(lifeOrDead==true){
					    		grid[row][column].setState(true);
						}
					}
				}
			}
    }
    
	public void definePulsarMode(boolean Answer){
		
		/*
		 * USE OF THE METHOD:
		 * 		Define the way to initialize the Grid.
		 * ARGUMENTS:
		 * Answer: the answer giving by the user (true if he want to see a pulsar).
		 */
		
		this.pulsarMode = Answer;
	}
	
	public void neighborsCounter(){
		
		/*
		 * USE OF THE METHOD:
		 * 		Count the number of neighbors in live that the Cell has by exploring 
		 * 		all its neighbourhood.
		 */
		
		
		/* -------------------------------------------------------- *
		 *   Reset of all the number of neighbours at each turn     *
		 * -------------------------------------------------------  */
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid.length; column++) {
				grid[row][column].resetNeighbors();
			}
		}
		
		/* -------------------------------------------------------- *
		 *                        General case                      *
		 * -------------------------------------------------------- */
		for(int row = 1;row< grid.length-1;row++) {
			for(int column = 1; column < grid.length-1; column++) {
				if(grid[row+1][column-1].getState()) {
					grid[row][column].addNeighbors();
				}
				if(grid[row+1][column].getState()) {
					grid[row][column].addNeighbors();
				}
				if(grid[row+1][column+1].getState()) {
					grid[row][column].addNeighbors();
				}
				if(grid[row][column-1].getState()) {
					grid[row][column].addNeighbors();
				}
				if(grid[row][column+1].getState()) {
					grid[row][column].addNeighbors();
				}
				if(grid[row-1][column-1].getState()) {
					grid[row][column].addNeighbors();
				}
				if(grid[row-1][column].getState()) {
					grid[row][column].addNeighbors();
				}
				if(grid[row-1][column+1].getState()) {
					grid[row][column].addNeighbors();
				}
			}
		}
		/* -------------------------------------------------------- *
		 *                      Up Border                           *
		 * -------------------------------------------------------- */
		for(int column = 1;column< grid.length-1;column++) {
			if(grid[0][column-1].getState()) {
				grid[0][column].addNeighbors();
			}
			if(grid[0][column+1].getState()) {
				grid[0][column].addNeighbors();
			}
			if(grid[1][column-1].getState()) {
				grid[0][column].addNeighbors();
			}
			if(grid[1][column].getState()) {
				grid[0][column].addNeighbors();
			}
			if(grid[1][column+1].getState()) {
				grid[0][column].addNeighbors();
			}
		}
		/* -------------------------------------------------------- *
		 *                      Low Border                          *
		 * -------------------------------------------------------- */
		for(int column = 1;column< grid.length-1;column++) {
			if(grid[grid.length-1][column-1].getState()) {
				grid[grid.length-1][column].addNeighbors();
			}
			if(grid[grid.length-1][column+1].getState()) {
				grid[grid.length-1][column].addNeighbors();
			}
			if(grid[grid.length-2][column-1].getState()){
				grid[grid.length-1][column].addNeighbors();
			}
			if(grid[grid.length-2][column].getState()) {
				grid[grid.length-1][column].addNeighbors();
			}
			if(grid[grid.length-2][column+1].getState()) {
				grid[grid.length-1][column].addNeighbors();
			}
		}
		/* -------------------------------------------------------- *
		 *                      Right Border                        *
		 * -------------------------------------------------------- */
		for(int row = 1;row< grid.length-1;row++) {
			if(grid[row-1][grid.length-1].getState()) {
				grid[row][grid.length-1].addNeighbors();
			}
			if(grid[row-1][grid.length-2].getState()) {
				grid[row][grid.length-1].addNeighbors();
			}
			if(grid[row][grid.length-2].getState()) {
				grid[row][grid.length-1].addNeighbors();
			}
			if(grid[row+1][grid.length-2].getState()) {
				grid[row][grid.length-1].addNeighbors();
			}
			if(grid[row+1][grid.length-1].getState()) {
				grid[row][grid.length-1].addNeighbors();
			}
		}
		/* -------------------------------------------------------- *
		 *                      Left Border                         *
		 * -------------------------------------------------------- */
		for(int row = 1;row< grid.length-1;row++) {
			if(grid[row-1][0].getState()) {
				grid[row][0].addNeighbors();
			}
			if(grid[row-1][1].getState()) {
				grid[row][0].addNeighbors();
			}
			if(grid[row][1].getState()) {
				grid[row][0].addNeighbors();
			}
			if(grid[row+1][0].getState()) {
				grid[row][0].addNeighbors();
			}
			if(grid[row+1][1].getState()) {
				grid[row][0].addNeighbors();
			}
		}
		/* -------------------------------------------------------- *
		 *                    Up Left Corner                        *
		 * -------------------------------------------------------- */
		if(grid[1][0].getState()) {
			grid[0][0].addNeighbors();
		}
		if(grid[0][1].getState()) {
			grid[0][0].addNeighbors();
		}
		if(grid[1][1].getState()) {
			grid[0][0].addNeighbors();
		}
		/* -------------------------------------------------------- *
		 *                    Down Left Corner                      *
		 * -------------------------------------------------------- */
		if(grid[grid.length-1][1].getState()) {
			grid[grid.length-1][0].addNeighbors();
		}
		if(grid[grid.length-2][0].getState()) {
			grid[grid.length-1][0].addNeighbors();
		}
		if(grid[grid.length-2][1].getState()) {
			grid[grid.length-1][0].addNeighbors();
		}
		/* -------------------------------------------------------- *
		 *                    Up Right Corner                       *
		 * -------------------------------------------------------- */
		if(grid[0][grid.length-2].getState()) {
			grid[0][grid.length-1].addNeighbors();
		}
		if(grid[1][grid.length-1].getState()) {
			grid[0][grid.length-1].addNeighbors();
		}
		if(grid[1][grid.length-2].getState()) {
			grid[0][grid.length-1].addNeighbors();
		}
		/* -------------------------------------------------------- *
		 *                    Down Right Corner                     *
		 * -------------------------------------------------------- */
		if(grid[grid.length-2][grid.length-2].getState()) {
			grid[grid.length-1][grid.length-1].addNeighbors();
		}
		if(grid[grid.length-2][grid.length-1].getState()) {
			grid[grid.length-1][grid.length-1].addNeighbors();
		}
		if(grid[grid.length-1][grid.length-2].getState()) {
			grid[grid.length-1][grid.length-1].addNeighbors();
		}
	}
	
	public void updateGrid() {
		
		/*
		 * USE OF THE METHOD:
		 * 		Define the next grid by definig the next state of each Cell in it.
		 */
		
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid.length; column++) {
				grid[row][column].defineNewState();
			}
			
			//Update of the number of death and birth of the border Cells.
			((Border) grid[row][0]).defineCreatedDead();
			((Border) grid[row][grid.length-1]).defineCreatedDead();
			
			//Update all the next Cell's states.
			for (int column = 0; column < grid.length; column++) {
				grid[row][column].updateCellState();
			}
		}
	}
	
	public void display(){
		
		/*
		 * USE OF THE METHOD:
		 * 		Display the current state of each Cell who compose the Game of Life
		 * 		and the number of death and birth of border Cells.
		 */
		
		for(int row = 0; row < grid.length; row++) {
			//Display of the left border.
			System.out.print(((Border) grid[row][0]).displayBorder());
			//Display of the game of life.
			for(int column = 0; column < grid.length; column++) {
				if(grid[row][column].getState()) {
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			//Display of the right border.
			System.out.println(((Border) grid[row][grid.length-1]).displayBorder());
		}
		System.out.println();
	}
}
