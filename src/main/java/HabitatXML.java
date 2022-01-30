import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

    @XmlRootElement(name="Habitat")
    public class HabitatXML {
        String titulo;
        String subtitulo;



        public HabitatXML(String titulo, String subtitulo) {
            this.titulo = titulo;
            this.subtitulo = subtitulo;
        }

        public HabitatXML() {
        }

        public String getTitulo() {
            return titulo;
        }

        public String getSubtitulo() {
            return subtitulo;
        }

        @XmlElement(name="Titulo")
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        @XmlElement(name="Subtitulo")
        public void setSubtitulo(String subtitulo) {
            this.subtitulo = subtitulo;
        }
    }


