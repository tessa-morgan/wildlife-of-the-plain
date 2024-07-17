package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tessa Morgan
 *
 */

/**
 * A badger eats a rabbit and competes against a fox.
 */
public class Badger extends Animal {
	
	/**
	 * Constructor
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Badger(Plain p, int r, int c, int a) {
		plain = p;
		row = r;
		column = c;
		age = a;
	}

	/**
	 * A badger occupies the square.
	 */
	@Override
	public State who() {
		return State.BADGER;  
	}

	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group
	 * of foxes.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living life form occupying the square in the next cycle.
	 */
	@Override
	public Living next(Plain pNew) {
		int[] censusInfo = new int[5]; 
		census(censusInfo);
		
		Living newAssignment;
		
		if (age == BADGER_MAX_AGE) {
			//empty
			newAssignment = new Empty(pNew, row, column);
		}
		else if (censusInfo[BADGER] == 1 && censusInfo[FOX] > 1) {
			//Fox, age 0
			newAssignment = new Fox(pNew, row, column, 0);
		}
		else if ((censusInfo[BADGER] + censusInfo[FOX]) > censusInfo[RABBIT]) {
			//empty
			newAssignment = new Empty(pNew, row, column);
		}
		else {
			//Badger, +1 age
			newAssignment = new Badger(pNew, row, column, age + 1);
		}
		
		return newAssignment;
	}

	@Override
	public String toString() {
		return "B" + myAge();
	}
	
	
}
