import java.io.*;
import java.util.*;

public class HoursWorking {

public static void main(String [] args) {
userInterface();
}

public static void userInterface() {
Scanner inputFile = getInputFileScanner();
PrintStream outputFile = getOutputFilePrintStream();
readFile(inputFile, outputFile);
}

public static Scanner getInputFileScanner() {
Scanner console = new Scanner(System.in);
Scanner inputFile = null;
while (inputFile == null) {
System.out.println("File Name? ");
String name = console.nextLine();
try {
inputFile = new Scanner(new File(name));
} catch (FileNotFoundException e) {
System.out.println("File not found.  Please try again");
}
}
return inputFile;
}

public static PrintStream getOutputFilePrintStream() {
Scanner console = new Scanner(System.in);
PrintStream outputFile = null;
while (outputFile == null) {
System.out.println("Output File Name? ");
String name = console.nextLine();
try {
outputFile = new PrintStream(new File(name));
} catch (FileNotFoundException e) {
System.out.println("File not created.  Please try again.");
}
}
return outputFile;
}

public static void readFile(Scanner inputFile, PrintStream outputFile) {
while (inputFile.hasNextLine()) {

processLine(inputFile.nextLine(), outputFile);
//         processLine(inputFile.nextLine(), System.out);
}
}

public static void processLine(String line, PrintStream output) {
Scanner input = new Scanner(line);
while (input.hasNext()) {
int id = input.nextInt();
String name = input.next();
double sum = 0.0;
while (input.hasNextDouble()) {
sum += input.nextDouble();
}
output.println("Hours worked by " + name + "(" + id + "): " + sum);
}
}
}
