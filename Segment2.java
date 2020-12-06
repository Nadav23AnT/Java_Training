
/**
 * This is class  Segment2.
 *
 * @author (your name)
 * @email (nadav2282@gmail.com)
 */
public class Segment2
{
    private final double _NUM = 2 , _DEFAULT = 0;
    private Point _poCenter;
    private double _length;

    public Segment2(double leftX, double leftY, double rightX, double rightY)    {
        /** Constructs a new segment using 4 specified x y coordinates: 
         * Two coordinates for the left point and two coordinates for the right point. */
        _poCenter = new Point(((rightX+leftX) / _NUM), rightY);
        _length = rightX-leftX; 
    }

    public Segment2(Point left, Point right)    {
        /** Constructs a new segment using two Points */
        _poCenter = new Point(((right.getX() + left.getX()) / _NUM) , right.getY());
        _length = right.getX() - left.getX();
    }

    public Segment2(Point poCenter, double length)    {
        /** Constructs a new segment using a center point and the segment length. */
        Point _poCenter = new Point(poCenter);
        _length = length;
    }  

    public Segment2(Segment2 other)    {
        /** Copy Constructor */
        _poCenter = other._poCenter;
        _length = other._length;
    }

    public void changeSize(double delta)     {
        /** Change the segment size by moving the right point by delta */
        if (getPoRight().getX() + delta > getPoLeft().getX())
            getPoRight().setX(getPoLeft().getX() + delta);
    }

    public double getLength()     {
        /** Returns the segment length. */
        return _length;
    }

    public Point getPoLeft()     {
        /** Returns the left point of the segment */
        return new Point((_poCenter.getX() - (_length / _NUM)), _poCenter.getY());
    }

    public Point getPoRight()     {
        /** Returns the right point of the segment */
        return (new Point(_poCenter.getX() + (_length / _NUM), _poCenter.getY()));
    }

    public boolean equals(Segment2 other)     {
        /**  Check if the reference segment is equal to this segment */
        return (_poCenter.equals(other._poCenter) && _length == other._length);
    }

    public boolean isAbove(Segment2 other)    {
        /** Check if this segment is above a reference segment. */
        return _poCenter.getY() > other._poCenter.getY();
    }

    public boolean isBigger(Segment2 other)    {
        /** Check if this segment is bigger than a reference segment. */
        return _length > other._length;
    }

    public boolean isLeft(Segment2 other)    {
        /** Check if this segment is left of a received segment */
        return this.getPoRight().getX() < other.getPoLeft().getX();
    }

    public boolean isRight(Segment2 other)    {
        /** Check if this segment is right of a received segment */
        return other.isLeft(this);
    }

    public boolean isUnder(Segment2 other)    {
        /** Check if this segment is under a reference segment */
        return other.isAbove(this);
    }

    public void moveHorizontal(double delta)    {
        /** Move the segment horizontally by delta */
        if (_poCenter.getX() - (_length / _NUM) + delta >= 0)
            _poCenter.move(delta , _DEFAULT);
    }

    public void moveVertical(double delta)    {
        /** Move the segment vertically by delta. */
        if (_poCenter.getY() + delta >= 0)
            _poCenter.move(_DEFAULT , delta);
    }

    public double overlap(Segment2 other)    {
        /**  Returns the overlap size of this segment and a reference segment. */
        if (!this.isLeft(other) && !this.isRight(other))
            if (this.getPoRight().isRight(other.getPoRight()))
                return other.getPoRight().getX() - this.getPoLeft().getX();
            else
                return this.getPoRight().getX() - other.getPoLeft().getX();
        else
            return _DEFAULT;
    }

    public boolean pointOnSegment(Point p)    {
        /** Check if a point is located on the segment */
        return _poCenter.getY() == p.getY() && getPoRight().getX() - p.getX() >= getPoLeft().getX(); 
    }

    public String toString()    {
        /**   Return a string representation of this segment 
         * in the format (3.0,4.0)---(3.0,6.0) */
        return getPoLeft().toString() + "---" + getPoRight().toString();
    }

    public double trapezePerimeter(Segment2 other)    {
        /** Compute the trapeze perimeter, 
         * which constructed by this segment and a reference segment. */
        return getPoLeft().distance(other.getPoLeft()) + getPoRight().distance(other.getPoRight()) +
        getLength() + other.getLength();
    }
} // end of class Segment2

