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

public class Jaxb {
        File file = new File("Habitat.xml");
        HabitatYAnimalXML habitatYAnimalXML = new HabitatYAnimalXML();
        HabitatXML habitatXML;
        AnimalXML animalXML;

        JAXBContext jaxbContext;
        Marshaller jaxbMarshaller;


        Jaxb(List<Habitat> habitats,List<Animal> animals) {
            try {
                jaxbContext = JAXBContext.newInstance(HabitatYAnimalXML.class);

                for (Habitat habitat : habitats) {
                    habitatXML = new HabitatXML(habitat.getTitulo(), habitat.getSubtitulo());
                    habitatYAnimalXML.addHabitatXML(habitatXML);
                    for (Animal animal : animals) {
                        animalXML = new AnimalXML(animal.getNombre(), animal.getEspecie(), animal.getFamilia(), animal.getOrden(), animal.getClase(), animal.getHabitat(), animal.getDieta(), animal.getGestacion(), animal.getNumeroDeCrias(), animal.getVida());
                        habitatYAnimalXML.addAnimalXML(animalXML);

                    }
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
