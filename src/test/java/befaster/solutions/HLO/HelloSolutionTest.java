package befaster.solutions.HLO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloSolutionTest {
	private HelloSolution hello;

	@Before
	public void setup() {
		hello = new HelloSolution();
	}

	@Test
	public void testHello() {
		Assert.assertEquals("Hello, test", hello.hello("test"));
	}
}
