public class Circle extends Shape {

    private double radius;

    public Circle(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void scale(double scalingFactor) {
        this.radius = scalingFactor * this.radius;
    }

    @Override
    public double calculateArea() {
        return (Math.PI * this.radius * this.radius);
    }

    @Override
    public String toString() {
        return "Circle at " + this.center.toString() + " with the radius " + this.radius;
    }
    
}
