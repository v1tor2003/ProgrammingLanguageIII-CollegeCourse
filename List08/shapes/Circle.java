package List08.shapes;

public class Circle extends Shape2D{
  private float radius;

  public Circle(float radius){
    super(ShapeName.CIRCLE);
    if(super.validateSide(radius))
      this.radius = radius;
    else
      this.radius = 1;
  }

  public Circle(Circle existingCircle){
    this(existingCircle.getRadius());
  }

  public float getRadius(){
    return this.radius;
  }
  
  public float calculateArea(){
    return (float) (Math.PI * (radius * radius));
  }

  public float calculatePerimeter(){
    return (float) (Math.PI * radius * 2);
  }

  @Override
  public String toString(){
    return String.format("%sradius: %.2f\n", super.toString(), this.getRadius());
  }
}
