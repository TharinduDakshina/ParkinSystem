package controller;

import com.jfoenix.controls.JFXButton;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DataStore;
import model.Driver;
import model.Vehicle;

import javax.management.AttributeList;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class DashBordFormController {


    public JFXButton btnManageLogin;
    public JFXButton btnParkVehicle;
    public JFXButton btnOnDiliveryShift;
    public AnchorPane dashBordContext;
    public ComboBox cmbSelectVehicle;
    public Label lblAnswer;
    public ComboBox cmbSelectDriver;
    public Label lblDiisplaySlotNumber;
    public Label lblDateTime;
    public String tempNewValue=null;
    public Label lblNameSlot;
    public Label lblDriver;

     static ArrayList<Vehicle> vehicleArrayList=new ArrayList();
     static ArrayList<Driver> driverArrayList=new ArrayList();
     static DataStore [][] dataStores=new DataStore[14][2];
     static  int [] slotStore=new int[14];


    public void btnLogin(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../view/LogInForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashBordContext.getScene().getWindow();
        window.setTitle("Login Form");
        window.setScene(new Scene(load));
    }

    public void checking() {

        L1: for (int k = 0; k < slotStore.length; k++) {
            if ("Bus" == (lblAnswer.getText())) {

                if (vehicleArrayList.get(k).getVehicleStatus() == ("Parking")) {
                    lblDiisplaySlotNumber.setText("14");
                    slotStore[13] = 1;

                    for (int z = 0; z < dataStores.length; z++) {
                        if (dataStores[z][1] == null) {
                            dataStores[z][1] = new DataStore(vehicleArrayList.get(z).getVehicleNumber(), vehicleArrayList.get(z).getVehicleType(), lblDiisplaySlotNumber.getText(), driverArrayList.get(z).getDriverName(), lblDateTime.getText());
                            break ;
                        }
                    }
                    for (int v = 0; v < dataStores.length; v++) {
                        if (dataStores[v][0].getVehicleNumber()==(cmbSelectVehicle.getValue())) {
                            dataStores[v][0] =null;
                            break ;
                        }
                    }

                } else {
                    slotStore[13] = 0;

                    if (dataStores[0][1] != null){
                        C0: for (int h=0;h<dataStores.length;h++){
                            if (cmbSelectVehicle.getValue()==(dataStores[h][1].getVehicleNumber())){
                                dataStores[h][1]=null;
                                break C0;
                            }
                        }
                    }

                }
                break L1;

            } else if ("Van" == lblAnswer.getText()) {

                L2:  for (int i = 0; i < slotStore.length; i++) {
                    if (vehicleArrayList.get(i).getVehicleStatus() == "Parking") {
                        if ((i >= 0 && i <= 3) || i == 11 || i == 12) {
                            if (slotStore[i] == 0) {
                                lblDiisplaySlotNumber.setText(i + 1 + "");
                                slotStore[i] = 1;
                             C2:for (int v = 0; v < dataStores.length; v++) {
                                    if (dataStores[v][1] == null) {
                                        dataStores[v][1] = new DataStore(vehicleArrayList.get(v).getVehicleNumber(), vehicleArrayList.get(v).getVehicleType(), lblDiisplaySlotNumber.getText(), driverArrayList.get(v).getDriverName(), lblDateTime.getText());
                                        break C2;

                                    }
                                }
                               C3: for (int u = 0; u < dataStores.length; u++) {
                                    if (dataStores[u][0].getVehicleNumber()==(cmbSelectVehicle.getValue())) {
                                        dataStores[u][0] =null;
                                        break C3;
                                    }
                                }

                                break L1;
                            } else {

                                continue L2;
                            }
                        }
                    } else if (dataStores[0][1] != null){
                        C4:  for (int p=0;p<dataStores.length;p++){
                            if (dataStores[p][1].getVehicleNumber()==(cmbSelectVehicle.getValue())){
                                dataStores[p][1]=null;
                                break C4;
                            }
                        }
                        slotStore[i] = 0;
                    }

                }
            } else if ("Cargo Lory" == lblAnswer.getText()) {

                L3:  for (int x = 4; x < slotStore.length; x++) {
                    if (vehicleArrayList.get(x).getVehicleStatus() == "Parking") {
                        if (x >= 4 && x < 11) {
                            if (slotStore[x] == 0) {
                                lblDiisplaySlotNumber.setText(x + 1 + "");
                                slotStore[x] = 1;
                              C1:  for (int q = 0; q < dataStores.length; q++) {
                                    if (dataStores[q][1] == null) {
                                        dataStores[q][1] = new DataStore(vehicleArrayList.get(q).getVehicleNumber(), vehicleArrayList.get(q).getVehicleType(), lblDiisplaySlotNumber.getText(), driverArrayList.get(q).getDriverName(), lblDateTime.getText());
                                        break C1;
                                    }
                                }
                                C5: for (int s = 0; s < dataStores.length; s++) {
                                    if (dataStores[s][0].getVehicleNumber()==(cmbSelectVehicle.getValue())) {
                                        dataStores[s][0] =null;
                                        break C5;
                                    }
                                }

                                break L1;
                            } else {
                                continue L3;
                            }
                        }
                    } else if (dataStores[0][1] != null){
                        C6:  for (int t=0;t<dataStores.length;t++){
                            if (dataStores[t][1].getVehicleNumber()==(cmbSelectVehicle.getValue())){
                                dataStores[t][1]=null;
                                break C6;
                            }
                        }
                        slotStore[x] = 0;
                    }

                }
            }

        }


    }

    public void btnParkOnAction(ActionEvent event) {
      l1: for (int i=0;i<vehicleArrayList.size();i++){
           if (vehicleArrayList.get(i).getVehicleStatus()==("Deliver") && vehicleArrayList.get(i).getVehicleNumber()==cmbSelectVehicle.getValue()){
               vehicleArrayList.get(i).setVehicleStatus("Parking");
               lblDiisplaySlotNumber.setVisible(true);
               lblNameSlot.setVisible(true);
               btnParkVehicle.setDisable(true);
               btnOnDiliveryShift.setDisable(false);
               checking();
                break l1 ;

           }
       }








    }

    public void btnOnDiliveryShiftOnAction(ActionEvent event) {


        for (int j=0;j<vehicleArrayList.size();j++){
            if (cmbSelectVehicle.getValue().equals(vehicleArrayList.get(j).getVehicleNumber())  ){
                vehicleArrayList.get(j).setVehicleStatus("Deliver");
                dataStores[j][0]=new DataStore(vehicleArrayList.get(j).getVehicleNumber(),vehicleArrayList.get(j).getVehicleType(),cmbSelectDriver.getValue().toString(),lblDateTime.getText());
                checking();
                btnOnDiliveryShift.setDisable(true);
                cmbSelectDriver.setVisible(true);
                btnParkVehicle.setDisable(false);
                //break;
            }

        }




    }

    public void  selectNumber(){



        for (int i=0;i<vehicleArrayList.size();i++){
            if (cmbSelectVehicle.getValue().equals(vehicleArrayList.get(i).getVehicleNumber()) && (vehicleArrayList.get(i).getVehicleStatus()==null || vehicleArrayList.get(i).getVehicleStatus()=="Parking")){
                lblAnswer.setText(vehicleArrayList.get(i).getVehicleType());
                btnParkVehicle.setDisable(true);
                btnOnDiliveryShift.setDisable(false);
                lblNameSlot.setVisible(false);
                lblDiisplaySlotNumber.setVisible(false);
               // System.out.println(vehicleArrayList.get(i).getVehicleStatus());
            }else if (cmbSelectVehicle.getValue().equals(vehicleArrayList.get(i).getVehicleNumber()) && (vehicleArrayList.get(i).getVehicleStatus()=="Deliver" || vehicleArrayList.get(i).getVehicleStatus()=="Parking")){
                lblAnswer.setText(vehicleArrayList.get(i).getVehicleType());
                btnParkVehicle.setDisable(false);
                btnOnDiliveryShift.setDisable(true);
                if (vehicleArrayList.get(i).getVehicleStatus()=="Deliver"){
                  S1:  for (int w=0;w<dataStores.length;w++){
                        if (vehicleArrayList.get(i).getVehicleNumber().equals(dataStores[w][0].getVehicleNumber())){
                            cmbSelectDriver.setValue(dataStores[w][0].getDriverName());
                            break S1;
                        }else {
                            continue S1;
                        }
                    }
                }
            }
        }

        /*for (int x=0;x<vehicleArrayList.size();x++){

        }*/


    }







    public  void initialize(){


        {
            Thread clock=new Thread(){
                public void run(){
                    try {
                        while (true) {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy \n HH:mm:ss a");
                            Date date = new Date();
                            String myString = formatter.format(date);
                            Platform.runLater(() -> {
                                lblDateTime.setText(myString);
                            });
                            sleep(1);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            clock.start();

        }



        lblNameSlot.setVisible(false);
        lblDiisplaySlotNumber.setVisible(false);





        ObservableList<String> observableList= FXCollections.observableArrayList();
        for (Vehicle temp:vehicleArrayList
        ) {
            observableList.add(temp.getVehicleNumber());
        }
        cmbSelectVehicle.setItems(observableList);

        ObservableList<String> observableListDriver= FXCollections.observableArrayList();
        for (Driver tempDriver:driverArrayList
        ) {
            observableListDriver.add(tempDriver.getDriverName());
        }
        cmbSelectDriver.setItems(observableListDriver);




    }

    static {
        driverArrayList.add(new Driver("Sumith Kumara","7855215545V","B6474845 ","Panadura","0725637456"));
        driverArrayList.add(new Driver("Amila Pathirana","8855215544V","B3354674","Galle","0717573583"));
        driverArrayList.add(new Driver("Jithmal Perera","9255215572V","B3674589","Horana","0772452457"));
        driverArrayList.add(new Driver("Sumith Disanayaka","9455215573V","B8366399","Kaluthara","0782686390"));
        driverArrayList.add(new Driver("Sumanasiri Herath","8955215573V","B3537538","Beruwala","0772534436"));
        driverArrayList.add(new Driver("Awantha Fernando","9155215564V","B3554789","Colombo","0714534356"));
        driverArrayList.add(new Driver("Charith Sudara","9155215538V","B6835836","Baththaramulla","0771536662"));
        driverArrayList.add(new Driver("Prashan Dineth","9555215555V","B2683536","Wadduwa","0715353434"));
        driverArrayList.add(new Driver("Chethiya Dilan","9355215576V","B6836836","Panadura","0772436737"));
        driverArrayList.add(new Driver("Dushantha Pereta","9155215549V","B3334435","Matara","0777245343"));
        driverArrayList.add(new Driver("Udana Cathuranga","9255215526V","B3573783","Galle","0703635442"));
        driverArrayList.add(new Driver("Mohomad Riaz","8755215534V","B5343783","Hettimulla","0713456878"));
        driverArrayList.add(new Driver("Sadun Kumara","9055215515V","B7888632","Kottawa","0772442444"));
        driverArrayList.add(new Driver("Priyanga perera","9655215596V","B3638537","Kaluthara","0777544222"));
        driverArrayList.add(new Driver("Dinesh Udara","955521554478V","B2263333","Panadura","0772325544"));
        driverArrayList.add(new Driver("Sumith Udayanga","9155215545V","B3853753","Matara","0723344562"));



        vehicleArrayList.add(new Vehicle("NA-3434", "3500", "60", "Bus"));
        vehicleArrayList.add(new Vehicle("KA-4563", "1000", "7", "Van"));
        vehicleArrayList.add(new Vehicle("58-3567", "1500", "4", "Van"));
        vehicleArrayList.add(new Vehicle("GF-4358", "800", "4", "Van"));
        vehicleArrayList.add(new Vehicle("CCB-3568", "1800", "8", "Van"));
        vehicleArrayList.add(new Vehicle("LM-6679", "1500", "4", "Van"));
        vehicleArrayList.add(new Vehicle("QA-3369", "1800", "6", "Van"));
        vehicleArrayList.add(new Vehicle("KB-3668", "2500", "2", "Cargo Lory"));
        vehicleArrayList.add(new Vehicle("JJ-9878", "3000", "2", "Cargo Lory"));
        vehicleArrayList.add(new Vehicle("GH-5772", "4000", "3", "Cargo Lory"));
        vehicleArrayList.add(new Vehicle("XY-4456", "3500", "2", "Cargo Lory"));
        vehicleArrayList.add(new Vehicle("YQ-3536", "2000", "2", "Cargo Lory"));
        vehicleArrayList.add(new Vehicle("CBB-3566", "2500", "2", "Cargo Lory"));
        vehicleArrayList.add(new Vehicle("QH-3444", "5000", "4", "Cargo Lory"));


    }

}
