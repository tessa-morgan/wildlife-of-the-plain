//package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  
 * @author Tessa Morgan
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with squares
 * inhabited by badgers, foxes, rabbits, grass, or none.
 *
 */
public class Wildlife {
	
	/**
	 * Update the new plain from the old plain in one cycle.
	 * 
	 * @param pOld old plain
	 * @param pNew new plain
	 */
	public static void updatePlain(Plain pOld, Plain pNew) {
		
		for (int row = 0; row < pOld.getWidth(); row++) {
			for (int col = 0; col < pOld.getWidth(); col++) {
				pOld.updateLiving(row, col, pNew);
			}
		}
	}
	
	public static void print(Plain pOld, Plain pNew, int numCycles){
		System.out.println();
		System.out.println("Initial Plain");
		System.out.println(pOld.toString());
		
		for (int i = 0; i < numCycles; i++) {
			if (i % 2 == 0) {
				updatePlain(pOld, pNew);
			}
			else if (i % 2 == 1) {
				updatePlain(pNew, pOld);
			}
		}
		
		System.out.println("Final Plane");
		if (numCycles % 2 == 0) {
			System.out.println(pOld.toString());
		}
		else {
			System.out.println(pNew.toString());
		}
		
	}


	/**
	 * Repeatedly generates plains either randomly or from reading files. Over each
	 * plain, carries out an input number of cycles of evolution.
	 *  
	 * @param args 
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Simulation of Wildlife on a Plain");
		System.out.println("Keys 1 (random plain) 2 (file input) 3 (exit)\n");
		System.out.print("Trial 1: ");
		
		Scanner sc = new Scanner(System.in); 
		
		Plain even; // the plain after an even number of cycles
		Plain odd; // the plain after an odd number of cycles
		
		
		int flag = sc.nextInt();
		int width;
		String fileName;
		int cycles;
		int numTrials = 2;
		
		while (flag < 3 && flag >= 1) {
			
			if (flag == 1) {
				System.out.println("Random Plain");
				System.out.print("Enter grid width: ");
				width = sc.nextInt();
				System.out.print("Enter a number of cycles: ");
				cycles = sc.nextInt();
				
				even = new Plain(width);
				odd = new Plain(width);
				even.randomInit();
				print(even, odd, cycles);
			}
			
			else if (flag == 2) {
				System.out.println("Plain input from a file");
				System.out.print("Filename: ");
				fileName = sc.next();
				System.out.print("Enter a number of cycles: ");
				cycles = sc.nextInt();
				
				even = new Plain(fileName);
				odd = new Plain(even.getWidth());
				print(even, odd, cycles);
			}
			
			System.out.print("Trial " + numTrials + ": ");
			numTrials++;
			flag = sc.nextInt();
		}
		
		sc.close();

	}
}
