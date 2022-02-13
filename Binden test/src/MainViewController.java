import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
//import javax.script.Bindings;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private TextField txtUniBind;
    @FXML
    private TextField txtDualBind;
    @FXML
    private Slider slider;
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

    public void setUpBindings() {

        //Uni-directional binding
        /*slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            txtUniBind.setText(newValue.toString());


        });*/

        //Bi-directional binding
        Bindings.bindBidirectional(
                txtDualBind.textProperty(),
                slider.valueProperty(),
                new ConverterHelper()

        );
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpBindings();

    }
}
