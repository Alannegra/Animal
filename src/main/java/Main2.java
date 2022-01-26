import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));
        //  System.out.println(System.getenv(""));

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        // File pathBinary = new File("src/main/resources/firefox");
        //  FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        // DesiredCapabilities desired = new DesiredCapabilities();
        FirefoxOptions options = new FirefoxOptions();
        // desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.nationalgeographic.com.es/animales");


        File file = new File("ImagenesYAnimales.txt");
        FileWriter fw = new FileWriter(file);

        List<WebElement> animalitos = new ArrayList<>();
        List<WebElement> imagenes = new ArrayList<>();
        List<WebElement> elements = new ArrayList<>();
        List<String> enlaces = new ArrayList<>();
        List<WebElement> cajitas = new ArrayList<>();


        animalitos = driver.findElements(new By.ByClassName("title"));
        imagenes = driver.findElements(new By.ByClassName("lazyloaded"));
        elements = driver.findElements(new By.ByClassName("element"));

        cajitas = driver.findElements(new By.ByClassName("thumb"));

        /*WebElement i = driver.findElement(new By.ByClassName("layloadad"));


        for (WebElement cajita : cajitas) {
            System.out.println(i.getAttribute("src"));
        }*/


        /*for (WebElement imagen: imagenes) {
            System.out.println(imagen.getAttribute("src"));
            fw.write(imagen.getAttribute("src")+"\n");
        }*/

        /*for (WebElement animalito: animalitos) {
            System.out.println(animalito.getText());
            fw.write(animalito.getText()+"\n");
            driver.get("https://www.nationalgeographic.com.es/animales/" + animalito.getText());
        }*/

        for (WebElement element: elements) {
            System.out.println(element);

            enlaces.add(element.getAttribute("href"));
        }


        for (String enlace: enlaces) {
            driver.navigate().to(enlace);
            driver.navigate().back();
        }







        fw.close();
        driver.close();


        //Cocodrilo

    }

}