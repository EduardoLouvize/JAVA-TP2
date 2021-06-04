package dominio;

public abstract class Pessoa {

	private int id;
	private String nome;
	private String categoria;
	
	public Pessoa ( ) {
		this.nome = "Sem Nome";
	}

	public Pessoa(String nome, String categoria) {
		this.nome = nome;
		this.categoria = categoria;
	}
	
	@Override
	public abstract String toString();
	
	public void imprimir() {
		System.out.printf(" [%d] %s | %s | (%s)\n",
				id,
				this.getNome(),
				this.toString(),
				this.getCategoria());
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
