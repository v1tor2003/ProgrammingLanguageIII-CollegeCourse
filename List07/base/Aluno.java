package List07.base;

import List06.base.statics.Data;

public class Aluno {
  private String nome;
  private Integer matricula;
  private Data dataAdmissao;  
  

  public Aluno(String nome, int matricula, int dia, int mes, int ano){
    if(validaAluno(nome, matricula)){
      this.nome = nome;
      this.matricula = matricula;
      this.dataAdmissao = new Data(dia, mes, ano);
    }
  }

  public Aluno(String nome, int matricula, Data admissao){
    this(nome, matricula, admissao.getDia(), admissao.getMes(), admissao.getAno());
  }

  public String toString(){
    return String.format("Nome: %s\nMatricula: %d\nData de Admissao: %s\n", 
                          this.nome, this.matricula, this.dataAdmissao);
  }

  private boolean validaAluno(String nome, int matricula){
    return validaNome(nome) && validaMatricula(matricula);
  }

  private boolean validaNome(String nome){
    return nome != null;
  }

  private boolean validaMatricula(int matricula){
    return matricula >= 0;
  } 

  public String getNome(){
    return this.nome;
  }

  public Integer getMatricula(){
    return this.matricula;
  }

  public Data getDataDeAdmissao(){
    return this.dataAdmissao;
  }
}