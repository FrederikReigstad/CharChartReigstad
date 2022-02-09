import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Random;

public class MainController {
    @FXML
    private LineChart<Number, Number> chartLine;

    public void DrawChart(ActionEvent actionEvent) {
        Axis<Number> xAxis = chartLine.getXAxis();
        xAxis.setLabel("Day");

        Axis<Number> yAxis = chartLine.getYAxis();
        yAxis.setLabel("Drinks sold");

        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        Random r = new Random();

        for (int i = 0; i < 10; i++ ){
            series.getData().add(new XYChart.Data<>(i, r.nextInt(550)+ 150));
        }

      /*  series.setName("Drinks sold in January");
        series.getData().add(new XYChart.Data<>(1, r.nextInt(350)+ 150));
        series.getData().add(new XYChart.Data<>(2, 244));
        series.getData().add(new XYChart.Data<>(3, 434));
        series.getData().add(new XYChart.Data<>(4, 140));
        series.getData().add(new XYChart.Data<>(5, 854));
        series.getData().add(new XYChart.Data<>(6, 254)); */

        chartLine.getData().add(series);

    }
}
