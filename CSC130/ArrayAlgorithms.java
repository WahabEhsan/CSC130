
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This program contains Algorithms for single and multi dimension Arrays.
 *
 * @author WahabEhsan
 */
public class ArrayAlgorithms {

    /**
     * Main method runs fillRandom and then passes array into incrementAll
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] data = fillRandom(10, 4);
        incrementAll(data);
        System.out.println(Arrays.toString(data));
        swap(data,5,2);
        System.out.println(Arrays.toString(data));
    }

    public static void swap2(int[] A, int first, int second){
        int temp;
        temp = A[first];
        A[first] = A[second];
        A[second] = temp;
    }
    /**
     * This program asks for a double to fill in array
     *
     * @param length The length of the array
     * @return array filled with random doubles
     */
    public static double[] getDoubleArray(int length) {
        double[] array = new double[length];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.print("Double ? ");
            while (!in.hasNextDouble()) {
                System.out.println("Not a double");
                System.out.print("Double ?");
            }
            array[i] = in.nextDouble();
        }
        return array;
    }

    /**
     * Fills the specified array with random values between 0 and the multiplier
     * - 1 (i.e. between [0, multiplier))
     *
     * @param length the length of the array
     * @param multiplier value to multiply Math.random by to fill the array
     * @return the array of random values
     */
    public static int[] fillRandom(int length, int multiplier) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            int random = (int) (Math.random() * multiplier);
            array[i] = random;
        }

        return array;
    }

    /**
     * Reads each value in array and increments by one
     *
     * @param data the array that is passed in
     */
    public static void incrementAll(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i]++;
        }
    }

    /**
     * Reads the array and adds up the array into a string
     *
     * @param data the array that is passed in
     * @return the line of array content
     */
    public static String printArray(int[] data) {
        String line = "";
        for (int i = 0; i < data.length; i++) {
            line += data[i] + " ";
        }
        return line;
    }

    /**
     * Uses print stream to print the array
     * 
     * @param data the array that is passed in
     * @param out The print stream that prints content in the file
     */
    public static void printArray(int[] data, PrintStream out) {
        String line = "";
        for (int i = 0; i < data.length; i++) {
            line += "" + data[i];
        }
        out.println(line);
    }

    /**
     * Finds the last index value in the array
     * 
     * @param data the array that is passed in
     * @param value the value for index that we are lookin for
     * @return the last index of the value
     */
    public static int lastIndexOf(int[] data, int value) {
        int index = -1;
        int count = 0;
        int biggest = 0;
        for (int i = 0; i < data.length; i++) {
            if (value == data[i]) {
                count++;
                if(count > biggest){
                    biggest = count;
                    index = i;
                }
            }
            
        }
        return index;
    }

    /**
     * Finds the range from the array
     *
     * @param data the array that is passed in
     * @return the range of the array
     */
    public static int range(int[] data) {
        int range = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
            if (data[i] < min) {
                min = data[i];
            }
        }
        range = max - min;
        return range;
    }

    /**
     * Counts the numbers between the min and max provided
     * 
     * @param data the array that is passed in
     * @param min the min value of range
     * @param max the max value of range
     * @return the count of elements between min and max
     */
    public static int countInRange(int[] data, int min, int max) {
        int elements = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= min && data[i] <= max) {
                elements++;
            }
        }
        return elements;
    }

    /**
     * This program reads the array and counts the value instances
     *
     * @param data the array that is passed in
     * @param value the value trying to find
     * @return the number of times the value is in the array
     */
    public static int countInstances(int[] data, int value) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                count++;
            }
        }
        return count;
    }

    /**
     * REads array to find index of value
     *
     * @param data the array that is passed in
     * @param value the value the index has
     * @return the index value
     */
    public static int indexOf(int[] data, int value) {
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Find the index of the first instance of a value starting at the specified index
     * 
     * @param data the array that is passed in
     * @param searchVal The index value after the startIndex is indicated
     * @param startIndex Sets this index value to start from
     * @return the value of index after starting from startIndex
     */
    public static int nextIndexOf(int[] data, int searchVal, int startIndex) {
        int value = 0;
        for (int i = 0; i < data.length; i++) {
            if (i == startIndex) {
                value = data[startIndex + searchVal];
            }
        }
        return value;
    }

    /**
     * Reads the array and finds the value then replaces it
     *
     * @param data the array that is passed in
     * @param searchVal The value that is needed to be find
     * @param newVal new value that is going to be replaced
     */
    public static void replaceAll(int[] data, int searchVal, int newVal) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == searchVal) {
                data[i] = newVal;
            }
        }
    }

    /**
     * This method swaps two values in an array
     *
     * @param data the array that is passed in
     * @param firstIndex the first index that is going to swap
     * @param secondIndex second index to be swapped
     */
    public static void swap(int[] data, int firstIndex, int secondIndex) {
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < data.length; i++) {
            if (i == firstIndex) {
                temp1 = data[i];
            }
            if (i == secondIndex) {
                temp2 = data[i];
                data[i] = temp1;
            }
        }
        for (int i = 0; i < data.length; i++) {
            if (i == firstIndex) {
                data[i] = temp2;
            }
        }
    }

    /**
     * Reads and reverses the array
     *
     * @param data the array that is passed in
     */
    public static void reverse(int[] data) {
        for (int i = 0; i < data.length / 2; i++) {
            int temp = data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = temp;
        }
    }

    /**
     * Rotates all the values in the array to the right
     *
     * @param data
     */
    public static void rotateRight(int[] data) {
        int temp = 0;
        for (int i = 0; i < data.length; i++) {
            data[i + 1] = temp;
            data[i] = data[i + 1];
            if(i == data.length - 1){
                data[0] = data[i];
            }
        }
    }

    /**
     * This program tells if two arrays equal
     *
     * @param data1 the first array that is passed in
     * @param data2 the second array that is passed in
     * @return boolean value for equal or not
     */
    public static boolean arraysEqual(int[] data1, int[] data2) {
        if (data1.length != data2.length) {
            return false;
        }
        for (int i = 0; i < data1.length; i++) {
            if (data1[i] != data2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * Tells if array sorted the array
     *
     * @param data the array that is passed in
     * @return the value of boolean for array if sorted or not
     */
    public static boolean isSorted(double[] data) {
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (!(data[i] > min)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Puts together both arrays
     *
     * @param data1 the first array that is passed in
     * @param data2 the second array that is passed in
     * @return
     */
    public static int[] append(int[] data1, int[] data2) {
        int[] array = new int[data1.length + data2.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < data1.length; j++) {
                array[i] = data1[j];
                array[i + data1.length] = data2[j];
            }
        }
        return array;
    }

    /**
     * Finds the mode in the array
     *
     * @param data the array that is passed in
     * @return the value of mode
     */
    public static int mode(int data[]) {
        int mode = 0;
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < data.length; ++i) {
            int count = 0;
            for (int j = 0; j < data.length; ++j) {
                if (data[j] == data[i]) {
                    ++count;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode = data[i];
            }
        }

        return mode;
    }

    /**
     * Finds the element which is appropriate for k
     * Sorts the array first so easy to find k value.
     *
     * @param data the array that is passed in
     * @param k value of number that element is at
     * @return the number value of largest element
     */
    public static int kthLargest(int[] data, int k) {
        int kValue = 0;
        int[] temp = new int[data.length];
        /*for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data.length; j++) {
        if (data[i] > data[j]) {
        data[i] = temp;
        data[i] = data[j];
        data[j] = temp;
        }
        }
        
        }*/
        Arrays.sort(data);
        for (int i = data.length - 1; i >= 0; i--){
           for (int j = 0; j < data.length; j++) {
               temp[j] = data[i];
           }
                           
        }
        kValue = temp[k];
        return kValue;
    }

    /**
     * Finds the longest sorted sequence and returns the length
     *
     * @param data the array that is passed in
     * @return the integer value of length
     */
    public static int longestSortedSequence(int[] data) {
        int longest = 1;
        int count = 1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] <= data[i + 1]) {
                count++;
            }
            if (data[i] > data[i + 1]) {
                count = 1;
            }
            if (count < longest) {
                longest = count;
            }
        }
        return longest;
    }

    /**
     * Puts the array together into a string
     *
     * @param grid the array that is passed in
     * @return the string value of array
     */
    public static String print(double[][] grid) {
        String output = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                output += grid[i][j] + " ";
            }
            output += "\n";
        }
        return output;
    }

    /**
     * Prints multi dimension array with PrintStream
     * @param grid the array that is passed in
     * @param out PrintStream that is going to be printed on
     */
    public static void print(double[][] grid, PrintStream out) {
        String output = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                output += grid[i][j] + " ";
            }
            output += "\n";
        }
        out.println(output);
    }

    /**
     * Checks if the 3d array is equal to one another
     *
     * @param grid1 the first array that is passed in
     * @param grid2 the second array that is passed in
     * @return boolean value of true if equal and false if not
     */
    public static boolean arrayEqual(double[][] grid1, double[][] grid2) {
        int grid1Count = 0;
        int grid2Count = 0;

        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                grid1Count++;
            }
        }
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                grid2Count++;

            }
        }
        if (grid1Count != grid2Count) {
            return false;
        } else {
            for (int i = 0; i < grid1.length; i++) {
                for (int j = 0; j < grid1[0].length; j++) {
                    if (grid1[i][j] != grid2[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
