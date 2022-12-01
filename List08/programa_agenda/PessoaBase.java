package List08.programa_agenda;
import List06.base.statics.Data;

public class PessoaBase implements Comparable<PessoaBase>{
  private String name;
  private String address;  
  private String phoneNumber;
  private String email;
  private Data birthDay;

  public PessoaBase(String name, String address, String phoneNumber, String email, int dia, int mes, int ano){
    if(validatePerson(name, email, email)){
      this.name = name;
      this.email = email;
      this.phoneNumber = phoneNumber;
    }else{
      this.name = null;
      this.email = null;
      this.phoneNumber = null;
    }

    if(validateAdrres(address))
      this.address = address;
    else
      this.address = new String ("Nao informado");

    this.birthDay = new Data (dia, mes, ano);
  }

  
  public PessoaBase(String name, String address, String phoneNumber, String email, Data birthDate){
    this(name, address, phoneNumber, email, birthDate.getDia(), birthDate.getMes(), birthDate.getAno());
  }

  private boolean validatePerson(String name, String email, String telefone){
    return validateName(name) && (validateEmail(email) || validatePhoneNumber(telefone));
  }

  private boolean validateName(String name){
    return name != null;
  }

  private boolean validateEmail(String email){
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    if(email == null)
      return false;

    return (email.matches(regex));
  }

  private boolean validateAdrres(String address){
    return validateName(address);
  }

  private boolean validatePhoneNumber(String phoneNumber){
    final int phoneNumberSize = 10;
    
    if(phoneNumber == null || phoneNumber.length() != 10 )
      return false;
    
    boolean isEqualToANumber = false;
    final char phoneAsCharArray [] = phoneNumber.toCharArray();
    final char numbersAsChar [] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};

    
    for(int i = 0; i < phoneNumberSize; i++){
      for(int j = 0; j < numbersAsChar.length; j++){
        if(phoneAsCharArray[i] == numbersAsChar[j]){
          isEqualToANumber = true;
          break;
        }
      }
      if (!isEqualToANumber)
        return false;
    }

    return true;
  }

  public String getName(){
    return this.name;
  }

  public String getEmail(){
    return this.email;
  }

  public String getPhone(){
    return this.phoneNumber;
  }

  public String getAddress(){
    return this.address;
  }

  public void setAdress(String address){
    if(validateAdrres(address))
      this.address = address;
    else
      System.out.println("Endereco invalido, por favor tente novamente.");
  }

  private String formatBirthDate(){
    String day = formatIndividualDateInfo(this.birthDay.getDia());
    String month = formatIndividualDateInfo(this.birthDay.getMes());

    return String.format("%s/%s", day, month);
  }

  private String formatIndividualDateInfo(int info){
    if(info < 10)
      return "0" + Integer.toString(info);
    else
      return Integer.toString(info);
  }

  @Override
  public String toString(){
    return String.format("Nome: %s\nEndereco: %s\nEmail: %s\nTelefone: %s\nAniversario: %s\n", 
                          this.getName(), this.getAddress(), this.getEmail(), this.getPhone(), formatBirthDate());
  }


  @Override
  public int compareTo(PessoaBase obj) {
    // TODO Auto-generated method stub
    return 0;
  }
}
