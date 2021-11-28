package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LogInFormController {

    public JFXTextField txtUserName;
    public JFXPasswordField psdUserPassword;
    public AnchorPane loginFormContent;

    public void cancleOnAction(ActionEvent event) throws IOException {
            URL resource = getClass().getResource("../view/DashBordForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window=(Stage) loginFormContent.getScene().getWindow();
            window.setTitle("Parking System");
            window.setScene(new Scene(load));



    }

    public void loginOnAction(ActionEvent event) throws IOException {
        if (txtUserName.getText().equalsIgnoreCase("admin")){
            URL resource = getClass().getResource("../view/InParkingForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window=(Stage) loginFormContent.getScene().getWindow();
            window.setTitle("Parking System");
            window.setScene(new Scene(load));
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Invalid Passsword.\nTry Again.",ButtonType.OK).show();
        }
    }
}
