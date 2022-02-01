import java.util.List;

/**
 * Clase HabitatWith: Tiene el objetivo de guardar los datos de una zona/habitat y los datos de los animales, cambiarlos o darlos.
 */
public class HabitatWith {
    String titulo;
    String subtitulo;
    List<Animal> animalList;

    /**
     * Constructor para construir un HabitatWith
     * @param titulo El nombre de la zona/habitat
     * @param subtitulo La descripcion de la zona/habitat
     * @param animalList La lista que contiene los animales
     */
    public HabitatWith(String titulo, String subtitulo, List<Animal> animalList) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.animalList = animalList;
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

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
