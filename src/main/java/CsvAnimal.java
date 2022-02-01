import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase CsvAnimal: Tiene el objetivo de crear un documento csv con todos los animales scrapeadas previamente.
 */
public class CsvAnimal {
    /**
     * Constructor para crear el CsvAnimal.
     * @param animals Lista de animales
     */
    public CsvAnimal(List<Animal> animals){
        File file = new File("Animal.csv");
        CSVWriter csvWriter;
        String[] head = {"Nombre","Especie","Familia","Orden","Clase","Habitat","Dieta","Gestacion","Numero de crias","Vida"};
        List<String[]> text = new ArrayList<>();

        for (Animal animal: animals){
            //data.add(new String[] {animal.nombre,animal.especie, animal.familia,animal.orden,animal.clase,animal.habitat,animal.dieta,animal.gestacion,animal.numeroDeCrias,animal.vida});
            if(animal.getNombre()!=null){
            text.add(new String[] {animal.getNombre(),animal.getEspecie(), animal.getFamilia(),animal.getOrden(),animal.getClase(),animal.getHabitat(),animal.getDieta(),animal.getGestacion(),animal.getNumeroDeCrias(),animal.getVida()});
            }
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(file));
            csvWriter.writeNext(head);
            csvWriter.writeAll(text);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
