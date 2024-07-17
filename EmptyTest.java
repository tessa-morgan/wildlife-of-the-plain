package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptyTest {

	Living e, e2;
	Plain p, p2, p3;
	String file, file2;
	
	@BeforeEach
	void setUp() throws FileNotFoundException {
		
		file = "./public/public1-3x3.txt";
		file2 = "./public/public2-6x6.txt";
		
		p = new Plain(file);
		p2 = new Plain(file2);
		p3 = new Plain(6);		
		
		e = p.grid[2][1];
		e2 = p2.grid[2][1];
		
	}
	
	
	@Test
	void who() {
		
		assertEquals(e.who(), State.EMPTY);
		assertEquals(e2.who(), State.EMPTY);
		
	}
	
	@Test
	void next() {
		
		assertEquals(e.toString(), "E ");
		assertEquals(e.next(p).toString(), "F0");
		
		assertEquals(e2.toString(), "E ");
		assertEquals(e2.next(p).toString(), "R0");
		
	}
	
	@Test
	void toStringTest() {
		
		assertEquals(e.toString(), "E ");
		assertEquals(e2.toString(), "E ");
		
	}

}
