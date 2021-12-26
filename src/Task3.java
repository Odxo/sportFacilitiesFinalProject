import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) throws SQLException {
        ResultSet resultSet = DataBase.getTask3Data();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> finance = new ArrayList<>();
        int max = 0;

        while (resultSet.next()){
            name.add(resultSet.getString("name"));
            finance.add(resultSet.getInt("allFinance"));
        }

        for (Integer integer : finance) {
            if (integer > max) max = integer;
        }

        System.out.println(name.get(finance.indexOf(max)) + " " + max);
    }
}
