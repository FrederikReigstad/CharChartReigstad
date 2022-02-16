package gui.Controllers;

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

public class CategoryAxisController {
    @FXML
    public LineChart<String, Number> categoryAxisChart ;
    @FXML
    public Button LineChartBt;

    public void DrawAreaChart(ActionEvent event) {
        Axis<String> xAxis = categoryAxisChart.getXAxis();
        xAxis.setLabel("Day");

        Axis<Number> yAxis = categoryAxisChart.getYAxis();
        yAxis.setLabel("Drinks sold");

        XYChart.Series<String, Number> series = new XYChart.Series();

        series.getData().add(new XYChart.Data<>("1", 1));


        categoryAxisChart.getData().add(series);
    }

    public void LineChartGoBt(ActionEvent event) throws IOException {
        Stage switchScene = (Stage) LineChartBt.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/View/MainVeiw.fxml"));
        Scene scene = new Scene(parent);
        switchScene.setScene(scene);
    }

    public void scatterChartBt(ActionEvent event) throws IOException {
        Stage switchScene = (Stage) LineChartBt.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("../View/ScatterChart.fxml"));
        Scene scene = new Scene(parent);
        switchScene.setScene(scene);
    }

    public void AreaChartBtCat(ActionEvent event) throws IOException {
        Stage switchScene = (Stage) LineChartBt.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/View/AreaChart.fxml"));
        Scene scene = new Scene(parent);
        switchScene.setScene(scene);
    }
}
