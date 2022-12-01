package List08.shapes;

public class Rectangle extends Shape2D{
  final static private int sidesOfARectangle = 2;
  private float height;
  private float base;

  public Rectangle(float height, float base){
    super(ShapeName.RECTANGLE);
    if(super.validateSide(height))
      this.height = height;
    else
      this.height = 1;

    if(super.validateSide(base))
      this.base = base;
    else
      this.base = 1;
  }

  public Rectangle(Rectangle existingRectangle){
    this(existingRectangle.getHeight(), existingRectangle.getBase());
  }

  @Override
  public float calculateArea(){
    return this.base * this.height;
  }
  
  @Override
  public float calculatePerimeter(){
    return sidesOfARectangle * (this.base + this.height);
  }

  @Override
  public String toString(){
    return String.format("%sheight: %.2f, base: %.2f\n", super.toString(), this.height, this.base);
  }

  public float getHeight(){
    return this.height;
  }
  
  public float getBase(){
    return this.base;
  }
}