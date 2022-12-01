package List08.pessoas;
import List06.base.statics.Data;

public class Funcionario extends Pessoa{
  final private static float funcionarioTax = 0.75f; 
  private Data admission;
  private float salary;

  public Funcionario(String name, long id, int diaNas, int mesNas, int anoNas, float salary, int diaAdm, int mesAdm, int anoAdm){
    super(name, id, diaNas, mesNas, anoNas);
    this.admission = new Data(diaAdm, mesAdm, anoAdm);
    if(validateSalary(salary))
      this.salary = salary;
    else 
      this.salary = 1000;
  }

  private boolean validateSalary(float salary){
    return salary > 0;
  }

  public float getSalary(){
    return this.salary;
  }

  public Data getAdmission(){
    return this.admission;
  }
  
  @Override
  public float calculateEmprestimo(){
    return Math.abs((this.salary * funcionarioTax) - super.getMinValue()); 
  }
  
  @Override
  public String toString(){
    return String.format("%sAdmissao: %s\nSalario: %.2f\n", super.toString(), this.getAdmission(),this.getSalary());
  }
}
