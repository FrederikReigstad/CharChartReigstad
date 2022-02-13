package gui.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class ScatterChartController {
    @FXML
    public Button LineChartBt;
    @FXML
    private StackedAreaChart<Number, Number> scatterChartCh;

    public void DrawAreaChart(ActionEvent actionEvent) {
        Axis<Number> xAxis = scatterChartCh.getXAxis();
        xAxis.setLabel("Day");

        Axis<Number> yAxis = scatterChartCh.getYAxis();
        yAxis.setLabel("Drinks sold");

        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            series.getData().add(new XYChart.Data<>(i, r.nextInt(550) + 150));
        }

        scatterChartCh.getData().add(series);

    }

    public void LineChartGoBt(ActionEvent actionEvent) throws IOException {
        Stage switchScene = (Stage) LineChartBt.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/View/MainVeiw.fxml"));
        Scene scene = new Scene(parent);
        switchScene.setScene(scene);

    }

    public void AreaChartGoBt(ActionEvent actionEvent) throws IOException {
        Stage switchScene = (Stage) scatterChartCh.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/View/AreaChart.fxml"));
        Scene scene = new Scene(parent);
        switchScene.setScene(scene);
    }
}
