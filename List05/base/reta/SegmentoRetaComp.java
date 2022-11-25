package base.reta;

import base.interfaces.SegmentoRetaI;

public class SegmentoRetaComp implements SegmentoRetaI {
  private Ponto2D P1;
  private Ponto2D P2;
  private float dimensao;

  public SegmentoRetaComp(float x1, float y1, float x2, float y2){
    this.P1 = new Ponto2D(x1, y1);
    this.P2 = new Ponto2D(x2, y2);
    this.dimensao = calculaDimensao();
  }

  public SegmentoRetaComp(Ponto2D p12, Ponto2D p22){
    this(p12.getX(), p12.getY(), p22.getX(), p22.getY());
  }

  @Override
  public String imprimeSegmentoReta() {
    // TODO Auto-generated method stub
    return String.format("O segmento de reta inicia no ponto %s e finaliza no ponto %s com dimensao %f.", 
                          this.P1, this.P2, dimensao);
  }

  @Override
  public float calculaDimensao() {
    // TODO Auto-generated method stub
    return P1.distancia(P2);
  }

  public String toString(){

    return imprimeSegmentoReta();
  }
  
}
