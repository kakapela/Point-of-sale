package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import model.dao.Database;
import model.devices.output.Printer;

import java.net.URL;
import java.util.ResourceBundle;

public class PrinterController implements Initializable {

    @FXML
    private TextArea productListArea;
    Printer printer = new Printer();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productListArea.setText("TOTAL SUM: " + printer.printTotalSum() + "\n\n");
        productListArea.appendText(printer.printProductList());
    }

    public void exitProgram(MouseEvent event) {
        Platform.exit();
        Database.getInstance().disconnect();
    }
}
