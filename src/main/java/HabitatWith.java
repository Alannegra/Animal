import java.util.List;

public class HabitatWith {
    String titulo;
    String subtitulo;
    List<Animal> animalList;

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
