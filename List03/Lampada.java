public class Lampada {
  private boolean estaLigada;

  public Lampada(){
    this.estaLigada = false;
  }

  public void acende (){
    this.estaLigada = true;
  }
  
  public void apaga(){
    this.estaLigada = false;
  }
  
  public void mostraEstado(){
    if(estaLigada)
      System.out.println("A lampada esta ligada");
    else
      System.out.println("A lampada esta desligada");
  }
}
