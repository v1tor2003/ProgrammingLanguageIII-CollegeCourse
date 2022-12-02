package List08;

public class TestSimples implements Comparable<TestSimples>{
  private String name;
  private int id;

  public TestSimples(String name, int id){
    this.name = name;
    this.id = id;
  }

  public boolean equals(TestSimples o){
    if (compareTo(o) == 0)
      return true;
   
    return false;
  }
  
  @Override
  public int compareTo(TestSimples o) {
    // TODO Auto-generated method stub
    if(this.id < o.id)
      return 1;
    else if (this.id > o.id)
      return -1;
    
    return 0;
  }

  public String getName(){
    return this.name;
  }

  public int getId(){
    return this.id;
  }

  public String toString(){
    return "Name: " + this.name + " id: " + this.id + "\n";  
  }
  
}
