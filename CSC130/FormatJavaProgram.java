
import java.io.*;
import java.util.*;

/**
 * Program that takes an unformatted Java program and prints out the same Java
 * program with proper indentation.
 *
 * @author WahabEhsan
 */
public class FormatJavaProgram {

    /**
     * Constant representing number of spaces to indent
     */
    public static final int NUM_SPACES = 4;

    /**
     * Starts the program
     *
     * @param args An array of command line arguments (not used)
     */
    public static void main(String[] args) {
        userInterface();
    }

    /**
     * Program's user interface.
     *
     */
    public static void userInterface() {
        //Create a console Scanner to interact with user
        Scanner console = new Scanner(System.in);

        //Get a Scanner that will read the input
        Scanner fileReader = getInputScanner(console);

        //Create a PrintStream based on the valid filename passed in by the user
        PrintStream fileWriter = getOutputPrintStream(console);

        processJavaFile(fileReader, fileWriter); //handle the formatting

        //close our readers and writers
        fileWriter.close();
        fileReader.close();
        console.close();
    }

    /**
     * Returns a Scanner for the specified file. The program will continue to
     * prompt the user for a file until a valid file is entered
     *
     * @param console console Scanner to process user's input
     * @return a Scanner to read the file
     */
    public static Scanner getInputScanner(Scanner console) {
        Scanner file = null;
        try {
            File f;
            do {
                System.out.print("Enter Java File to Format: ");
                String input = console.nextLine();
                f = new File(input);

            } while (!f.exists());
            file = new Scanner(f);

        } catch (FileNotFoundException ex) {
        }
        return file;
    }

    /**
     * Returns a PrintStream for the specified file. The program will continue
     * to prompt the user for a file that does not currently exist that can be
     * created.
     *
     * @param console console Scanner to process user's input
     * @return a PrintStream to print to the file.
     */
    public static PrintStream getOutputPrintStream(Scanner console) {
        File f;
        PrintStream file = null;
        while (file == null) {
            try {
                System.out.print("Enter Output file: ");
                String input = console.nextLine();
                f = new File(input);
                file = new PrintStream(f);
            } catch (FileNotFoundException ex) {
            }
        }

        return file;

    }

    /**
     * Processes a Java file and provides the proper indentation
     *
     * @param input the Java file to process
     * @param output the file to write the formated code to
     */
    public static void processJavaFile(Scanner input, PrintStream output) {
        int indentLevels = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine().trim(); //trim() cuts off leading and ending whitespace

            if (line.contains("}") && line.contains("{")) {//If line contains both { and } like a catch or else line
                output.println(getFormattedLine(line, indentLevels));

            } else if (line.contains("}")) {  //If the line only contains a closing bracket
                output.println(getFormattedLine(line, indentLevels));
                indentLevels--; //decrements by one

            } else if (line.contains("{")) { //If the line only contains an opening bracket
                indentLevels++;//increments by one
                if (line.contains("public class")) {//if has words "public class"
                    indentLevels--;//decrements by one
                }
                output.println(getFormattedLine(line, indentLevels));

            } else if (line.contains("import")) { //if line contains word "import", no action takes place 
                output.println((getFormattedLine(line, indentLevels)));

            } else {//all the rest are incremented first then decremented
                indentLevels++;//increments
                output.println((getFormattedLine(line, indentLevels)));
                indentLevels--;//decrements

            }
        }
    }

    /**
     * Returns a line of Java code formatted to the proper indentation
     *
     * @param line the line to format
     * @param indentLevels the number of levels of indentation
     * @return the formatted line
     */
    public static String getFormattedLine(String line, int indentLevels) {
        String formattedLine = "";
        for (int i = 0; i < indentLevels; i++) {
            for (int j = 0; j < NUM_SPACES; j++) {
                formattedLine += " ";
            }
        }
        formattedLine += line;
        return formattedLine;
    }

}
