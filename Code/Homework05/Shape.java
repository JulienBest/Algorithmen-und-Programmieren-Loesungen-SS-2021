public abstract class Shape {

    protected Point center;

    public void moveTo(Point newCenter) {
        this.center = newCenter;
    }

    public abstract void scale(double scalingFactor);

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public abstract String toString();
}
