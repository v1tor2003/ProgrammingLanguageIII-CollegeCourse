package List08.programa_agenda;
import List06.base.statics.Data;

public class PessoaJuridica extends PessoaBase{
  final private static int fullCnpjSize = 18;
  final private static int minCnpjSize = 14;
  private String CNPJ;

  public PessoaJuridica(String name, String address, String phoneNumber, String email, int dia, int mes, int ano, String cnpj) {
    super(name, address, phoneNumber, email, dia, mes, ano);
    if(validatecnpj(cnpj))
      this.CNPJ = cnpj;
    else 
      this.CNPJ = new String("Invalido");
  }

  public PessoaJuridica(String name, String address, String phoneNumber, String email, Data birthDate, String cnpj){
    this(name, address, phoneNumber, email, birthDate.getDia(), birthDate.getMes(), birthDate.getAno(), cnpj);
  }

  private boolean validatecnpj(String cnpj){
    return cnpj.length() == fullCnpjSize || cnpj.length() == minCnpjSize;
  }

  public String getcnpj(){
    return this.CNPJ;
  }

  public void setcnpj(String cnpj){
    if(validatecnpj(cnpj))
      this.CNPJ = cnpj;
    else
      System.out.println("CNPJ invalido, por favor tente novamente");
  }

  @Override
  public String toString(){
    return String.format("%sCNPJ: %s\n", super.toString(), this.getcnpj());
  }

  @Override
  public int compareTo(PessoaBase o){
    PessoaJuridica obj = (PessoaJuridica) o;
    if(this.CNPJ.length() == obj.CNPJ.length() && checkFullString(obj.CNPJ))
      return 0;
    else if(this.CNPJ.length() < obj.CNPJ.length())
      return -1;
    else 
      return 1;
  }

  public boolean checkFullString(String cnpj){
    final char [] objCnpj = this.CNPJ.toCharArray();
    final char [] otherCnpj = cnpj.toCharArray();

    for(int i = 0; i < this.CNPJ.length(); i++)
      if (objCnpj[i] != otherCnpj[i])
        return false;

    return true;
  }
  
}

