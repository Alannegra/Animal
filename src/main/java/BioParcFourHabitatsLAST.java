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

public class BioParcFourHabitatsLAST {


    public static void main(String[] args) throws IOException {

        CodeCracker codeCracker = new CodeCracker();

        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://www.bioparcvalencia.es/animales/habitats");
        File file = new File("HabitatAnimal.txt");
        FileWriter fw = new FileWriter(file);

        WebElement inputButtonNext = driver.findElement(new By.ById("pdcc-modal-accept"));
        inputButtonNext.click();

        //----------
        List<WebElement> habitats = new ArrayList<>();
        List<String> enlacesHabitats = new ArrayList<>();
        List<WebElement> elements = new ArrayList<>();
        List<String> enlaces = new ArrayList<>();

        List<WebElement> crs = new ArrayList<>();
        List<WebElement> extras = new ArrayList<>();
        List<WebElement> clases = new ArrayList<>();

        habitats = driver.findElements(new By.ByClassName("boxed"));

        for (WebElement habitat: habitats) {

            enlacesHabitats.add(habitat.findElement(new By.ByTagName("a")).getAttribute("href"));

            String habitatTiulo = habitat.findElement(new By.ByClassName("box-text--titulo")).getText();
            //String habitatDescripcion = habitat.findElement(new By.ByClassName("box-text--content")).getText();

            WebElement habitatDescripcionTotal = habitat.findElement(new By.ByClassName("box-text--content"));

            String habitatDescripcion = habitatDescripcionTotal.findElement(new By.ByTagName("p")).getText();

            fw.write(habitatTiulo);
            fw.write(habitatDescripcion);
            System.out.println(habitatTiulo);
            System.out.println(habitatDescripcion);

        }

        for (String enlaceHabitat: enlacesHabitats) {
            if (enlaceHabitat != null) driver.navigate().to(enlaceHabitat);

            elements = driver.findElements(new By.ByClassName("habitat-box--ficha"));

            for (WebElement element: elements) {
                enlaces.add(element.getAttribute("href"));
            }

        //----------

        for (String enlace: enlaces) {
            driver.navigate().to(enlace);
            extras = driver.findElements(new By.ByClassName("vc_tta-panel-body"));
            crs = driver.findElements(new By.ByClassName("vc_tta-tab"));
            clases = driver.findElements(new By.ByClassName("box-ficha-animal--caracteristica"));

            for ( WebElement clase : clases) {
                String r = clase.findElement(new By.ByClassName("box-ficha-animal--title")).getText();
                String part1 = codeCracker.recorte(clase.getText(),r);
                System.out.print(part1);
                fw.write(part1);
            }

            for (WebElement cr : crs) {
                cr.click();
                for (WebElement extra : extras) {
                    if(!extra.getText().isEmpty()){
                        fw.write(extra.getText() + " ");
                        System.out.println(extra.getText());
                    }
                }
            }
            fw.write("\n");
        }

        }

        fw.close();
        driver.close();

    }

}
