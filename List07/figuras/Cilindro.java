package List07.figuras;

import List07.base.Circulo;

public class Cilindro extends Circulo {
  final private static float power = Circulo.getPower();
  private float altura;

  public Cilindro(float x, float y, float raio, float altura) {
    super(x, y, raio);
    this.altura = altura;
  }

  public Cilindro(float x, float y, float raio) {
    super(x, y, raio);
    this.altura = 1;
  }

  @Override
  public float area() {

    return (float) ((power * super.area()) + (power * Math.PI * super.getRaio() * this.altura));
  }

  public float volume() {

    return (float) (super.area() * this.altura);
  }

  @Override
  public String toString() {
    return String.format("Base: %s, altura %.2f", super.toString(), this.getAltura());
  }

  public float getAltura() {
    return this.altura;
  }

}
