package interfaces;

public interface IEstoqueService {

    void entradaProduto(int id, int quantidade);

    void saidaProduto(int id, int quantidade);

    boolean verificarDisponibilidade(int id);
}
