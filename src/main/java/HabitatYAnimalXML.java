import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Animales")
public class HabitatYAnimalXML {
    List<AnimalXML> animalsXMLS = new ArrayList<>();


    public List<AnimalXML> getDatos() {
        return animalsXMLS;
    }


    @XmlElement(name = "Animal")
    public void setDatos(List<AnimalXML> animalsXMLS) {
        this.animalsXMLS = animalsXMLS;
    }


    public void addAnimalXML(AnimalXML animalXML) {
        this.animalsXMLS.add(animalXML);
    }
}
