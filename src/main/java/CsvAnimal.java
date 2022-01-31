import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvAnimal {
    public CsvAnimal(List<Animal> animals){
        File file = new File("Animal2.csv");
        CSVWriter csvWriter;
        String[] head = {"Nombre","Especie","Familia","Orden","Clase","Habitat","Dieta","Gestacion","Numero de crias","Vida"};
        List<String[]> text = new ArrayList<>();

        for (Animal animal: animals){
            //data.add(new String[] {animal.nombre,animal.especie, animal.familia,animal.orden,animal.clase,animal.habitat,animal.dieta,animal.gestacion,animal.numeroDeCrias,animal.vida});
            text.add(new String[] {animal.getNombre(),animal.getEspecie(), animal.getFamilia(),animal.getOrden(),animal.getClase(),animal.getHabitat(),animal.getDieta(),animal.getGestacion(),animal.getNumeroDeCrias(),animal.getVida()});

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
