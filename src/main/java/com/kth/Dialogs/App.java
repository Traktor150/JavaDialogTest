package com.kth.Dialogs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  private static Scene scene;

  // create a Start method for JavaFX
  @Override
  public void start(Stage primaryStage) throws Exception {
    // create a new View
    View view = new View();

    // add the view to the stage
    scene = new Scene(view, 640, 480);
    primaryStage.setScene(scene);

    // set the title of the window
    primaryStage.setTitle("Hello, World!");
    // show the window

    primaryStage.sizeToScene();
    primaryStage.setResizable(false);

    primaryStage.show();
  }

  public static void main(String[] args) {
    System.out.println("Hello, World!");
    launch(App.class, args);
  }
}
