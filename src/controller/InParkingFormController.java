package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class InParkingFormController {

    public ComboBox cmbTypeDetails;
    public TableColumn clVehicleNumber;
    public TableColumn clVehicleType;
    public TableColumn clParkingSlot;
    public TableColumn clDateTime;
    public AnchorPane inParkingContext;
    public TableView tblVehicleTable;
   static ArrayList<String> selectInterface= new ArrayList<>();
    public JFXButton btnLogOut;
    public AnchorPane inParkContext;
    public Button btnAddVehicle;
    public Button btnAddDriver;



    public void initialize(){

        ObservableList<String> observableList=FXCollections.observableArrayList();
        for (String tmSlectInterFace:selectInterface
             ) {
            observableList.add(tmSlectInterFace);
        }
        cmbTypeDetails.setItems(observableList);

        cmbTypeDetails.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
            if (newValue=="On Delivery"){
                URL resource = getClass().getResource("../view/OnDelivaryShiftForm.fxml");
                try {
                    Parent load = FXMLLoader.load(resource);
                    inParkContext.getChildren().clear();
                    inParkContext.getChildren().add(load);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else{
                URL resource = getClass().getResource("../view/InParkingDeatilsForm.fxml");
                try {
                    Parent load = FXMLLoader.load(resource);
                    inParkContext.getChildren().clear();
                    inParkContext.getChildren().add(load);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });


    }
    static {
        selectInterface.add("In Parking");
        selectInterface.add("On Delivery");
    }

    public void addVehicle(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicle.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage) inParkingContext.getScene().getWindow();
        window.setTitle("Update Vehicle ");
        window.setScene(new Scene(load));
    }

    public void addDriver(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/AddDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage) inParkingContext.getScene().getWindow();
        window.setTitle("Update Driver ");
        window.setScene(new Scene(load));
    }

    public void logOut(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/DashBordForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage) inParkingContext.getScene().getWindow();
        window.setTitle("Parking System");
        window.setScene(new Scene(load));
    }


}
