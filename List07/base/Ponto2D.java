package List07.base;

public class Ponto2D extends PontoBase {
  
  public Ponto2D(){
    super(0, 0);
  }

  public Ponto2D(float x, float y){
    super(x, y);
  }

  public Ponto2D(Ponto2D other){
    super(other.getX(), other.getY());
  }

  public boolean isAxisX(){
    return super.isEixoX();
  }

  public boolean isAxisY(){
    return super.isEixoY();
  }

  public boolean isAxis(){
    return isAxisX() && isAxisX();
  }

  public boolean isOrigin(){
    return isAxis();
  }

  public float distance(Ponto2D other){
    return distance(other.getX(), other.getY());
  }

  public float distance(float x, float y){
    return super.distancia(this.getX(), this.getY(), x, y);
  }

  @Override
  public String toString(){
    return "Ponto2D: " + super.toString();
  }
}
