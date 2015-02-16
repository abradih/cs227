package lab5;

import org.junit.Test;
import org.junit.Before;

import balloon1.Balloon;
import static org.junit.Assert.assertEquals;

public class BalloonTest1 {
	// margin of error
	private static final double EPSILON = 10e-07;

	// new balloon
	private Balloon a;

	@Before
	public void setup() // runs before every test case
	{
		a = new Balloon(5);
	}

	// new balloon has no radius
	@Test
	public void TestRadius() {
		assertEquals(0.0, a.getRadius(), EPSILON);
	}

	// new balloon should not be popped
	@Test
	public void TestNotPopped() {
		assertEquals(false, a.isPopped());
	}

	// blow equals the radius
	@Test
	public void TestBlow() {
		a.blow(2);
		assertEquals(2, a.getRadius(), EPSILON);
	}

	// Popped balloon has a radius of zero
	@Test
	public void TestPopRadius() {
		a.blow(6);
		assertEquals(0, a.getRadius(), EPSILON);
	}

	// Test if balloon under inflated pops, No!
	@Test
	public void TestNotPop() {
		a.blow(4);
		assertEquals(false, a.isPopped());
	}

	// Test if balloon over inflated pops, Yes!
	@Test
	public void TestPop() {
		a.blow(6);
		assertEquals(true, a.isPopped());
	}

	// Test if balloon is deflated
	@Test
	public void TestDeflate() {
		a.blow(4);
		a.deflate();
		assertEquals(0, a.getRadius());
	}

	// Test if deflated balloon is popped
	@Test
	public void TestNotPoppeddeflate() {
		a.blow(4);
		a.deflate();
		assertEquals(false, a.isPopped());
	}

	// Test if deflated popped balloon is popped
	@Test
	public void TestPoppedDeflate() {
		a.blow(6);
		a.deflate();
		assertEquals(true, a.isPopped());
	}

	// test raduis of popped and deflated balloon
	@Test
	public void TestPoppedDeflateRadius() {
		a.blow(6);
		a.deflate();
		assertEquals(0, a.getRadius());
	}

	//test cant blow up popped balloon
	@Test
	public void TestBlowPoppedBalloon() {
		a.blow(6);
		a.blow(1);
		assertEquals(0, a.getRadius());
		assertEquals(true, a.isPopped());
	}
	
	//double blow
	@Test
	public void TestBlowTwice() {
		a.blow(2);
		a.blow(1);
		assertEquals(3, a.getRadius());
		assertEquals(false, a.isPopped());
	}
	
}
