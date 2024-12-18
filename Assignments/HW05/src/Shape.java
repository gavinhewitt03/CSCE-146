/*
 * Gavin Hewitt
 */
public class Shape implements Comparable<Shape>{
	private double area;
	public Shape()
	{
		area = 0.0;
	}
	public Shape(double a)
	{
		area = a;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		if(area < 0.0)
			return;
		this.area = area;
	}
	public int compareTo(Shape s)
	{
		if(this.getArea() == s.getArea()) 
		{
			if(this.getClass().equals(s.getClass()))
				return 0;
			if(this instanceof Circle)
				return 1;
			if(s instanceof Circle)
				return -1;
			if(this instanceof Rectangle)
				return 1;
			else //can only be a right triangle compared to a rectangle so favor rectangle
				return -1;
		}
		if(this.getArea() > s.getArea())
			return 1;
		else
			return -1;
	}
}
