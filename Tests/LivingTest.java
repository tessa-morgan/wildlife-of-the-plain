package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class LivingTest {

	String file = "./public/public1-3x3.txt";
	String file2 = "./public/public2-6x6.txt";
	
	@Test
	void census() throws FileNotFoundException {
		
		Plain p = new Plain(file);
		
		int[] censusActual = new int[5];
		p.grid[1][1].census(censusActual);
		
		//Badger, Empty, Fox, Grass, Rabbit
		int[] censusExpected = {1, 1, 4, 2, 1};
		
		for (int i = 0; i < 5; i++) {
			assertEquals(censusActual[i], censusExpected[i]);
		}
		
	}
	
	

}
