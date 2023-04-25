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

    //     Scanner scanner = new Scanner(System.in);
    // /* 
    // * Ler/Criar os Dicionários
    // */
        HashMap<String, Personagem> personagens = LeitorArquivos.lerPersonagens();
    
        HashMap<String, Cap> capitulos = LeitorArquivos.lerCapitulos();
    /*
    //  * Executável 
    //  */
        Cap cabeca = capitulos.get("encontrododesastre");
    
    //     cabeca.Mostrar();
    
    //     scanner.close();

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
