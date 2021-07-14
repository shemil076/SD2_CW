package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class mainPageController {


    @FXML
    private ImageView body;

    @FXML
    private Button btnStart;


    public void start(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("formPage.fxml"));
        newStage.setTitle("Patient Details");
        newStage.setScene(new Scene(root, 897,496));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }
}
