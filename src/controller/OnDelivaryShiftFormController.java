package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.DataStore;
import view.tm.tmDataStore;

public class OnDelivaryShiftFormController {

    public TableColumn clVehicleNumber;
    public TableColumn clVehicleType;
    public TableColumn clDriverName;
    public TableColumn clLeftTime;
    public TableView tblDeliverData;
    //  public AnchorPane onDeliveryShiftContext;
    DataStore [][] allStoreData=DashBordFormController.dataStores;

    public AnchorPane inParkContext;
    public  void  initialize(){
        clVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        clVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        clDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        clLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));

        ObservableList<tmDataStore> tmDataStoreObservableList= FXCollections.observableArrayList();
        for (int i=0;i<allStoreData.length;i++){
            if (allStoreData[i][0] != null){
                tmDataStoreObservableList.add(new tmDataStore(allStoreData[i][0].getVehicleNumber(),allStoreData[i][0].getVehicleType(),"0",allStoreData[i][0].getDriverName(),allStoreData[i][0].getLeftTime()));
            }else {break;}
            System.out.println(allStoreData[i][0]);
        }
        tblDeliverData.setItems(tmDataStoreObservableList);
        System.out.println(tmDataStoreObservableList);

    }
}
