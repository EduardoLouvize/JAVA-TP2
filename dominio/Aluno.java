package dominio;

public class Aluno extends Pessoa {

	private float notaAvaliacao1;
	private float notaAvaliacao2;
	private float mediaFinal;
	private String situacao;

	public Aluno() {

		this.setNome("Aluno sem nome");
		this.setCategoria("Aluno");

	}

	public Aluno(String nome, String categoria) {
		super(nome, categoria);
	}

	public Aluno(String nome, String categoria, float notaAvaliacao1, float notaAvaliacao2) {
		this(nome, categoria);
		this.notaAvaliacao1 = notaAvaliacao1;
		this.notaAvaliacao2 = notaAvaliacao2;
	}

	@Override
	public String toString() {

		return String.format("Nota 1: %.2f | Nota 2: %.2f | M�dia Final: %.2f | %s", notaAvaliacao1, notaAvaliacao2,
				mediaFinal, situacao);
	}

	private float calcularMediaFinal() {
		return (getNotaAvaliacao1() + getNotaAvaliacao2()) / 2;
	}

	private String verificarSituacao(float media) {

		if (media < 4) {
			return "Reprovado";
		} else if (media >= 4 && media < 7) {
			return "Prova Final";
		} else {
			return "Aprovado";
		}

	}

	public float getNotaAvaliacao1() {
		return notaAvaliacao1;
	}

	public void setNotaAvaliacao1(float notaAvaliacao1) {
		this.notaAvaliacao1 = notaAvaliacao1;
	}

	public float getNotaAvaliacao2() {
		return notaAvaliacao2;
	}

	public void setNotaAvaliacao2(float notaAvaliacao2) {
		this.notaAvaliacao2 = notaAvaliacao2;
	}

	public float getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal() {
		this.mediaFinal = calcularMediaFinal();
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao() {
		this.situacao = verificarSituacao(mediaFinal);
	}

}
