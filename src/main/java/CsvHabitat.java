import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase CsvHabitat: Tiene el objetivo de crear un documento csv con todas las zonas/habitats scrapeadas previamente.
 */
public class CsvHabitat {

    /**
     * Constructor para crear el CsvHabitat.
     * @param habitats Lista de zonas/habitats
     */
    public CsvHabitat(List<Habitat> habitats) {
        File file = new File("Zona.csv");
        CSVWriter csvWriter;
        String[] head = {"Titulo","Subtitulo"};
        List<String[]> text = new ArrayList<>();

        for (Habitat habitat: habitats){
            text.add(new String[] {habitat.titulo,habitat.subtitulo});
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
