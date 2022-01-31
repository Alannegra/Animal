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
        File file = new File("BioParc.xml");

        HabitatYAnimalXML habitatYAnimalXML = new HabitatYAnimalXML();
        HabitatXML habitatXML;

        JAXBContext jaxbContext;
        Marshaller jaxbMarshaller;
        AnimalsXML animalsXML;
        AnimalXML animalXML;

        Jaxb(List<HabitatWith> habitatWiths) {

            //System.out.println("MIRA AQUI " + habitatWiths.get(0).animalList.get(0).getNombre() + " MIRA AQUI");

            try {
                jaxbContext = JAXBContext.newInstance(HabitatYAnimalXML.class);

                List<AnimalXML> animalXMLList = new ArrayList<>();
                animalsXML = new AnimalsXML();
                int contador = 0;
                for (HabitatWith habitatWith : habitatWiths) {
                    for (Animal animal: habitatWiths.get(contador).getAnimalList()) {
                        animalXMLList.add(new AnimalXML(animal.getNombre(), animal.getEspecie(), animal.getFamilia(), animal.getOrden(), animal.getClase(), animal.getHabitat(), animal.getDieta(), animal.getGestacion(), animal.getNumeroDeCrias(), animal.getVida()));

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
