import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Historia extends Application{
  public static void main(String[] args) throws Exception {
    launch(args);
  }
  
  //Metodo implementado da interface "Application"
  @Override
  public void start(Stage primaryStage) throws Exception {
    
  // Carregador do Arquivo .fxml, e definir o que vai ser exibido // Relative Path
   FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneLayout.fxml"));
   Parent root = loader.load();
   Scene tela = new Scene(root,1070,583);
  
   // Executar o projeto;
   primaryStage.setTitle("Projeto9");
   primaryStage.setScene(tela);
   primaryStage.show();

  }
    

  

}
