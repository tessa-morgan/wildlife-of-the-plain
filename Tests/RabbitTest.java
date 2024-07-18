//package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RabbitTest {

	Living r, r2;
	Plain p, p2, p3;
	String file, file2;
	
	@BeforeEach
	void setUp() throws FileNotFoundException {
		
		file = "./public/public1-3x3.txt";
		file2 = "./public/public2-6x6.txt";
		
		p = new Plain(file);
		p2 = new Plain(file2);
		p3 = new Plain(6);		
		
		r = p.grid[1][2];
		r2 = p2.grid[2][2];
		
	}
	
	
	@Test
	void who() {
		
		assertEquals(r.who(), State.RABBIT);
		assertEquals(r2.who(), State.RABBIT);
		
	}
	
	@Test
	void next() {
		
		assertEquals(r.toString(), "R0");
		assertEquals(r.next(p).toString(), "F0");
		
		assertEquals(r2.toString(), "R0");
		assertEquals(r2.next(p).toString(), "E ");
		
	}
	
	@Test
	void toStringTest() {
		
		assertEquals(r.toString(), "R0");
		assertEquals(r2.toString(), "R0");
		
	}
	
	@Test 
	void age() {
		
		assertEquals(((Animal) r).myAge(), 0);
		assertEquals(((Animal) r2).myAge(), 0);
		
	}

}
