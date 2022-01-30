import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Habitat")
    public class HabitatXML {
        String titulo;
        String subtitulo;
        AnimalsXML animalsXML;


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

        @XmlElement(name="Titulo")
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        @XmlElement(name="Subtitulo")
        public void setSubtitulo(String subtitulo) {
            this.subtitulo = subtitulo;
        }

        @XmlElement(name="Animals")
        public void setAnimalsXML(AnimalsXML animalsXML) {
            this.animalsXML = animalsXML;
        }
}


