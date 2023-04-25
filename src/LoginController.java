import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button botaoLogin;

    @FXML
    private TextField campoSenha;

    @FXML
    private TextField campoUsuario;

    @FXML
    void fazerLogin(ActionEvent event) {
      String usuario = campoUsuario.getText();
      String senha = campoSenha.getText();

      if (usuario.equals("luccas") && senha.equals("luccas17")){
        System.out.println("Fez o login com Sucesso");
      } else {
        System.out.println("Errou");
      }

    }

}
