public class Main {
    public static void main(String[] args) {
        Shape[] shapes = createShapes();
        manageShapes(shapes);
    }

    public static Shape[] createShapes() {

        // Punkte erstellen
        Point p1 = new Point(5.1, -8.6);
        Point p2 = new Point(17.6, 9.5);
        Point p3 = new Point(-4.8, 10.0);

        // Kreis, Dreieck, Rechteck erstellen mit den erstellten Punkten als Zentrum
        Shape circle = new Circle(p1, 3);
        Shape triangle = new Triangle(p2, 5);
        Shape square = new Square(p3, 2);

        // Array erstellen mit dem Typ Shape
        Shape[] shapes = new Shape[3];

        // Die erstellten Formen in dem Array abspeichern
        shapes[0] = circle;
        shapes[1] = triangle;
        shapes[2] = square;
        
        return shapes;
    }


    public static void manageShapes(Shape[] shapes) {

        // Gibt die Informationen über alle Formen in dem Array aus
        System.out.println("Print information about shapes:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i] + " has an Area of " + shapes[i].calculateArea());
        }

        // Bewegt den Kreis zum Punkt (0|0) und setzt den Radius auf 2 
        Point p4 = new Point(0.0, 0.0);
        shapes[0].moveTo(p4);
        shapes[0].scale(2.0);

        // Gibt Informationen aller Formen erneut aus
        System.out.println("Print information about shapes once again:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i] + " has an Area of " + shapes[i].calculateArea());
        }
    }
}
