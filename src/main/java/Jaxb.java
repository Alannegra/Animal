import java.io.File;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase HabitatWith: Tiene el objetivo de crear un documento xml con todas las zonas y sus animales.
 */
public class Jaxb {
        File file = new File("Zona&Animal.xml");

        HabitatYAnimalXML habitatYAnimalXML = new HabitatYAnimalXML();
        HabitatXML habitatXML;

        JAXBContext jaxbContext;
        Marshaller jaxbMarshaller;
        AnimalsXML animalsXML;
        AnimalXML animalXML;

    /**
     * Constructor para crear el xml.
     * @param habitatWiths Lista de zonas con sus animales
     */
        Jaxb(List<HabitatWith> habitatWiths) {

            try {
                jaxbContext = JAXBContext.newInstance(HabitatYAnimalXML.class);

                List<AnimalXML> animalXMLList = new ArrayList<>();
                animalsXML = new AnimalsXML();
                int contador = 0;
                for (HabitatWith habitatWith : habitatWiths) {
                    for (Animal animal: habitatWiths.get(contador).getAnimalList()) {
                        if(animal.getNombre()!=null) {
                            animalXMLList.add(new AnimalXML(animal.getNombre(), animal.getEspecie(), animal.getFamilia(), animal.getOrden(), animal.getClase(), animal.getHabitat(), animal.getDieta(), animal.getGestacion(), animal.getNumeroDeCrias(), animal.getVida()));
                        }
                    }
                    contador++;
                    for (AnimalXML a: animalXMLList) {
                        animalsXML.addAnimalXML(a);
                    }
                    habitatXML = new HabitatXML(habitatWith.getTitulo(), habitatWith.getSubtitulo(), animalsXML);
                    habitatYAnimalXML.addHabitatXML(habitatXML);
                }


                jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(habitatYAnimalXML, file);
//            jaxbMarshaller.marshal(datas, System.out);

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
