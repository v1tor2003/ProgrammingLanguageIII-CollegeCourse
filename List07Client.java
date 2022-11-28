import List06.base.statics.Data;
import List07.base.Aluno;
import List07.base.alunos.AlunoDoutorado;
import List07.base.alunos.AlunoGraduacao;
import List07.base.alunos.AlunoMestrado;
import List07.base.alunos.AlunoPosgraduacao;
import List07.base.figuras.Cilindro;
import List07.base.figuras.Cone;
import List07.base.livro.Livro;
import List07.base.livro.LivroBiblioteca;
import List07.base.livro.LivroLivraria;
import List07.base.pontos.Ponto2D;
import List07.base.pontos.Ponto3DAgre;
import List07.base.pontos.Ponto3DComp;
import List07.base.pontos.Ponto3DHeranca;

public class List07Client {
  public static void main(String[]args) {
    Ponto2D p1 = new Ponto2D(1, 2);
    Ponto3DHeranca pointDist = new Ponto3DHeranca(2, 3, 1);

    Ponto3DHeranca p3DHeranca = new Ponto3DHeranca(1, 2, 0); 
    Ponto3DComp p3DComp = new Ponto3DComp(1, 2, 0);
    Ponto3DAgre p3DAgre = new Ponto3DAgre(p1, 0);

    System.out.println("Testing Ponto2D:");
    System.out.println(p1);
    System.out.println("isAxisX? "+ p1.isAxisX());
    System.out.println("isAxisY? "+ p1.isAxisY());
    System.out.println("isAxis? "+ p1.isAxis());
    System.out.println("isOrigin? "+ p1.isOrigin());
    System.out.println("Distancia: " + p1.distance(2, 3));

    System.out.println("\nTesting Ponto3D Heranca:");
    System.out.println(p3DHeranca);
    System.out.println("isAxisX? "+ p3DHeranca.isAxisX());
    System.out.println("isAxisY? "+ p3DHeranca.isAxisY());
    System.out.println("isAxisZ? "+ p3DHeranca.isAxisZ());
    System.out.println("isAxis? "+ p3DHeranca.isAxis());
    System.out.println("isOrigin? "+ p3DHeranca.isOrigin());
    System.out.println("Distancia: " + p3DHeranca.distance(pointDist.getX(), pointDist.getY(), pointDist.getY()));

    System.out.println("\nTesting Ponto3D Composition:");
    System.out.println(p3DComp);
    System.out.println("isAxisX? "+ p3DComp.isAxisX());
    System.out.println("isAxisY? "+ p3DComp.isAxisY());
    System.out.println("isAxisZ? "+ p3DComp.isAxisZ());
    System.out.println("isAxis? "+ p3DComp.isAxis());
    System.out.println("isOrigin? "+ p3DComp.isOrigin());
    System.out.println("Distancia: " + p3DComp.distance(pointDist.getX(), pointDist.getY(), pointDist.getY()));

    System.out.println("\nTesting Ponto3D Agregation:");
    System.out.println(p3DAgre);
    System.out.println("isAxisX? "+ p3DAgre.isAxisX());
    System.out.println("isAxisY? "+ p3DAgre.isAxisY());
    System.out.println("isAxisZ? "+ p3DAgre.isAxisZ());
    System.out.println("isAxis? "+ p3DAgre.isAxis());
    System.out.println("isOrigin? "+ p3DAgre.isOrigin());
    System.out.println("Distancia: " + p3DAgre.distance(pointDist.getX(), pointDist.getY(), pointDist.getY()));

    Livro book = new Livro("Dracula", "Alguem");
    Livro book1 = new Livro("Romeu e Julieta", "Outro Alguem", 10, 10, 3, 1971);
    LivroBiblioteca livroBiblioteca = new LivroBiblioteca("Harry Potter", "Alguem Rolling");
    LivroLivraria livroLivraria = new LivroLivraria("Menino do Espelho", "Alguem 3");
    LivroLivraria l2 = new LivroLivraria("2", "null");


    System.out.println("\nTesting Base Livro:");
    System.out.println("\n" + book);
    System.out.println("\n" + book1);
    System.out.println("isOlder: "+ book.isOlder(book1));

    System.out.println("\nTesting Livro Biblioteca:");
    System.out.println(livroBiblioteca);
    livroBiblioteca.setEmprestimo(true, Data.getCurrentData());
    System.out.println(livroBiblioteca);
    System.out.println("Devolvendo livro...");
    livroBiblioteca.returnBook();
    System.out.println(livroBiblioteca);

    System.out.println("Testing Livro Livraria:");
    System.out.println(livroLivraria);
    System.out.println("\n"+ l2);

    livroLivraria.sell();
    System.out.println("\n"+livroLivraria);
    System.out.printf("Estoque: %d\nTotal Arrecadado: %.2f\nLivros Vendidos: %s\n", LivroLivraria.getEstoque(), 
                              LivroLivraria.getTotalArrecadado(), LivroLivraria.getTotalDeLivrosVendidos());
    
    Cilindro cilindro = new Cilindro(1, 2, 3, 2);                              
    Cone cone = new Cone(1, 2, 3, 2);

    System.out.println("\nTesting Cilindro:");
    System.out.println(cilindro);
    System.out.println("Area: " + cilindro.area());
    System.out.println("Volume: " + cilindro.volume());

    System.out.println("\nTesting Cone:");
    System.out.println(cone);
    System.out.println("Area: " + cone.area());
    System.out.println("Volume: " + cone.volume());

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
