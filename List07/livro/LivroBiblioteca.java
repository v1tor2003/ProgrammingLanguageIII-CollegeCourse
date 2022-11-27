package List07.livro;

import List06.statics.Data;

public class LivroBiblioteca extends Livro{
  private boolean emprestado;
  private Data dataDevolucao;

  public LivroBiblioteca(String titulo, String autor, int paginas, int dia, int mes, int ano){
    super(titulo, autor, paginas, dia, mes, ano);
    this.dataDevolucao = new Data();
    this.emprestado = false;
  }

  public LivroBiblioteca(String titulo, String autor){
    this(titulo, autor, 1, 0, 0, 0);
  }

  public LivroBiblioteca(String titulo, String autor, int paginas){
    this(titulo, autor, paginas, 0, 0, 0);
  }

  public LivroBiblioteca(String titulo, String autor, Data publicacao){
    this(titulo, autor, 1, publicacao.getDia(), publicacao.getMes(), publicacao.getAno());
  }

  public void setDevolucao(Data other){
    if(other.isPrevious(Data.getCurrentData()) || other.isEquals(Data.getCurrentData())){
      final int dec = 12;
      Data novaDevolucao = Data.getCurrentData();
 
      int mesDevolucao = novaDevolucao.getMes() + 1;
      int anoDevolucao = novaDevolucao.getAno();
      int diaDevolucao = novaDevolucao.getDia();

      if(mesDevolucao > dec){
        mesDevolucao = 1;
        anoDevolucao += 1;
      }

      dataDevolucao.setData(diaDevolucao, mesDevolucao, anoDevolucao);
      return;
    }

    dataDevolucao.setData(other.getDia(), other.getMes(), other.getAno());
  }

  public void setDevolucao(int dia, int mes, int ano){
    dataDevolucao.setData(dia, mes, ano);
  }

  public void setEmprestimo(boolean newState, Data dataDevolucao){
    this.emprestado = newState;
    if(emprestado)
      setDevolucao(dataDevolucao);
  }

  public void setEmprestimo(boolean newState){
    this.emprestado = newState; 
  }

  public boolean getEmprestado(){
    return this.emprestado;
  }

  public boolean isOlder(LivroBiblioteca other){
    return super.isOlder((Livro) other);
  }

  @Override
  public String toString(){
    String str = super.toString();
    if (emprestado)
      return str += String.format("\nStatus: emprestado, devolucao prevista para: %s\n", this.dataDevolucao);
    else
      return str += String.format("\nStatus: disponivel\n");
  }

  public boolean isAvaliable() {

    return !this.emprestado;
  }

  public void borrow(Data devolucao) {
    if(isAvaliable())
      setEmprestimo(true, dataDevolucao);
    else
      System.out.println("Livro indisponivel para emprestimo.");
  }
  
  public void returnBook(){
    if(!isAvaliable())
      setEmprestimo(false);
    else
      System.out.println("Voce nao pode devolver um livro que nao foi emprestado.");  
  }
}
