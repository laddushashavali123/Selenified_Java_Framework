package integration;

import com.coveros.selenified.Browser.BrowserName;
import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.testng.Assert.*;

public class ActionGetIT extends WebBase {

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getBrowser method")
    public void getBrowserTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        if (app.getBrowser().getName() == BrowserName.NONE) {
            app.getOutputFile().addError();
        }
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getDesiredCapabilities method")
    public void getCapabilitiesTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        if (app.getDesiredCapabilities() == null) {
            app.getOutputFile().addError();
        }
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration test to check the getCookie method")
    public void getCookieTest() throws IOException, ParseException {
        // the cookie date
        String dateval = "2019-12-18T12:00:00";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        Cookie cookie = app.get().cookie("cookie");
        assertEquals(cookie, new Cookie("cookie", "cookietest", "/", df.parse(dateval)));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration negative test to check the getCookie method")
    public void negativeGetCookieTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        Cookie cookie = app.get().cookie("badcookie");
        assertNull(cookie);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration negative test to check the getCookie method")
    public void negativeGetCookieNullTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.killDriver();
        Cookie cookie = app.get().cookie("badcookie");
        assertNull(cookie);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration test to check the getCookieValue method")
    public void getCookieValueTest() throws IOException, ParseException {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String cookie = app.get().cookieValue("cookie");
        assertEquals(cookie, "cookietest");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration negative test to check the getCookieValue method")
    public void negativeGetCookieValueTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String cookie = app.get().cookieValue("badcookie");
        assertNull(cookie);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration test to check the getCookiePath method")
    public void getCookiePathTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String cookie = app.get().cookiePath("cookie");
        assertEquals(cookie, "/");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration negative test to check the getCookiePath method")
    public void negativeGetCookiePathTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String cookie = app.get().cookiePath("badcookie");
        assertNull(cookie);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration test to check the getCookieDomain method")
    public void getCookieDomainTest(ITestContext context) {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String cookie = app.get().cookieDomain("cookie");
        assertEquals(cookie, getTestSite(this.getClass().getName(), context).split("/")[2].split(":")[0]);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration negative test to check the getCookieDomain method")
    public void negativeGetCookieDomainTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String cookie = app.get().cookieDomain("badcookie");
        assertNull(cookie);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration test to check the getCookieExpiration method")
    public void getCookieExpirationTest() throws IOException, ParseException {
        // the cookie date
        String dateval = "2019-12-18T12:00:00";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        Date cookie = app.get().cookieExpiration("cookie");
        assertEquals(cookie, df.parse(dateval));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get", "cookie"},
            description = "An integration negative test to check the getCookieExpiration method")
    public void negativeGetCookieExpirationTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        Date cookie = app.get().cookieExpiration("badcookie");
        assertNull(cookie);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectOptions method")
    public void getSelectOptionsTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String[] options = app.newElement(Locator.NAME, "car_list").get().selectOptions();
        assertEquals(options, new String[]{"Volvo", "Saab", "Mercedes", "Audi"});
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectOptions method")
    public void getSelectOptionsNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String[] options = app.newElement(Locator.NAME, "non-existent-name", 0).get().selectOptions();
        assertNull(options);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectOptions method")
    public void getSelectValuesTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String[] options = app.newElement(Locator.NAME, "car_list").get().selectValues();
        assertEquals(options, new String[]{"volvo", "saab", "mercedes", "audi"});
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectOptions method")
    public void getSelectValuesNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String[] options = app.newElement(Locator.NAME, "non-existent-name", 0).get().selectValues();
        assertNull(options);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getNumOfSelectOptions method")
    public void getNumOfSelectOptionsTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        int options = app.newElement(Locator.NAME, "car_list").get().numOfSelectOptions();
        assertEquals(options, 4);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getNumOfSelectOptions method")
    public void getNumOfSelectOptionsNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        int options = app.newElement(Locator.NAME, "non-existent-name", 0).get().numOfSelectOptions();
        assertEquals(options, 0);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getNumOfTableRows method")
    public void getNumOfTableRowsTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        int rows = app.newElement(Locator.ID, "table").get().numOfTableRows();
        assertEquals(rows, 7);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getNumOfTableRows method")
    public void getNumOfTableRowsNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        int rows = app.newElement(Locator.ID, "non-existent-name", 0).get().numOfTableRows();
        assertEquals(rows, 0);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getNumOfTableColumns method")
    public void getNumOfTableColumnsTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        int columns = app.newElement(Locator.ID, "table").get().numOfTableColumns();
        assertEquals(columns, 4);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getNumOfTableColumns method")
    public void getNumOfTableColumnsNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        int columns = app.newElement(Locator.ID, "non-existent-name", 0).get().numOfTableColumns();
        assertEquals(columns, 0);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableRow method")
    public void getTableRowTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<WebElement> row = app.newElement(Locator.ID, "table").get().tableRow(1);
        assertEquals(row.size(), 4);
        assertEquals(row.get(0).getText(), "President");
        assertEquals(row.get(1).getText(), "Alfreds Futterkiste");
        assertEquals(row.get(2).getText(), "Maria Anders");
        assertEquals(row.get(3).getText(), "Germany");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableRow method")
    public void getTableRowNoRowTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<WebElement> row = app.newElement(Locator.ID, "table", 0).get().tableRow(99);
        assertEquals(row, new ArrayList<>());
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableRow method")
    public void getTableRowNotTableTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<WebElement> row = app.newElement(Locator.ID, "input_box", 0).get().tableRow(1);
        assertNull(row);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableRow method")
    public void getTableRowNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<WebElement> row = app.newElement(Locator.ID, "non-existent-name").get().tableRow(1);
        assertNull(row);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableRow method")
    public void getTableRowsTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<WebElement> rows = app.newElement(Locator.ID, "table", 1).get().tableRows();
        assertEquals(rows.size(), 7);
        assertTrue(rows.get(0).getText().matches("\\s*Company\\s*Contact\\s*Country"));
        assertTrue(
                rows.get(1).getText().matches("President\\s*Alfreds\\s*Futterkiste\\s*Maria\\s*Anders\\s*Germany"));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableRow method")
    public void getTableRowsNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<WebElement> rows = app.newElement(Locator.ID, "non-existent-name", 1).get().tableRows();
        assertNull(rows);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableColumn method")
    public void getTableColumnTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<WebElement> column = app.newElement(Locator.ID, "table").get().tableColumn(1);
        assertEquals(column.size(), 7);
        assertEquals(column.get(0).getText(), "Company");
        assertEquals(column.get(1).getText(), "Alfreds Futterkiste");
        assertEquals(column.get(2).getText(), "Centro comercial Moctezuma");
        assertEquals(column.get(3).getText(), "Ernst Handel");
        assertEquals(column.get(4).getText(), "Island Trading");
        assertEquals(column.get(5).getText(), "Laughing Bacchus Winecellars");
        assertEquals(column.get(6).getText(), "Magazzini Alimentari Riuniti");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableColumn method")
    public void getTableColumnNoColumnTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<WebElement> column = app.newElement(Locator.ID, "table", 0).get().tableColumn(99);
        assertEquals(column, new ArrayList<>());
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableColumn method")
    public void getTableColumnNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<WebElement> column = app.newElement(Locator.ID, "non-existent-name").get().tableColumn(1);
        assertNull(column);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableColumn method")
    public void getTableColumnNotTableTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<WebElement> column = app.newElement(Locator.ID, "transparent_input").get().tableColumn(1);
        assertNull(column);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableColumn method")
    public void getTableColumnsTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<List<WebElement>> columns = app.newElement(Locator.ID, "table", 1).get().tableColumns();
        assertEquals(columns.size(), 4);
        assertEquals(columns.get(1).get(0).getText(), "Company");
        assertEquals(columns.get(1).get(1).getText(), "Alfreds Futterkiste");
        assertEquals(columns.get(1).get(2).getText(), "Centro comercial Moctezuma");
        assertEquals(columns.get(1).get(3).getText(), "Ernst Handel");
        assertEquals(columns.get(1).get(4).getText(), "Island Trading");
        assertEquals(columns.get(1).get(5).getText(), "Laughing Bacchus Winecellars");
        assertEquals(columns.get(1).get(6).getText(), "Magazzini Alimentari Riuniti");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableColumn method")
    public void getTableColumnsNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        List<List<WebElement>> columns = app.newElement(Locator.ID, "non-existent-name", 1).get().tableColumns();
        assertNull(columns);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableCell method")
    public void getTableCellTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        WebElement cell = app.newElement(Locator.ID, "table").get().tableCell(1, 1);
        assertEquals(cell.getText(), "Alfreds Futterkiste");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableCell method")
    public void getTableCellNoCellWideTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        WebElement cell = app.newElement(Locator.ID, "table", 0).get().tableCell(1, 99);
        assertNull(cell);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableCell method")
    public void getTableCellNoCellLongTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        WebElement cell = app.newElement(Locator.ID, "table").get().tableCell(99, 1);
        assertNull(cell);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableCell method")
    public void getTableCellNoCellTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        WebElement cell = app.newElement(Locator.ID, "table").get().tableCell(99, 99);
        assertNull(cell);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getTableCell method")
    public void getTableCellNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        WebElement cell = app.newElement(Locator.ID, "non-existent-name").get().tableCell(1, 1);
        assertNull(cell);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedText method")
    public void getSelectedTextTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String text = app.newElement(Locator.ID, "car_list").get().selectedOption();
        assertEquals(text, "Volvo");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedText method")
    public void getSelectedTextNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String text = app.newElement(Locator.ID, "non-existent-name", 0).get().selectedOption();
        assertNull(text);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedText method")
    public void getSelectedTextNotSelectTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String text = app.newElement(Locator.ID, "table").get().selectedOption();
        assertNull(text);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedTexts method")
    public void getSelectedTextsTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String[] text = app.newElement(Locator.ID, "car_list").get().selectedOptions();
        assertEquals(text, new String[]{"Volvo"});
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedTexts method")
    public void getSelectedTextsNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String[] text = app.newElement(Locator.ID, "non-existent-name", 0).get().selectedOptions();
        assertNull(text);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedTexts method")
    public void getSelectedTextsNotSelectTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String[] text = app.newElement(Locator.ID, "table").get().selectedOptions();
        assertNull(text);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedValue method")
    public void getSelectedValueTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String value = app.newElement(Locator.ID, "car_list").get().selectedValue();
        assertEquals(value, "volvo");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedValue method")
    public void getSelectedValueNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String value = app.newElement(Locator.ID, "non-existent-name", 0).get().selectedValue();
        assertNull(value);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedValue method")
    public void getSelectedValueNotSelectTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String value = app.newElement(Locator.ID, "table").get().selectedValue();
        assertNull(value);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedValues method")
    public void getSelectedValuesTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String[] value = app.newElement(Locator.ID, "car_list").get().selectedValues();
        assertEquals(value, new String[]{"volvo"});
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedValues method")
    public void getSelectedValuesNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String[] value = app.newElement(Locator.ID, "non-existent-name", 0).get().selectedValues();
        assertNull(value);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getSelectedValues method")
    public void getSelectedValuesNotSelectTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String[] value = app.newElement(Locator.ID, "table").get().selectedValues();
        assertNull(value);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getText method")
    public void getTextTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String text = app.newElement(Locator.ID, "disable_click").get().text();
        assertEquals(text, "Click me to Disable/Enable a html button");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getText method")
    public void getTextNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String text = app.newElement(Locator.ID, "non-existent-name", 0).get().text();
        assertNull(text);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getValue method")
    public void getValueTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String text = app.newElement(Locator.ID, "input_box").get().value();
        assertEquals(text, "");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getValue method")
    public void getValueNotInputTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String text = app.newElement(Locator.ID, "disable_click", 0).get().value();
        assertNull(text);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getValue method")
    public void getValueNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String text = app.newElement(Locator.ID, "non-existent-name").get().value();
        assertNull(text);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getCss method")
    public void getCssTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String css = app.newElement(Locator.ID, "disable_click").get().css("display");
        assertEquals(css, "block");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getCss method")
    public void getCssWonkyTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String css = app.newElement(Locator.ID, "disable_click", 0).get().css("some-bad-css-attribute");
        assertEquals(css, "");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getCss method")
    public void getCssNullTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String css = app.newElement(Locator.ID, "disable_click", 0).get().css(null);
        assertNull(css);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getCss method")
    public void getCssNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String css = app.newElement(Locator.ID, "non-existent-name").get().css("display");
        assertNull(css);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getAttribute method")
    public void getAttributeTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String attribute = app.newElement(Locator.ID, "disable_click").get().attribute("class");
        assertEquals(attribute, "click");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getAttribute method")
    public void getAttributeWonkyTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String attribute = app.newElement(Locator.ID, "disable_click", 0).get().attribute("some-bad-attribute");
        assertNull(attribute);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getAttribute method")
    public void getAttributeNullTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String attribute = app.newElement(Locator.ID, "disable_click", 0).get().attribute(null);
        assertNull(attribute);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getAttribute method")
    public void getAttributeNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        String attribute = app.newElement(Locator.ID, "non-existent-name").get().attribute("display");
        assertNull(attribute);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getAllAttribute method")
    public void getAllAttributeTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        Map<String, String> attributes = app.newElement(Locator.ID, "disable_click").get().allAttributes();
        Map<String, String> expected = new HashMap<>();
        expected.put("id", "disable_click");
        expected.put("class", "click");
        assertEquals(attributes, expected);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getAllAttribute method")
    public void getAllAttributeNoneTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        Map<String, String> attributes = app.newElement(Locator.TAGNAME, "thead", 0).get().allAttributes();
        Map<String, String> expected = new HashMap<>();
        assertEquals(attributes, expected);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "A negative integration test to check the getAllAttribute method")
    public void getAllAttributeNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        Map<String, String> attributes = app.newElement(Locator.ID, "non-existent-name").get().allAttributes();
        assertEquals(attributes, new HashMap<>());
        // verify 0 issue
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getEval method")
    public void getEvalTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        Element cars = app.newElement(Locator.ID, "car_list");
        assertTrue(cars.is().present());
        app.get().eval("document.body.innerHTML = '';");
        assertFalse(cars.is().present());
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getEval method")
    public void getEvalResultTest(Method method, ITestContext test) {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertEquals(app.get().eval("return window.location.href;"),
                getTestSite(method.getDeclaringClass().getName(), test));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getEval method")
    public void getEvalNullResultTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertNull(app.get().eval("document.body.innerHTML = '';"));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration negative test to check the getEval method")
    public void getEvalBadDriverTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.killDriver();
        assertNull(app.get().eval("document.body.innerHTML = '';"));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getEval method")
    public void getElementEvalTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        Element disabled = app.newElement(Locator.ID, "disable_click", 0);
        assertTrue(disabled.is().present());
        disabled.get().eval("arguments[0].remove();");
        assertFalse(disabled.is().present());
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getEval method")
    public void getElementEvalResultTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertEquals(app.newElement(Locator.ID, "disable_click", 0).get().eval("return arguments[0].innerHTML;"),
                "Click me to Disable/Enable a html button");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getEval method")
    public void getElementEvalNullResultTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertNull(app.newElement(Locator.ID, "disable_click", 0).get().eval("arguments[0].remove();"));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getEval method")
    public void getElementEvalNullTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertNull(app.newElement(Locator.ID, "disable_click", 0).get().eval(null));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "A negative integration test to check the getEval method")
    public void getElementEvalNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertNull(app.newElement(Locator.ID, "non-existent-name").get().eval("return document.location"));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getPrompt method")
    public void getPromptTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.newElement(Locator.ID, "prompt_button").click();
        String prompt = app.get().prompt();
        assertEquals(prompt, "What do you think?");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "A integration negative test to check the getPrompt method")
    public void negativeGetPromptTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.get().prompt();
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getConfirmation method")
    public void getConfirmationTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.newElement(Locator.ID, "confirm_button").click();
        String confirm = app.get().confirmation();
        assertEquals(confirm, "Is this not great?");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration negative test to check the getConfirmation method")
    public void negativeGetConfirmationTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.get().confirmation();
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getAlert method")
    public void getAlertTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.newElement(Locator.ID, "disable_click").click();
        app.newElement(Locator.ID, "alert_button").click();
        String alert = app.get().alert();
        assertEquals(alert, "Enabled!");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration negative test to check the getAlert method")
    public void negativeGetAlertTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.get().alert();
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getHtmlSource method")
    public void getHtmlSourceTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.newElement(Locator.ID, "submit_button", 0).click();
        String source = app.get().htmlSource();
        assertTrue(source.contains("You're on the next page"));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration negative test to check the getHtmlSource method")
    public void getHtmlSourceBadDriverTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.killDriver();
        assertNull(app.get().htmlSource());
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getElementMatchCount method")
    public void getElementMatchCountTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertEquals(app.newElement(Locator.ID, "submit_button").get().matchCount(), 1);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the getElementMatchCount method")
    public void getElementMatchCountMultipleTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertEquals(app.newElement(Locator.CLASSNAME, "overlay").get().matchCount(), 3);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration negative test to check the getElementMatchCount method")
    public void getElementMatchCountNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertEquals(app.newElement(Locator.ID, "non-existent-name").get().matchCount(), 0);
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getXPath method")
    public void getElementXPathTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertEquals(app.newElement(Locator.CLASSNAME, "overlay").get().xPath(), "id(\"overlay_span\")");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the getXPath method")
    public void getElementXPathDivTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertEquals(app.newElement(Locator.TAGNAME, "tr").get().xPath(), "id(\"align_table\")/tbody[1]/tr[1]");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration negative test to check the getXPath method")
    public void getElementXPathNotExistTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertNull(app.newElement(Locator.ID, "non-existent-name").get().xPath());
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration test to check the get location method")
    public void getLocationTest(Method method, ITestContext test) {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertEquals(app.get().location(), getTestSite(method.getDeclaringClass().getName(), test));
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration negative test to check the get location method")
    public void getLocationBadDriverTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.killDriver();
        assertNull(app.get().location());
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"}, description = "An integration test to check the get title method")
    public void getTitleTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        assertEquals(app.get().title(), "Selenified Test Page");
        // verify no issues
        finish();
    }

    @Test(groups = {"integration", "actions", "get"},
            description = "An integration negative test to check the get title method")
    public void getTitleBadDriverTest() {
        // use this object to manipulate the app
        App app = this.apps.get();
        // perform some actions
        app.killDriver();
        assertNull(app.get().title());
        // verify no issues
        finish();
    }
}