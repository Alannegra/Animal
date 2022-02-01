import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase AnimalsXML: Tiene el objetivo de guardar Listas de animalesXML, cambiarlas o darlas preparadas para ser convertidos a XML.
 */
@XmlRootElement(name="Animals")
public class AnimalsXML {

    List<AnimalXML> animalsXMLS = new ArrayList<>();

    public List<AnimalXML> getAnimalsXMLS() {
        return animalsXMLS;
    }

   @XmlElement(name = "Animal")
    public void setAnimalsXMLS(List<AnimalXML> animalsXMLS) {
        this.animalsXMLS = animalsXMLS;
    }

    /**
     * Metodo addAnimalXML: Se encarga de añadir a la lista de animalesXML un animalXML.
     */
   public void addAnimalXML(AnimalXML animalXML) {
        this.animalsXMLS.add(animalXML);
    }


}

