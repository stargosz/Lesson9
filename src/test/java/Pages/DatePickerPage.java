package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerPage {

    WebDriver driver;
    LocalDate localDate = LocalDate.now();


    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#datepicker")
    WebElement datePickerInput;

    @FindBy(css = "a[title='Next']")
    WebElement monthNext;

    @FindBy(css = "a[title='Prev']")
    WebElement monthPrevious;

    @FindBy(css = ".ui-datepicker-title")
    WebElement fullDate;

    @FindBy(css = ".display-4")
    WebElement header;


    public void clickOnDatePickerInput() {
        datePickerInput.click();
    }
    public void clearDatePickerInput(){
        datePickerInput.clear();
        header.click();
    }

    public WebElement getDatePickerInput() {
        return datePickerInput;
    }

    public WebElement getFullDate() {
        return fullDate;
    }

    public void setDate(String day, String month, String year){
        String monthAndYear = month+" "+year;

        while(!getFullDate().getText().equals(monthAndYear)) {
            monthNext.click();
            Actions actions = new Actions(driver);
            actions.moveByOffset(10,10).build().perform();
            if (getFullDate().equals(monthAndYear)){
                break;
            }
        }
        WebElement dayNumber =  driver.findElement(By.xpath("//*[@class='ui-state-default' and text()='"+day+"']"));
        dayNumber.click();
    }

    public void setDateInPast(String day, String month, String year ){
        String monthAndYear = month+" "+year;
        while(!getFullDate().getText().equals(monthAndYear)) {
            monthPrevious.click();
            Actions actions = new Actions(driver);
            actions.moveByOffset(10,10).build().perform();
            if (getFullDate().equals(monthAndYear)){
                break;
            }
        }
        WebElement dayNumber =  driver.findElement(By.xpath("//*[@class='ui-state-default' and text()='"+day+"']"));
        dayNumber.click();
    }

    public void setTodaysDate(){
        String currentDay = localDate.format(DateTimeFormatter.ofPattern("dd"));
        WebElement dayNumber =  driver.findElement(By.xpath("//*[contains(@class,'ui-state-default') and contains(text(),'"+currentDay+"')]"));
        dayNumber.click();
    }
}
