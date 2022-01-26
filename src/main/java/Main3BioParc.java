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

public class Main3BioParc {

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
        driver.get("https://www.bioparcvalencia.es/animal/sabana-africana/");


        File file = new File("BioParc.txt");
        FileWriter fw = new FileWriter(file);

        WebElement inputButtonNext = driver.findElement(new By.ById("pdcc-modal-accept"));



        inputButtonNext.click();


        List<WebElement> animalitos = new ArrayList<>();
        List<WebElement> imagenes = new ArrayList<>();
        List<WebElement> cajitas = new ArrayList<>();

        List<WebElement> elements = new ArrayList<>();
        List<String> enlaces = new ArrayList<>();



        animalitos = driver.findElements(new By.ByClassName("title"));
        imagenes = driver.findElements(new By.ByClassName("lazyloaded"));

        elements = driver.findElements(new By.ByClassName("habitat-box--ficha"));

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

        System.out.println(elements.size());

        for (WebElement element: elements) {
            System.out.println(element);
            enlaces.add(element.getAttribute("href"));
        }

        List<WebElement> crs = new ArrayList<>();

        for (String enlace: enlaces) {

            crs = driver.findElements(new By.ByClassName("vc_tta-tab"));

            for (WebElement cr : crs) {
                System.out.println(cr.getText());
            }

            driver.navigate().to(enlace);
            WebElement clase = driver.findElement(new By.ByClassName("box-ficha-animal--caracteristica"));

            System.out.println(clase.getText());
            fw.write(clase.getText()+"\n");

            //WebElement inputButtonAnyos = driver.findElement(new By.ByClassName("vc_tta-icon fas fa-adjust"));
            //inputButtonAnyos.click();
            //WebElement anyos = driver.findElement(new By.ByClassName("vc_tta-title-text"));
            //System.out.println(anyos.getText());
            driver.navigate().back();
        }

        fw.close();
        driver.close();

        //Cocodrilo

    }

}