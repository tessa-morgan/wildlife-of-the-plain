package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FoxTest {

	Living f, f2;
	Plain p, p2, p3;
	String file, file2;
	
	@BeforeEach
	void setUp() throws FileNotFoundException {
		
		file = "./public/public1-3x3.txt";
		file2 = "./public/public2-6x6.txt";
		
		p = new Plain(file);
		p2 = new Plain(file2);
		p3 = new Plain(6);		
		
		f = p.grid[1][0];
		f2 = p2.grid[3][4];
		
	}
	
	
	@Test
	void who() {
		
		assertEquals(f.who(), State.FOX);
		assertEquals(f2.who(), State.FOX);
		
	}
	
	@Test
	void next() {
		
		assertEquals(f.toString(), "F0");
		assertEquals(f.next(p).toString(), "E ");
		
		assertEquals(f2.toString(), "F0");
		assertEquals(f2.next(p).toString(), "B0");
		
	}
	
	@Test
	void toStringTest() {
		
		assertEquals(f.toString(), "F0");
		assertEquals(f2.toString(), "F0");
		
	}
	
	@Test 
	void age() {
		
		assertEquals(((Animal) f).myAge(), 0);
		assertEquals(((Animal) f2).myAge(), 0);
		
	}

}
