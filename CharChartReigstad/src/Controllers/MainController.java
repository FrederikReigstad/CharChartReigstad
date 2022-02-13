package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class MainController {
    @FXML
    public Button AreaChartBt;
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


    public void AreaChartGoBt(ActionEvent actionEvent) throws IOException {
        Stage switchScene = (Stage) AreaChartBt.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("View/AreaChart.fxml"));
        Scene scene = new Scene(parent);
        switchScene.setScene(scene);
    }
}
