package br.edu.ifpe.ads.arqsoft.domain.entity;

import java.util.Objects;

public class Categoria {

	private String nome;
	private String descricao;
	private long id;
	
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}


	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}



	public String getDescricao() {
		return descricao;
	}



	@Override
	public int hashCode() {
		return Objects.hash(descricao, nome);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(nome, other.nome);
	}
	
	
	
	
}
