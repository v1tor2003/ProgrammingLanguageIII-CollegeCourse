package List06.statics;

public class Ponto2D {
  private float x, y;

  public Ponto2D(float x, float y){
    this.x = x;
    this.y = y;
  }

  public Ponto2D(){
    this(0, 0);
  }
  
  public String imprimirPonto(){
    return String.format("(%f, %f)", this.x, this.y);
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
    return (Ponto2D.isEixoX(y) && Ponto2D.isEixoY(x));
  }

  public static int findQuadrante(float x, float y){
    if (Ponto2D.isEixos(x, y))
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

    return Ponto2D.findQuadrante(this.x, this.y);
  }

  public static int quadrante(Ponto2D p){

    return Ponto2D.findQuadrante(p.getX(), p.getY());
  }

  public static float distancia(float x1, float y1, float x2, float y2){
    final float potValor = 2;
    double distancia = Math.pow((x1 - x2), potValor) + Math.pow((y1 - y2), potValor);
    return (float) (Math.sqrt(distancia));
  }

  public float distancia(){
    return Ponto2D.distanciaOrigem(this.x, this.y);
  }

  public float distancia(Ponto2D PontoQ){
    return Ponto2D.distancia(this.x, this.y, PontoQ.getX(), PontoQ.getY());
  }

  public static float distance(Ponto2D p){
    return Ponto2D.distanciaOrigem(p.getX(), p.getY());
  }

  private static float distanciaOrigem(float x, float y){
    return Ponto2D.distancia(0, 0, x, y);
  }

  public static float distancia(Ponto2D p1, Ponto2D p2){
    return distancia(p1.getX(), p1.getY(), p2.getX(), p2.getY());
  }
  
  public float getX(){
    return x;
  }

  public float getY(){
    return y;
  }

  public String toString(){
    return imprimirPonto();
  }
}