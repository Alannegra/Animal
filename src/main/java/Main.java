import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase Main: Tiene el objetivo de scrapear una web y guardar los datos en diferentes clases para luego llamar a las clases Csv's y Jaxb.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        CodeCracker codeCracker = new CodeCracker();
        List<Animal> animals = new ArrayList<>();
        List<Habitat> habitats = new ArrayList<>();
        List<HabitatWith> habitatWiths = new ArrayList<>();

        CsvHabitat csvHabitat;
        CsvAnimal csvAnimal;
        Jaxb jaxb;


        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();

        //NW No abrimos el navegador NO WINDOW
        options.setHeadless(true);

        WebDriver driver = new FirefoxDriver(options);

        /**
         * Escribimos la direccion de la web a scrapear y nos dirijira a ella.
         */
        driver.get("https://www.bioparcvalencia.es/animales/habitats");

        /**
         * Aceptamos las cookies.
         */
        WebElement inputButtonNext = driver.findElement(new By.ById("pdcc-modal-accept"));
        inputButtonNext.click();


        List<WebElement> habitatsBoxes = new ArrayList<>();
        List<String> habitatsLinks = new ArrayList<>();
        List<WebElement> animalsBoxes = new ArrayList<>();
        List<String> animalsLinks = new ArrayList<>();
        List<WebElement> animalsInfos = new ArrayList<>();
        List<WebElement> animalsDescriptionsButtons = new ArrayList<>();
        List<WebElement> animalsDescriptions = new ArrayList<>();

        /**
         * Selecionamos todas las cajas que contienen una Zona/Habitat.
         */
        habitatsBoxes = driver.findElements(new By.ByClassName("boxed"));

        /**
         * Por cada Zona/Habitat guardamos su Nombre, Descripcion y el enlace que nos llevara a la seccion de animales.
         */
        int idH = 0;
        for (WebElement habitatBox: habitatsBoxes) {
            habitatsLinks.add(habitatBox.findElement(new By.ByTagName("a")).getAttribute("href"));
            String habitatTiulo = habitatBox.findElement(new By.ByClassName("box-text--titulo")).getText();
            WebElement habitatDescripcionTotal = habitatBox.findElement(new By.ByClassName("box-text--content"));
            String habitatDescripcion = habitatDescripcionTotal.findElement(new By.ByTagName("p")).getText();
            habitats.add(new Habitat(habitatTiulo,habitatDescripcion));
            habitatWiths.add(new HabitatWith(habitatTiulo,habitatDescripcion, null));
        }

        /**
         * Por cada enlace de Zona/Habitat guardamos todos los enlaces que nos llevaran a cada Animal.
         */
        for (String habitatLink: habitatsLinks) {
            if (habitatLink != null) driver.navigate().to(habitatLink);
            animalsBoxes = driver.findElements(new By.ByClassName("habitat-box--ficha"));

            for (WebElement animalBox: animalsBoxes) {
                animalsLinks.add(animalBox.getAttribute("href"));
            }

            int id = 0;

            /**
             * Por cada enlace de Animal guardamos todos los datos.
             */
            for (String animalLink: animalsLinks) {

                driver.navigate().to(animalLink);
                animalsDescriptions = driver.findElements(new By.ByClassName("vc_tta-panel-body"));
                animalsDescriptionsButtons = driver.findElements(new By.ByClassName("vc_tta-tab"));
                animalsInfos = driver.findElements(new By.ByClassName("box-ficha-animal--caracteristica"));

                int contador = 0;

                    animals.add(new Animal());

                /**
                 * Guardamos la primera parte de los datos.
                 */
                for (WebElement animalInfo : animalsInfos) {
                    String tituloDelete = animalInfo.findElement(new By.ByClassName("box-ficha-animal--title")).getText();
                    String respuesta = codeCracker.recorte(animalInfo.getText(),tituloDelete);
                    //System.out.print(respuesta);

                    switch (contador) {
                        case 0:
                            animals.get(id).setNombre(respuesta.trim());
                            System.out.println(respuesta);
                            break;
                        case 1:
                            animals.get(id).setEspecie(respuesta.trim());
                            break;
                        case 2:
                            animals.get(id).setFamilia(codeCracker.recorte(respuesta.trim(),"Subfamilia:").trim());
                            break;
                        case 3:
                            animals.get(id).setOrden(respuesta.trim());
                            break;
                        case 4:
                            animals.get(id).setClase(respuesta.trim());
                            break;
                        default:
                            break;
                    }
                    contador++;
                }

                /**
                 * Guardamos la segunda parte de los datos en la cual haremos uso de la misma tecnia utilizada a la hora de aceptar cookies.
                 */
                contador = 0;
                for (WebElement animalDescriptionButton : animalsDescriptionsButtons) {
                    animalDescriptionButton.click();
                    for (WebElement animalDescription : animalsDescriptions) {

                        if(!animalDescription.getText().isEmpty()){
                            String respuesta = animalDescription.getText();

                            if(respuesta.isEmpty()){

                            }else {
                                switch (contador) {
                                    case 0:
                                        animals.get(id).setHabitat(respuesta);
                                        break;
                                    case 1:
                                        animals.get(id).setDieta(respuesta);
                                        break;
                                    case 2:
                                        animals.get(id).setGestacion(respuesta);
                                        break;
                                    case 3:
                                        animals.get(id).setNumeroDeCrias(respuesta);
                                        break;
                                    case 4:
                                        animals.get(id).setVida(respuesta);
                                        break;
                                    default:
                                        break;
                                }
                                contador++;
                            }
                        }
                    }
                }
                id++;
            }
        habitatWiths.get(idH).setAnimalList(animals);
        idH++;
        }

        driver.close();

        /**
         * Construimos con la informacion obtenida dos CSV's y un XML.
         */
        csvHabitat = new CsvHabitat(habitats);
        csvAnimal = new CsvAnimal(animals);
        jaxb = new Jaxb(habitatWiths);

    }

}
