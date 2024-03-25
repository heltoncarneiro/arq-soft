package br.edu.ifpe.ads.arqsoft.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.ProdutoRepository;
import br.edu.ifpe.ads.arqsoft.repository.infra.DatabaseFactory;

/**
 * Servlet implementation class ProdutoController
 */
@WebServlet("/produto")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Produto> produtos = new ArrayList<>();
    private ProdutoRepository produRepo = new ProdutoRepository(DatabaseFactory.getPostgreDBConection());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		var acao = request.getParameter("acao");
		if(acao.equalsIgnoreCase("listar")) {
			//produRepo.listarTodos();
			request.getRequestDispatcher("views/produto/lista_produtos.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var nome = request.getParameter("nome");
		var preco = request.getParameter("preco");
		var produto = new Produto(nome,Double.valueOf(preco));
		produto.setDescricao(request.getParameter("descricao"));
		produtos.add(produto);
		produRepo.salvar(produto);
	}

}
