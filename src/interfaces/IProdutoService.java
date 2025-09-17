package interfaces;

import model.Produto;

import java.util.List;

public interface IProdutoService {

    void cadastrarProduto(Produto produto);

    void atualizarProduto(int id, Produto produtoAtualizado);

    void removerProduto(int id);

    Produto consultarProduto(int id);

    List<Produto> listarProdutos();
}
