public class Contato{
  private String nome;
  private String email;
  private String telefone;
  private Data dataNascimento;

  public Contato(String nome, String email, String telefone, int dia, int mes,int ano){
    String dadoDefault = "Nao cadastrado";
    
    if(validateContact(nome, email, telefone)){
      this.nome = nome;
      this.email = email;
      this.telefone = telefone;
    }else{
      this.nome = dadoDefault;
      this.email = dadoDefault;
      this.telefone = dadoDefault;

    }

    this.dataNascimento = new Data(dia, mes, ano);
  }
  
  public void imprimirContato(){
    System.out.println("Nome: " + nome);
    System.out.println("Email: " + email);
    System.out.println("Telefone: " + telefone);
    System.out.print("Data de Nascimento: ");
    dataNascimento.imprimirData();
  }
  
  private boolean validateContact(String nome, String email, String telefone){
    return (validateName(nome) && validateEmail(email) && validatePhoneNumber(telefone));
  }

  private boolean validateEmail(String email){
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    return (email.matches(regex));
  }

  private boolean validateName(String nome){
    final int minNameSize = 3;    
    return (nome.length() > minNameSize);
  }

  private boolean validatePhoneNumber(String telefone){
    final int phoneNumberSize = 10;
    boolean isEqualToANumber = false;
    final char phone [] = telefone.toCharArray();
    final char numbersAsChar [] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};

    if(telefone.length() != 10)
      return false;
    
    for(int i = 0; i < phoneNumberSize; i++){
      for(int j = 0; j < numbersAsChar.length; j++){
        if(phone[i] == numbersAsChar[j]){
          isEqualToANumber = true;
          break;
        }
      }
      if (!isEqualToANumber)
        return false;
    }

    return true;
  }

  public int calcularIdade(){
    final int anoAtual = 2022;
    final int mesAtual = 10;
    
    int mesNascimento = dataNascimento.acharMes();
    int anoNascimento = dataNascimento.acharAno();
    int age = anoAtual - anoNascimento; 
    
    if(mesAtual < mesNascimento)
      age = age - 1;
    
    return age;
  }

  public String getNome(){
    return nome;
  }

  public String getEmail(){
    return email;
  }

  public String getTelefone(){
    return telefone;
  }

  public void setContato(String nome, String email, String telefone){
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
  }
  
  public void setDataNascimento(int dia, int mes, int ano){
    dataNascimento.setData(dia, mes, ano);
  }
}