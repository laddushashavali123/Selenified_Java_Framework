package integration;

import com.coveros.selenified.application.App;
import com.coveros.selenified.exceptions.InvalidBrowserException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import static com.coveros.selenified.DriverSetup.FALSE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class NoBrowserIT extends WebBase {

    @BeforeMethod(alwaysRun = true)
    protected void startTest(Object[] dataProvider, Method method, ITestContext test, ITestResult result) throws InvalidBrowserException, MalformedURLException {
        super.startTest(dataProvider, method, test, result, FALSE);
    }

    @Test(groups = {"integration"}, description = "An integration test to verify we can start a test without a browser")
    public void verifyNoBrowser() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // verify no selenium actions class was setup
        assertNull(app);
        // verify no issues
        finish();
    }
}