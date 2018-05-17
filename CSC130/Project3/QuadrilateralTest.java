/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the Java JUnit test for Quadrilateral.java
 *
 * @author WahabEhsan
 */
public class QuadrilateralTest {

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    /**
     * Initialize the four points with a square
     */
    private void initPointsWithSquare() {
        //Square
        p1 = new Point(1, 1);
        p2 = new Point(1, 2);
        p3 = new Point(2, 2);
        p4 = new Point(2, 1);
    }

    /**
     * Test isParallelogram with a square as input
     */
    @Test
    public void testIsParallelogramWithSquare() {
        initPointsWithSquare();

        assertEquals(true, Quadrilateral.isParallelogram(p1, p2, p3, p4));
    }

    /**
     * Test isRhombus with a square as input
     */
    @Test
    public void testIsRhombusWithSquare() {
        initPointsWithSquare();
        assertEquals(true, Quadrilateral.isRhombus(p1, p2, p3, p4));
    }

    /**
     * Test isKite with a square as input
     */
    @Test
    public void testIsKiteWithSquare() {
        initPointsWithSquare();
        assertEquals(true, Quadrilateral.isKite(p1, p2, p3, p4));
    }

    /**
     * Test isRectangle with a square as input
     */
    @Test
    public void testIsRectangleWithSquare() {
        initPointsWithSquare();
        assertEquals(true, Quadrilateral.isRectangle(p1, p2, p3, p4));
    }

    /**
     * Test isSquare with a square as input
     */
    @Test
    public void testIsSquareWithSquare() {
        initPointsWithSquare();
        assertEquals(true, Quadrilateral.isSquare(p1, p2, p3, p4));
    }

    //Rectangle - Add 5 testcases, one for each of the methods as shown above, for a quadrilateral 
    //            that is a Rectangle, but not a Square.
    /**
     * Test isRectanlge with parallelogram points
     */
    @Test
    public void testIsRectangleWithParallelogram() {
        Point p1 = new Point(2, 0);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(6, 6);
        Point p4 = new Point(6, 2);
        assertEquals(false, Quadrilateral.isRectangle(p1, p2, p3, p4));
    }

    /**
     * Test isRectanlge with rhombus points
     */
    @Test
    public void testIsRectangleWithRhombus() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(4, 3);
        assertEquals(false, Quadrilateral.isRectangle(p1, p2, p3, p4));
    }

    /**
     * Test isRectanlge with kite points
     */
    @Test
    public void testIsRectangleWithKite() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 1);
        Point p4 = new Point(1, 0);
        assertEquals(false, Quadrilateral.isRectangle(p1, p2, p3, p4));
    }

    /**
     * Test isRectanlge with rectangle points
     */
    @Test
    public void testIsRectangleWithRectangle() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(5, 4);
        Point p4 = new Point(5, 2);
        assertEquals(true, Quadrilateral.isRectangle(p1, p2, p3, p4));
    }

    /**
     * Test isRectanlge with other points
     */
    @Test
    public void testIsRectangleWithOther() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 1);
        Point p4 = new Point(5, 3);
        assertEquals(false, Quadrilateral.isRectangle(p1, p2, p3, p4));
    }

    //Parallelogram - Add 5 testcases, one for each of the methods as shown above, for a quadrilateral 
    //                that is a Parallelogram, but not a Rectangle.
    /**
     * Test isParallelogram with a other as input
     */
    @Test
    public void testIsParallelogramWithOther() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 1);
        Point p4 = new Point(5, 3);
        assertEquals(false, Quadrilateral.isParallelogram(p1, p2, p3, p4));
    }

    /**
     * Test isParallelogram with a Square as input
     */
    @Test
    public void testIsParallelogramSquare() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(1, 0);
        assertEquals(true, Quadrilateral.isParallelogram(p1, p2, p3, p4));
    }

    /**
     * Test isParallelogram with a Kite as input
     */
    @Test
    public void testIsParallelogramWithKite() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 1);
        Point p4 = new Point(1, 0);
        assertEquals(false, Quadrilateral.isParallelogram(p1, p2, p3, p4));
    }

    /**
     * Test isParallelogram with a Rhombus as input
     */
    @Test
    public void testIsParallelogramRhombus() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(4, 3);
        assertEquals(true, Quadrilateral.isParallelogram(p1, p2, p3, p4));
    }

    /**
     * Test isParallelogram with a Rectangle as input
     */
    @Test
    public void testIsParallelogramRectangle() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(5, 4);
        Point p4 = new Point(5, 2);
        assertEquals(true, Quadrilateral.isParallelogram(p1, p2, p3, p4));
    }

    //Rhombus - Add 5 testcases, one for each of the methods as shown above, for a quadrilateral  
    //          that is a Rhombus, but not a Square.
    /**
     * This isRhombus test with Rhombus input
     */
    @Test
    public void testIsRhombusWithRhombus() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(4, 3);
        assertEquals(true, Quadrilateral.isRhombus(p1, p2, p3, p4));
    }

    /**
     * This isRhombus test with kite input
     */
    @Test
    public void testIsRhombusWithKite() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 1);
        Point p4 = new Point(1, 0);
        assertEquals(false, Quadrilateral.isRhombus(p1, p2, p3, p4));
    }

    /**
     * This isRhombus test with parallelogram input
     */
    @Test
    public void testIsRhombusWithParallelogram() {
        Point p1 = new Point(2, 0);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(6, 6);
        Point p4 = new Point(6, 2);
        assertEquals(false, Quadrilateral.isRhombus(p1, p2, p3, p4));
    }

    /**
     * This isRhombus test with rectangle input
     */
    @Test
    public void testIsRhombusWithRectanlge() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(5, 4);
        Point p4 = new Point(5, 2);
        assertEquals(false, Quadrilateral.isRhombus(p1, p2, p3, p4));
    }

    /**
     * This isRhombus test with other input
     */
    @Test
    public void testIsRhombusWithOther() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 1);
        Point p4 = new Point(5, 3);
        assertEquals(false, Quadrilateral.isRhombus(p1, p2, p3, p4));
    }

    //Kite - Add 5 testcases, one for each of the methods as shown above, for a quadrilateral  
    //       that is a Kite, but not a Square.
    /**
     * Test of isKite with kite points
     */
    @Test
    public void testIsKiteWithKite() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 1);
        Point p4 = new Point(1, 0);
        assertEquals(true, Quadrilateral.isKite(p1, p2, p3, p4));
    }

    /**
     * Test of isKite with Rhombus points
     */
    @Test
    public void testIsKiteWithRhombus() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(4, 3);
        assertEquals(true, Quadrilateral.isKite(p1, p2, p3, p4));
    }

    /**
     * Test of isKite with rectangle points
     */
    @Test
    public void testIsKiteWithRectangle() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(5, 4);
        Point p4 = new Point(5, 2);
        assertEquals(false, Quadrilateral.isKite(p1, p2, p3, p4));
    }

    /**
     * Test of isKite with parallelogram points
     */
    @Test
    public void testIsKiteWithParallelogram() {
        Point p1 = new Point(2, 0);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(6, 6);
        Point p4 = new Point(6, 2);
        assertEquals(false, Quadrilateral.isKite(p1, p2, p3, p4));
    }

    /**
     * Test of isKite with other points
     */
    @Test
    public void testIsKiteWithOther() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 1);
        Point p4 = new Point(5, 3);
        assertEquals(false, Quadrilateral.isKite(p1, p2, p3, p4));
    }

    //Other - Add 5 testcases, one for each of the methods as shown above, for a quadrilateral  
    //        that is not a Kite nor a Parallelogram.
    /**
     * This test the isOther with square
     */
    @Test
    public void testIsOtherWithSquare() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(1, 0);
        assertEquals(true, Quadrilateral.isKite(p1, p2, p3, p4));
    }

    /**
     * This test the isOther with rectangle
     */
    @Test
    public void testIsOtherWithRectangle() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(5, 4);
        Point p4 = new Point(5, 2);
        assertEquals(false, Quadrilateral.isKite(p1, p2, p3, p4));
    }

    /**
     * This test the isOther with kite
     */
    @Test
    public void testIsOtherWithKite() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 1);
        Point p4 = new Point(1, 0);
        assertEquals(false, Quadrilateral.isSquare(p1, p2, p3, p4));
    }

    /**
     * This test the isOther with parallelogram
     */
    @Test
    public void testIsOtherWithParallelogram() {
        Point p1 = new Point(2, 0);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(6, 6);
        Point p4 = new Point(6, 2);
        assertEquals(false, Quadrilateral.isKite(p1, p2, p3, p4));
    }

    /**
     * This test the isOther with rhombus
     */
    @Test
    public void testIsOtherWithRhombus() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(4, 3);
        assertEquals(true, Quadrilateral.isKite(p1, p2, p3, p4));
    }

    /**
     * Test of isRightAngle method, with three points that form a right angle.
     */
    @Test
    public void testIsRightAngleWithValidRightAngle() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 2);
        assertEquals(true, Quadrilateral.isRightAngle(p1, p2, p3));
    }

    /**
     * Test of isRightAngle method, with three points that don't form a right
     * angle.
     */
    @Test
    public void testIsRightAngleWithInVvlidRightAngle() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 5);
        assertEquals(false, Quadrilateral.isRightAngle(p1, p2, p3));
    }
}
