package gui.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ScatterChartController {

    @FXML
    public Button LineChartBt;
    @FXML
    public StackedAreaChart AreaChartController;

    public void DrawAreaChart(ActionEvent actionEvent) {
    }

    public void LineChartGoBt(ActionEvent actionEvent) throws IOException {
        Stage switchScene = (Stage) LineChartBt.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/View/MainVeiw.fxml"));
        Scene scene = new Scene(parent);
        switchScene.setScene(scene);

    }

    public void AreaChartGoBt(ActionEvent actionEvent) throws IOException {
        Stage switchScene = (Stage) AreaChartController.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("gui/View/AreaChart.fxml"));
        Scene scene = new Scene(parent);
        switchScene.setScene(scene);
    }
}
