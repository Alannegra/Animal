import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Habitats")
public class HabitatYAnimalXML {

    List<HabitatXML> habitatsXMLS = new ArrayList<>();
    List<AnimalXML> animalsXMLS = new ArrayList<>();


    public List<HabitatXML> getHabitatsXMLS() {
        return habitatsXMLS;
    }

    public List<AnimalXML> getAnimalsXMLS() {
        return animalsXMLS;
    }



    @XmlElement(name = "Habitat")
    public void setHabitatsXMLS(List<HabitatXML> habitatsXMLS) {
        this.habitatsXMLS = habitatsXMLS;
    }

    @XmlElement(name = "Animal")
    public void setAnimalsXMLS(List<AnimalXML> animalsXMLS) {
        this.animalsXMLS = animalsXMLS;
    }

    public void addHabitatXML(HabitatXML habitatXML) {
        this.habitatsXMLS.add(habitatXML);
    }

    public void addAnimalXML(AnimalXML animalXML) {
        this.animalsXMLS.add(animalXML);
    }



}
