package com.kth.Dialogs;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

// import the class required for the JOptionPane
import javax.swing.JOptionPane;
import javafx.scene.control.Dialog;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class View extends VBox {

  private Button button;
  private Button button2;
  
  private String name = "default";

  public View() {
    // creata a new VBox with a label
    super(new Label("Hello, World!"));
    // creata a button and add it to the VBox

    button = new Button("Click me!");
    this.getChildren().add(button);

    Dialog<String> dialog = new Dialog<>();
    dialog.setTitle("Login Dialog");

    // add a text field to the dialog
    TextField username = new TextField();
    username.setPromptText("Username");

    // add username to the dialog
    dialog.getDialogPane().setContent(username);
    

    ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().add(loginButtonType);
    boolean disabled = false; // computed based on content of text fields, for example
    dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);

    // set the result converter for the dialog
    dialog.setResultConverter(
        dialogButton -> {
          if (dialogButton == loginButtonType) {
            return username.getText();
          }
          return null;
        });

    button.setOnAction(
        (event) -> {
          dialog.setContentText("Hello, World!");
          dialog.showAndWait().ifPresent(
            usernamePassword -> {
              System.out.println("Username=" + usernamePassword);
              name = usernamePassword;
            });
        });

    // create a new button
    button2 = new Button("Print name");
    // add an event handler to the button
    button2.setOnAction(
        (event) -> {
          // print the name
          System.out.println("Name=" + name);
        });

    this.getChildren().add(button2);
  }
}
