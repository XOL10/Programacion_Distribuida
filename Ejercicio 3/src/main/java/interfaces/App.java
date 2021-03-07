public class App
{
    public static void main( String[] args ){
        Polygon circle1 = new Circle(6);
        Polygon circle2 = new Circle(8);
        Polygon square1 = new Square(7);
        Polygon square2 = new Square(4);
        Polygon rectangle1 = new Rectangle(4, 6);
        Polygon rectangle2 = new Rectangle(5, 10);

        System.out.println("***** Circles *****");
        System.out.println("Circle1 area: " + circle1.getArea());
        System.out.println("Circle1 sides: " + circle1.getSides());
        System.out.println("Circle2 area: " + circle2.getArea());
        System.out.println("Circle2 sides: " + circle2.getSides());

        System.out.println("\n***** Squares *****");
        System.out.println("Square1 area: " + square1.getArea());
        System.out.println("Square1 sides: " + square1.getSides());
        System.out.println("Square2 area: " + square2.getArea());
        System.out.println("Square2 sides: " + square2.getSides());

        System.out.println("\n***** Rectangles *****");
        System.out.println("Rectangle1 area: " + rectangle1.getArea());
        System.out.println("Rectangle1 sides: " + rectangle1.getSides());
        System.out.println("Rectangle2 area: " + rectangle2.getArea());
        System.out.println("Rectangle2 sides: " + rectangle2.getSides());
    }
}
