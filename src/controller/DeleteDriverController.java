package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class DeleteDriverController {
    public Label lblDriverName;
    public Label lblLicenseNo;
    public Label lblAddress;
    public Label lblContactNumber;

    public JFXComboBox cmbSelectNICNumber;
    public AnchorPane deleteDriverContext;

    ArrayList<Driver> modifyDriverList=DashBordFormController.driverArrayList;

    public void initialize() {
        ObservableList<String> observableListVehiclenumber= FXCollections.observableArrayList();
        for (Driver temp: modifyDriverList
        ) {
            observableListVehiclenumber.add(temp.getNoNIC());
        }
        cmbSelectNICNumber.setItems(observableListVehiclenumber);
    }

    public void deleteDriver(ActionEvent event) {
        for (Driver tempDriver:modifyDriverList
        ) {
            if (cmbSelectNICNumber.getValue()==tempDriver.getNoNIC()){
                modifyDriverList.remove(tempDriver);
                initialize();
                lblDriverName.setText(null);
                lblContactNumber.setText(null);
                lblAddress.setText(null);
                lblLicenseNo.setText(null);
                break;
            }
        }
    }


    public void showDataOnAction(ActionEvent event) {
        for (Driver tempDriver:modifyDriverList
             ) {
            if (cmbSelectNICNumber.getValue()==tempDriver.getNoNIC()){
                lblDriverName.setText(tempDriver.getDriverName());
                lblLicenseNo.setText(tempDriver.getDrivingLicenseNo());
                lblAddress.setText(tempDriver.getAddress());
                lblContactNumber.setText(tempDriver.getContact());
                break;
            }
        }
    }

    public void backOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/AddDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage) deleteDriverContext.getScene().getWindow();
        window.setTitle("Parking System");
        window.setScene(new Scene(load));
    }
}
