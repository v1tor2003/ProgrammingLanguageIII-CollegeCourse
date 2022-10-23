class Lampada {
  boolean estaLigada;

  void acende (){
    this.estaLigada = true;
  }
  
  void apaga(){
    this.estaLigada = false;
  }
  
  void mostraEstado(){
    if(estaLigada)
      System.out.println("A lampada esta ligada");
    else
      System.out.println("A lampada esta desligada");
  }
}
