import List07.base.Ponto2D;
import List07.base.Ponto3DComp;
import List07.base.Ponto3DHeranca;

public class List07Client {
  public static void main(String[]args) {
    Ponto2D p1 = new Ponto2D(1, 2);
    Ponto3DHeranca pointDist = new Ponto3DHeranca(2, 3, 1);
    Ponto3DHeranca p3DHeranca = new Ponto3DHeranca(1, 2, 0); 
    Ponto3DComp p3DComp = new Ponto3DComp(1, 2, 0);

    System.out.println("Testing Ponto2D:");
    System.out.println(p1);
    System.out.println("isAxisX? "+ p1.isAxisX());
    System.out.println("isAxisY? "+ p1.isAxisY());
    System.out.println("isAxis? "+ p1.isAxis());
    System.out.println("isOrigin? "+ p1.isOrigin());
    System.out.println("Distancia: " + p1.distance(2, 3));

    System.out.println("\nTesting Ponto3D Heranca:");
    System.out.println(p3DHeranca);
    System.out.println("isAxisX? "+ p3DHeranca.isAxisX());
    System.out.println("isAxisY? "+ p3DHeranca.isAxisY());
    System.out.println("isAxisZ? "+ p3DHeranca.isAxisZ());
    System.out.println("isAxis? "+ p3DHeranca.isAxis());
    System.out.println("isOrigin? "+ p3DHeranca.isOrigin());
    System.out.println("Distancia: " + p3DHeranca.distance(pointDist.getX(), pointDist.getY(), pointDist.getY()));

    System.out.println("\nTesting Ponto3D Composition:");
    System.out.println(p3DComp);
    System.out.println("isAxisX? "+ p3DComp.isAxisX());
    System.out.println("isAxisY? "+ p3DComp.isAxisY());
    System.out.println("isAxisZ? "+ p3DComp.isAxisZ());
    System.out.println("isAxis? "+ p3DComp.isAxis());
    System.out.println("isOrigin? "+ p3DComp.isOrigin());
    System.out.println("Distancia: " + p3DComp.distance(pointDist.getX(), pointDist.getY(), pointDist.getY()));


  }
}
