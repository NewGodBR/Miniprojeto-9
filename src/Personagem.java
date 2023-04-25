public class Personagem {
	private String name;
	private int atention;

	public String getName() {
		return name;
	}

	public int getAtention() {
		return this.atention;
	}

	public String setAtention(int atencao) {
		this.atention += atencao;
		String condicao = "";
		if (this.atention > 100) {
			this.atention = 100;
		} else if (this.atention <= 0) {
			condicao = " está completamente desfocado de sua tarefa";
		}
		return condicao;
	}

	public Personagem(String nome, int atencao) {
		this.name = nome;
		this.atention = atencao;
	}
}