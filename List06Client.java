
import List06.base.statics.Contato;
import List06.base.statics.Data;
import List06.base.statics.TimeAsInt;

public class List06Client {
  public static void main(String[]args) {
    Contato con1 = new Contato("Vitor");
    Contato con2 = new Contato("OutraPessoa");
    TimeAsInt time1 = new TimeAsInt(21, 0);
    TimeAsInt time2 = new TimeAsInt(19, 0);
    Data data = new Data(25, 11, 2022); 

    System.out.println("Contato counter testing:");
    System.out.println("contatos: " + Contato.getContatoQntd());


    System.out.println("Time testing:");
    System.out.println("diffTime (t1, t2): " + TimeAsInt.diffTime(time1, time2));
    System.out.println("diffTime (t1): "+ TimeAsInt.diffTime(time1));
    System.out.println("isAm (t1): " + TimeAsInt.isAm(time1));
    System.out.println("isPm (t1): " + TimeAsInt.isPm(time1));


    System.out.println("Data testing:");
    System.out.println("nextMonth: " + Data.howManyDaysUntilNextMonth(data));
    System.out.println("nextYear: " + Data.howManyDaysUntilEndYear(data));

    System.out.println("dayOfWeek (static):" + Data.dayOfWeek(25, 11, 2022));
    System.out.println("dayOfWeek: " + data.dayOfWeek());

    System.out.println("dayToPrintShort/imprimirData (static): " + Data.imprimirData(25, 11, 2022));
    System.out.println("dayToPrintShort/imprimirData: " + data.imprimirData());
    System.out.println("dayToPrintLong/imprimirDataExtenso (static): " + Data.imprimirDataExtenso(25, 11, 2022));
    System.out.println("dayToPrintLong/imprimirDataExtenso: " + data.imprimirDataExtenso());
  
  }
}
