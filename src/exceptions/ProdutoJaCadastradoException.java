package exceptions;

public class ProdutoJaCadastradoException extends RuntimeException {
  public ProdutoJaCadastradoException(String message) {
    super(message);
  }
}
