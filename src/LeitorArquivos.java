import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LeitorArquivos {
  /**
   * Ler todo o arquivo Capitulos.txt e separa e organiza, 
   * criando os capitulos com suas respectivas escolhas e Personagens 
   * @return HashMap Caps (Capitulos)
   */
  public static HashMap<String, Cap> lerCapitulos() {

    HashMap<String, Cap> caps = new HashMap<String, Cap>();
    try {
      File myFile = new File(
          "C:/Users/Amd/Desktop/Projetos - Programação/Miniprojeto 9/lib/Capitulos.txt");
      Scanner myReader = new Scanner(myFile, "UTF-8");
      
      // Variavéis declaradas inicialmente "nulas"

      String title = "";
      String hist = "";
      ArrayList<Escolha> choice = new ArrayList<Escolha>();
      Personagem perso = null;
      int changeA = 0;
      
      // Estrutura de repetição até ler todo o arquivo

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();

        // chave/titulo + historia + Personagem + Alteração, 
        // Escolha = 0 para inicio de criação 

        if (data.startsWith("Titulo: ")) {
          title = data.substring(8);
        } else if (data.startsWith("Historia: ")) {
          hist = data.substring(10);

          while (myReader.hasNextLine()) {
            String line = myReader.nextLine();

            if (line.startsWith("Escolhas:")) {
              // Escolhas identificadas após criação dos personagens.
              break;
            } else {
              hist += "\n" + line;
            }
          }
        } else if (data.startsWith("Personagem: ")) {
          String keyP = data.substring(12);

          perso = new Personagem(
              LeitorArquivos.lerPersonagens().get(keyP).getName(),
              LeitorArquivos.lerPersonagens().get(keyP).getAtention());
        } else if (data.startsWith("Alteracao: ")) {
          changeA = Integer.parseInt(data.substring(12));

          Cap cap = new Cap(hist,title, choice, perso, changeA);
          caps.put(title, cap);

          // Reinicia as variáveis para ler o próximo capítulo
          title = "";
          hist = "";
          choice = new ArrayList<Escolha>();
          perso = null;
          changeA = 0;
        }
      }

      //Estrutura de repetição até re-ler todo o arquivo 
      
      int count = 0;
      Scanner choiceReader = new Scanner(myFile);

      while (choiceReader.hasNextLine()) {
        String data = choiceReader.nextLine();

        ArrayList<Escolha> choiceX = new ArrayList<Escolha>();

        if (data.startsWith("Escolhas: ")) {
          String stringCh = data.substring(10);

          if (stringCh.equalsIgnoreCase("0")) {
            choiceX = null;
          } else {
            // [texto:CapProx texto:CapProx]
            // Quebra da String Escolha: do arquivo .txt
            String[] arrayEscolhas = stringCh.split(" ");

            for (String choseStr : arrayEscolhas) {
              String[] choiceFor = choseStr.split(":");

              choiceX.add(new Escolha(choiceFor[0], caps.get(choiceFor[1])));
            }
          }

          // Endereçamento das Escolhas para seus respectivos Capitulos.

          count += 1;
          if (count == 1) {
            caps.get("Encontro do Desastre").setChoices(choiceX);
          } else if (count == 2) {
            caps.get("Continua").setChoices(choiceX);
          } else if (count == 3) {
            caps.get("Ligacao").setChoices(choiceX);
          } else if (count == 4) {
            caps.get("Casamento").setChoices(choiceX);
          } else if (count == 5) {
            caps.get("Missao").setChoices(choiceX);
          }
        }
      }
      choiceReader.close();

      myReader.close();

    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado.");
      e.printStackTrace();
    }

    return caps;

  }
  /**
   * Ler todo o arquivo Personagem.txt e separa e organiza, 
   * entre chave do personagem, nome e energia
   * @return HashMap Chars (Capitulos)
   */
  public static HashMap<String, Personagem> lerPersonagens() {
    HashMap<String, Personagem> chars = new HashMap<String, Personagem>();

    try {
      File myFile = new File(
          "C:/Users/Amd/Desktop/Projetos - Programação/Miniprojeto 9/lib/Personagens.txt");
      Scanner myReader = new Scanner(myFile, "UTF-8");

      String keyP = "";

      // Estrutura de repetição até leitura completa do Arquivo.txt
      // Organizando os Personagens por chave, nome, energia em um HashMap

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();

        if (data.matches("[a-zA-Z]+")) {
          keyP = data;
        } else if (data.startsWith("Nome: ")) {
          String nome = data.substring(6);
          data = myReader.nextLine();

          if (data.startsWith("Atencao: ")) {
            int mana = Integer.parseInt(data.substring(9));
            Personagem perso = new Personagem(nome, mana);
            chars.put(keyP, perso);
          }
        }

      }

      myReader.close();

    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado.");
      e.printStackTrace();
    }

    return chars;

  }
}