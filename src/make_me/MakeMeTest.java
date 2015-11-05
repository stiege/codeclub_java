package make_me;

import static org.junit.Assert.*;
import static make_me.MakeMe.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.Math;
import java.math.BigInteger;

public class MakeMeTest {
	private double rand = Math.random() * 10000;
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReturn_divide_by_two() {
		double val = return_divide_by_two(rand);
		assertEquals(rand/2, val, 0.1);
	}

	@Test
	public void testReturn_hello_world() {
		String ret = return_hello_world();
		assertEquals("hello world", ret.toLowerCase());
	}

	@Test
	public void testReturn_nth_fibonacci() {
		BigInteger ret = return_nth_fibonacci((int)rand);
		BigInteger i = new BigInteger("1");
		BigInteger j = new BigInteger("1");
		BigInteger next_val = new BigInteger("0");
		int start = (int) rand;
		while (start > 2){
			next_val = i.add(j);
			j = i;
			i = next_val;
			start--;
		}
		assertEquals(next_val, ret);
	}
	
	@Test
	public void testReturn_a_duck() {
		IDuck test_duck = return_a_duck();

		// Check the duck sounds like a duck
		assertEquals("quack", test_duck.quack());
		// Check the duck walks like a duck
		assertEquals("waddle, waddle, waddle", test_duck.walk());

		final class Bread implements IConsumable{
			boolean test_bread_eaten = false;
			
			@Override
			public String consume(){
				test_bread_eaten = true;
				return "Healthy goodness";
			}
			
			public boolean bread_was_consumed(){
				return test_bread_eaten;
			}
		}
		
		Bread test_bread = new Bread();
		test_duck.eat(test_bread);
		if (!test_bread.bread_was_consumed()){
			fail("Duck did not eat the bread it was given");
		}
	}

}
