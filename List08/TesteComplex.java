package List08;

public class TesteComplex extends TestSimples {
  private String info;

  public TesteComplex(String name, int id, String info) {
    super(name, id);
    //TODO Auto-generated constructor stub
    this.info = info;
  }

  public TesteComplex(TestSimples test, String info) {
   this(test.getName(), test.getId(), info);
  }

  public String toString(){
    return super.toString() + "Info: " + this.info + "\n";
  }

  private int compareLocal(String otherInfo) {
    // TODO Auto-generated method stub
    if(this.info.compareTo(otherInfo) > 0){
      return 1;
    }
    else if (this.info.compareTo(otherInfo) < 0){
      return -1;
    }
    
    return 0;
  }
  
  @Override
  public int compareTo(TestSimples obj) {
    // TODO Auto-generated method stub
    TesteComplex newObj = (TesteComplex) obj;
    String ref = newObj.info;
    return compareLocal(ref);
  }
  
}
