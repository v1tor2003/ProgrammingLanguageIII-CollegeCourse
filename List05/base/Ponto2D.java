package base;
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
    return "("+x+", "+y+")";
  }

  public boolean isEixoX(){
    return (this.y == 0.0);
  }

  public boolean isEixoY(){
    return (this.x == 0.0);
  }

  public boolean isEixos(){
    return (isEixoX() && isEixoY());
  }

  public int quadrante(){
    if (isEixos())
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

  public float distancia(float x, float y){
    final float potValor = 2;
    double distancia = Math.pow((this.x - x), potValor) + Math.pow((this.y - y), potValor);
    return (float) (Math.sqrt(distancia));
  }

  public float distancia(){
    return distancia(0,0);
  }

  public float distancia(Ponto2D PontoQ){
    return distancia(PontoQ.getX(), PontoQ.getY());
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