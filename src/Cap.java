import java.util.ArrayList;
import java.util.Scanner;

public class Cap {
  private String text;
  private String titulo;

  public String getTitulo() {
    return titulo;
  }

  public String getText() {
    return text;
  }

  private ArrayList<Escolha> choices;

  public ArrayList<Escolha> getChoices() {
    return choices;
  }

  private Personagem chars;
  private int atentionV;

  public Cap(
    String texto, String titulo, ArrayList<Escolha> escolhas, Personagem personagem, int atencao) {
    this.text = texto;
    this.titulo = titulo;
    this.choices = escolhas;
    this.chars = personagem;
    this.atentionV = atencao;
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