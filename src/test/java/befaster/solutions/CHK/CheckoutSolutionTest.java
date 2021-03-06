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
		Assert.assertEquals(Integer.valueOf(-1), checkoutSolution.checkout("-"));
	}

	@Test
	public void testCheckout() {
		Assert.assertEquals(Integer.valueOf(180 + 45 + 15), checkoutSolution.checkout("AABBAAD"));
	}

	@Test
	public void testCheckout1() {
		Assert.assertEquals(Integer.valueOf(200 + 45 + 50 + 130 + 15 + 80), checkoutSolution.checkout("AAAAABBABAAADEE"));
	}

	@Test
	public void testCheckout2() {
		Assert.assertEquals(Integer.valueOf(180 + 15 + 80), checkoutSolution.checkout("AAAADEE"));
	}

	@Test
	public void testCheckout3() {
		Assert.assertEquals(Integer.valueOf(20), checkoutSolution.checkout("FF"));
	}

	@Test
	public void testCheckout4() {
		Assert.assertEquals(Integer.valueOf(40 + 10), checkoutSolution.checkout("FFFFFFF"));
	}
}
