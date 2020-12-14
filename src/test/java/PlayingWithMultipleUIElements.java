import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PlayingWithMultipleUIElements {
    public static void main(String[] args) throws InterruptedException {
        //setting chromedriver location
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
        //Selecting Round Trip Button
        driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).click();
        //Selecting From Drop Down
        driver.findElement(By.cssSelector("input#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(1000);
        //Selecting To Drop Down
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CJB']")).click();
        //Checking & Selecting Calender For Specific Month [From]
        while (!driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText().equalsIgnoreCase("March")) {
            driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
        }
        //Checking & Selecting Calender For Specific date [From]
        List<WebElement> dateElement = driver.findElements(By.cssSelector("a.ui-state-default"));
        int totaldateElement = dateElement.size();
        for(int i=0;i<totaldateElement;i++){
            String dateCaptured = dateElement.get(i).getText();
            if(dateCaptured.equalsIgnoreCase("22")){
                dateElement.get(i).click();
                break;
            }
        }
        //Checking & Selecting Calender For Specific Month [To]
        driver.findElement(By.cssSelector("input#ctl00_mainContent_view_date2")).click();
        while (!driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText().equalsIgnoreCase("March")) {
            driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
        }
        //Checking & Selecting Calender For Specific date [To]
        List<WebElement> returnDateElement = driver.findElements(By.cssSelector("a.ui-state-default"));
        int totalReturnDateElement = returnDateElement.size();
        for(int i=0;i<totalReturnDateElement;i++){
            String returnDateCaptured = returnDateElement.get(i).getText();
            if(returnDateCaptured.equalsIgnoreCase("24")){
                returnDateElement.get(i).click();
                break;
            }
        }
        //Selecting Amount of Passengers Using Select Class
        driver.findElement(By.cssSelector("div#divpaxinfo")).click();
        WebElement adultWebElement = driver.findElement(By.cssSelector("select#ctl00_mainContent_ddl_Adult"));
        Select select = new Select(adultWebElement);
        select.selectByValue("2");
        //Clicking Student CheckBox
        driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_StudentDiscount")).click();
        //Clicking Search Button
        driver.findElement(By.cssSelector("input#ctl00_mainContent_btn_FindFlights")).click();
    }
}