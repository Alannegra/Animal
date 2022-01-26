import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BioParcAnimalFaun {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://www.bioparcvalencia.es/animal/sabana-africana/");
        File file = new File("MIRA.txt");
        FileWriter fw = new FileWriter(file);

        WebElement inputButtonNext = driver.findElement(new By.ById("pdcc-modal-accept"));
        inputButtonNext.click();

        List<WebElement> elements = new ArrayList<>();
        List<String> enlaces = new ArrayList<>();

        elements = driver.findElements(new By.ByClassName("habitat-box--ficha"));

        for (WebElement element: elements) {
            System.out.println(element);
            enlaces.add(element.getAttribute("href"));
        }

        List<WebElement> crs = new ArrayList<>();
        List<WebElement> extras = new ArrayList<>();
        List<WebElement> clases = new ArrayList<>();



        for (String enlace: enlaces) {
            driver.navigate().to(enlace);

             extras = driver.findElements(new By.ByClassName("vc_tta-panel-body"));

            crs = driver.findElements(new By.ByClassName("vc_tta-tab"));

            for (WebElement cr : crs) {
                cr.click();
                fw.write(cr.getText()+"\n");
                for (WebElement extra : extras) {

                    if(!extra.getText().isEmpty()){
                        fw.write(extra.getText()+"\n");
                        System.out.println(extra.getText());
                    }

                }
            }


             clases = driver.findElements(new By.ByClassName("box-ficha-animal--caracteristica"));

            for ( WebElement clase : clases) {
                System.out.println(clase.getText());
                fw.write(clase.getText()+"\n");
            }


            //driver.navigate().back();
        }

        fw.close();
        driver.close();

        //Cocodrilo

    }

}