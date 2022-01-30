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
        List<Animal> animals = new ArrayList<>();
        List<Habitat> habitats = new ArrayList<>();
        String  nombre,especie,familia,orden,clase,habitat,dieta,gestacion,numeroDeCrias,vida;
        Csv csv;
        Jaxb jaxb;


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
        List<WebElement> habitatsBoxes = new ArrayList<>();
        List<String> habitatsLinks = new ArrayList<>();
        List<WebElement> animalsBoxes = new ArrayList<>();
        List<String> animalsLinks = new ArrayList<>();
        List<WebElement> animalsInfos = new ArrayList<>();
        List<WebElement> animalsDescriptionsButtons = new ArrayList<>();
        List<WebElement> animalsDescriptions = new ArrayList<>();


        habitatsBoxes = driver.findElements(new By.ByClassName("boxed"));

        for (WebElement habitatBox: habitatsBoxes) {

            habitatsLinks.add(habitatBox.findElement(new By.ByTagName("a")).getAttribute("href"));

            String habitatTiulo = habitatBox.findElement(new By.ByClassName("box-text--titulo")).getText();
            //String habitatDescripcion = habitat.findElement(new By.ByClassName("box-text--content")).getText();

            WebElement habitatDescripcionTotal = habitatBox.findElement(new By.ByClassName("box-text--content"));

            String habitatDescripcion = habitatDescripcionTotal.findElement(new By.ByTagName("p")).getText();

            fw.write(habitatTiulo);
            fw.write(habitatDescripcion);
            System.out.println(habitatTiulo);
            System.out.println(habitatDescripcion);
            habitats.add(new Habitat(habitatTiulo,habitatDescripcion));
        }
        csv = new Csv(habitats);

        for (String habitatLink: habitatsLinks) {
            if (habitatLink != null) driver.navigate().to(habitatLink);

            animalsBoxes = driver.findElements(new By.ByClassName("habitat-box--ficha"));

            for (WebElement animalBox: animalsBoxes) {
                animalsLinks.add(animalBox.getAttribute("href"));
            }

        //----------

        for (String animalLink: animalsLinks) {
            driver.navigate().to(animalLink);
            animalsDescriptions = driver.findElements(new By.ByClassName("vc_tta-panel-body"));
            animalsDescriptionsButtons = driver.findElements(new By.ByClassName("vc_tta-tab"));
            animalsInfos = driver.findElements(new By.ByClassName("box-ficha-animal--caracteristica"));

            int contador = 0;
            for (WebElement animalInfo : animalsInfos) {
                String r = animalInfo.findElement(new By.ByClassName("box-ficha-animal--title")).getText();
                String part1 = codeCracker.recorte(animalInfo.getText(),r);
                System.out.print(part1);
                fw.write(part1);

                switch (contador) {
                    case 1:  contador = 0;
                        break;
                    case 2:  contador = 1;
                        break;
                    case 3:  contador = 2;
                        break;
                    case 4:  contador = 3;
                        break;
                    case 5:  contador = 4;
                        break;
                    case 6:  contador = 5;
                        break;
                    case 7:  contador = 6;
                        break;
                    default: contador = 10;
                        break;
                }
                contador++;

            }

            for (WebElement animalDescriptionButton : animalsDescriptionsButtons) {
                animalDescriptionButton.click();
                for (WebElement animalDescription : animalsDescriptions) {
                    if(!animalDescription.getText().isEmpty()){
                        fw.write(animalDescription.getText() + " ");
                        System.out.println(animalDescription.getText());
                    }
                }
            }

            //animals.add();
            fw.write("\n");
        }

        }

        fw.close();
        driver.close();
        //jaxb = new JAXB(champions);

    }

}
