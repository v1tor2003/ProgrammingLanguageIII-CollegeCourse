class Ponto2D {
  private int x, y;

  public void imprimirPonto(){
    System.out.println("("+x+", "+y+")");
  }

  boolean isEixoX(){

  }

  boolean isEixoY(){

  }

  boolean isEixos(){

  }

  int quadrante(){
    if (x == 0 && y == 0)
      return 0;

    if(x >= 0){
      if (y >= 0)
        return 1;
      else
        return 2;
    }else{
      if(y >= 0)
        return 3;
      else 
        return 4;
    }    
  }

  public float distancia(Ponto2D PontoQ){
    return 2.1;
  }
  
  public int getX(){
    return x;
  }

  public void setX(){
    this.x = x;
  }

  public int getY(){
    return y;
  }

  public void setY(){
    this.y = y;
  }
  
}
