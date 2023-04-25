import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

  HashMap<String, Personagem> personagens;
  HashMap<String, Cap> capitulos;

    @FXML
    private Button botaoEsc1;

    @FXML
    private Button botaoEsc2;

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
      labelTitulo.setText(capitulo.getTitulo());
      labelTexto.setText(
        capitulo.getText()+ "\n" +
        capitulo.alterarEnergia());
      botaoEsc1.setText(capitulo.getChoices().get(0).getName());
      botaoEsc2.setText(capitulo.getChoices().get(1).getName());
      }

}


// public void Mostrar() {
  
//   if (choices != null) {
//     int i = 1;

//     for (Escolha escolha : choices) {
//       System.out.println(i + ". [" + escolha.getName() + "]");
//       i++;
//     }

//     Scanner scanner = new Scanner(System.in);
//     String playerCh = scanner.nextLine();
//     int count = 0;
//     for (Escolha escolha : choices) {
//       if (playerCh.equals(escolha.getName())) {
//         Cap proximo = escolha.getNext();
//         if (proximo != null) {
//           proximo.Mostrar();
//           count += 1;
//           return;
//         }
//       } 
//       }
//       if (count == 0){
//         System.out.println("Escolha Inválida");
//       }

//       scanner.close();
//     }
//   }