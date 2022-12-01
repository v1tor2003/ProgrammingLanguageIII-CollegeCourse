package List08.shapes;

public class Triangle extends Shape2D{
  private float sideA;
  private float sideB;
  private float sideC;

  public Triangle(float sideA, float sideB, float sideC){
    super(ShapeName.TRIANGLE);
    if(validateTriangle(sideA, sideB, sideC)){
      this.sideA = sideA;
      this.sideB = sideB;
      this.sideC = sideC;
    }else{
      this.sideA = 1;
      this.sideB = 1;
      this.sideC = 1;
    }
  }

  public Triangle(Triangle existingTriangle){
    this(existingTriangle.getSideA(), existingTriangle.getSideB(), existingTriangle.getSideC());
  }

  private boolean validateTriangle(float sideA, float sideB, float sideC){
    if(sideA <= 0 || sideB <= 0 || sideC <= 0)
      return false;
    
    return ((sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA));
  }

  @Override
  public float calculateArea(){
    float semiPerimeter = calculatePerimeter();
    return (float) Math.sqrt(semiPerimeter * (semiPerimeter - this.sideA) * (semiPerimeter - this.sideB) * (semiPerimeter - this.sideC));
  }

  @Override
  public float calculatePerimeter(){
    return this.sideA + this.sideB + this.sideC;
  }

  @Override
  public String toString(){
    return String.format("%ssideA: %.2f, sideB: %.2f, sideC: %.2f\n", super.toString(), this.getSideA(), this.getSideB(), this.getSideC());
  }

  public float getSideA(){
    return this.sideA;
  }
  
  public float getSideB(){
    return this.sideB;
  }
  
  public float getSideC(){
    return this.sideC;
  }

 
}