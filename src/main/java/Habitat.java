/**
 * Clase Habitat: Tiene el objetivo de guardar los datos de una zona/habitat, cambiarlos o darlos.
 */
public class Habitat {
    String titulo;
    String subtitulo;

    /**
     * Constructor para construir una zona/habitat
     * @param titulo El nombre de la zona/habitat
     * @param subtitulo La descripcion de la zona/habitat
     */
    public Habitat(String titulo, String subtitulo) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }
}
