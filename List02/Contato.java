class Contato{
  String nome;
  String email;
  String telefone;
  Data dataNascimento = new Data();

  void inicializarContato(){
    String dadoDefault = "Nao cadastrado";
    setContato(dadoDefault, dadoDefault, dadoDefault);
    dataNascimento.inicializarData();
  }
  
  void imprimirContato(){
    System.out.println("Nome: " + nome);
    System.out.println("Email: " + email);
    System.out.println("Telefone: " + telefone);
    System.out.print("Data de Nascimento: ");
    dataNascimento.imprimirData();
  }
  
  int calcularIdade(){
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