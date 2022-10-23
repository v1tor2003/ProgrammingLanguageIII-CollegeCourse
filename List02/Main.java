public class Main {
  public static void main (String[] agrs){
    Data myDate = new Data();
    Contato myContact = new Contato();
    Contato myNewContact = new Contato();
    Lampada myLamp = new Lampada();
    
    myContact.inicializarContato();
    myNewContact.inicializarContato();
    
    myContact.setContato("Vitor Pires", "vitor@teste", "7398845529");
    myContact.setDataNascimento(29, 9, 2003);
    int age = myContact.calcularIdade();
    myContact.imprimirContato();
    System.out.println("Idade: " + age);
    
    myNewContact.setContato("Exemplo Dois", "exemplo@teste", "000000000");
    myNewContact.setDataNascimento(2, 11, 2000);
    age = myNewContact.calcularIdade();
    myNewContact.imprimirContato();
    System.out.println("Idade: " + age);
    
    myLamp.acende();
    myLamp.mostraEstado();
    myLamp.apaga();
    myLamp.mostraEstado();
  }
}
