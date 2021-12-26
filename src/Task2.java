import java.sql.ResultSet;
import java.sql.SQLException;

public class Task2 {
    public static void main(String[] args) throws SQLException {
        ResultSet resultSet = DataBase.getTask2Data();
        long sum = 0;
        int iterations = 0;
        while (resultSet.next()) {
            sum += resultSet.getInt("allFinance");
            iterations++;
        }
        System.out.println(sum / iterations);
    }
}
