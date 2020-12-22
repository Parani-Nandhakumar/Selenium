import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        //Creating Object reference
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        //Taking Screenshot
        File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File targetDirectory = new File(System.getProperty("user.dir") + "/src/Screenshot/screenshot.jpg");
        //Copying in to directory
        FileUtils.copyFile(screenshotFile,targetDirectory);
    }
}