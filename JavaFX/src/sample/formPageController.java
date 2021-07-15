package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class formPageController   {
    ObservableList list = FXCollections.observableArrayList();
    public javafx.scene.control.Button generateReceipt;


    @FXML
    private ImageView body;

    @FXML
    private ToggleGroup gender;


    @FXML
    private TextField city;

    @FXML
    private TextField contactNumber;

    @FXML
    private TextField idNumber;

    @FXML
    private TextField mail;

    @FXML
    private TextField age;


    @FXML
    public TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private RadioButton radioMale;


    @FXML
    private RadioButton radioFemale;


    @FXML
    private RadioButton astrazeneca;

    @FXML
    private ToggleGroup vaccines;

    @FXML
    private RadioButton sinopharm;

    @FXML
    private RadioButton pfizer;

    public String getBoothNumber() {
        String vaccine = loadVaccines();

        int boothNumber = 0;
        if (vaccine.equalsIgnoreCase("astrazeneca")){
            boothNumber = (int)Math.random() *1;

        }else if (vaccine.equalsIgnoreCase("sinopharm")){
            boothNumber =(int) (Math.random() * ((3 - 2) + 1)) +2;
        }else if(vaccine.equalsIgnoreCase("pfizer")){
            boothNumber =(int) (Math.random() * ((5 - 4) + 1)) +4;
        }
       String boothNo= String.valueOf(boothNumber);
        return boothNo;
    }



    public String loadVaccines(){
        String vaccineType ="";
        if (astrazeneca.isSelected()){
            vaccineType += astrazeneca.getText();
        }else if(sinopharm.isSelected()){
            vaccineType += sinopharm.getText();
        }else if(pfizer.isSelected()){
            vaccineType += pfizer.getText();
        }
        return  vaccineType;
    }

    public String loadRadio(){
        String patientsGender ="";
        if (radioMale.isSelected()){
            patientsGender += radioMale.getText();
        }else if(radioFemale.isSelected()){
            patientsGender += radioFemale.getText();
        }
        return  patientsGender;
    }



    @FXML
    public void sendDetails(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("receipt.fxml"));
        Parent root = loader.load();

        receiptController getReceipt = loader.getController();
        String first_name = firstName.getText();
        String last_name = lastName.getText();
        String e_Mail = mail.getText();
        String id_number = idNumber.getText();
        String patient_age =  age.getText();
        String current_city =  city.getText();
        String contact_number = contactNumber.getText();
        String patientsGender = loadRadio() ;
        String vaccine = loadVaccines();





        if (first_name.equals("")){
            Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
            newAlert.setContentText("First name is missing, Enter the first name");
            newAlert.show();
        }else{
            if (last_name.equals("")){
                Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                newAlert.setContentText("Last name is missing, Enter the last name");
                newAlert.show();
            }else{

                if(current_city.equals("")){
                    Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                    newAlert.setContentText("Current living city is missing, Enter the current city address");
                    newAlert.show();
                }else{
                    if (id_number.equals("")){
                        Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                        newAlert.setContentText("your NIC/PASSPORT number is missing, Enter your NIC/PASSPORT number address");
                        newAlert.show();
                    }else{
                        if (patient_age.equals("")){
                            Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                            newAlert.setContentText("Your age is missing, Enter the age address");
                            newAlert.show();
                        }else{
                            if (contact_number.equals("") ){
                                Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                                newAlert.setContentText("Your contact number is missing, Enter the contact number address");
                                newAlert.show();
                            }else{
                                if(e_Mail.equals("")){
                                    Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                                    newAlert.setContentText("Your e-mail address  is missing, Enter the E-mail address");
                                    newAlert.show();
                                }else{
                                    if(patientsGender.equals("")){
                                        Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                                        newAlert.setContentText("Your gender is missing, Enter the the gender address");
                                        newAlert.show();

                                    } else{
                                        if(vaccine.equals("")){
                                            Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                                            newAlert.setContentText("Please select a vaccine type");
                                            newAlert.show();

                                        } else{

                                                String booths =getBoothNumber();
                                            System.out.println(booths);


                                            getReceipt.showReceipt(first_name,last_name,e_Mail,id_number,patient_age,current_city,contact_number,patientsGender, vaccine, booths );

                                            Stage newStage = new Stage();
                                            newStage.setScene(new Scene(root,878,496));
                                            newStage.setTitle("Vaccination Receipt");
                                            newStage.show();
                                            Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                                            previousStage.close();
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

