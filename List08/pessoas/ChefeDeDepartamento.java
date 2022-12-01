package List08.pessoas;
import List06.base.statics.Data;

public class ChefeDeDepartamento extends Funcionario{
  final private static int chefeDepartamentoTax = 3;
  private String departament;
  private Data datePromotion;

  public ChefeDeDepartamento(String name, long id, int diaNas, int mesNas, int anoNas, 
                             float salary, int diaAdm, int mesAdm, int anoAdm,
                              String departament, int diaPro, int mesPro, int anoPro){
    super(name, id, diaNas, mesNas, anoNas, salary, diaAdm, mesAdm, anoAdm);
    if(validateDepartament(departament))
      this.departament = departament;
    else
      this.departament = new String("Nao informado");

    this.datePromotion = new Data (diaPro, mesPro, anoPro);
  }

  @Override
  public float calculateEmprestimo(){
    return chefeDepartamentoTax * this.getSalary();
  }
  
  public String getDepartament(){
    return this.departament;
  }

  private boolean validateDepartament(String departament){
    return departament != null;
  }
  
  public Data getPromoDate(){
    return this.datePromotion;
  }
  
  @Override
  public String toString(){
    return String.format("%sDepartamento: %s\nPromocao: %s\n", super.toString(), this.getDepartament(), this.getPromoDate());
  }
}

