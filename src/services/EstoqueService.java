package services;

import exceptions.ProdutoJaCadastradoException;
import exceptions.ProdutoNaoEncontradoException;
import exceptions.ValorInvalidoException;
import interfaces.IProdutoService;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class EstoqueService implements IProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public void cadastrarProduto(Produto produto) {
        if (produto.getNome() == null && produto.getPreco()
                <= 0 && produto.getQuantidade() < 0) {
            throw new ValorInvalidoException(
                    "Esse produto não tem as informações" +
                            " necessárias para ser cadastrado"
            );
        }

        for (Produto p : produtos) {
            if (p.getId() == produto.getId() ||
                    p.getNome().equalsIgnoreCase(produto.getNome())) {
                throw new ProdutoJaCadastradoException(
                        "Produto já cadastrado: " + produto.getNome()
                );
            }
        }

        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    @Override
    public void atualizarProduto(int id, Produto produtoAtualizado) {
        Produto produtoParaAtualizar = null;

        for (Produto prod : produtos) {
            if (prod.getId() == produtoAtualizado.getId()) {
                produtoParaAtualizar = prod;
                break;
            }
        }

        if (produtoParaAtualizar == null) {
            throw new ProdutoNaoEncontradoException(
                    "Produto não encontrado com id: " + produtoAtualizado.getId()
            );
        }

        if (produtoAtualizado.getNome() == null || produtoAtualizado.getNome().isEmpty()
                || produtoAtualizado.getPreco() <= 0
                || produtoAtualizado.getQuantidade() < 0) {
            throw new ValorInvalidoException(
                    "Dados inválidos para atualizar o produto"
            );
        }

        produtoParaAtualizar.setNome(produtoAtualizado.getNome());
        produtoParaAtualizar.setPreco(produtoAtualizado.getPreco());
        produtoParaAtualizar.setQuantidade(produtoAtualizado.getQuantidade());

        System.out.println("Produto atualizado com sucesso!");
    }

    @Override
    public void removerProduto(int id) {
        Produto produtoParaRemover = null;

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtoParaRemover = produto;
                break;
            }
        }

        if (produtoParaRemover != null) {
            produtos.remove(produtoParaRemover);
            System.out.println("Produto removido com sucesso!");
        } else {
            throw new ProdutoNaoEncontradoException(
                    "O produto não foinencontrado!"
            );
        }
    }

    @Override
    public Produto consultarProduto(int id) {
        return null;
    }

    @Override
    public List<Produto> listarProdutos() {
        return List.of();
    }
}
