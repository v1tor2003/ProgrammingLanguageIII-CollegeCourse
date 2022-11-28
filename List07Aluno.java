import List06.base.statics.Data;
import List07.base.Aluno;
import List07.base.alunos.AlunoGraduacao;
import List07.base.alunos.AlunoPosgraduacao;
public class List07Aluno {
  public static void main(String[] args) {
    Data data = new Data(16, 8, 2019);
    Aluno aluno = new Aluno("Vitor Pires", 202121120, data);
    AlunoGraduacao alunoGraduacao = new AlunoGraduacao(aluno, 3, "computacao");
    AlunoPosgraduacao alunoPosgraduacao = new AlunoPosgraduacao(alunoGraduacao, "Professor X", "Projeto Y", 'M');

    System.out.println(aluno);
    System.out.println(alunoGraduacao);
    System.out.println(alunoPosgraduacao);
  }
}
