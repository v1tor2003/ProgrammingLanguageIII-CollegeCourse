public class RoboSimples {
  private String nomeDoRobo;
  private int posicaoXAtual,posicaoYAtual;
  private char direcaoAtual;

  RoboSimples(String nome, int px, int py, char d){
    if(validaNome(nome))
      nomeDoRobo = nome;
    else
      nomeDoRobo = "Sem nome";
    
    if(validaPosicao(d))
      direcaoAtual = d;
    else
      direcaoAtual = 'N';
    
    posicaoXAtual = px;
    posicaoYAtual = py;
  }

  RoboSimples(String nome){
    this(nome, 0, 0, 'N');
  }

  RoboSimples(){
    this(null);
  }

  private boolean validaNome(String nome){
    return (nome != null);
  }

  private boolean validaPosicao(char d){
    return (validaPosVertical(d) || validaPosHorizontal(d));
    
  }

  private boolean testaPosicaoNoEixo(char direcoes[], char d){
    boolean posValida = false;
    
    for(char direcao : direcoes){
      if(d == direcao)
        posValida = true;
    }

    return posValida;
  }

  private boolean validaPosVertical(char d){
    final char direcoesVerticais [] = {'N', 'S'};
    return testaPosicaoNoEixo(direcoesVerticais, d);
  }

  private boolean validaPosHorizontal(char d){
    final char direcoesHorizontais [] = {'E', 'L'};
    return testaPosicaoNoEixo(direcoesHorizontais, d);
  }

  public void move(){
    this.move(1);
  }

  public void move(int passos){
    this.move(passos, '/');
    
    /*if (direcaoAtual == 'N') posicaoYAtual += passos;
    if (direcaoAtual == 'S') posicaoYAtual -= passos;
    if (direcaoAtual == 'L') posicaoXAtual += passos;
    if (direcaoAtual == 'O') posicaoXAtual -= passos;*/

    // comandos "movidos para o move de mais especificidade"
    // se so os passos forem informados a função ele modificara os valores em cima dos eixos
    // ou seja, so em N, ou S, ou O, ou L
    // se informada a direção a função de maior especificidade mudara
    // as posicões do robo em dois eixos relacionados, isso significa que se o robo estiver 
    // direcionado para N, ele se move += passos em N e += passos em O ou L
    
    // AINDA SEM TESTAR, FUI DORMIR
  }

  // Usei a logica de que o robo so pode ir pra onde ele esta direcionado
  // ou seja, se ele estiver direcionado para o Norte ele ganha posições em N e em O ou L
  // de forma analoga a logica foi usada para que ele se mova nas diagonais em relação a S, L ou O

  public void move(int passos, char direcaoLateral){
    if(validaPosHorizontal(direcaoLateral)){
      if(direcaoAtual == 'N')
        posicaoYAtual += passos;
      else if (direcaoAtual == 'S')
        posicaoYAtual -= passos;

      if(direcaoLateral == 'L')
        posicaoXAtual += passos;
      else 
        posicaoXAtual -= passos;
    }else if(validaPosVertical(direcaoLateral)){
      if(direcaoAtual == 'L')
        posicaoXAtual += passos;
      else if (direcaoAtual == 'O')
        posicaoXAtual -= passos;
      
      if(direcaoLateral == 'N')
        posicaoYAtual += passos;
      else 
        posicaoYAtual -= passos;
    }
  }

  public void mudaDireção(char novaDirecao){
    direcaoAtual = novaDirecao;
  }

  public String toString(){
    String str = "\nNome do robo: "+nomeDoRobo+"\n";
    str = str + "Posicao do robo: ("+posicaoXAtual+", "+posicaoYAtual+")\n";
    str = str + "Direcao do robo: "+direcaoAtual;

    return str;
  }

}