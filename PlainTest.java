package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlainTest {

	
	String fileName1 = "./public/public1-3x3.txt";
	String fileName12 = "./public/public1-5cycles.txt";
	String fileName2 = "./public/public2-6x6.txt";
	String fileName22 = "./public/public2-8cycles.txt";
	String fileName3 = "./public/public3-10x10.txt";
	String fileName32 = "./public/public3-6cycles.txt";
	String fileRand = "./publicRandom-5x5.txt";
	
	Random rand;
	int n;
	Plain pRand, p, p3x3, p6x6;
	Living b;
	
	@BeforeEach
	void setUp() throws FileNotFoundException {
		
		rand = new Random();
		n = rand.nextInt(9) + 1;
		pRand = new Plain(n);
		
		p3x3 = new Plain(fileName1);
		p6x6 = new Plain(fileName2);
		
	}
	
	@Test
	void getWidth() {
		 
		assertEquals(pRand.getWidth(), n);
	}

	@Test
	void testRandomInit() {
		
		pRand.randomInit();
		assertTrue(pRand.grid[rand.nextInt(n)][rand.nextInt(n)] != null);
		
	} 
	
	@Test
	void getAge() {
		
		Plain p = new Plain(3);
		p.grid[1][1] = new Badger(p, 1, 1, 2);
		assertEquals(Plain.getAge(p.grid[1][1].toString()), 2);
		
	}
	
	@Test
	void strToLiving() {
		
		b = Plain.strToLiving("B0", new Plain(3), 2, 3);
		assertEquals(b.who(), State.BADGER);
		assertEquals(b.row, 2);
		assertEquals(b.column, 3);
		
	}
	
	@Test
	void updateLiving() {
		
		assertEquals(p3x3.grid[1][1].toString(), "F0");
		p3x3.updateLiving(1, 1, p3x3);
		assertEquals(p3x3.grid[1][1].toString(), "E ");
		
	}
	
	
	@Test
	void testFileInputInit() {
		
		assertEquals(p3x3.getWidth(), 3);
	}
	
	
	@Test 
	void write() throws FileNotFoundException {
		
		p6x6.write(fileRand);
		Plain pWrite = new Plain(fileRand);
		assertEquals(p6x6.toString(), pWrite.toString());
		
	}
	
	
	

	
}
