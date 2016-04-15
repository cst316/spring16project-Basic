package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.*;
import net.sf.memoranda.date.CalendarDate;

public class TaskTest {
	
	//Declare objects to be tested
	
	private String test0 = "test0";
	private String test1 = "test1";
	
	private TaskList foo;
	private Task bar, bar2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	//Assign attributes
		foo = CurrentProject.getTaskList();

		bar = foo.createTask( CalendarDate.today(), CalendarDate.tomorrow(), "text", 0, 0, "description", null, test0);

		bar2 = foo.createTask( CalendarDate.today(), CalendarDate.tomorrow(), "text", 0, 0, "description", null, test1);

		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTaskType() {
		assertFalse(bar.getType().equals(test1));
		assertTrue(bar2.getType().equals(test1));
		
	}


}
