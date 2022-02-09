import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private Label lblHeavyTask;

    @FXML
    private void handleHeavyTask(ActionEvent actionEvent) {

        Thread t = new Thread(() -> {
        simulateHeavyTask();
        });
        t.start();

    }

    private void simulateHeavyTask(){

        for (int i=0 ; i < 10_000_00; i++){
            System.out.println("Doing boring work on item... Work Work aaa fuck all day" + i);
        }
        Platform.runLater(() -> {
            lblHeavyTask.setText("Done working...");
        });



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
