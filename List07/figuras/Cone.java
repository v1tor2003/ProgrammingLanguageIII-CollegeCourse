package List07.figuras;


public class Cone extends Cilindro {
  private float geratriz;
  final private static float power = Cilindro.getPower();

  public Cone(float x, float y, float raio, float altura) {
    super(x, y, raio, altura);
    this.geratriz = calculateGeratriz(); 
  }

  @Override
  public float area(){
    // area PI * raio^2 + PI * raio * geratriz
    return (float) (Math.PI * Math.pow(super.getRaio(), power)
                 + Math.PI * super.getRaio() * this.geratriz);
  }

  @Override
  public float volume(){
    // volume (PI * raio^2 * altrua )/3
    return (float) (super.volume()/3.0);
  }

  private float calculateGeratriz(){
    return (float) Math.sqrt(Math.pow(super.getAltura(), power) + Math.pow(super.getRaio(), power));
  }

  @Override
  public String toString(){
    return String.format("%s, geratriz %.2f.",super.toString(), this.getGeratriz());
  }

  public float getGeratriz(){
    return this.geratriz;
  }
}
