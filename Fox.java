package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tessa Morgan
 *
 */

/**
 * A fox eats rabbits and competes against a badger.
 */
public class Fox extends Animal {
	
	/**
	 * Constructor
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Fox(Plain p, int r, int c, int a) { 
		plain = p; 
		row = r;
		column = c;
		age = a;
	}

	/**
	 * A fox occupies the square.
	 */
	@Override
	public State who() {
		return State.FOX;
	}

	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior
	 * badgers.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living life form occupying the square in the next cycle.
	 */
	@Override
	public Living next(Plain pNew) {
		int[] censusInfo = new int[5];
		census(censusInfo);
		
		Living newAssignment;
		
		if (age == FOX_MAX_AGE) {
			//Empty
			newAssignment = new Empty(pNew, row, column);
		}
		else if (censusInfo[BADGER] > censusInfo[FOX]) {
			//Badger, age 0
			newAssignment = new Badger(pNew, row, column, 0);
		}
		else if ((censusInfo[BADGER] + censusInfo[FOX]) > censusInfo[RABBIT]) {
			//Empty
			newAssignment = new Empty(pNew, row, column);
		}
		else {
			//Fox, age +1
			newAssignment = new Fox(pNew, row, column, age + 1);
		}
		return newAssignment;
	}
	
	@Override
	public String toString() {
		return "F" + myAge();
	}
}
