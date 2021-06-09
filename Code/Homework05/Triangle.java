public class Triangle extends Shape {

    private double sideLength;

    public Triangle(Point center, double sideLength) {
        this.center = center;
        this.sideLength = sideLength;
    }

    @Override
    public void scale(double scalingFactor) {
        this.sideLength = scalingFactor * this.sideLength;
    }

    @Override
    public double calculateArea() {
        double h = 0.5 * Math.sqrt(3) * this.sideLength;
        return 0.5 * this.sideLength * h;
    }

    @Override
    public double calculatePerimeter(){
        return (this.sideLength * 3);
    }

    @Override
    public String toString() {
        return "Triangle at " + this.center.toString() + " with the side length " + this.sideLength;
    }

}
