package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablePage {
    WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "tbody tr")
    List<WebElement> allMountainsData;

    @FindBy(css = "td")
    List<WebElement> allColumns;

    @FindBy(css = "tbody th")
    List<WebElement> ranks;

    public List<WebElement> getRanks() {
        return ranks;
    }

    public void setRanks(List<WebElement> ranks) {
        this.ranks = ranks;
    }

    public List<WebElement> getAllMountainsData() {
        return allMountainsData;
    }

    public void setAllMountainsData(List<WebElement> allMountainsData) {
        this.allMountainsData = allMountainsData;
    }

    public List<WebElement> getAllColumns() {
        return allColumns;
    }

    public void setAllColumns(List<WebElement> allColumns) {
        this.allColumns = allColumns;
    }
}
