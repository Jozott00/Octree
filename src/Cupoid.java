import MyStack.Point;

public class Cupoid {
    private double halfWidth;
    private double halfHeight;
    private double halfDepth;

    private Point center;

    public Cupoid(Point center, double halfWidth, double halfHeight, double halfDepth) {
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.halfDepth = halfDepth;

        this.center = center;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(center.getX(), center.getY(), halfWidth, halfHeight);
    }

    public boolean contains(Point p) {
        if(!(center.getX() - halfWidth < p.getX() && center.getX() + halfWidth > p.getX())) return false;
        if(!(center.getY() - halfHeight < p.getY() && center.getY() + halfHeight > p.getY())) return false;
        if(!(center.getZ() - halfDepth < p.getZ() && center.getZ() + halfDepth > p.getZ())) return false;
        return true;
    }

    public boolean intersects (Cupoid other) {
        double otherUpperLimit = other.center.getY() + other.getHalfLengths()[1];
        double otherLowerLimit = other.center.getY() - other.getHalfLengths()[1];
        double otherLeftLimit =  other.center.getX() - other.getHalfLengths()[0];
        double otherRightLimit =  other.center.getX() + other.getHalfLengths()[0];
        double otherFrontLimit = other.center.getY() - other.getHalfLengths()[2];
        double otherBackLimit = other.center.getZ() + other.getHalfLengths()[2];

        double thisUpperLimit = this.center.getY() + this.halfHeight;
        double thisLowerLimit = this.center.getY() - this.halfHeight;
        double thisLeftLimit = this.center.getX() - this.halfWidth;
        double thisRightLimit = this.center.getX() + this.halfWidth;
        double thisFrontLimit = this.center.getZ() - this.halfDepth;
        double thisBackLimit = this.center.getZ() + this.halfDepth;

        boolean bool = !(otherLeftLimit > thisRightLimit ||
                otherRightLimit < thisLeftLimit ||
                otherLowerLimit > thisUpperLimit ||
                otherUpperLimit < thisLowerLimit ||
                otherFrontLimit > thisBackLimit ||
                otherBackLimit < thisFrontLimit);

        return bool;
    }


    public Point getCenter() { return this.center; }

    public double[] getHalfLengths() { return new double[] {halfWidth, halfHeight, halfDepth}; }
}
