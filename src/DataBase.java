import java.sql.*;

public class DataBase {

    static Statement statement;

    public static void insert(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:sportFacilities.db");
            statement = connection.createStatement();
            StringBuilder stringStatement = new StringBuilder("INSERT INTO 'sportFacilities' VALUES (");

            for (int i = 0; i < args.length; i++) {
                args[i] = args[i].replaceAll("'", "''");
                if (i != args.length - 1 && args[i] == "") stringStatement.append("'', ");
                else if (i != args.length - 1) stringStatement.append(args[i].replace('"', '\'') + ", ");

                else stringStatement.append(args[i].replace('"', '\''));
            }
            stringStatement.append(");");
            statement.execute(stringStatement.toString());

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static ResultSet getTask1Data() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:sportFacilities.db");
        statement = connection.createStatement();
        return statement.executeQuery("SELECT allFinance, substr(finishDate, -4, 4)  FROM sportFacilities GROUP BY substr(finishDate, -4, 4);");
    }

    public static ResultSet getTask2Data() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:sportFacilities.db");
        statement = connection.createStatement();
        return statement.executeQuery("SELECT allFinance FROM sportFacilities WHERE substr(startDate, -4, 4) like 2012;");
    }

    public static ResultSet getTask3Data() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:sportFacilities.db");
        statement = connection.createStatement();
        return statement.executeQuery("SELECT allFinance, name FROM sportFacilities WHERE complexType like 'многофункциональный спортивный комплекс' or 'стадион';");
    }
}