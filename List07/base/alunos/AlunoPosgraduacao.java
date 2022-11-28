package List07.base.alunos;

import List06.base.statics.Data;

public class AlunoPosgraduacao extends AlunoGraduacao {
  final private static int mestradoRegular = 24;
  final private static int doutoradoRegular = 48;
  private String nomeOrientador;
  private String tituloProjeto;
  private Nivel nivel;

  public AlunoPosgraduacao(String nome, int matricula, Data admissao, int semestre, String curso,
                           String orientador, String projeto, char nivel) {
    super(nome, matricula, admissao, semestre, curso);

    if(validaNome(orientador))
      this.nomeOrientador = orientador;
    else
      this.nomeOrientador = "Nao informado";

    if(validaNome(projeto))
      this.tituloProjeto = projeto;
    else
      this.nomeOrientador = "Nao informado";

    this.nivel = getNivel(nivel);

  }

  public AlunoPosgraduacao(AlunoGraduacao aluno, String orientador, String projeto, char nivel){
    this(aluno.getNome(), aluno.getMatricula(), aluno.getDataDeAdmissao(), aluno.getSemestre(), aluno.getNomeCurso(), orientador, projeto, nivel);
  }

  private boolean validaNome(String nome){
    return nome != null;
  }

  private Nivel getNivel(char nivel){
    if(nivel == 'D')
      return Nivel.D;
    else
      return Nivel.M;
  }
  
  @Override
  protected boolean isRegular(){
    int months = super.calculateMonthsSinceAdmssion();

    if(this.nivel == Nivel.M)
      return months <= mestradoRegular;
    
    return months <= doutoradoRegular;
  }

  @Override
  public String toString(){
    return String.format("%sNivel: %s\nOrientador: %s\nProjeto: %s\n", super.toString(), this.nivel, this.nomeOrientador,this.tituloProjeto);
  }


  
}
