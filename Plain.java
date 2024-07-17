package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tessa Morgan
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

/**
 * 
 * The plain is represented as a square grid of size width x width.
 *
 */
public class Plain {
	private int width; // grid size: width X width

	public Living[][] grid;

	/**
	 * Default constructor reads from a file
	 */
	public Plain(String inputFileName) throws FileNotFoundException {
		
		File input = new File(inputFileName);
		Scanner sc = new Scanner(input);
		
		width = 0;
		
		Scanner sc1 = new Scanner(sc.nextLine());
		
		while(sc1.hasNext()) {
			String next = sc1.next();
			width++;
		}
		
		sc.close();
		sc = new Scanner(input);
		grid = new Living[width][width];
		
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < width; c++) {
				grid[r][c] = strToLiving(sc.next(), this, r, c);
			}
		}
		
		sc1.close();
		sc.close();
	}
	
	/**
	 * Constructor that builds a w x w grid without initializing it.
	 * 
	 * @param width the grid
	 */
	public Plain(int w) {
		grid = new Living[w][w];
		width = w;
	}
	
	/**
	 * Given the two character string of an element in a plain, 
	 * 	returns the Living object associated with it 
	 * @param str
	 * @param p
	 * @param row
	 * @param col
	 * @return 
	 * 		a Living object associated with the given string
	 */
	protected static Living strToLiving(String str, Plain p, int row, int col) {
		char type = str.charAt(0);
		
		Living assignment = new Empty(p, row, col);
		
		if (type == 'B') {
			assignment = new Badger(p, row, col, getAge(str));
		}
		else if (type == 'F') {
			assignment = new Fox(p, row, col, getAge(str));
		}
		else if (type == 'R') {
			assignment = new Rabbit(p, row, col, getAge(str));
		}
		else if (type == 'G') {
			assignment = new Grass(p, row, col);
		}
		
		return assignment;
	}
	
	/**
	 * Given a two character string, returns the age the associated 
	 *   Living object should be initialized with
	 * @param str
	 * @return
	 *     and int representing the age of the Living object
	 */		
	protected static int getAge(String str) {
		char a = str.charAt(1);
		return Character.getNumericValue(a);
	}

	/**
	 * Returns the width of this plain
	 * @return
	 * 		the width as an integer
	 */		
	public int getWidth() {
		return this.width;  
	}
	
	/**
	 * Assigns what the next living object should be to the next plain
	 * 	based on the coordinates and plain given
	 * @param row
	 * @param col
	 */
	protected void updateLiving(int row, int col, Plain pNew) {
		pNew.grid[row][col] = grid[row][col].next(pNew);;
	}

	/**
	 * Initialize the plain by randomly assigning to every square of the grid one of
	 * BADGER, FOX, RABBIT, GRASS, or EMPTY.
	 * BADGER, EMPTY, FOX, GRASS, RABBIT
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit() {
		Random generator = new Random();
		
		int type;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid.length; c ++) { 
				type = generator.nextInt(4);
				Living animal;
				
				if (type == 0) {
					animal = new Badger(this, r, c, 0);
				}
				else if (type == 2) {
					animal = new Fox(this, r, c, 0);
				}
				else if (type == 3) {
					animal = new Grass(this, r, c);
				}
				else if (type == 4) {
					animal = new Rabbit(this, r, c, 0);
				}
				else {
					animal = new Empty(this, r, c);
				}
				
				grid[r][c] = animal;
			}
		}
	}
	 

	/**
	 * Output the plain grid. For each square, output the first letter of the living
	 * form occupying the square. If the living form is an animal, then output the
	 * age of the animal followed by a blank space; otherwise, output two blanks.
	 */
	public String toString() {
		String toPrint = "";
		for (int r = 0; r < grid.length; r++) {
			toPrint += "[ ";
			for (int c = 0; c < grid.length; c++) {
				if (grid[r][c] == null) {
					toPrint += "  ";
				}
				else{
					toPrint += grid[r][c].toString() + " ";
				}
			}
			toPrint += "]\n";
		}
		return toPrint;
	}
	

	/**
	 * Write the plain grid to an output file. Also useful for saving a randomly
	 * generated plain for debugging purpose.
	 * 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException {
		
		File outputFile = new File(outputFileName);
		PrintWriter writer = new PrintWriter(outputFile);
		
		String toFile = "";
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid.length; c++) {
				toFile += grid[r][c].toString() + " ";
			}
			toFile += "\n";
		}
		
		writer.write(toFile);
		
		writer.close();
		
	}
}
