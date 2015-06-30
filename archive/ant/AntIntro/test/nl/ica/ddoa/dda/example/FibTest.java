package nl.ica.ddoa.dda.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibTest {

	public FibTest(int input, int expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{{0,0},{1,1},{2,1},{3,2},{4,3},{5,5},{6,8}});
	}
	
	private int input;
	private int expectedOutput;
	
	@Test
	public void fibo()
	{
		assertEquals(expectedOutput, Fibonacci.maakKonijntjes(input));
	}
	
}
