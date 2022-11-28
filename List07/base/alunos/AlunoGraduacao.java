package List07.base.alunos;

import List07.base.Aluno;
import List06.base.statics.Data;


public class AlunoGraduacao extends Aluno{
  final private static float mensalidadeBase = 700;
  final private static float alunoIrregularTaxa = 0.2f;
  final private static int tamanhoSemestre = 6;
  private int semestre;
  private TipoCursos curso;
 
  
  public AlunoGraduacao(String nome, int matricula, Data admissao, int semestre, String curso) {
    super(nome, matricula, admissao);
    
    if(validaSemestre(semestre))
      this.semestre = semestre;
    else 
      this.semestre = 1;
    
    this.curso = getTipoDoCurso(curso);
  }

  public AlunoGraduacao(Aluno aluno, int semestre, String curso ){
    this(aluno.getNome(), aluno.getMatricula(), aluno.getDataDeAdmissao(), semestre, curso);
  }

  private boolean validaSemestre(int semestre){
    return semestre >= 1 && semestre <= 10;
  }

  private TipoCursos getTipoDoCurso(String curso){
    TipoCursos arr [] = TipoCursos.values();
    
    curso.toLowerCase();
    
    for(int i = 0; i < arr.length; i++){
      if(arr[i].courseType.equals(curso))
        return arr[i];
    }

    return arr[0];
  }

  public String getNomeCurso(){
    if (this.curso == TipoCursos.NAO_INFORMADO)
      return "Curso nao informado";
    else
      return this.curso.courseType;
  }

  private float regularStudentPayment(){
    return mensalidadeBase + mensalidadeBase * this.curso.courseTax;
  }

  private float nonRegularStudent(){
    return regularStudentPayment() + regularStudentPayment() * alunoIrregularTaxa;
  }

  protected boolean isRegular(){    
    int monthsSinceAdmission = calculateMonthsSinceAdmssion();
    
    return semestersSinceAdmission(monthsSinceAdmission) == this.semestre;
  }

  protected int calculateMonthsSinceAdmssion(){
    Data currentData = Data.getCurrentData();
    int diffInDays = Math.abs(currentData.howManyDays(super.getDataDeAdmissao()));

    return daysToMonth(diffInDays);
  }

  protected int semestersSinceAdmission(int monthsSinceAdmission){
  
    return (int) Math.round(((double) monthsSinceAdmission / tamanhoSemestre) + 0.5d);
  }

  public int getSemestre(){
    return this.semestre;
  }

  private int daysToMonth(int days){
    return days / Data.getDefaultMonthDuration();
  }

  public float getMensalidadeAluno(){
    if(isRegular())
      return regularStudentPayment();
    else 
      return nonRegularStudent();
  }

  @Override
  public String toString(){
    return String.format("%sSemestre: %d\nMensalidade: %.2f\nCurso:%s\n", super.toString(), this.getSemestre(), this.getMensalidadeAluno(), this.getNomeCurso());
  }


}
