import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase HabitatYAnimalXML: Tiene el objetivo de guardar Listas de habitatsXML, cambiarlas o darlas preparadas para ser convertidas a XML.
 */
@XmlRootElement(name="Zonas")
public class HabitatYAnimalXML {

    List<HabitatXML> habitatsXMLS = new ArrayList<>();

    public List<HabitatXML> getHabitatsXMLS() {
        return habitatsXMLS;
    }

    @XmlElement(name = "Zona")
    public void setHabitatsXMLS(List<HabitatXML> habitatsXMLS) {
        this.habitatsXMLS = habitatsXMLS;
    }

    /**
     * Metodo addHabitatXML: Se encarga de añadir a la lista de habitatsXML un habitatXML.
     */
    public void addHabitatXML(HabitatXML habitatXML) {
        this.habitatsXMLS.add(habitatXML);
    }


}
