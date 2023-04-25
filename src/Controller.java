import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Controller {

  //Declaração de váriaveis e "nodes" 
  HashMap<String, Personagem> personagens;
  HashMap<String, Cap> capitulos;

    @FXML
    private Button botaoInicio;

    @FXML
    private HBox hBoxbotao;

    @FXML
    private Label labelASCII;

    @FXML
    private Label labelTexto;

    @FXML
    private Label labelTitulo;

    @FXML

    // Método de apertar o botão; Ao apertar o botão carregará os Hashmaps e executara o metodo
    // MostrarCapitulo.
    void botaoCarregar(ActionEvent event) {
      personagens = LeitorArquivos.lerPersonagens();
      capitulos = LeitorArquivos.lerCapitulos();

      Cap raiz = capitulos.get("Encontro do Desastre");
      mostrarCapitulo(raiz);
      
    }
    
    /*
     * Método que Recebe como parametro um capitulo e impreme-o nos "nodes" da
     * do projeto .fxml
     */
    void mostrarCapitulo(Cap capitulo){
      // Limpar barra de botões
      hBoxbotao.getChildren().clear();

      // Mostrar titulo, imagem, texto
      labelTitulo.setText(capitulo.getTitulo());
      labelTexto.setText(
        capitulo.getText()+ "\n" +
        capitulo.alterarEnergia());
      labelASCII.setText(capitulo.getImagem());

      // Adicionar escolhas em botões, quantas houver 
      if (capitulo.getChoices()!=null){
        for (Escolha escolha : capitulo.getChoices()){

          // Definir função dos botões
          Button botao = new Button(escolha.getName());
          botao.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
              mostrarCapitulo(escolha.getNext());
            }
          });
          // Adicionar o botão na barra horizontal / Mostrar os botões
          hBoxbotao.getChildren().add(botao);
        }

        botaoInicio.setText("Reiniciar");
      } 
    }
      }



