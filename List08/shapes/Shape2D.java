package List08.shapes;

public class Shape2D implements ShapesI {
  protected ShapeName name;

  public Shape2D(ShapeName name){
    this.name = name;
  }
  
  protected boolean validateSide(float side){
    return side > 0;
  }
  
	@Override
	public float calculateArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float calculatePerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

  public String getName(){
    return this.name.nameOfShape;
  }

  @Override
  public String toString(){
    return String.format("%s, ", this.getName());
  }
 
}