//package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tessa Morgan
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is
 * eaten.
 *
 */
public class Grass extends Living {
	/**
	 * 	Constructor
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 */
	public Grass(Plain p, int r, int c) {
		plain = p; 
		row = r;
		column = c;
	}

	@Override
	public State who() {
		return State.GRASS; 
	}

	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast
	 * enough to take over Grass.
	 */
	@Override
	public Living next(Plain pNew) {
		int[] censusInfo = new int[5];
		census(censusInfo);
		
		Living newAssignment;
		
		if (censusInfo[RABBIT] >= (3 * censusInfo[GRASS])) {
			//Empty
			newAssignment = new Empty(pNew, row, column);
		}
		else if (censusInfo[RABBIT] >= 3) {
			//Rabbit, age 0
			newAssignment = new Rabbit(pNew, row, column, 0);
		}
		else {
			//Grass
			newAssignment = new Grass(pNew, row, column);
		}
		
		return newAssignment;
	}
	
	@Override
	public String toString() {
		return "G "; 
	}
}
