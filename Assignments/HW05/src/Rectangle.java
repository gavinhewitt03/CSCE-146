/*
 * Gavin Hewitt
 */
public class Rectangle extends Shape {
	private double length;
	private double height;
	private double area;
	public Rectangle(double l, double h)
	{
		length = l;
		height = h;
		area = l * h;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		if(length <= 0.0)
			return;
		this.length = length;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		if(height <= 0.0)
			return;
		this.height = height;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		if(area <= 0.0)
			return;
		this.area = area;
	}
	public String toString()
	{
		return "Rectangle\t" + this.getLength() + "\t" + this.getHeight();
	}
}
