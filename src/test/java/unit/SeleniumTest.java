package unit;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenified.exceptions.InvalidBrowserException;
import tools.output.Selenium.Browsers;
import tools.output.Selenium.DriverSetup;

public class SeleniumTest {
	
	@Test
	public void DriverSetupTest() {
		Assert.assertFalse(DriverSetup.FALSE.useBrowser());
		Assert.assertTrue(DriverSetup.OPEN.useBrowser());
		Assert.assertTrue(DriverSetup.LOAD.useBrowser());

		Assert.assertFalse(DriverSetup.FALSE.loadPage());
		Assert.assertFalse(DriverSetup.OPEN.loadPage());
		Assert.assertTrue(DriverSetup.LOAD.loadPage());
	}
	
	@Test
	public void BrowsersTest() throws InvalidBrowserException {
		Assert.assertEquals(Browsers.lookup("CHROME"), Browsers.CHROME);
		Assert.assertEquals(Browsers.lookup("chrome"), Browsers.CHROME);
		Assert.assertEquals(Browsers.lookup("cHroMe"), Browsers.CHROME);
	}

	@Test(expectedExceptions = InvalidBrowserException.class)
	public void BrowsersInvalidTest() throws InvalidBrowserException {
		Browsers.lookup("HELLOWORLD");
	}
}