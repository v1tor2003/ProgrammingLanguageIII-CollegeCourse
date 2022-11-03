public class Circulo {
  private Ponto2D circuloCoordenadas;
  private float raio;
  
  public Circulo(float x, float y, float raio){
    float raioDefault = 1;
    
    if(validaRaio(raio))
      this.raio = raio;
    else
      this.raio = raioDefault;
    
    circuloCoordenadas = new Ponto2D(x, y);
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

  public void imprimirCirculo(){
    System.out.print("Circulo : ("+ circuloCoordenadas.getX() +", "+ circuloCoordenadas.getY() +"), ");
    System.out.println("raio : " + this.raio);
  }

  public boolean isInnerPoint(Ponto2D Ponto){
    final float potValor = 2;
    double result = Math.pow((this.circuloCoordenadas.getX() - Ponto.getX()), potValor) + Math.pow((this.circuloCoordenadas.getY() - Ponto.getY()), potValor);
    return (result < Math.pow(this.raio, potValor));
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
    final double potValor = 2;
    return (float) (Math.PI * Math.pow(raio, potValor));
  }

  public float perimeter(){
    final float constantValor = 2;
    return  (float)(Math.PI * constantValor * raio);
  }

  public float getRaio(){
    return raio;
  }

  public void setRaio(float raio){
    if(validaRaio(raio))
      this.raio = raio;
  }
}
