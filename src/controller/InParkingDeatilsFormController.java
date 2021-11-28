package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.DataStore;
import view.tm.tmDataStore;

public class InParkingDeatilsFormController {
    public AnchorPane inParkContext;
    public TableView tblVehicleTable;
    public TableColumn clVehicleNumber;
    public TableColumn clVehicleType;
    public TableColumn clParkingSlot;
    public TableColumn clDateTime;

    DataStore [][] allDataStore=DashBordFormController.dataStores;

    public void  initialize(){
        /*for (int a=0;a<allDataStore.length;a++){
            //System.out.print(a+" ");
            System.out.println(allDataStore[a][1]);
        }*/
        clVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        clVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        clParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        clDateTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));

        ObservableList<tmDataStore> tmDataStoreObservableList= FXCollections.observableArrayList();
       for (int i=0;i<allDataStore.length;i++){
           if (allDataStore[i][1] != (null)){
               System.out.println("hukanawa");
               tmDataStoreObservableList.add(new tmDataStore(allDataStore[i][1].getVehicleNumber(),allDataStore[i][1].getVehicleType(),allDataStore[i][1].getParkingSlot(),allDataStore[i][1].getParkedTime()));
           }else {break;}

       }
       tblVehicleTable.setItems(tmDataStoreObservableList);

    }
}
