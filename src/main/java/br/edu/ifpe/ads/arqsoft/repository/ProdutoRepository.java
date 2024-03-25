package br.edu.ifpe.ads.arqsoft.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.infra.Database;

public class ProdutoRepository {
	private Database database;
	private String sqlInsert = "insert into produto(nome,descricao,preco,id_categoria) values (?,?,?,?)";
	private String sqlSelect = "SELECT id,nome,descricao,preco,id_categoria FROM produto";
	public ProdutoRepository(Database database) {
		this.database = database;
	}
	
	public void salvar(Produto produto) {
		Connection conexao = this.database.connect();
		try {
			PreparedStatement pstm = conexao.prepareStatement(sqlInsert);
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getPreco());
			pstm.setLong(4, 1);
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			database.close(conexao);
		}
		
		
	}
	public List<Produto> listarTodos() {
		Connection conexao = this.database.connect();
		
		List<Produto> produtos = new ArrayList<>();
		PreparedStatement pstm;
		
		try {
			pstm = conexao.prepareStatement(sqlSelect);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				System.out.println("Result: " + rs.getString("nome"));
				var produto = new Produto(rs.getString("nome"), rs.getDouble("preco"));
				produto.setDescricao(rs.getString("descricao"));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			database.close(conexao);
		}
		
		return null;
	}
//	
//	public Produto atualizar(Produto produto) {
//		
//	}
//	
//	public void remover(int id) {
//		
//	}
//	
//	public Produtor pegarProdutoPorId(int id)
}
