package tictactoe;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("tictactoe.fxml"));
        primaryStage.setTitle("Tic-Tac-Toe");
        Scene scene = new Scene(root, 700, 325);
        scene.getStylesheets().add(getClass() .getResource("tictactoe.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene); 	
        primaryStage.show();
    }
    


    public static void main(String[] args) {
        launch(args);
    }
}