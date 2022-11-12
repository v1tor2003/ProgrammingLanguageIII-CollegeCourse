import base.DataHoraComp;
import base.SegmentoRetaComp;

public class Main {
  public static void main (String[] args){
      DataHoraComp dhTest = new DataHoraComp();
      System.out.println(dhTest);

      SegmentoRetaComp srTest = new SegmentoRetaComp(1, 2, 3, 1);
      System.out.println(srTest);
  }
}
