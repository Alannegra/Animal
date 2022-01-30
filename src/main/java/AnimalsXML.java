import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

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

   public void addAnimalXML(AnimalXML animalXML) {
        this.animalsXMLS.add(animalXML);
    }



}

