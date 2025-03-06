package com.example;

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

            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
            //LoginViewController loginViewController = new LoginViewController();
            //loader.setController(loginViewController);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/alexandre/icons/MainLogo.png")));
            primaryStage.setTitle("Home");
            primaryStage.show();
        } catch(Exception e) {

            System.out.println("Erro - 01");  //TO - DO
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {launch(args);}
}
