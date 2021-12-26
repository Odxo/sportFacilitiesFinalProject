import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CSVReader {
    public ArrayList<String[]> csvRead(String file) throws IOException {
        String line;
        BufferedReader csv = new BufferedReader(new FileReader(file));
        ArrayList<String[]> data = new ArrayList<>();
        while ((line = csv.readLine()) != null) {
            data.add(line.split(","));
        }
        return data;
    }
}
