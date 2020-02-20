/*
 * INFO0062 - Object-oriented programming
 * Project 1
 *
 * @author: Guilian Deflandre
 */

public class Cell {
	
	/*
	 * USE OF THE CLASS:
	 * 		Define an element, here Cell, which are an element of the Game of Life. This cell can be in 
	 *      2 states alive or dead.
	 */
	
	protected boolean state;    //Current state of the cell (true if alive).
	protected boolean newState; //Next state of the cell.
	protected int neighbors;    //Number of neighbor of the cell.
	protected int row;          //Number of the row where the cell is.      
	protected int column;       //Number of the column where the cell is.   
	
	/* --------------------------------------------------------------------------- *
	 *                        INITIALIZATION OF THE CELL                           *
	 * ARGUMENTS:                                                                  *
	 * row: Row where the cell is in the Game of Life.                             *
	 * column: Column where the cell is in the Game of Life.                       * 
	 * --------------------------------------------------------------------------- */
	public Cell(int row, int column){
		this.state = false;
		this.newState = false;
		this.neighbors = 0;
		row = this.row;
		column = this.column;
	}
	
	
	public void setState(boolean state){
		
		/*
		 * USE OF THE METHOD:
		 * 		Define the current state of the Cell.
		 * ARGUMENTS:
		 * State: The state take by the Cell.
		 */
		
		this.state = state;
	}
	
	public void resetNeighbors(){
		
		/*
		 * USE OF THE METHOD:
		 * 		Define the Cell's neighbors number to 0.
		 */
		
		this.neighbors = 0;
	}
	
	public void defineNewState(){
		
		/**
		 * USE OF THE METHODE:
		 * 		Define the next state of the Cell helped by the statement:
		 * 		If a cell is surrounded by 2 or 3 other cells, it lives.
		 * 		If a cell is surrounded by 0 or 1 other cell, it dies of loneliness.
		 * 		If a cell is surrounded by 4 cells or more, it dies by asphyxiation.
		 * 		If a dead Cell is surrounded by exactly 3 cells, it comes to life.
		 */
		
		if(this.state == true){
			if(this.neighbors == 2 || this.neighbors == 3){
				this.newState = true;
			}else{
				this.newState = false;
			}
		}else{
			if(this.neighbors == 3) {
				this.newState = true;
			}else{
				this.newState = false;
			}
		}
	}
	
	public boolean getState() {
		
		/*
		 * USE OF THE METHOD:
		 * 		Obtain the current state of the Cell from outside of this Class.
		 */
		
		return state;
	}
	
	public void addNeighbors() {
		
		/*
		 * USE OF THE METHOD:
		 * 		Add a neighbors to the Cell.
		 */
		
		this.neighbors++;
	}
	
	public void updateCellState(){
		
		/*
		 * USE OF THE METHOD:
		 * 		Update the state of the Cell by pass from the current to the next state.
		 */
		
		this.state = this.newState;
	}
}
