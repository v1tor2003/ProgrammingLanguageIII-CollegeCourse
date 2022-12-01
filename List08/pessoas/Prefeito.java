package List08.pessoas;

public class Prefeito extends Politico{
  private String cidade;

  public Prefeito(String name, long id, int dia, int mes, int ano, String sigla, short partidoNumber, String cidade){
    super(name, id, dia, mes, ano, sigla, partidoNumber);
    if(validateCity(cidade))
      this.cidade = cidade;
    else
      this.cidade = "Nao informada";
  }

  public String getCidade() {
    return this.cidade;  
  } 

  private boolean validateCity(String cidade){
    return cidade != null;
  }
  
  @Override
  public String toString(){
    return String.format("%sCidade: %s\n", super.toString(), this.getCidade());
  }

}
