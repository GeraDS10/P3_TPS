import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class CSVReader {

    private String path;

    public CSVReader(String path) {
        this.path = path;
    }

    public void read() {

        // Obtengo una lista con las lineas del archivo
        // lines.get(0) tiene la primer linea del archivo
        // lines.get(1) tiene la segunda linea del archivo... y así
        ArrayList<String[]> lines = this.readContent();
        
        List<Arco<Integer>> arcos = new LinkedList<>();

        for (String[] line: lines) {
            // Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
            Integer origen = Integer.parseInt(line[0].trim().substring(1));
            Integer destino = Integer.parseInt(line[1].trim().substring(1));
            Integer etiqueta = Integer.parseInt(line[2].trim());
            arcos.add(new Arco<>(origen, destino, etiqueta));
            // Aca instanciar lo que necesiten en base a los datos leidos
        }

        Backtracking backtracking = new Backtracking(arcos);
        backtracking.encontrarRedSubterraneos();

        Greedy greedy = new Greedy<>(arcos);
        greedy.construirRedSubterraneos();
    }

    private ArrayList<String[]> readContent() {
        ArrayList<String[]> lines = new ArrayList<String[]>();

        File file = new File(this.path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                lines.add(line.split(";"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }
        return lines;
    }

}