package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WildlifeTest {
	
	String fileName1 = "./public/public1-3x3.txt";
	String fileName12 = "./public/public1-5cycles.txt";
	String fileName2 = "./public/public2-6x6.txt";
	String fileName22 = "./public/public2-8cycles.txt";
	String fileName3 = "./public/public3-10x10.txt";
	String fileName32 = "./public/public3-6cycles.txt";
	
	Plain p, p1, p12, p2, p22, p3, p32;
	
	@BeforeEach
	void setup() throws FileNotFoundException {
		p1 = new Plain(fileName1);
		p12 = new Plain(fileName12);
		
		p2 = new Plain(fileName2);
		p22 = new Plain(fileName22);
		
		p3 = new Plain(fileName3);
		p32 = new Plain(fileName32);
		
	}
	
	@Test
	void plain3x3() {
		
		p = new Plain(p1.getWidth());
		
		Wildlife.updatePlain(p1, p); //Cycle 1
		Wildlife.updatePlain(p, p1); //Cycle 2
		Wildlife.updatePlain(p1, p); //Cycle 3
		Wildlife.updatePlain(p, p1); //Cycle 4
		Wildlife.updatePlain(p1, p); //Cycle 5
		
		assertEquals(p12.toString(), p.toString());
		
	}
	
	@Test
	void plain6x6() {
		
		p = new Plain(p2.getWidth());
		
		Wildlife.updatePlain(p2, p); //Cycle 1
		Wildlife.updatePlain(p, p2); //Cycle 2
		Wildlife.updatePlain(p2, p); //Cycle 3
		Wildlife.updatePlain(p, p2); //Cycle 4
		Wildlife.updatePlain(p2, p); //Cycle 5
		Wildlife.updatePlain(p, p2); //Cycle 6
		Wildlife.updatePlain(p2, p); //Cycle 7
		Wildlife.updatePlain(p, p2); //Cycle 8
		
		assertEquals(p22.toString(), p2.toString());
		
	}
	
	@Test
	void plain10x10() {
		
		p = new Plain(p3.getWidth());
		
		Wildlife.updatePlain(p3, p); //Cycle 1
		Wildlife.updatePlain(p, p3); //Cycle 2
		Wildlife.updatePlain(p3, p); //Cycle 3
		Wildlife.updatePlain(p, p3); //Cycle 4
		Wildlife.updatePlain(p3, p); //Cycle 5
		Wildlife.updatePlain(p, p3); //Cycle 6

		
		assertEquals(p32.toString(), p3.toString());
		
	}

}
