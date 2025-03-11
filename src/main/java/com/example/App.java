package com.example;

import com.example.controller.RegisterController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/Register.fxml"));
            RegisterController registerController = new RegisterController();
            loader.setController(registerController);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/icons/MainLogo.png")));
            primaryStage.setTitle("CRUD - Java");
            primaryStage.show();
        } catch(Exception e) {

            System.out.println("Erro - 01");  //TO - DO
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {launch(args);}
}
