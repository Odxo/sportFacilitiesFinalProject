import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    }

    public static void fillingDataBase() throws IOException {
        ArrayList<String[]> csv = new CSVReader().csvRead("sportFacilities.csv");
        for (int i = 1; i < csv.size(); i++) {
            DataBase.insert(csv.get(i));
        }
    }
}



