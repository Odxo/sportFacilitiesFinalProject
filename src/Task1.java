import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Task1 {
    public static void main(String[] args) throws SQLException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ResultSet resultSet = DataBase.getTask1Data();
        while (resultSet.next()){
            if (resultSet.getInt("allFinance") < 0) continue;
            dataset.addValue(resultSet.getInt("allFinance"), "Объём финансирования", resultSet.getString("substr(finishDate, -4, 4)"));
        }

        LineChart_AWT chart = new LineChart_AWT("Задача 1", "Общий объём финансирования по годам",
                "Год", "Финансирование", dataset);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
