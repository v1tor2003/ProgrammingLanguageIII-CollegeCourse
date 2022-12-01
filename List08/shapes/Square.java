package List08.shapes;

public class Square extends Shape2D{
  final private static int sidesOfASquare = 4;
  private float size;
  
  public Square(float size){
    super(ShapeName.SQUARE);
    if(super.validateSide(size))
      this.size = size;
    else 
      this.size = 1;
  }

  public Square(Square existingSquare){
    this(existingSquare.getSize());
  }

  @Override
  public float calculateArea(){
    return (float) this.size * this.size;
  }

  @Override
  public float calculatePerimeter(){
    return (float) this.size * sidesOfASquare;
  }

  @Override
  public String toString(){
    return String.format("%ssize: %.2f\n", super.toString(), this.size);
  }
 
  public float getSize(){
    return this.size;
  }
}