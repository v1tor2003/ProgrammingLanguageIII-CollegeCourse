import List08.pessoas.*;
import List08.shapes.*;
import List08.programa_agenda.*;

public class List08Client {
  public static void main(String[] args) {
    Shape2D [] arr = new Shape2D[4];
    arr[0] = new Square(2);
    arr[1] = new Rectangle(2, 4);
    arr[2] = new Circle(3);
    arr[3] = new Triangle(2, 2, 3);

    for(Shape2D shape : arr){
      System.out.print(shape);
      System.out.println("area: " + shape.calculateArea());
      System.out.println("perimeter: " + shape.calculatePerimeter());
    }

    Pessoa pessoa = new Pessoa("Vitor", 123456, 29, 9, 2003);
    Funcionario funcionario = new Funcionario("Vitor", 123456, 29, 9, 2003, 1200, 30, 11, 2022);
    ChefeDeDepartamento chefe = new ChefeDeDepartamento("Vitor", 12345, 29, 9, 2003, 5000, 30, 11, 2022, "testes", 10, 1, 2023);

    System.out.println("\n" + pessoa);
    System.out.println("\n" + funcionario);
    System.out.println("\n" + chefe);
    
    short number = 1;
    Politico politico = new Politico("Vitor", 123456, 29,9, 2003, "VP", number);
    Prefeito prefeito = new Prefeito("Vtior", 123456, 29, 9, 2003, "VP", number, "vitorlandia");
    Governador gov = new Governador("Vtior", 123456, 29, 9, 2003, "VP", number, "meuestado");
    System.out.println(politico);
    System.out.println(prefeito);
    System.out.println(gov);

    PessoaBase pessoaBase = new PessoaBase("Vitor", "Ilheus, 50", "7398545529",
                                           "vitor.pr@teste.com", 29, 9, 2003);
    PessoaFisica pessoaFisica = new PessoaFisica("Vitor","Ilheus, 50", "7398545529",
                                           "vitor.pr@teste.com", 29, 9, 2003, "11207552550" );
    PessoaJuridica pessoaJuridica = new PessoaJuridica("Vitor","Ilheus, 50", "7398545529",
                                           "vitor.pr@teste.com", 29, 9, 2003, "11.222.333/0001-00" );
    PessoaJuridica pessoaJuridica1 = new PessoaJuridica("teste","Ilheus, 50", "1122334455",
                                           "teste.pr@teste.com", 29, 9, 2003, "11.222.333/0001-00" );
    //System.out.println(pessoaBase);
    //System.out.println(pessoaFisica);
    //System.out.println(pessoaJuridica);
    Agenda myAgenda = new Agenda();
    myAgenda.add(pessoaBase);
    myAgenda.add(pessoaFisica);
    myAgenda.show();
    System.out.println("Contato achado"+ myAgenda.search("1120755250"));
  }
}
