public class Square extends Shape {

    private double sideLength;

    public Square(Point center, double sideLength){
        this.center = center;
        this.sideLength = sideLength;
    }

    @Override
    public void scale(double scalingFactor) {
        this.sideLength = scalingFactor * this.sideLength;
    }

    @Override
    public double calculateArea() {
        return this.sideLength * this.sideLength;
    }

    @Override
    public String toString() {
        return "Square at " + this.center.toString() + " with the side length " + this.sideLength;
    }

}
