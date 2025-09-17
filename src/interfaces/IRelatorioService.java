package interfaces;

import model.Produto;

import java.util.List;
import java.util.Map;

public interface IRelatorioService {

    List<Produto> listarProdutosEmFalta();

    int quantidadeTotalEstoque();

    Map<String, List<Produto>> gerarRelatorioPorCategoria();
}
