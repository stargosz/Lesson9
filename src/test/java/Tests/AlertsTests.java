package Tests;

import Pages.AlertsPage;
import TestBase.TestBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AlertsTests extends TestBase {
    AlertsPage alertsPage = new AlertsPage(getDriver());

    @ParameterizedTest
    @DisplayName("Open 'seleniumui.moderntester' web page")
    @Order(1)
    @ValueSource(strings = "Automation Pratice")
    public void shouldOpenWebPage(String title) {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle, is(title));
    }

    @ParameterizedTest
    @Order(2)
    @DisplayName("Click prompt alert button and send keys to the alert")
    @CsvSource({"Hello Lord Vader! How are you today?, Lord Vader"})
    public void shouldSendKeysToAlertBox(String message, String name){
        alertsPage.clickPromptAlertButton();
        getDriver().switchTo().alert().sendKeys(name);
        getDriver().switchTo().alert().accept();
        assertThat(alertsPage.getPromptAlertMessage().getText(), is(message));
    }

    @ParameterizedTest
    @Order(3)
    @DisplayName("Click confirm alert button accepts and then cancels it")
    @CsvSource("You pressed OK!, You pressed Cancel!")
    public void shouldAcceptThenCancelConfirmationAlert(String messageOk, String messageCancel){
        alertsPage.clickConfirmAlertButton();
        getDriver().switchTo().alert().accept();
        assertThat(alertsPage.getConfirmAlertMessage().getText(), is(messageOk));
        alertsPage.clickConfirmAlertButton();
        getDriver().switchTo().alert().dismiss();
        assertThat(alertsPage.getConfirmAlertMessage().getText(), is(messageCancel));
    }

}
