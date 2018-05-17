
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This Test is for Cipher.java and it test inputs for the file
 *
 * @author WahabEhsan
 */

public class CipherTest {

    /**
     * Variable for new line.
     */
    public static final String NEWLINE = System.getProperty("line.separator");

    private static final String taleOriginal = "It was the best of times," + NEWLINE
            + "it was the worst of times," + NEWLINE
            + "it was the age of wisdom," + NEWLINE
            + "it was the age of foolishness," + NEWLINE
            + "it was the epoch of belief," + NEWLINE
            + "it was the epoch of incredulity," + NEWLINE
            + "it was the season of Light," + NEWLINE
            + "it was the season of Darkness," + NEWLINE
            + "it was the spring of hope," + NEWLINE
            + "it was the winter of despair, ...";
    private static final String taleEncrypted = "Nn jfm gmy ojmg tz gngrx," + NEWLINE
            + "nn jfm gmy jtlfy is yczjm," + NEWLINE
            + "nn jfm gmy nly bk qvxxbr," + NEWLINE
            + "nn jfm gmy nly bk zbtfvxbajmf," + NEWLINE
            + "nn jfm gmy ruipm is gyynys," + NEWLINE
            + "nn jfm gmy ruipm is nhpwyqzfvys," + NEWLINE
            + "nn jfm gmy fjufth bk Fvlbg," + NEWLINE
            + "nn jfm gmy fjufth bk Xnweajmf," + NEWLINE
            + "nn jfm gmy fulvsa bk bbuy," + NEWLINE
            + "nn jfm gmy jnhgjl bk xrxjnnl, ...";

    /**
     * Checks getKey for valid key input.
     */
    @Test
    public void testGetKeyWithValidKey() {
        Scanner console = new Scanner("validkey");
        String expResult = "validkey";
        String result = Cipher.getKey(console);
        assertEquals(expResult, result);
    }

    /**
     * Checks getKey for invalid key input.
     */
    @Test
    public void testGetKeyWithInvalidKeyFirst() {
        Scanner console = new Scanner("invalidKey" + NEWLINE + "validkey");
        String expResult = "validkey";
        String result = Cipher.getKey(console);
        assertEquals(expResult, result);
    }

    /**
     * Checks getKey for invalid key as number input.
     */
    @Test
    public void testGetKeyWithNumericKeysFirst() {
        Scanner console = new Scanner("2" + NEWLINE + "validkey");
        String expResult = "validkey";
        String result = Cipher.getKey(console);
        assertEquals(expResult, result);
    }

    /**
     * Checks getKey for invalid key as empty input.
     */
    @Test
    public void testGetKeyWithEmptyKeysFirst() {
        Scanner console = new Scanner("" + NEWLINE + "validkey");
        String expResult = "validkey";
        String result = Cipher.getKey(console);
        assertEquals(expResult, result);
    }

    /**
     * Checks getKey for invalid key as spaces in input.
     */
    @Test
    public void testGetKeyWithKeyWithSpaces() {
        Scanner console = new Scanner(" " + NEWLINE + "validkey");
        String expResult = "validkey";
        String result = Cipher.getKey(console);
        assertEquals(expResult, result);
    }

    /**
     * Checks getKey for invalid key as Unicode input.
     */
    @Test
    public void testGetKeyWithUnicodeKeysFirst() {
        Scanner console = new Scanner("\u00DF" + NEWLINE + "validkey");
        String expResult = "validkey";
        String result = Cipher.getKey(console);
        assertEquals(expResult, result);
    }

    /**
     * Checks getKey for invalid key as capital letters input.
     */
    @Test
    public void testGetKeyWithCapitalLetter() {
        Scanner console = new Scanner("Hi" + NEWLINE + "validkey");
        String expResult = "validkey";
        String result = Cipher.getKey(console);
        assertEquals(expResult, result);
    }

    /**
     * Checks getKey for invalid key as space in middle as input.
     */
    @Test
    public void testGetKeyWithSpaceInMiddle() {
        Scanner console = new Scanner("hi bro" + NEWLINE + "validkey");
        String expResult = "validkey";
        String result = Cipher.getKey(console);
        assertEquals(expResult, result);
    }

    /**
     * Test for input as valid file.
     */
    @Test
    public void testGetInputScannerWithValidFile() {
        String goodFileName = "TaleOfTwoCities.txt";
        File goodFile = new File(goodFileName);
        Scanner mockConsole = null;

        if (goodFile.exists()) {
            mockConsole = new Scanner(goodFileName); //this will act like the user input
            Scanner fileScanner = Cipher.getInputScanner(mockConsole);
            Scanner taleScanner = new Scanner(taleOriginal);
            assertEquals(fileScanner.nextLine(), taleScanner.nextLine()); //this isn't an exhaustive test, but is a start
        }
    }

    /**
     * Test for input as invalid file.
     */
    @Test
    public void testGetInputScannerWithInvalidFilesFirst() {
        String goodFileName = "TaleOfTwoCities.txt";
        String badFileName = "aux.txt"; //anything with AUX or PRN is not allowed in filenames on Windows systems. It's a relatively safe bet that a file with this name will not exist on most systems.
        File goodFile = new File(goodFileName);
        Scanner mockConsole = null;

        if (goodFile.exists()) {
            mockConsole = new Scanner(badFileName + NEWLINE + goodFileName); //this will act like the user input
            Scanner fileScanner = Cipher.getInputScanner(mockConsole);
            Scanner taleScanner = new Scanner(taleOriginal);
            assertEquals(fileScanner.nextLine(), taleScanner.nextLine());
        }
    }

    /**
     * Processes encryption in proccesFile method with EncrpytTale.
     */
    @Test
    public void testProcessFileEncryptTale() {
        String key = "fun";
        Scanner input = new Scanner(taleOriginal);
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(byteOutStream);
        Cipher.processFile(true, key, input, output);
        String allWrittenLines = byteOutStream.toString();
        assertTrue(allWrittenLines.contains(taleEncrypted));
    }

    /**
     * Processes decryption in proccesFile method with EncrpytTale.
     */
    @Test
    public void testProcessFileDecryptTale() {
        String key = "fun";
        Scanner input = new Scanner(taleEncrypted);
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(byteOutStream);
        Cipher.processFile(false, key, input, output);
        String allWrittenLines = byteOutStream.toString();
        assertTrue(allWrittenLines.contains(taleOriginal));
    }

    /**
     * Test input with numbers and has key as cats.
     */
    @Test
    public void testEncryptLine1() {
        String expected = "Oexl ct 102 Xdo Sm.";
        assertEquals(expected, Cipher.encryptLine("cats", "Meet at 102 Elm St."));
    }

    /**
     * Test input with passage from encrypt tales with new lines and has key as
     * fun.
     */
    @Test
    public void testEncryptLine2() {
        String input = "It was the best of times," + NEWLINE
                + "it was the worst of times," + NEWLINE;
        String expected = "Nn jfm gmy ojmg tz gngrx," + NEWLINE
                + "nn jfm gmy jtlfy is yczjm," + NEWLINE;
        String actual = Cipher.encryptLine("fun", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with random words and has key as "bbb" for making sure all
     * chars move same.
     */
    @Test
    public void testEncryptLine3() {
        String input = "Hello human";
        String expected = "Ifmmp ivnbo";
        String actual = Cipher.encryptLine("bbb", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with words with symbols and has key as cool.
     */
    @Test
    public void testEncryptLine4() {
        String input = "T!h@i#s i$s c%o^o*l";
        String expected = "V!v@w#d k$g q%z^q*z";
        String actual = Cipher.encryptLine("cool", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with spaces and has key as wow.
     */
    @Test
    public void testEncryptLine5() {
        String input = "   Woa h";
        String expected = "   Scw d";
        String actual = Cipher.encryptLine("wow", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with capital letters and has key as grade.
     */
    @Test
    public void testEncryptLine6() {
        String input = "I JuST wAnT aN A";
        String expected = "O AuVX cRnW eT R";
        String actual = Cipher.encryptLine("grade", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with symbols only and has key as fun.
     */
    @Test
    public void testEncryptLine7() {
        String input = "!/////\\\\\\\\\\!";
        String expected = "!/////\\\\\\\\\\!";
        String actual = Cipher.encryptLine("fun", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with numbers and has key as cats.
     */
    @Test
    public void testDecryptLine1() {
        String expected = "Meet at 102 Elm St.";
        assertEquals(expected, Cipher.decryptLine("cats", "Oexl ct 102 Xdo Sm."));
    }

    /**
     * Test input with passage from encrypt tales with new lines and has key as
     * fun.
     */
    @Test
    public void testDecryptLine2() {
        String input = "Nn jfm gmy ojmg tz gngrx," + NEWLINE
                + "nn jfm gmy jtlfy is yczjm," + NEWLINE;
        String expected = "It was the best of times," + NEWLINE
                + "it was the worst of times," + NEWLINE;
        String actual = Cipher.decryptLine("fun", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with random words and has key as "bbb" for making sure all
     * chars move same.
     */
    @Test
    public void testDecryptLine3() {
        String input = "Ifmmp ivnbo";
        String expected = "Hello human";
        String actual = Cipher.decryptLine("bbb", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with words with symbols and has key as cool.
     */
    @Test
    public void testDecryptLine4() {
        String input = "V!v@w#d k$g q%z^q*z";
        String expected = "T!h@i#s i$s c%o^o*l";
        String actual = Cipher.decryptLine("cool", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with spaces and has key as wow.
     */
    @Test
    public void testDecryptLine5() {
        String input = "   Scw d";
        String expected = "   Woa h";
        String actual = Cipher.decryptLine("wow", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with capital letters and has key as grade.
     */
    @Test
    public void testDecryptLine6() {
        String input = "O AuVX cRnW eT R";
        String expected = "I JuST wAnT aN A";
        String actual = Cipher.decryptLine("grade", input);
        assertEquals(expected, actual);
    }

    /**
     * Test input with symbols only and has key as fun.
     */
    @Test
    public void tesDecryptLine7() {
        String input = "!/////\\\\\\\\\\!";
        String expected = "!/////\\\\\\\\\\!";
        String actual = Cipher.decryptLine("fun", input);
        assertEquals(expected, actual);
    }
}
