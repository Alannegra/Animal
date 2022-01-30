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
        CsvAnimal csvAnimal;
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

            int id = 0;
            int contador = 0;

            animals.add(new Animal());

            for (WebElement animalInfo : animalsInfos) {
                String tituloDelete = animalInfo.findElement(new By.ByClassName("box-ficha-animal--title")).getText();
                String respuesta = codeCracker.recorte(animalInfo.getText(),tituloDelete);
                System.out.print(respuesta);
                fw.write(respuesta);

                switch (contador) {
                    case 0:
                        animals.get(id).setNombre(respuesta.trim());
                        break;
                    case 1:
                        animals.get(id).setEspecie(respuesta.trim());
                        break;
                    case 2:
                        animals.get(id).setFamilia(respuesta.trim());
                        break;
                    case 3:
                        animals.get(id).setOrden(respuesta.trim());
                        break;
                    case 4:
                        animals.get(id).setClase(respuesta.trim());
                        break;
                    default: contador = 10;
                        break;
                }

                contador++;


            }
            contador = 0;

            for (WebElement animalDescriptionButton : animalsDescriptionsButtons) {
                animalDescriptionButton.click();
                for (WebElement animalDescription : animalsDescriptions) {

                    if(!animalDescription.getText().isEmpty()){
                        String respuesta = animalDescription.getText();
                        fw.write(respuesta + " ");
                        //System.out.println(respuesta);
                    switch (contador) {
                        case 0:
                            animals.get(id).setHabitat(respuesta);
                            System.out.println(respuesta);
                            break;
                        case 1:
                            animals.get(id).setDieta(respuesta);
                            System.out.println(respuesta);
                            break;
                        case 2:
                            animals.get(id).setGestacion(respuesta);
                            System.out.println(respuesta);
                            break;
                        case 3:
                            animals.get(id).setNumeroDeCrias(respuesta);
                            System.out.println(respuesta);
                            break;
                        case 4:
                            animals.get(id).setVida(respuesta);
                            System.out.println(respuesta);
                            break;
                        default: contador = 10;
                            break;
                    }
                    contador++;
                    }
                }

            }

            //animals.add();
            fw.write("\n");
            id++;

        }
            //XXXXXXXXXXXXXXXXX
            //XXXXXXXXXXXXXXXXX
            //XXXXXXXXXXXXXXXXX
            break;
            //XXXXXXXXXXXXXXXXX
            // XXXXXXXXXXXXXXXXX
            //XXXXXXXXXXXXXXXXX

        }

        fw.close();
        driver.close();

        csv = new Csv(habitats);
        csvAnimal = new CsvAnimal(animals);
        //jaxb = new JAXB(champions);

    }

}
