package befaster.solutions.CHK;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckoutSolutionTest {
	private CheckoutSolution checkoutSolution;

	@Before
	public void setup() {
		checkoutSolution = new CheckoutSolution();
	}

	@Test
	public void testInvalidInput() {
		Assert.assertEquals(Integer.valueOf(-1), checkoutSolution.checkout("E"));
	}

	@Test
	public void testCheckout() {
		Assert.assertEquals(Integer.valueOf(180 + 45 + 15), checkoutSolution.checkout("AABBAAD"));
	}
}

