/*
 * Gavin Hewitt
 */
public class Circle extends Shape {
	private double radius;
	private double area;
	public Circle(double r)
	{
		radius = r;
		area = Math.PI * Math.pow(r,2);
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		if(radius <= 0.0)
			return;
		this.radius = radius;
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
		return "Circle\t" + this.getRadius();
	}
}
