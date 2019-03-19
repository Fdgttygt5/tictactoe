package tictactoe;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {
	@FXML Button b1;
	@FXML Button b2;
	@FXML Button b3;
	@FXML Button b4;
	@FXML Button b5;
	@FXML Button b6;
	@FXML Button b7;
	@FXML Button b8;
	@FXML Button b9;
	@FXML Button OkPlayer1;
	@FXML Button OkPlayer2;
	@FXML MenuItem MenuPlay;
	@FXML TextField Player1NameText;
	@FXML TextField Player2NameText;
	@FXML GridPane gameBoard;
	@FXML TextArea LeaderBoardText;
	
   	Path path = Paths.get("scores.txt");
	
	private boolean isFirstPlayer = true;

	
   public void buttonClickHandler(ActionEvent evt){

        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();


        if ("".equals(buttonLabel) && isFirstPlayer && !find3InARow()){
            clickedButton.setText("X");
            isFirstPlayer = false;
            find3InARow();
            if (find3InARow() == true) {
            	FirstPlayerWins();
            }
        } else if("".equals(buttonLabel) && !isFirstPlayer && !find3InARow()){
            clickedButton.setText("O");
            isFirstPlayer = true;
            find3InARow();
            if (find3InARow() == true) {
            	SecondPlayerWins();
            }
        }
        
        if(OkPlayer1.equals(clickedButton)) {
           	Path path = Paths.get("scores.txt");
           	
           	try {         
                   if ( Files.exists(path)){            
                       Files.write(path, getPlayer1Name().getBytes(),
                                 StandardOpenOption.APPEND);
                   } else {
                       Files.write(path, getPlayer1Name().getBytes(), StandardOpenOption.CREATE);
                   }

           	} catch (IOException ioe) {
           		System.out.println("Could not write into the file: " + ioe.getMessage());     
           	}
        }
        if(OkPlayer2.equals(clickedButton)) {
           	Path path = Paths.get("scores.txt");
           	
           	try {         
                   if ( Files.exists(path)){            
                       Files.write(path, getPlayer2Name().getBytes(),
                                 StandardOpenOption.APPEND);
                   } else {
                       Files.write(path, getPlayer2Name().getBytes(), StandardOpenOption.CREATE);
                   }

           	} catch (IOException ioe) {
           		System.out.println("Could not write into the file: " + ioe.getMessage());     
           	}
        }
   }
   
   public void changeScene(ActionEvent event) throws IOException {
   	Parent leaderBoardParent = FXMLLoader.load(getClass().getResource("leaderboard.fxml"));
   	Scene leaderBoardScene = new Scene (leaderBoardParent);
   	
   	Stage stage = (Stage)(b9.getScene()).getWindow();
   	
   	stage.setScene(leaderBoardScene);
    
   
   	Node lBText=leaderBoardParent.lookup("#LeaderBoardText");
   	TextArea ltx  = (TextArea)lBText;
   	ltx.setText(getLeaderBoardScores());
	stage.show();
   }
   
   public void changeScene1(ActionEvent event) throws IOException {
	   	Parent tictactoeParent = FXMLLoader.load(getClass().getResource("tictactoe.fxml"));
	   	Scene tictactoeScene = new Scene (tictactoeParent);
	   	
	   	Stage stage = (Stage)(LeaderBoardText.getScene()).getWindow();
	   	
	   	stage.setScene(tictactoeScene);
        tictactoeScene.getStylesheets().add(getClass() .getResource("tictactoe.css").toExternalForm());
	   	stage.show();
	   }
   
   public String getLeaderBoardScores(){
	      String currentLine = ("");
	      String allLines="";
	   try {

		      BufferedReader bufferedReader = Files.newBufferedReader(path);
		      
		      while ((currentLine = bufferedReader.readLine()) != null) {
			      allLines = allLines+System.lineSeparator()+currentLine;
			      
		      }

		      
		    } catch (IOException ioe) {
		        System.out.println("Can't read file: " +
		                             ioe.getMessage());
		    }
	      return allLines.trim();

   }
   
   public void quitProgram(ActionEvent event) {
		   Stage stage = (Stage)(b9.getScene()).getWindow();
		   stage.close();
   }
   public void quitProgram1(ActionEvent event) {
	   Stage stage = (Stage)(LeaderBoardText.getScene()).getWindow();
	   stage.close();
   }
   
   
   public void MenuPlayPressed(ActionEvent evt) throws IOException {

	   
	   MenuItem clickedMenu = (MenuItem) evt.getTarget();
	   String menuLabel = clickedMenu.getText();

	   
	   if("Play".equals(menuLabel)) {
		   b1.setText("");
		   b2.setText("");
		   b3.setText("");
		   b4.setText("");
		   b5.setText("");
		   b6.setText("");
		   b7.setText("");
		   b8.setText("");
		   b9.setText("");
		   b1.getStyleClass().remove("winning-square");
		   b2.getStyleClass().remove("winning-square");
		   b3.getStyleClass().remove("winning-square");
		   b4.getStyleClass().remove("winning-square");
		   b5.getStyleClass().remove("winning-square");
		   b6.getStyleClass().remove("winning-square");
		   b7.getStyleClass().remove("winning-square");
		   b8.getStyleClass().remove("winning-square");
		   b9.getStyleClass().remove("winning-square");
		   b1.getStyleClass().remove("winning-square");
		   b2.getStyleClass().remove("winning-square");
		   b3.getStyleClass().remove("winning-square");
		   b4.getStyleClass().remove("winning-square");
		   b5.getStyleClass().remove("winning-square");
		   b6.getStyleClass().remove("winning-square");
		   b7.getStyleClass().remove("winning-square");
		   b8.getStyleClass().remove("winning-square");
		   b9.getStyleClass().remove("winning-square");
		   isFirstPlayer = true;
	   }
	   
   }
   
   private void FirstPlayerWins() {
   	System.out.println("ButtonClicked");
   	
   	String WinnerPlayer1 = "winner: " + getPlayer1Name();
   	
   	try {         
           if ( Files.exists(path)){            
               Files.write(path, WinnerPlayer1.getBytes(),
                         StandardOpenOption.APPEND);
           } else {
               Files.write(path, WinnerPlayer1.getBytes(), StandardOpenOption.CREATE);
           }

   	} catch (IOException ioe) {
   		System.out.println("Could not write into the file: " + ioe.getMessage());     
   	}
   }
   
   private void SecondPlayerWins() {
	   	System.out.println("ButtonClicked");
	   	Path path = Paths.get("scores.txt");
	   	
	   	String WinnerPlayer2 = "winner: " + getPlayer2Name();

	   	try {         
	           if ( Files.exists(path)){            
	               Files.write(path, WinnerPlayer2.getBytes(),
	                         StandardOpenOption.APPEND);
	           } else {
	               Files.write(path, WinnerPlayer2.getBytes(), StandardOpenOption.CREATE);
	           }

	   	} catch (IOException ioe) {
	   		System.out.println("Could not write into the file: " + ioe.getMessage());     
	   	}
	   }

   private boolean find3InARow(){
       //Row 1
       if (""!=b1.getText() && b1.getText() == b2.getText()
           && b2.getText() == b3.getText()){
           highlightWinningCombo(b1,b2,b3);
           return true;
       }
       //Row 2
       if (""!=b4.getText() && b4.getText() == b5.getText()
           && b5.getText() == b6.getText()){
           highlightWinningCombo(b4,b5,b6);
           return true;
       }
       //Row 3
       if (""!=b7.getText() && b7.getText() == b8.getText()
           && b8.getText() == b9.getText()){
           highlightWinningCombo(b7,b8,b9);
           return true;
       }
       //Column 1
       if (""!=b1.getText() && b1.getText() == b4.getText()
           && b4.getText() == b7.getText()){
           highlightWinningCombo(b1,b4,b7);
           return true;
       }
       //Column 2
       if (""!=b2.getText() && b2.getText() == b5.getText()
           && b5.getText() == b8.getText()){
           highlightWinningCombo(b2,b5,b8);
           return true;
       }
       //Column 3
       if (""!=b3.getText() && b3.getText() == b6.getText()
           && b6.getText() == b9.getText()){
           highlightWinningCombo(b3,b6,b9);
           return true;
       }
       //Diagonal 1
       if (""!=b1.getText() && b1.getText() == b5.getText()
           && b5.getText() == b9.getText()){
           highlightWinningCombo(b1,b5,b9);
           return true;
       }
       //Diagonal 2
       if (""!=b3.getText() && b3.getText() == b5.getText()
           && b5.getText() == b7.getText()){
           highlightWinningCombo(b3,b5,b7);
           return true;
       }
       return false;
   }
   
   private String getPlayer1Name() {
	   String Player1Name = Player1NameText.getText() + System.lineSeparator();
	   return Player1Name;
   }
   
   private String getPlayer2Name() {
	   String Player2Name = Player2NameText.getText() + System.lineSeparator();
	   return Player2Name;
   }
   
   private void highlightWinningCombo(Button first, Button second, Button third){
       first.getStyleClass().add("winning-square");
       second.getStyleClass().add("winning-square");
       third.getStyleClass().add("winning-square");
   }
   
}