package List06.base.statics;

public class UnidadesDePeso {
  final private static float gramsInOneKgUnit = 1000;
  final private static float gramsInOnePoundUnit = 453.6f;
  final private static float gramsInOneOunceUnit = 28.35f;
  
  final private static float ouncesInOneKgUnit = 35.274f;
  final private static int   ouncesInOnePoundUnit = 16;
  
  final private static float poundsInOneKgUnit = 2.205f;
  

  public static float gramsToKg(float grams){
    return (grams/gramsInOneKgUnit);
  }

  public static float gramsToPounds(float grams){
    return (grams/gramsInOnePoundUnit);
  }

  public static float gramsToOunces(float grams){
    return (grams/gramsInOneOunceUnit);
  }
  
  public static float kgToGrams(float kg){
    return (kg * gramsInOneKgUnit);
  }

  public static float kgToPounds(float kg){
    return (kg * poundsInOneKgUnit);
  }

  public static float kgToOunces(float kg){
    return (kg * ouncesInOneKgUnit);
  }

  public static float poundsToKg(float pounds){
    return (float) (pounds/poundsInOneKgUnit);  
  }

  public static float poundsToGrams(float pounds){
    return (pounds * gramsInOnePoundUnit);  
  }

  public static float poundsToOunces(float pounds){
    return (pounds * ouncesInOnePoundUnit);  
  }

  public static float ouncesToKg(float ounces){
    return (ounces/ouncesInOneKgUnit);
  }
  
  public static float ouncesToGramas(float ounces){
    return (ounces * gramsInOneOunceUnit);
  }
  
  public static float ouncesToPounds(float ounces){
    return (ounces / ouncesInOnePoundUnit);
  }

}
