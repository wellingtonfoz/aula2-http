package app.entity;

public class Carro {
	
	private long id;
	private String nome;
	private String cor;
	
	
	
	
	public Carro(long id, String nome, String cor) {
		this.id = id;
		this.nome = nome;
		this.cor = cor;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	

}
