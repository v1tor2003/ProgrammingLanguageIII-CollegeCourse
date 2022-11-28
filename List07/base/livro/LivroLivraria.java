package List07.base.livro;

public class LivroLivraria extends Livro{
  final private float preco;
  private boolean vendido;
  private static int estoque = 0;
  private static int livrosVendidos = 0;
  private static float totalArrecadado = 0;

  public LivroLivraria(String titulo, String autor, int paginas, float preco, int dia, int mes, int ano){
    super(titulo, autor, paginas, dia, mes, ano);
    this.preco = preco;
    this.vendido = false;
    estoque += 1;
  }

  public LivroLivraria(String titulo, String autor){
    this(titulo, autor, 1, 1, 0,0,0);
  }

  public LivroLivraria(String titulo, String autor, int paginas){
    this(titulo, autor, paginas, 1, 0,0,0);
  }

  public LivroLivraria(String titulo, String autor, float preco){
    this(titulo, autor, 1, preco, 0,0,0);
  }

  public boolean isAvaliable(){

    return !vendido && estoque >= 1;
  } 

  public void sell(){
    if(isAvaliable()){
      estoque -= 1;
      livrosVendidos += 1;
      totalArrecadado += this.preco;
      this.vendido = true;
      System.out.printf("%s de %s foi vendido por R$ %.2f\n", super.getTitulo(), super.getAutor(), this.preco);
    }else
      System.out.println("Livro nao disponivel para venda.");
  } 

  @Override
  public String toString(){
    String str = super.toString();
    if(vendido) 
      return str += String.format("\nStatus: vendido\nPreco: R$ %.2f", this.preco);
    else
      return str += String.format("\nStatus: disponivel\nPreco: R$ %.2f", this.preco);
  }

  public static int getTotalDeLivrosVendidos(){
    return livrosVendidos;
  }

  public static float getTotalArrecadado(){
    return totalArrecadado;
  }

  public static int getEstoque(){
    return estoque;
  }

}
