package List07.base.pontos;

public class Ponto3DHeranca extends Ponto2D {
  private float z;

  public Ponto3DHeranca(){
    this(0, 0, 0);
  }

  public Ponto3DHeranca(float x, float y, float z){
    super(x, y);
    this.z = z;
  }

  public Ponto3DHeranca(Ponto2D pontoXY, float z){
    this(pontoXY.getX(), pontoXY.getY(), z);
  }

  @Override
  public boolean isAxisX(){
    return super.isAxisX() && this.z == 0; 
  }

  @Override
  public boolean isAxisY(){
    return super.isAxisY() && this.z == 0; 
  }

  public boolean isAxisZ(){
    return this.getX() == 0 && this.getY() == 0;
  }

  @Override 
  public boolean isAxis(){
    return isAxisX() && isAxisY() && isAxisZ();
  }

  @Override
  public boolean isOrigin(){
    return isAxis();
  }

  public float distance(float x, float y, float z){
    final float power = super.getPot();
    double distancia = Math.pow((this.getX() - x), power)
                      +Math.pow((this.getY() - y), power)
                      +Math.pow((this.getZ() - z), power);
    
    return (float) (Math.sqrt(distancia));
  }

  public float distance(Ponto3DHeranca other3D){
    return distance(other3D.getX(), other3D.getY(), other3D.getZ());
  }

  @Override
  public String toString(){
    return String.format("Ponto3D: (%.2f, %.2f, %.2f)", this.getX(), this.getY(), this.getZ()); 
  }
  
  public float getX(){
    return super.getX();
  }
  
  public float getY(){
    return super.getY();
  }
  
  public float getZ(){
    return this.z;
  }
}
