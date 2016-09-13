package package1;

public class TestShape {

public static void main( String[] args ){
Shape theShape = new Square();
if (theShape instanceof Square)
System.out.println("Square");
if (theShape instanceof Shape)
System.out.println("Shape");
if (theShape instanceof Circle)
System.out.println("Circle");
else
System.out.println("Some Shape");
}
}
