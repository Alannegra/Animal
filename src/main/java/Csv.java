import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Csv {

    public Csv(List<Habitat> habitats) {
        File file = new File("Habitat.csv");
        CSVWriter csvWriter;
        String[] head = {"Titulo","Subtitulo"};
        List<String[]> data = new ArrayList<>();

        for (Habitat habitat: habitats){
            data.add(new String[] {habitat.titulo,habitat.subtitulo});
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
