/**
 * This is class Point.
 * This class is according to the polar system
 * And will represent a point in a geometric graph in the first quarter only
 * The class has private instances like alpha radius which 
 * represent the length of the vector and the angle (in degrees) of the vector
 * 
 * @author (Nadav Chen)
 * @email (nadav2282@gmail.com)
 */
public class Point
{
    private final int DEFAULT_VAL = 0, NUM = 2;
    // Representing the angle of the vector
    private double _x;
    // Representing the length of the vector
    private double _y;

    public Point(double x, double y) {
        /** A class builder gets the private instances and creates a point */
        _x = (x >= DEFAULT_VAL)? x: DEFAULT_VAL;
        _y = (y >= DEFAULT_VAL)? y: DEFAULT_VAL;
    }

    public Point(Point other) {
        /** Gets another point as a parameter and copies it */
        _x = other._x;
        _y = other._y;
    }

    public double getX() {
        /** Returns the value of X */
        return _x;
    }

    public double getY() {
        /** Returns the value of Y */
        return _y;
    }

    public void setX(double num) {
        /** Changes the value of X as long as it is a positive number */
        if (num >= DEFAULT_VAL)
            _x = num;
    }

    public void setY(double num) {
        /** Changes the value of Y as long as it is a positive number */
        if (num >= DEFAULT_VAL)
            _y = num;
    }

    public String toString() {
        /** Returns the contents of the object as a string of characters */
        return ("(" +_x +","+ _y +")");
    }

    public boolean equals(Point other) {
        /** Gets a point as a parameter and compares 
         * whether the point on which the method was applied is equal */
        return (_x == other._x && _y == other._y);
    }

    public boolean isAbove(Point other) {
        /** If the point at which the method was applied
         * is above the point received as a parameter then returns true */
        return _y > other._y;
    }

    public boolean isUnder(Point other) {
        /** If the point at which the method was applied
         * is below the point received as a parameter then returns true */
        return other.isAbove(this);
    }

    public boolean isLeft(Point other) {
        /** Check if the point on which the method is applied
         * is on the left side (according to the X-axis) of the point in the parameter */
        return _x < other._x;
    }

    public boolean isRight(Point other) {
        /** Check if the point on which the method is applied
         * is on the right side (according to the X-axis) of the point in the parameter */
        return other.isLeft(this);
    }

    public double distance(Point p) {
        /** Measures the distance between the point and the point in the parameter */
        return Math.sqrt(Math.pow((_x-p._x) , NUM) + Math.pow((_y-p._y) , NUM));
    }

    public void move(double dx, double dy) {
        /** A method that moves the point according to the addition
         * in the numbers written in the parameter */
        if ((_x + dx) >= DEFAULT_VAL && (_y + dy) >= DEFAULT_VAL){
            setX(_x + dx);
            setY(_y + dy);
        }
    }
} // end of class Point
