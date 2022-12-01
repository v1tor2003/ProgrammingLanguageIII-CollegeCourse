package List08.shapes;

public enum ShapeName {
  
  SQUARE("Square"),
  RECTANGLE("Rectangle"),
  TRIANGLE("Triangule"),
  CIRCLE("Circle");
  
  final String nameOfShape;
  
  ShapeName(String nameOfShape){
    this.nameOfShape = nameOfShape;
  }
}
