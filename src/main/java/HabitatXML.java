import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase HabitatXML: Tiene el objetivo de guardar los datos de una zona/habitat, cambiarlos o darlos preparados para ser convertidos a XML.
 */
@XmlRootElement(name="Zona")
    public class HabitatXML {
        String titulo;
        String subtitulo;
        AnimalsXML animalsXML;

    /**
     * Constructor para construir un HabitatXML
     * @param titulo El nombre de la zona/habitat
     * @param subtitulo La descripcion de la zona/habitat
     * @param animalsXML La lista de animales preparados para ser convertidos a XML
     */
    public HabitatXML(String titulo, String subtitulo, AnimalsXML animalsXML) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.animalsXML = animalsXML;
    }

    public HabitatXML() {}

        public String getTitulo() {
            return titulo;
        }

        public String getSubtitulo() {
            return subtitulo;
        }

        public AnimalsXML getAnimalsXML() {
            return animalsXML;
        }

        @XmlElement(name="Nombre")
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        @XmlElement(name="Descripcion")
        public void setSubtitulo(String subtitulo) {
            this.subtitulo = subtitulo;
        }

        @XmlElement(name="Animals")
        public void setAnimalsXML(AnimalsXML animalsXML) {
            this.animalsXML = animalsXML;
        }
}


