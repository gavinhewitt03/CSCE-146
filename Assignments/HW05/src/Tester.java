
public class Tester {
	public static void main(String[] args)
	{
		Circle c = new Circle(2);
		Rectangle r = new Rectangle(2, 2);
		
		System.out.println(c.compareTo(r));
		System.out.println(r.getClass());
		
		LinkedBST<Shape> shapes = new LinkedBST<Shape>();
		shapes.add(r);
		shapes.add(c);
		shapes.add(new RightTriangle(4, 2));
		shapes.add(new Rectangle(4,2));
		shapes.add(new Rectangle(8,2));
		shapes.printInorder();
		System.out.println();
		shapes.remove(new Rectangle(4,2));
		shapes.printInorder();
		System.out.println(shapes.search(new Rectangle(8,2)));
		System.out.println(shapes.findMaxInTree());
		System.out.println();
		shapes.removeGreaterThan(new Shape(10));
		shapes.printInorder();
		shapes.writeFile("./shapesTest.txt");
	}
}
