
import java.util.*;
import java.io.*;

/**
 * This program counts words, lines, and characters after scanning a file
 * @author WahabEhsan
 */
public class WordCount {

    /**
     * Calls userInterface method
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        userInterface();
    }

    /**
     * Searches and Scans file, also runs processFile method
     * @throws FileNotFoundException
     */
    public static void userInterface() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        File f;
        do {
            System.out.print("Please name a file: ");
            String file = in.nextLine();
            f = new File(file);

        } while (!f.exists());

        Scanner input = new Scanner(f);

        processFile(input);

    }

    /**
     * Processes the file and prints the answers
     * @param s Scanner that scans the file
     * @throws FileNotFoundException
     */
    public static void processFile(Scanner s) throws FileNotFoundException {

        int words = countWords(s);
        int characters = countCharacters(s);
        int lineCount = countLines(s);

        if (s.hasNextLine()) {
            lineCount++;
        }

        System.out.println("Words: " + words);
        System.out.println("Characters: " + characters);
        System.out.println("Lines: " + lineCount);

    }

    /**
     * Counts the words in a file.
     * @param s Scans the file
     * @return word cunt
     * @throws FileNotFoundException
     */
    public static int countWords(Scanner s) throws FileNotFoundException {

        int words = 0;

        if (s.hasNext()) {
            words++;
        }

        return words;
    }

    /**
     * This method counts the characters in the file.
     * @param s Scans the files
     * @return Character count
     * @throws FileNotFoundException
     */
    public static int countCharacters(Scanner s) throws FileNotFoundException {

        int characterCount = 0;

        while (s.hasNextByte()) {
            characterCount++;
        }
        return characterCount;
    }

    public static int countLines(Scanner s) throws FileNotFoundException {

        int lineCount = 0;
        if (s.hasNextLine()) {
            lineCount++;
        }
        return lineCount;
    }

}
