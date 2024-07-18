//package edu.iastate.cs228.hw1;

/**
 * 
 * @author Tessa Morgan
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal {
	
	/**
	 * Creates a Rabbit object.
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Rabbit(Plain p, int r, int c, int a) { 
		plain = p;
		row = r;
		column = c;
		age = a;
	} 

	/**
	 * Rabbit occupies the square.
	 */
	@Override
	public State who() {
		return State.RABBIT;
	}

	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a
	 * fox.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living new life form occupying the same square
	 */
	@Override
	public Living next(Plain pNew) {
		int[] censusInfo = new int[5];
		census(censusInfo);
		
		Living newAssignment;
		
		if (age == RABBIT_MAX_AGE) {
			//Empty
			newAssignment = new Empty(pNew, row, column);
		}
		else if (censusInfo[GRASS] == 0) {
			//Empty
			newAssignment = new Empty(pNew, row, column);
		}
		else if ((censusInfo[BADGER] + censusInfo[FOX]) >= censusInfo[RABBIT] && (censusInfo[FOX] > censusInfo[BADGER])) {
			//Fox, age 0
			newAssignment = new Fox(pNew, row, column, 0);
		}
		else if (censusInfo[BADGER] > censusInfo[RABBIT]) {
			//Badger, age 0
			newAssignment = new Badger(pNew, row, column, 0);
		}
		else {
			//Rabbit, age +1
			newAssignment = new Rabbit(pNew, row, column, age + 1);
		}
		
		return newAssignment;
	}
	
	@Override
	public String toString() {
		return "R" + myAge();
	}
}
