package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tessa Morgan
 *
 */

/**
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living {
	
	/**
	 *  Constructor
	 *  
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 */
	public Empty(Plain p, int r, int c) {
		plain = p;
		row = r;
		column = c;
	}

	@Override
	public State who() {
		return State.EMPTY;  
	}

	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or
	 * Grass, or remain empty.
	 * 
	 * @param pNew plain of the next life cycle.
	 * @return Living life form in the next cycle.
	 */
	@Override
	public Living next(Plain pNew) {
		int[] censusInfo = new int[5];
		census(censusInfo);
		
		Living newAssignment;
		
		if (censusInfo[RABBIT] > 1) {
			//Rabbit, age 0
			newAssignment = new Rabbit(pNew, row, column, 0);
		}
		else if (censusInfo[FOX] > 1) {
			//Fox, age 0
			newAssignment = new Fox(pNew, row, column, 0);
		}
		else if (censusInfo[BADGER] > 1) {
			//Badger, age 0
			newAssignment = new Badger(pNew, row, column, 0);
		}
		else if (censusInfo[GRASS] >= 1) {
			//Grass
			newAssignment = new Grass(pNew, row, column);
		}
		else {
			//Empty
			newAssignment = new Empty(pNew, row, column);
		}
		
		return newAssignment;
	}
	
	@Override
	public String toString() {
		return "E "; 
	}
}
