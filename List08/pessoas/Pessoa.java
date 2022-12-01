package List08.pessoas;
import List06.base.statics.Data;

public class Pessoa {
  final private static float minValue = 1000;
  protected String name;
  private long id;
  private Data dataNascimento;

  public Pessoa(String name, long id, int dia, int mes, int ano){
    if(validatePerson(name, id)){
      this.name = name;
      this.id = id;
    }else
      this.name = "";
    
    this.dataNascimento = new Data(dia, mes, ano);
  }

  public Pessoa(String name, long id, Data existingData){
    this(name, id, existingData.getDia(), existingData.getMes(), existingData.getAno());
  }

  public float calculateEmprestimo(){
    return minValue;
  }

  private boolean validatePerson(String name, long id){
    return validateName(name) && validateId(id);
  }

  protected boolean validateName(String name){
    return name != null;
  }

  protected boolean validateId(long id){
    return id > 0;
  }

  public String getName(){
    return this.name;
  }

  public long getId(){
    return this.id;
  }

  public float getMinValue(){
    return minValue;
  }

  public Data getDataNascimento(){
    return this.dataNascimento;
  }
  
  public String toString(){
    return String.format("Nome: %s\nId: %d\nData de Nascimento: %s\nEmprestimo Disponivel: %.2f\n", this.getName(), this.getId(), this.getDataNascimento(), this.calculateEmprestimo());
  }
}
