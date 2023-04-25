import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class Historia extends Application{
  public static void main(String[] args) throws Exception {
    launch(args);
    
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception {
   FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneLayout.fxml"));
   Parent root = loader.load();
   Scene tela = new Scene(root);

   primaryStage.setTitle("Projeto9");
   primaryStage.setScene(tela);
   primaryStage.show();

  }
    

  

}
