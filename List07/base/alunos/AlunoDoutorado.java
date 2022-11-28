package List07.base.alunos;

public class AlunoDoutorado extends AlunoGraduacao {
  
  final private static int doutoradoRegular = 48;
  private String nomeOrientador;
  private String tituloProjeto;


  public AlunoDoutorado(AlunoGraduacao aluno, String orientador, String projeto) {
    super(aluno.getNome(), aluno.getMatricula(), aluno.getDataDeAdmissao(), aluno.getSemestre(), aluno.getNomeCurso());
    
    if(validaNome(orientador))
      this.nomeOrientador = orientador;
    else
      this.nomeOrientador = "Nao informado";

      if(validaNome(projeto))
      this.tituloProjeto = projeto;
    else
      this.tituloProjeto = "Nao informado";

  }

  private boolean validaNome(String nome){
    return nome != null;
  }

  @Override
  protected boolean isRegular(){
    int monthsSinceAdmission = super.calculateMonthsSinceAdmssion();

    return monthsSinceAdmission <= doutoradoRegular;
  }

  @Override
  public String toString(){
    return String.format("%sNivel: Doutorado\nOrientador: %s\nProjeto: %s\n", super.toString(), this.nomeOrientador, this.tituloProjeto);
  }
  
  
}
