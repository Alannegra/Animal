import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvAnimal {
    public CsvAnimal(List<Animal> animals){
        File file = new File("Animal.csv");
        CSVWriter csvWriter;
        String[] head = {"1","2","2","2","2","2","2","2","2","2"};
        List<String[]> data = new ArrayList<>();

        for (Animal animal: animals){
            data.add(new String[] {animal.nombre,animal.especie, animal.familia,animal.orden,animal.clase,animal.habitat,animal.dieta,animal.gestacion,animal.numeroDeCrias,animal.vida});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(file));
            csvWriter.writeNext(head);
            csvWriter.writeAll(data);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
