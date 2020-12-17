import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().fullscreen();
        Actions actions = new Actions(driver);
        /*
        * Frames is a web page within a web page
        * so to do operations inside frames, we have to use below declarations to go inside frames
        * once we are in to the frame, we can use actions call to do specific operations
        */
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        WebElement source = driver.findElement(By.cssSelector("div#draggable"));
        WebElement target = driver.findElement(By.cssSelector("div#droppable"));
        actions.dragAndDrop(source,target).build().perform();
        //Once operated we can switch to driver object to do operations outside of frame
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("h2.logo > a")).click();
    }
}
