package base;
// TO BE TESTED
public class Triangulo {
  private Ponto2D A, B, C;
  private float ladoAB, ladoAC, ladoBC;
  final static double EPSILON = 0.000001;
  private boolean isTriangulo;

  public Triangulo(float xa, float ya, float xb, float yb, float xc, float yc){
    this.A = new Ponto2D(xa, ya);
    this.B = new Ponto2D(xb, yb);
    this.C = new Ponto2D(xc, yc);
    
    this.ladoAB = this.A.distancia(B);
    this.ladoAC = this.A.distancia(C);
    this.ladoBC = this.B.distancia(C);
    
    this.isTriangulo = validateTriangulo(ladoAB, ladoAC, ladoBC);
  }

  public Triangulo(Ponto2D A, Ponto2D B, Ponto2D C){
    this(A.getX(), A.getY(), B.getX(), B.getY(), C.getX(), C.getY());
  }

  public boolean isTrianguloRetangulo(){
    float hip, catA, catB;

    if(isTrianguloEquilatero())
      return false;

    if(ladoAB > ladoAC && ladoAB > ladoBC){
      hip = ladoAB;
      catA = ladoAC;
      catB = ladoBC;
    }else{
      catA = ladoAB;
      if(ladoAC > ladoBC){
        hip = ladoAC;
        catB = ladoBC;
      }else{
        hip = ladoBC;
        catB = ladoAC;
      }
    }

    return ((this.isTriangulo) && checkHipEqualsPecs(hip, catA, catB));
  }

  public boolean isTrianguloIssoceles(){
    
    return ((this.isTriangulo) && (isRealsEquals(ladoAB, ladoAC)  || isRealsEquals(ladoAB, ladoBC) || isRealsEquals(ladoBC, ladoAC)));
  }

  public boolean isTrianguloEquilatero(){
    
    return ((this.isTriangulo) && (isRealsEquals(ladoAB, ladoAC) && isRealsEquals(ladoAC, ladoBC)));
  }

  private boolean validateTriangulo(float ladoAB, float ladoAC, float ladoBC){
    return ((ladoAB + ladoAC > ladoBC) && (ladoAB + ladoBC > ladoAC) && (ladoAC + ladoBC) > ladoAB);
  }

  private boolean isRealsEquals(float a, float b){
    return (Math.abs(a - b) < EPSILON);
  }

  private boolean checkHipEqualsPecs(float hip, float catA, float catB){
    float a = hip * hip;
    float b = ((catA * catA) - (catB * catB));
    return isRealsEquals(a, b);
  }

  public String imprimeTriangulo(){
    if(!isTriangulo)
      return "Os pontos informados nao formam um triangulo";

    return String.format("Triangulo representado pelos pontos A %s, B %s, C %s",
            this.A, this.B, this.C); 
  }

  public String toString(){
    return imprimeTriangulo();
  }
}
