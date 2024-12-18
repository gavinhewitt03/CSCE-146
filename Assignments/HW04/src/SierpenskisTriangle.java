/*
 * Gavin Hewitt
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SierpenskisTriangle extends Canvas 
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Sierpenski's Triangle");
		frame.setSize(500,500);
		SierpenskisTriangle st = new SierpenskisTriangle();
		frame.add(st);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g)
	{
		drawTriangle(400, 400, 400, g);
		drawUpsideDownTriangle(400, 200, 0, 400, 0, 400, g);
	}
	public void drawTriangle(int x, int y, int side, Graphics g) //draws the big triangle that going to be separated
	{
		int[] Xs = {x - side, x, x/2, x - side};
		int[] Ys = {y, y, 0, y};
		g.drawPolygon(Xs, Ys, 4);
		g.fillPolygon(Xs, Ys, 4);
	}
	public void drawUpsideDownTriangle(int x2, int x1, int x0, int y1, int y0, int side, Graphics g) //draws the middle triangle
	{
		int[] Xs = {mid(x1,x0), mid(x2,x0), mid(x2, x1), mid(x1, x0)};
		int[] Ys = {mid(y1, y0), y1, mid(y1,y0), mid(y1,y0)};
		g.setColor(Color.WHITE);
		g.drawPolygon(Xs, Ys, 4);
		g.fillPolygon(Xs, Ys, 4);
		if(side >= 20) 
		{
			//Top
			drawUpsideDownTriangle(Xs[2], Xs[1], Xs[0], Ys[0], y0, side/2, g); 
			//Left
			drawUpsideDownTriangle(Xs[1], Xs[0], x0, y1, Ys[0], side/2, g); 
			//Right
			drawUpsideDownTriangle(x2, Xs[2], Xs[1], y1, Ys[0], side/2, g);
		}
	}
	private int mid(int v1, int v0) //method to calculate the midpoint
	{
		return (v1 + v0)/2;
	}
}
