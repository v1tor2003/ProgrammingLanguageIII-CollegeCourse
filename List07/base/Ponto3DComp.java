package List07.base;

public class Ponto3DComp {
  private Ponto2D coodenatesXY;
  private float z;

  public Ponto3DComp(){
    this.coodenatesXY = new Ponto2D();
    this.z = 0;
  }

  public Ponto3DComp(float x, float y, float z){
    this.coodenatesXY = new Ponto2D(x, y);
    this.z = z;
  }

  public Ponto3DComp(Ponto3DComp other){
    this(other.getX(), other.getY(), other.getZ());
  }

  public boolean isAxisX(){
    return coodenatesXY.getY() == 0 && this.z == 0; 
  }

  public boolean isAxisY(){
    return coodenatesXY.getX() == 0 && this.z == 0; 
  }

  public boolean isAxisZ(){
    return coodenatesXY.getX() == 0 && coodenatesXY.getY() == 0;
  }
 
  public boolean isAxis(){
    return isAxisX() && isAxisY() && isAxisZ();
  }

  public boolean isOrigin(){
    return isAxis();
  }

  public float distance(float x, float y, float z){
    final float power = Ponto2D.getPot();
    double distancia = Math.pow((this.getX() - x), power)
                      +Math.pow((this.getY() - y), power)
                      +Math.pow((this.getZ() - z), power);
    
    return (float) (Math.sqrt(distancia));
  }

  public float distance(Ponto3DComp other3D){
    return distance(other3D.getX(), other3D.getY(), other3D.getZ());
  }

  public float getX(){
    return this.coodenatesXY.getX();
  }

  public float getY(){
    return this.coodenatesXY.getY();
  }

  public float getZ(){
    return this.z;
  }

  public String toString(){
    return String.format("Ponto3D: (%.2f, %.2f, %.2f)", this.getX(), this.getY(), this.getZ());
  }

}
