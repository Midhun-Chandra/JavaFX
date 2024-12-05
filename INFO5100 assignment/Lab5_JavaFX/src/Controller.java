
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * 
 */

   
     
public class Controller {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField emailTextField;

    @FXML
    private void submit(ActionEvent event) {
        System.out.println("Submitted");

        String name = nameTextField.getText().trim();
        String age = ageTextField.getText().trim();
        String email = emailTextField.getText().trim();

        // Validation
        if (name.isEmpty() || age.isEmpty() || email.isEmpty()) {
            showErrorAlert("Validation Error", "All fields are required!");
            return;
        }

        if (!age.matches("\\d+")) {
            showErrorAlert("Validation Error", "Age must be a valid number!");
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            showErrorAlert("Validation Error", "Email must be in a valid format!");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Submitted");
        alert.setHeaderText("Thank You");
        alert.setContentText(String.format("Submitted Details: Name: %s Age: %s Email: %s", name, age, email));
        alert.showAndWait();
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
