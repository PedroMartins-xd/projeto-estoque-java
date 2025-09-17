package model;

import interfaces.IProdutoService;

public abstract class Produto implements IProdutoService {

    protected int produto;
    protected String nome;
    protected Categoria categoria;
    protected double preco;
    protected int quantidade;

}
