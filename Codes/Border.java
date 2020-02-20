/*
 * INFO0062 - Object-oriented programming
 * Project 1
 *
 * @author: Guilian Deflandre
 */

public class Border extends Cell{
	
	/*
	 * USE OF THE CLASS:
	 * 		Extend a Cell element characteristics by adding it the number of time
	 * 		it change state (life to death and death to life). This element will be only 
	 * 		use for the border of the Game of Life.
	 */
	
	protected int created;  //Number of border Cell's birth.
	protected int dead;     //Number of border Cell's death.
	
	/* --------------------------------------------------------------------------- *
	 *                     INITIALIZATION OF THE BORDER CELL                       *
	 * ARGUMENTS:                                                                  *
	 * row: Row in the Game of Life.                                               *
	 * column: Column in the Game of Life (could be only 0 or n-1).                * 
	 * --------------------------------------------------------------------------- */
	public Border(int row, int column) {
		super(row,column);
		created = 0;
		dead = 0;
	}
	
	public void defineCreatedDead(){
		
		/*
		 * USE OF THE METHOD:
		 * 		Define the number of the Cell's birth and death.
		 */
		
		if(this.state == true && this.newState == false) {
			this.dead++;
		}else if(this.state == false && this.newState == true) {
			this.created++;
		}
	}
	
	public String displayBorder()
	{
		
		/*
		 * USE OF THE METHOD:
		 * 		Give the string containing lifes and the deaths of the cell.
		 * RETURN
		 * String       the array of format: [+   nbTakeLife/-   nbDie]
		 */
		
		return "[+"+String.format("%3d",this.created)+"/-"+String.format("%3d", this.dead)+"]";
	}
}
