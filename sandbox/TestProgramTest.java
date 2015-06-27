package sandbox;

import static org.junit.Assert.*;

import org.junit.*;

public class TestProgramTest extends TestProgram {

	TestProgram t = new TestProgram("James", 100, 3,3);
	

	@Test
	public void testInstantiate(){
		
		TestProgram q = new TestProgram("James", 100, 3,3);
		assertEquals(q.getName(),"James");
		assertEquals(q.getHitpoint(), 100 );
		assertEquals(q.getIsDead(),false);

		TestProgram r = new TestProgram();
		assertEquals(r.getName(),"basic");
		assertEquals(r.getDescription() ,"This is a basic object");
		assertEquals(r.getHitpoint(), 300 );
		assertEquals(r.getIsDead(),false);
		
	}
	
	@Test
	public void testSettersAndGetters() {
		
		t.setName("Rick");
		String desc = "This is a test";
		t.setDescription(desc);
		
		assertEquals("Rick", t.getName());
		assertEquals(desc, t.getDescription());		
		t.setHitpoint(1000);
		assertEquals(t.getHitpoint(),1000);
		t.setHitpoint(200);
		assertEquals(t.getHitpoint(),200);
		t.setHitpoint(1000.00);
		assertEquals(t.getHitpoint(),1000);
		t.setIsDead(true);
		assertEquals(t.getIsDead(),true);
		t.setIsDead(false);
		assertEquals(t.getIsDead(),false);
		
	}

}
