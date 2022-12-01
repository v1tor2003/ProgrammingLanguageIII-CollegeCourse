package List08.pessoas;

public class Governador extends Politico{
  private String estado;

  public Governador(String name, long id, int dia, int mes, int ano, String sigla, short partidoNumber, String estado){
    super(name, id, dia, mes, ano, sigla, partidoNumber);
    if(validateEstado(estado))
      this.estado = estado;
    else
      this.estado = "Nao informada";
  }

  public String getEstado() {
    return this.estado;  
  } 

  private boolean validateEstado(String estado){
    return estado != null;
  }
  
  @Override
  public String toString(){
    return String.format("%sEstado: %s\n", super.toString(), this.getEstado());
  }
}