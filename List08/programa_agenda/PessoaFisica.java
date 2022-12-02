package List08.programa_agenda;
import List06.base.statics.Data;

public class PessoaFisica extends PessoaBase{
  final private static int fullCpfSize = 14;
  final private static int minCpfSize = 11;
  private String CPF;

  public PessoaFisica(String name, String address, String phoneNumber, String email, int dia, int mes, int ano, String cpf) {
    super(name, address, phoneNumber, email, dia, mes, ano);
    if(validateCPF(cpf))
      this.CPF = cpf;
    else 
      this.CPF = new String("Invalido");
  }

  public PessoaFisica(String name, String address, String phoneNumber, String email, Data birthDate, String cpf){
    this(name, address, phoneNumber, email, birthDate.getDia(), birthDate.getMes(), birthDate.getAno(), cpf);
  }

  private boolean validateCPF(String cpf){
    return cpf.length() == fullCpfSize || cpf.length() == minCpfSize;
  }

  public String getCPF(){
    return this.CPF;
  }

  public void setCPF(String cpf){
    if(validateCPF(cpf))
      this.CPF = cpf;
    else
      System.out.println("CPF invalido, por favor tente novamente");
  }

  @Override
  public String toString(){
    return String.format("%sCPF: %s\n", super.toString(), this.getCPF());
  }
  
  private int compareLocal(String otherInfo) {
    // TODO Auto-generated method stub
    if(this.CPF.compareTo(otherInfo) > 0){
      return 1;
    }
    else if (this.CPF.compareTo(otherInfo) < 0){
      return -1;
    }
    
    return 0;
  }
  
  @Override
  public int compareTo(PessoaBase obj) {
    // TODO Auto-generated method stub
    if(obj instanceof PessoaJuridica)
      return -1;
    PessoaFisica newObj = (PessoaFisica) obj;
    String ref = newObj.CPF;
    return compareLocal(ref);
  }
  
}
