package List07.livro;

import List06.statics.Data;

public class Livro {
  private String titulo;
  private String autor;
  private Integer nroPaginas;
  private Data anoPublicacao;

  public Livro(String titulo, String autor, int paginas, int dia, int mes, int ano){
    if(validateBook(titulo, autor)){
      this.titulo = titulo;
      this.autor = autor;

      if(validatePages(paginas))
        this.nroPaginas = paginas;
      else
        this.nroPaginas = 1;

      this.anoPublicacao = new Data(dia, mes , ano);
    }else 
      System.out.println("Livro nao criado, informacoes insuficientes");   
  }

  public Livro(String titulo, String autor, int paginas){
    this(titulo, autor, paginas, 0, 0, 0);
  }

  public Livro(String titulo, String autor, Data data){
    this(titulo, autor, 1, data.getDia(), data.getMes(), data.getAno());
  }

  public Livro(String titulo, String autor){
    this(titulo, autor, 1);
  }

  private boolean validateBook(String titulo, String autor){
    return (titulo != null) && (autor != null);
  }

  private boolean validatePages(int pages){
    return pages > 0;
  }

  public boolean isOlder(Livro otherBook){
    return this.anoPublicacao.isPrevious(otherBook.anoPublicacao);
  }

  public String toString(){
    return String.format("Titulo: %s\nAutor: %s\nPaginas: %s\nPublicacao: %s",
                          this.titulo, this.autor, this.nroPaginas, this.anoPublicacao);
  }

  public Data getPublicacao(){
    return anoPublicacao;
  }
}
