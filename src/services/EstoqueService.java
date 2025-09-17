package services;

import interfaces.IProdutoService;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Estoque implements IProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    @Override
    public void atualizarProduto(int id, Produto produto) {

    }

    @Override
    public void removerProduto(int id) {

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
