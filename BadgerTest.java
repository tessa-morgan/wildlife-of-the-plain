package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BadgerTest {
	
	Living b, b2;
	Plain p, p2, p3;
	int r, c;
	String file, file2;
	
	@BeforeEach
	void setUp() throws FileNotFoundException {
		
		file = "./public/public1-3x3.txt";
		file2 = "./public/public2-6x6.txt";
		
		p = new Plain(file);
		p2 = new Plain(file2);
		p3 = new Plain(6);		
		
		b = p.grid[0][1];
		b2 = p2.grid[5][3];
		
	}
	
	
	@Test
	void who() {
		
		assertEquals(b.who(), State.BADGER);
		assertEquals(b2.who(), State.BADGER);
		
	}
	
	@Test
	void next() {
		
		assertEquals(b.toString(), "B0");
		assertEquals(b.next(p).toString(), "F0");
		
		assertEquals(b2.toString(), "B0");
		assertEquals(b2.next(p).toString(), "B1");
		
	}
	
	@Test
	void toStringTest() {
		
		assertEquals(b.toString(), "B0");
		assertEquals(b2.toString(), "B0");
		
	}
	
	@Test 
	void age() {
		
		assertEquals(((Animal) b).myAge(), 0);
		assertEquals(((Animal) b2).myAge(), 0);
		
	}
	
	

}
