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

public class BioParcAnimalFaunWhitoutTittle {


    public static void main(String[] args) throws IOException {

        CodeCracker codeCracker = new CodeCracker();

        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://www.bioparcvalencia.es/animal/sabana-africana/");
        File file = new File("MIRAsintitulo4.txt");
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

        WebElement[] a = new WebElement[0];
        String lol = "";


        for (String enlace: enlaces) {
            driver.navigate().to(enlace);

             extras = driver.findElements(new By.ByClassName("vc_tta-panel-body"));

            crs = driver.findElements(new By.ByClassName("vc_tta-tab"));

             clases = driver.findElements(new By.ByClassName("box-ficha-animal--caracteristica"));

            for ( WebElement clase : clases) {

                String r = clase.findElement(new By.ByClassName("box-ficha-animal--title")).getText();
                String part1 = codeCracker.recorte(clase.getText(),r);

                System.out.print(part1);

                    //System.out.println(clase.getText());
                    fw.write(part1);
            }

            for (WebElement cr : crs) {
                cr.click();

                //fw.write(miarray[1]+"\n");
                //fw.write(cr.getText()+",");

                for (WebElement extra : extras) {

                    if(!extra.getText().isEmpty()){
                        fw.write(extra.getText() + " ");
                        System.out.println(extra.getText());
                    }

                }

            }


            fw.write("\n");

            //driver.navigate().back();
        }


        fw.close();
        driver.close();

        //Cocodrilo

    }

}