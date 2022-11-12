package base;

public class Triangulo {
  private Ponto2D A, B, C;
  private float ladoAB, ladoAC, ladoBC;
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

  // TO FINISH, WE JUST NEED TO GET THE HIP AND THE CATS
  public boolean isTrianguloRetangulo(){
    final double EPSILON = 0.000001;
    float hip, catA, catB;

    hip = getHipotenusa();
    return ((this.isTriangulo) && (Math.abs((hip * hip) - ((catA * catA) - (catB * catB))) < EPSILON));
  }

  public boolean isTrianguloIssoceles(){
    final double EPSILON = 0.000001;
    return ((this.isTriangulo) && (Math.abs(this.ladoAB - ladoAC) < EPSILON) || (Math.abs(this.ladoAB - ladoBC) < EPSILON) || (Math.abs(this.ladoBC - this.ladoAC) < EPSILON)));
  }

  public boolean isTringuloEquilatero(){
    final double EPSILON = 0.000001;
    return ((this.isTriangulo) && (Math.abs(this.ladoAB - this.ladoAC) < EPSILON) && (Math.abs(this.ladoAC - this.ladoBC) < EPSILON));
  }

  private boolean validateTriangulo(float ladoAB, float ladoAC, float ladoBC){
    return ((ladoAB + ladoAC > ladoBC) && (ladoAB + ladoBC > ladoAC) && (ladoAC + ladoBC) > ladoAB);
  }

  private float getHipotenusa(){
    
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
