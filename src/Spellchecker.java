import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Spellchecker<E> {
	HashSet spellChecker = new HashSet();
	MyBST spellChecker2 = new MyBST();

	public Spellchecker(String dictionaryFileName, boolean ds1) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(dictionaryFileName));
		scan.useDelimiter("[^a-zA-Z]*[^a-zA-Z']+[^a-zA-Z]*");
		if (ds1) {
			while (scan.hasNext()) {
				spellChecker.add(scan.next());
			}
		} else {
			while (scan.hasNext()) {
				spellChecker2.add(scan.next());
			}
		}
		scan.close();
	}

	// Searches the file given by textFileName for all spelling errors. Outputs
	// every word in the file that's not found in the dictionary to the file given
	// by outputFileName.
	public void findErrors(String textFileName, String outputFileName, boolean ds1) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(textFileName));
		scan.useDelimiter("[^a-zA-Z]*[^a-zA-Z']+[^a-zA-Z]*");
		if (ds1) {
			PrintWriter pw = new PrintWriter(outputFileName);
			while (scan.hasNext()) {
				String word = scan.next();
				if (!spellChecker.contains(word.toLowerCase())) {
					pw.println(word);
				}
			}
			pw.close();
		} else {
			PrintWriter pw = new PrintWriter(outputFileName);
			while (scan.hasNext()) {
				String word = scan.next();
				if (!spellChecker2.contains(word.toLowerCase())) {
					pw.println(word);
				}
			}
			pw.close();
		}
	}
}