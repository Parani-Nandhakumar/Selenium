import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class SoftAssertion {
    public static void main(String[] args) throws IOException {
        /*
        * This example is to go to below url and try to connect to the url in below WebElements
        * and check the response code whether url is broken or working
        */
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> webElementList = driver.findElements(By.cssSelector("li[class='gf-li'] > a"));
        //SoftAssert declaration
        SoftAssert softAssert = new SoftAssert();
        for(WebElement list : webElementList){
            String url = list.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int code = connection.getResponseCode();
            System.out.println("Response code is: " + code);
            //Below code waits till end of loop to print the fail message
            //SoftAssert prevents the execution stoppage for a failure
            softAssert.assertTrue(code<400,"Response code is greater than 400");
        }
        softAssert.assertAll();
    }
}