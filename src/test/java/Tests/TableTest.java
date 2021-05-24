package Tests;

import Pages.TablePage;
import TestBase.TestBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TableTest extends TestBase {
    TablePage tablePage = new TablePage(getDriver());

    @ParameterizedTest
    @DisplayName("Open 'seleniumui.moderntester' web page")
    @Order(1)
    @ValueSource(strings = "Automation Pratice")
    public void shouldOpenWebPage(String title) {
        getDriver().get("https://seleniumui.moderntester.pl/table.php");
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle, is(title));
    }

    @Test
    @Order(2)
    @DisplayName("Prints out 'Rank', 'Peak' and 'Mountain range' of mountains that are in 'Switzerland' and are higher than 4000 m")
    public void shouldPrintPeaksHigherThan4000InSwitzerland() {
        tablePage.getAllMountainsData();
        for (WebElement rows : tablePage.getAllMountainsData()) {
            List<WebElement> signleRow = rows.findElements(By.cssSelector("td"));
            List<WebElement> ranks = rows.findElements(By.cssSelector("tbody th"));
            if ((signleRow.get(2).getText().contains("Switzerland"))) {
                if (Integer.parseInt(signleRow.get(3).getText()) > 4000) {
                    String matchingData = ("Rank: "+ranks.get(0).getText() + ", Peak: " + signleRow.get(0).getText() + ", Mountain range: " + signleRow.get(1).getText());
                    System.out.println(matchingData);
                }
            }
        }
    }
}
