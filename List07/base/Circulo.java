package List07.base;

import List07.base.pontos.Ponto2D;

public class Circulo extends Ponto2D{
  private float raio;
  final static float power = Ponto2D.getPot();

  public Circulo(float x, float y, float raio){
    super(x, y);
    this.raio = raio;
  }

  public Circulo(){
    this(0, 0, 1);
  }

  public Circulo(float raio){
    this(0, 0, raio);
  }

  public Circulo(float x, float y){
    this(x, y, 1);
  }

  public boolean isInnerPoint(Ponto2D Ponto){
    double result = Math.pow((this.getX() - Ponto.getX()), power) + Math.pow((this.getY() - Ponto.getY()), power);
    return (result < Math.pow(this.raio, power));
  }

  private boolean validaRaio(float raio){
    return (raio >= 0);
  }

  public boolean isBiggerThan(Circulo circulo){
    if(area() > circulo.area())
      return true;
    
    return false;
  }
  
  public float area(){

    return (float) (Math.PI * Math.pow(raio, power));
  }

  public float perimeter(){

    return  (float)(Math.PI * power * raio);
  }
  
  public void setRaio(float raio){
    if(validaRaio(raio))
    this.raio = raio;
  }
  
  public float getX(){
    return super.getX();
  }
  
  public float getY(){
    return super.getY();
  }
  
  public float getRaio(){
    return raio;
  }

  @Override
  public String toString(){
    return String.format("(%s, %s), raio %.2f", this.getX(), this.getY(), this.raio);
  }

  public static float getPower(){
    return power;
  } 
}
