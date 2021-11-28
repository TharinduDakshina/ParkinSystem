package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DataStore;
import model.Vehicle;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class AddVehicleController {

    public AnchorPane addVehicleContext;
    public JFXComboBox cmbVehicleType;
    public JFXTextField txtVehicleNumber;
    public JFXTextField txtMaxWait;
    public JFXTextField txtNoPassenders;
    public Label lblAnswer;


    static ArrayList<String>vehicleType=new ArrayList();
    public Label number;
    public Label passenger;
    public Label type;
    public JFXButton addVehicleButton;
    public JFXComboBox cmDeletebVehicleType;
    public Label lblAddNewVehicleTital;
    public JFXTextField txtDeleteVehicleMaxWait;
    public Label lblWait;
    public Separator separator;
    public JFXComboBox cmDeleteVehicleNumber;
    public AnchorPane addVehicleDashboardContext;

    ArrayList<Vehicle> modifyVehicleArrayList=DashBordFormController.vehicleArrayList;

    public void initialize(){
        ObservableList<String>observableList=FXCollections.observableArrayList();
        for (String tmVehicleType:vehicleType
             ) {
            observableList.add(tmVehicleType);
        }
        cmbVehicleType.setItems(observableList);
        cmDeletebVehicleType.setItems(observableList);

        number.setDisable(true);
        passenger.setDisable(true);
        type.setDisable(true);
        lblWait.setDisable(true);
        number.setDisable(true);
        number.setDisable(true);
        addVehicleButton.setDisable(true);
        txtVehicleNumber.setDisable(true);
        txtNoPassenders.setDisable(true);
        txtMaxWait.setDisable(true);
        cmbVehicleType.setDisable(true);
        lblAddNewVehicleTital.setDisable(true);
        separator.setDisable(true);

        fixedDeleteVehicleComboBox();
    }

    public void fixedDeleteVehicleComboBox(){
        ObservableList<String> observableListVehiclenumber=FXCollections.observableArrayList();
        for (Vehicle temVehicleNumber: modifyVehicleArrayList
        ) {
            observableListVehiclenumber.add(temVehicleNumber.getVehicleNumber());
        }
        cmDeleteVehicleNumber.setItems(observableListVehiclenumber);

        hideAddVehicleOnAction();
    }

    public void hideAddVehicleOnAction(){
        if (modifyVehicleArrayList.size()==14){
            number.setDisable(true);
            passenger.setDisable(true);
            type.setDisable(true);
            lblWait.setDisable(true);
            number.setDisable(true);
            number.setDisable(true);
            addVehicleButton.setDisable(true);
            txtVehicleNumber.setDisable(true);
            txtNoPassenders.setDisable(true);
            txtMaxWait.setDisable(true);
            cmbVehicleType.setDisable(true);
            lblAddNewVehicleTital.setDisable(true);
            separator.setDisable(true);
        }else {
            number.setDisable(false);
            passenger.setDisable(false);
            type.setDisable(false);
            lblWait.setDisable(false);
            number.setDisable(false);
            number.setDisable(false);
            addVehicleButton.setDisable(false);
            txtVehicleNumber.setDisable(false);
            txtNoPassenders.setDisable(false);
            txtMaxWait.setDisable(false);
            cmbVehicleType.setDisable(false);
            lblAddNewVehicleTital.setDisable(false);
            separator.setDisable(false);
        }

    }

    static {
        vehicleType.add("Bus");
        vehicleType.add("Van");
        vehicleType.add("Cargo Lorry");

    }

    public void addVehicle(ActionEvent event) {

        modifyVehicleArrayList.add(new Vehicle(txtVehicleNumber.getText(),txtMaxWait.getText(),txtNoPassenders.getText(),cmbVehicleType.getValue().toString()));

        fixedDeleteVehicleComboBox();

        txtDeleteVehicleMaxWait.setText(null);
        txtVehicleNumber.setText(null);
        txtMaxWait.setText(null);
        txtNoPassenders.setText(null);


    }


    public void backOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/InParkingForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage) addVehicleDashboardContext.getScene().getWindow();
        window.setTitle("Parking System");
        window.setScene(new Scene(load));
    }

    public void selectDeleteVehicleNumberOnAction(ActionEvent event) {hideAddVehicleOnAction();}

    public void deleteOnAction(ActionEvent event) {

        for (Vehicle tem:modifyVehicleArrayList
             ) {

            if (tem.getVehicleNumber().equals(cmDeleteVehicleNumber.getValue())){
                modifyVehicleArrayList.remove(tem);
                fixedDeleteVehicleComboBox();

                break;
            }
        }


        number.setDisable(false);
        passenger.setDisable(false);
        type.setDisable(false);
        lblWait.setDisable(false);
        number.setDisable(false);
        number.setDisable(false);
        addVehicleButton.setDisable(false);
        txtVehicleNumber.setDisable(false);
        txtNoPassenders.setDisable(false);
        txtMaxWait.setDisable(false);
        cmbVehicleType.setDisable(false);
        lblAddNewVehicleTital.setDisable(false);
        separator.setDisable(false);
    }
}
