import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Controller {

  HashMap<String, Personagem> personagens;
  HashMap<String, Cap> capitulos;

  @FXML
  private VBox campoBotao;

    @FXML
    private Button botaoStart;

    @FXML
    private Label labelASCII;

    @FXML
    private Label labelTexto;

    @FXML
    private Label labelTitulo;

    @FXML
    void botaoCarregar(ActionEvent event) {
      personagens = LeitorArquivos.lerPersonagens();
      capitulos = LeitorArquivos.lerCapitulos();

      Cap raiz = capitulos.get("Encontro do Desastre");
      mostrarCapitulo(raiz);
      
    }

    @FXML
    void carregarEscolha1(ActionEvent event) {
      
  }

    @FXML
    void carregarEscolha2(ActionEvent event) {

    }
    void mostrarCapitulo(Cap capitulo){
      campoBotao.getChildren().clear();
      labelTitulo.setText(capitulo.getTitulo());
      labelTexto.setText(
        capitulo.getText()+ "\n" +
        capitulo.alterarEnergia());
      if (capitulo.getChoices().size() > 0 ){
        for (Escolha escolha : capitulo.getChoices()){

          Button botao = new Button(escolha.getName());
          botao.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
              mostrarCapitulo(escolha.getNext());
            }
          });

          campoBotao.getChildren().add(botao);
        }
      }
      }

}

