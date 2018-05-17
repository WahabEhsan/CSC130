
import java.util.Scanner;
import java.awt.*;

/**
 * This program asks for four points and tells whether its square, rectangle,
 * kite, etc also pops up graph if points between 0 and 10.
 *
 * @author WahabEhsan
 */
public class Quadrilateral {

    /**
     * Main method prints the intro and runs the interFace method
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("\t\t\tQuadrilateral Program");
        System.out.println("Enter the integer x, y coordinates for 4 points that form a simple\n"
                + "quadrilateral, where Point 1 is connected to Point 2, Point 2 is\n"
                + "connected to Point 3, Point 3 is connected to Point 4, and Point 4\n"
                + "is connected to Point 1. This program will tell you if the Quadrilateral is\n"
                + "a Square, Rectangle, Parallelogram, Kite, Rhombus or Other shape.\n"
                + "If all x,y coordinates are between 0 and 10, your shape will be displayed!\n");

        userInterface();

    }

    /**
     * Prompts the user for x and y for four points, then makes a point object
     * for each point also if points between 0 and 10, makes a graph pop up.
     */
    public static void userInterface() {

        Scanner input = new Scanner(System.in);

        System.out.print("Point 1 x y: ");
        handling(input); //Runs method to see if input valid
        int x1 = input.nextInt();
        handling(input);//Runs method to see if input valid
        int y1 = input.nextInt();
        Point p1 = new Point(x1, y1);
        System.out.print("Point 2 x y: ");
        handling(input);//Runs method to see if input valid
        int x2 = input.nextInt();
        handling(input);//Runs method to see if input valid
        int y2 = input.nextInt();
        Point p2 = new Point(x2, y2);
        System.out.print("Point 3 x y: ");
        handling(input);//Runs method to see if input valid
        int x3 = input.nextInt();
        handling(input);//Runs method to see if input valid
        int y3 = input.nextInt();
        Point p3 = new Point(x3, y3);
        System.out.print("Point 4 x y: ");
        handling(input);//Runs method to see if input valid
        int x4 = input.nextInt();
        handling(input);//Runs method to see if input valid
        int y4 = input.nextInt();
        Point p4 = new Point(x4, y4);

        if (x1 <= MAX && x2 <= MAX && x3 <= MAX && x4 <= MAX
                && y1 <= MAX && y2 <= MAX && y3 <= MAX && y4 <= MAX
                && x1 >= MIN && x2 >= MIN && x3 >= MIN && x4 >= MIN
                && y1 >= MIN && y2 >= MIN && y3 >= MIN && y4 >= MIN) {
            Drawing.drawShape(p1, p2, p3, p4);
        } //if points greater than 10 or less then 0, doesn't bring up graph
        //Every point has its separate statement

        process(p1, p2, p3, p4); //calls the process method which prints the shape

    }
    /**
     * Max value of point for graph to be displayed
     */
    public static final int MAX = 10;
    /**
     * Min value of point for graph to be displayed
     */
    public static final int MIN = 0;

    /**
     * Prints the type of shape after getting feed back from a method that
     * corresponds
     *
     * @param p1 Point one
     * @param p2 Point two
     * @param p3 Point three
     * @param p4 Point four
     */
    public static void process(Point p1, Point p2, Point p3, Point p4) {
        if (isSquare(p1, p2, p3, p4)) {
            System.out.println("\nSqaure"); //Prints Square if returned true
        } else if (isRhombus(p1, p2, p3, p4)) {
            System.out.println("\nRhombus");//Prints rhombus if returned true
        } else if (isRectangle(p1, p2, p3, p4)) {
            System.out.println("\nRectangle");//Prints rectangle if returned true
        } else if (isParallelogram(p1, p2, p3, p4)) {
            System.out.println("\nParallelogram");//Prints parallelogram if returned true
        } else if (isKite(p1, p2, p3, p4)) {
            System.out.println("\nKite");//Prints kite if returned true
        } else {
            System.out.println("\nOther");//Prints other if not met any other method
        }
    }

    /**
     * If input not integer, re-prompts the user
     *
     * @param input Scanner input from main method
     */
    public static void handling(Scanner input) {

        while (!input.hasNextInt()) { //Shows "Invalid point" until user enters right point
            System.out.print("Invalid Point: ");
            input.next();
        }
    }

    /**
     * Distance Formula that finds out the distance between two points
     *
     * @param xa X one
     * @param ya Y one
     * @param xb X two
     * @param yb Y two
     * @return distance
     */
    public static double distanceFormula(int xa, int ya, int xb, int yb) {

        double x = Math.pow(xa - xb, 2); // X one minus X two squared
        double y = Math.pow(ya - yb, 2);// Y one minus Y two squared
        double distance = Math.sqrt(x + y);//taking sqareroot of the addition of x and y

        return distance;
    }

    /**
     * Tells whether the points make a right angle
     *
     * @param a Point starting angle
     * @param b Point in the middle of angle
     * @param c Point at the end of angle
     * @return value of boolean depending on angle
     */
    public static boolean isRightAngle(Point a, Point b, Point c) {
        double product = (b.x - a.x) * (c.x - b.x) + (b.y - a.y) * (c.y - b.y);
        if (product == 0) { //if dot poduct is 0, return true for right angle
            return true;
        }
        return false;
    }

    /**
     * Checks to see if points make a parallelogram
     *
     * @param p1 Point one
     * @param p2 Point two
     * @param p3 Point three
     * @param p4 Point four
     * @return value of boolean depending whether parallelogram or not
     */
    public static boolean isParallelogram(Point p1, Point p2, Point p3, Point p4) {
        double distance1and2 = distanceFormula(p1.x, p1.y, p2.x, p2.y);
        double distance1and4 = distanceFormula(p1.x, p1.y, p4.x, p4.y);
        double distance2and3 = distanceFormula(p2.x, p2.y, p3.x, p3.y);
        double distance3and4 = distanceFormula(p3.x, p3.y, p4.x, p4.y);
        //Calls Distanceformula method with each parameters that are valid and possible  

        if ((distance1and2 == distance3and4) && (distance2and3 == distance1and4)) {
            return true;
        } //if side a and b are equal, and c and d are equal, returns true
        return false;
    }

    /**
     * Checks to see if points make a rectangle
     *
     * @param p1 Point one
     * @param p2 Point two
     * @param p3 Point three
     * @param p4 Point four
     * @return value of boolean depending whether rectangle or not
     */
    public static boolean isRectangle(Point p1, Point p2, Point p3, Point p4) {
        if (isRightAngle(p1, p2, p3)
                && isRightAngle(p2, p3, p4)
                && isRightAngle(p3, p4, p1)
                && isRightAngle(p4, p1, p2)) {
            return true;
        }//returns true if all the angles are right angles
        return false;
    }

    /**
     * Checks to see if points make a square
     *
     * @param p1 Point one
     * @param p2 Point two
     * @param p3 Point three
     * @param p4 Point four
     * @return value of boolean depending whether square or not
     */
    public static boolean isSquare(Point p1, Point p2, Point p3, Point p4) {
        double distance1and2 = distanceFormula(p1.x, p1.y, p2.x, p2.y);
        double distance1and4 = distanceFormula(p1.x, p1.y, p4.x, p4.y);
        double distance2and3 = distanceFormula(p2.x, p2.y, p3.x, p3.y);
        double distance3and4 = distanceFormula(p3.x, p3.y, p4.x, p4.y);
        //Calls Distanceformula method with each parameters that are valid and possible  

        if (distance1and2 == distance2and3
                && distance3and4 == distance1and4
                && distance1and2 == distance3and4
                && distance2and3 == distance1and4
                && distance1and2 == distance1and4
                && distance2and3 == distance3and4) {

            if (isRightAngle(p1, p2, p3)
                    && isRightAngle(p2, p3, p4)
                    && isRightAngle(p3, p4, p1)) {
                return true;
            }
        }//returns true if all sides equal and all right angles
        return false;
    }

    /**
     * Checks to see if points make a rhombus
     *
     * @param p1 Point one
     * @param p2 Point two
     * @param p3 Point three
     * @param p4 Point four
     * @return value of boolean depending whether rhombus or not
     */
    public static boolean isRhombus(Point p1, Point p2, Point p3, Point p4) {
        double distance1and2 = distanceFormula(p1.x, p1.y, p2.x, p2.y);
        double distance1and4 = distanceFormula(p1.x, p1.y, p4.x, p4.y);
        double distance2and3 = distanceFormula(p2.x, p2.y, p3.x, p3.y);
        double distance3and4 = distanceFormula(p3.x, p3.y, p4.x, p4.y);
        //Calls Distanceformula method with each parameters that are valid and possible  

        if (distance1and2 == distance2and3
                && distance3and4 == distance1and4
                && distance1and2 == distance3and4
                && distance2and3 == distance1and4
                && distance1and2 == distance1and4
                && distance2and3 == distance3and4) {
            return true;

        }//returns true if only all sides equal true
        return false;
    }

    /**
     * Checks to see if points make a kite
     *
     * @param p1 Point one
     * @param p2 Point two
     * @param p3 Point three
     * @param p4 Point four
     * @return value of boolean depending whether kite or not
     */
    public static boolean isKite(Point p1, Point p2, Point p3, Point p4) {

        double distance1and2 = distanceFormula(p1.x, p1.y, p2.x, p2.y);
        double distance2and3 = distanceFormula(p2.x, p2.y, p3.x, p3.y);
        double distance3and4 = distanceFormula(p3.x, p3.y, p4.x, p4.y);
        double distance1and4 = distanceFormula(p1.x, p1.y, p4.x, p4.y);
        //Calls Distanceformula method with each parameters that are valid and possible  

        if ((distance1and2 == distance2and3
                && distance3and4 == distance1and4) || (distance3and4 == distance2and3
                && distance1and2 == distance1and4)) {
            return true;
        } //returns true only if two sides are equal to to other sides

        return false;
    }
}
