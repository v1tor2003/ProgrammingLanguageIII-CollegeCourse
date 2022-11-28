import List06.base.statics.Data;
import List07.base.Aluno;
import List07.base.alunos.AlunoDoutorado;
import List07.base.alunos.AlunoGraduacao;
import List07.base.alunos.AlunoMestrado;
import List07.base.alunos.AlunoPosgraduacao;
public class List07Aluno {
  public static void main(String[] args) {
    Data data = new Data(16, 8, 2019);
    Aluno aluno = new Aluno("Vitor Pires", 202121120, data);
    AlunoGraduacao alunoGraduacao = new AlunoGraduacao(aluno, 3, "computacao");
    AlunoPosgraduacao alunoPosgraduacao = new AlunoPosgraduacao(alunoGraduacao, "Professor X", "Projeto Y", 'M');
    AlunoMestrado alunoMestrado = new AlunoMestrado(alunoGraduacao, "Professor Z", "Projeto Mestrado");
    AlunoDoutorado alunoDoutorado = new AlunoDoutorado(alunoGraduacao, "Professor W", "Projeto Doutorado");
    
    System.out.println("Testing Aluno/Aluno Posgraducao\n");
    System.out.println(aluno);
    System.out.println(alunoGraduacao);
    System.out.println(alunoPosgraduacao);

    System.out.println("Testing Mestrado/Doutorado Herenca de Graduacao\n");
    System.out.println(alunoMestrado);
    System.out.println(alunoDoutorado);

  }
}
