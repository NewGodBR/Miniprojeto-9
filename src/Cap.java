import java.util.ArrayList;

public class Cap {

  private String imagem;
  private String text;
  private String titulo;
  private ArrayList<Escolha> choices;
  private Personagem chars;
  private int atentionV;
  
  public Cap(String imagem, String text, String titulo, ArrayList<Escolha> choices, Personagem chars, int atentionV) {
    this.imagem = imagem;
    this.text = text;
    this.titulo = titulo;
    this.choices = choices;
    this.chars = chars;
    this.atentionV = atentionV;
  }
    public String getImagem() {
      return imagem;
    }
    public String getTitulo() {
      return titulo;
    }
  
    public String getText() {
      return text;
    }
    
  public ArrayList<Escolha> getChoices() {
    return choices;
  }
  public void setChoices(ArrayList<Escolha> escolhas) {
    this.choices = escolhas;
  }

  public String alterarEnergia() {
    return this.chars.setAtention(this.atentionV);
  
  }

  /**
   * Mostra o capitulo x, incluindo seu nome, personagem e alteração, escolhas (caso houver),
   * e o re-executa caso houver um proximo até o fim.
   */
  
  }