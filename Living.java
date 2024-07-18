//package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tessa Morgan
 *
 */

/**
 * 
 * Living refers to the life form occupying a square in a plain grid. It is a
 * superclass of Empty, Grass, and Animal, the latter of which is in turn a
 * superclass of Badger, Fox, and Rabbit. Living has two abstract methods
 * awaiting implementation.
 *
 */
public abstract class Living {
	protected Plain plain; // the plain in which the life form resides
	protected int row; // location of the square on which
	protected int column; // the life form resides

	// constants to be used as indices.
	protected static final int BADGER = 0;
	protected static final int EMPTY = 1;
	protected static final int FOX = 2;
	protected static final int GRASS = 3;
	protected static final int RABBIT = 4;

	public static final int NUM_LIFE_FORMS = 5;

	// life expectancies
	public static final int BADGER_MAX_AGE = 4;
	public static final int FOX_MAX_AGE = 6;
	public static final int RABBIT_MAX_AGE = 3;
	
	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a plain.
	 * 
	 * @param population counts of all life forms
	 */
	protected void census(int[] population) {
		
		int startRow = row - 1;
		if (startRow < 0) {
			//startRow = 0;
			startRow = row;
		}
		
		int startCol = column - 1;
		if (startCol < 0) {
			//startCol = 0;
			startCol = column;
		}
		
		int endRow = row + 1;
		if (endRow >= plain.getWidth()) {
			//endRow = plain.getWidth() - 1;
			endRow = row;
		}
		
		int endCol = column + 1;
		if (endCol >= plain.getWidth()) {
			//endCol = plain.getWidth() - 1;
			endCol = column;
		}
		
		for (int r = startRow; r <= endRow; r++) {
			for (int c = startCol; c <= endCol; c++) {
				State type = plain.grid[r][c].who();
				int typeNum = -1;
				
				if (type == State.BADGER) {
					typeNum = BADGER;
				}
				else if (type == State.RABBIT) {
					typeNum = RABBIT;
				} 
				else if (type == State.FOX) {
					typeNum = FOX;
				}
				else if (type == State.GRASS) {
					typeNum = GRASS;
				}
				else if (type == State.EMPTY) {
					typeNum = EMPTY;
				}
				
				population[typeNum] += 1; 
			}
		}
	}
	
	

	/**
	 * Gets the identity of the life form on the square.
	 * 
	 * @return State
	 */
	public abstract State who();

	
	/**
	 * Determines the life form on the square in the next cycle.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living
	 */
	public abstract Living next(Plain pNew);
	

}
