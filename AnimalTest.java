package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class AnimalTest {

	@Test
	void age() throws FileNotFoundException {
		
		Plain p = new Plain("./public/public1-3x3.txt");
		Animal a = (Animal) p.grid[0][1];
		assertEquals(a.myAge(), 0);
		
		p = new Plain("./public/public3-6cycles.txt");
		a = (Animal) p.grid[7][0];
		assertEquals(a.myAge(), 4);
	}

}
