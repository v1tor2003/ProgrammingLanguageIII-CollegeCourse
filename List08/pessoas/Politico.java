package List08.pessoas;

public class Politico extends Pessoa{
  private String sigla;
  private short partidoNumber;

  public Politico(String name, long id, int dia, int mes, int ano, String sigla, short partidoNumber){
    super(name, id, dia, mes, ano);
    if(validatePolitico(sigla, partidoNumber)){
      this.sigla = sigla;
      this.partidoNumber = partidoNumber;
    }else{
      this.sigla = "--";
      this.partidoNumber = 0;
    }
  }

  private boolean validatePolitico(String sigla, short partidoNumber){
    return validateName(name) && validatePartidoNumber(partidoNumber);  
  }

  public String getSigla(){
    return this.sigla;
  }

  public short getPartidoNumber(){
    return this.partidoNumber;
  }

  public boolean validatePartidoNumber(short partido){
    return partido > 0;
  }

  @Override
  protected boolean validateName(String name){
    return name.length() <= 5;
  }

  @Override
  public String toString(){
    return String.format("%sPartido: %s\nNumero: %d\n", super.toString(), this.getSigla(), this.getPartidoNumber());
  }
}