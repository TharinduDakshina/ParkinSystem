package controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AddDriverController {

    public JFXTextField txtDriverName;
    public JFXTextField txtNIC;
    public JFXTextField txtDrivingLicenseNo;
    public JFXTextField txtContact;
    public JFXTextArea txtAreaAddress;
    public AnchorPane addDriverContext;

    ArrayList<Driver> newDriverArrayList=DashBordFormController.driverArrayList;

    public void addDriver(ActionEvent event) {
        newDriverArrayList.add(new Driver(txtDriverName.getText(),txtNIC.getText(),txtDrivingLicenseNo.getText(),txtAreaAddress.getText(),txtContact.getText()));
        txtAreaAddress.setText(null);
        txtContact.setText(null);
        txtDriverName.setText(null);
        txtNIC.setText(null);
        txtDrivingLicenseNo.setText(null);
    }

    public void backOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/InParkingForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage) addDriverContext.getScene().getWindow();
        window.setTitle("Parking System");
        window.setScene(new Scene(load));
    }

    public void deleteDriver(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/DeleteDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage) addDriverContext.getScene().getWindow();
        window.setTitle("Parking System");
        window.setScene(new Scene(load));
    }
}
