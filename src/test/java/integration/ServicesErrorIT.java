package integration;

import java.lang.reflect.Method;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.coveros.selenified.selenium.Action;
import com.coveros.selenified.selenium.Selenium.DriverSetup;
import com.coveros.selenified.services.Request;
import com.coveros.selenified.tools.TestBase;
import com.google.gson.JsonObject;

public class ServicesErrorIT extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        // set the base URL for the tests here
        setTestSite("https://bad.url.com/");
        // set the author of the tests here
        setAuthor("Max Saperstone\n<br/>max.saperstone@coveros.com");
        // set the version of the tests or of the software, possibly with a
        // dynamic check
        setVersion("0.0.1");
    }

    @BeforeMethod(alwaysRun = true)
    protected void startTest(Object[] dataProvider, Method method, ITestContext test, ITestResult result) {
        super.startTest(dataProvider, method, test, result, DriverSetup.FALSE);
    }

    @Test(groups = { "integration", "services", "httpget",
            "virtual" }, description = "An integration test to verify the response code from a get call")
    public void compareGetResponseCode200Test() {
        // use this object to verify the page looks as expected
        Action actions = this.actions.get();
        // perform some actions
        actions.call().get("posts/").assertEquals(200);
        // verify 2 issues
        finish(2);
    }

    @Test(groups = { "integration", "services", "httppost",
            "virtual" }, description = "An integration test to verify the response code from a post call")
    public void comparePostResponseCode201Test() {
        JsonObject request = new JsonObject();
        request.addProperty("title", "foo");
        request.addProperty("body", "bar");
        request.addProperty("userId", 2);
        // use this object to verify the page looks as expected
        Action actions = this.actions.get();
        // perform some actions
        actions.call().post("posts/", new Request(request)).assertEquals(201);
        // verify 2 issues
        finish(2);
    }

    @Test(groups = { "integration", "services", "httpput",
            "virtual" }, description = "An integration test to verify the response code from a put call")
    public void comparePutResponseCode200Test() {
        JsonObject request = new JsonObject();
        request.addProperty("id", 1);
        request.addProperty("title", "foo1");
        request.addProperty("body", "bar");
        request.addProperty("userId", 3);
        // use this object to verify the page looks as expected
        Action actions = this.actions.get();
        // perform some actions
        actions.call().put("posts/3", new Request(request)).assertEquals(200);
        // verify 2 issues
        finish(2);
    }

    @Test(groups = { "integration", "services", "httppatch",
            "virtual" }, description = "An integration test to verify the response code from a patch call")
    public void comparePatchResponseCode200Test() {
        JsonObject request = new JsonObject();
        request.addProperty("id", 1);
        request.addProperty("title", "foo1");
        request.addProperty("body", "bar");
        request.addProperty("userId", 4);
        // use this object to verify the page looks as expected
        Action actions = this.actions.get();
        // perform some actions
        actions.call().patch("posts/4", new Request(request)).assertEquals(200);
        // verify 2 issues
        finish(2);
    }

    @Test(groups = { "integration", "services", "httpdelete",
            "virtual" }, description = "An integration test to verify the response code from a delete call")
    public void compareDeleteResponseCode200Test() {
        JsonObject request = new JsonObject();
        request.addProperty("id", 1);
        request.addProperty("title", "foo1");
        request.addProperty("body", "bar");
        request.addProperty("userId", 5);
        // use this object to verify the page looks as expected
        Action actions = this.actions.get();
        // perform some actions
        actions.call().delete("posts/5", new Request(request)).assertEquals(200);
        // verify 2 issues
        finish(2);
    }
}