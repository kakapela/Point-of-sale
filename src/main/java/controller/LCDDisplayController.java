package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.devices.output.DisplayState;
import model.devices.output.Printer;
import model.product.ProductStates;
import model.devices.input.InputDevice;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Window;
import model.devices.output.LCDDisplay;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LCDDisplayController implements Initializable {
    @FXML
    private JFXTextField input;
    @FXML
    private TextArea lcdDisplayOutput;
    private String barcode;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textLimiter(input, 8);

    }


    @FXML
    public void submit(MouseEvent event) {
        try {
            barcode = input.getText();
            InputDevice.scanBarcode(barcode);
            LCDDisplay lcdDisplay = new LCDDisplay();


            if (barcode.isEmpty()) {
                DisplayState.getInstance().setState(ProductStates.INVALID_BARCODE);
                lcdDisplayOutput.setText(lcdDisplay.showMessage());
            }
            else if (barcode.toLowerCase().matches("exit")) {
               createNewScene("/view/layouts/PrinterView.fxml");
            } else {
                lcdDisplayOutput.setText(lcdDisplay.showMessage());
                Printer printer = new Printer();
                System.out.println(printer.printProductList());
                System.out.println(printer.printTotalSum());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void exitProgram(MouseEvent event) {
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm", ButtonType.OK, ButtonType.CANCEL);
        Window owner = ((Node) event.getTarget()).getScene().getWindow();
        exitAlert.setContentText("Czy napewno chcesz wyjść?");
        exitAlert.initModality(Modality.APPLICATION_MODAL);
        exitAlert.initOwner(owner);
        exitAlert.showAndWait();

        if (exitAlert.getResult() == ButtonType.OK) {
            Platform.exit();
        } else {
            exitAlert.close();
        }
    }


    public static void textLimiter(final JFXTextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

    public void createNewScene(String view){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(view));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Product List");
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
}
