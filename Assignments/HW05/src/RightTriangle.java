/*
 * Gavin Hewitt
 */
public class RightTriangle extends Shape {
	private double base;
	private double height;
	private double area;
	public RightTriangle(double b, double h)
	{
		base = b;
		height = h;
		area = 0.5 * b * h;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		if(base <= 0.0)
			return;
		this.base = base;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		if(base <= 0.0)
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
		return "Right Triangle\t" + this.getBase() + "\t" + this.getHeight();
	}
}
