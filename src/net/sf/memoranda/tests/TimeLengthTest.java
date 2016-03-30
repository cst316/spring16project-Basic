package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.TimeLength;

public class TimeLengthTest {

	private TimeLength t1;
	private TimeLength t2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t1 = new TimeLength();
		t2 = new TimeLength("Days", 100);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetters() {
		assertTrue(t1.getLength() == 0);
		assertTrue(t1.getType().equals("Seconds"));
		assertTrue(t2.getLength() == 100);
		assertTrue(t2.getType().equals("Days"));
	}
	
	@Test
	public void testSetters() {
		t1.setLength(100);
		assertFalse(t1.getLength() == 0);
		t1.setType("Hours");
		assertTrue(t1.getType().equals("Hours"));
	}

}