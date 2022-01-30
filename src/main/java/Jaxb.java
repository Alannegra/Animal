import java.io.File;
import java.io.StringWriter;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class Jaxb {

    File file = new File("lol.xml");
    HabitatYAnimalXML habitatYAnimalXML = new HabitatYAnimalXML();
    AnimalXML data;
    JAXBContext jaxbContext;
    Marshaller jaxbMarshaller;

    public static void main(String[] args) {
        //Java object. We will convert it to XML.
        //Employee employee = new Employee(1, "Lokesh", "Gupta", new Department(101, "IT"));
        Habitat habitat = new Habitat("Titulo", "Descripcion");
        //Animal animal = new Animal("Nombre","Especie","Familia","Orden","Clase","Habitat","Dieta","Gestacion","Crias","Vida");

        //Method which uses JAXB to convert object to XML
        jaxbObjectToXML(habitat);
    }

    private static void jaxbObjectToXML(Habitat habitat)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Habitat.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(habitat, sw);

            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println( xmlContent );

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
