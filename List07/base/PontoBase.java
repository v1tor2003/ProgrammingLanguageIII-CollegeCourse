package List07.base;

public class PontoBase {
  private float x, y;
  final private static float potValor = 2;

  public PontoBase(float x, float y){
    this.x = x;
    this.y = y;
  }

  public PontoBase(){
    this(0, 0);
  }

  public PontoBase(PontoBase p){
    this(p.getX(), p.getY());
  }
  
  public String toString(){
    return String.format("(%.2f, %.2f)", this.x, this.y);
  }

  public boolean isEixoX(){

    return isEixoX(this.y);
  }

  public boolean isEixoY(){
    
    return isEixoX(this.x);
  }

  public static boolean isEixoX(float y){
    return (y == 0.0);
  }

  public static boolean isEixoY(float x){
    return (x == 0.0);
  }

  public static boolean isEixos(float x, float y){
    return (PontoBase.isEixoX(y) && PontoBase.isEixoY(x));
  }

  public static int findQuadrante(float x, float y){
    if (PontoBase.isEixos(x, y))
      return 0;

    if(x >= 0.0){
      if (y >= 0.0)
        return 1;
      else
        return 2;
    }else{
      if(y >= 0.0)
        return 3;
      else 
        return 4;
    }    
  }

  public int quadrante(){

    return PontoBase.findQuadrante(this.x, this.y);
  }

  public static int quadrante(PontoBase p){

    return PontoBase.findQuadrante(p.getX(), p.getY());
  }

  public static float distancia(float x1, float y1, float x2, float y2){
    double distancia = Math.pow((x1 - x2), potValor) + Math.pow((y1 - y2), potValor);
    return (float) (Math.sqrt(distancia));
  }

  public float distancia(){
    return PontoBase.distanciaOrigem(this.x, this.y);
  }

  public float distancia(PontoBase PontoQ){
    return PontoBase.distancia(this.x, this.y, PontoQ.getX(), PontoQ.getY());
  }

  public static float distance(PontoBase p){
    return PontoBase.distanciaOrigem(p.getX(), p.getY());
  }

  private static float distanciaOrigem(float x, float y){
    return PontoBase.distancia(0, 0, x, y);
  }

  public static float distancia(PontoBase p1, PontoBase p2){
    return distancia(p1.getX(), p1.getY(), p2.getX(), p2.getY());
  }
  
  public float getX(){
    return x;
  }

  public float getY(){
    return y;
  }

  public static float getPot(){
    return potValor;
  }
}
