package base;

import base.interfaces.IsegmentoReta;

public class SegmentoRetaComp implements IsegmentoReta {
  private Ponto2D P1;
  private Ponto2D P2;
  private float dimensao;

  public SegmentoRetaComp(float x1, float y1, float x2, float y2){
    this.P1 = new Ponto2D(x1, y1);
    this.P2 = new Ponto2D(x2, y2);
    this.dimensao = calculaDimensao();
  }

  public SegmentoRetaComp(Ponto2D P1, Ponto2D P2){
    this(P1.getX(), P1.getY(), P2.getX(), P2.getY());
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
