import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

/**
 * Draws quadrilaterals in which the x,y coordinates of each point are between 0 and 10
 * @author Suzanne Balik
 *
 */
public class Drawing {
	
	/** Width of the drawing area. */
	public static final int WIDTH = 400;

	/** Height of the drawing area. */
	public static final int HEIGHT = 400;

	/** Where to start drawing, on the left */
	public static final int START_X = 50;

	/** Where to start drawing, at the left */
	public static final int START_Y = 50;

	/** Size of one unit of drawing */
	public static final int SIZE = 30;

	/** Range of X and Y values */
	public static final int MAX = 10;

	/** Size of a tick mark on a coordinate axis */
	public static final int TICK = 5;

	/** How far the arrow pokes off the end. */
	public static final int ARROW = 15;
	
	/** Radius of circle for points*/
	public static final int RADIUS = 2;
	
	/**
	 * Draws a quadrilateral assuming x,y coordinates of each point are between 0 and 10
	 * @param p1 Point 1
	 * @param p2 Point 2
	 * @param p3 Point 3
	 * @param p4 Point 4
	 */
	public static void drawShape(Point p1, Point p2, Point p3, Point p4) {
		if (System.getProperty("drawing.disabled") != null) {
			System.out.println("[Pretend this is a drawing panel]");
			return;
		}
		
		DrawingPanel dp = new DrawingPanel(WIDTH, HEIGHT);
		Graphics g = dp.getGraphics();

		// Draw coordinate axes in gray.
		g.setColor( Color.LIGHT_GRAY );

		// Line for the axis
		g.drawLine( START_X, START_Y + SIZE * MAX,
		            START_X + MAX * SIZE + ARROW, START_Y + SIZE * MAX );

		// An arrow at the end.
		g.drawLine( START_X + MAX * SIZE + ARROW - TICK, START_Y + SIZE * MAX - TICK,
		            START_X + MAX * SIZE + ARROW, START_Y + SIZE * MAX );
		g.drawLine( START_X + MAX * SIZE + ARROW - TICK, START_Y + SIZE * MAX + TICK,
		            START_X + MAX * SIZE + ARROW, START_Y + SIZE * MAX );

		// Draw line for Y axis
		g.drawLine( START_X, START_Y + MAX * SIZE,
		            START_X, START_Y - ARROW );

		// And an arrow at the end.
		g.drawLine( START_X - TICK, START_Y - ARROW + TICK,
		            START_X, START_Y - ARROW );
		g.drawLine( START_X + TICK, START_Y - ARROW + TICK,
		            START_X, START_Y - ARROW );

		for ( int x = 0; x <= MAX; x++ ) {
			g.drawLine( START_X + x * SIZE, START_Y + SIZE * MAX - TICK,
			            START_X + x * SIZE, START_Y + SIZE * MAX + TICK );
		}

		for ( int y = 0; y <= MAX; y++ ) {
			g.drawLine( START_X - TICK, START_Y + SIZE * ( MAX - y ),
			            START_X + TICK, START_Y + SIZE * ( MAX - y ) );
		}


		// Now, draw the quadrilateral in black.
		g.setColor( Color.BLACK );
		
		int p1X = START_X + SIZE * p1.x;
		int p1Y = START_Y + SIZE * (MAX - p1.y);
		int p2X = START_X + SIZE * p2.x;
		int p2Y = START_Y + SIZE * (MAX - p2.y);
		int p3X = START_X + SIZE * p3.x;
		int p3Y = START_Y + SIZE * (MAX - p3.y);
		int p4X = START_X + SIZE * p4.x;
		int p4Y = START_Y + SIZE * (MAX - p4.y);
		g.drawLine(p1X, p1Y, p2X, p2Y);
		g.drawLine(p2X, p2Y, p3X, p3Y);
		g.drawLine(p3X, p3Y, p4X, p4Y);
		g.drawLine(p4X, p4Y, p1X, p1Y);
		
		g.fillOval(p1X - RADIUS, p1Y - RADIUS, 2 * RADIUS, 2 * RADIUS);
		g.fillOval(p2X - RADIUS, p2Y - RADIUS, 2 * RADIUS, 2 * RADIUS);
		g.fillOval(p3X - RADIUS, p3Y - RADIUS, 2 * RADIUS, 2 * RADIUS);
		g.fillOval(p4X - RADIUS, p4Y - RADIUS, 2 * RADIUS, 2 * RADIUS);
	}
	
	public static void main (String[] args) {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 10);
		Point p3 = new Point(10, 10);
		Point p4 = new Point(10, 0);
		drawShape(p1,p2,p3,p4);
		
		p1 = new Point(1, 1);
		p2 = new Point(1, 2);
		p3 = new Point(3, 2);
		p4 = new Point(3, 1);
		drawShape(p1,p2,p3,p4);
		p1 = new Point(1, 1);
		p2 = new Point(2, 2);
		p3 = new Point(4, 2);
		p4 = new Point(3, 1);
		drawShape(p1,p2,p3,p4);
		p1 = new Point(1, 1);
		p2 = new Point(2, 2);
		p3 = new Point(4, 2);
		p4 = new Point(5, 1);
		drawShape(p1,p2,p3,p4);
	}
}
