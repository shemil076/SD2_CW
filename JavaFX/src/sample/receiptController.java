package sample;


import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class receiptController {
    @FXML
    private AnchorPane body;

    @FXML
    public Label lblFirstName;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblVaccine;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblContactNumber;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblId;


    @FXML
    private Label lblbooth;


    @FXML
    private Label lblCity;

    @FXML
    private Button btnClose;




    public void close(javafx.event.ActionEvent actionEvent) throws IOException {

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }

    public void showReceipt(String firstName, String lastName, String mail, String idNumber, String age , String city, String contactNumber, String gender, String vaccine, String booth){
        lblFirstName.setText("  "+ firstName);
        lblLastName.setText("  "+ lastName);
        lblEmail.setText("  "+ mail);
        lblId.setText("  "+ idNumber);
        lblAge.setText("  "+ age);
        lblCity.setText("  "+ city);
        lblContactNumber.setText("  "+ contactNumber);
        lblGender.setText("  "+gender);
        lblVaccine.setText("  "+vaccine);
        lblbooth.setText("  "+booth);




        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss:a");
        lblTime.setText(timeFormat.format(currentDate));

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        lblDate.setText(dateFormat.format(currentDate));


    }
}
