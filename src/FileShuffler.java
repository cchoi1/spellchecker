import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileShuffler {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("dictionary.txt"));
		ArrayList<String> words = new ArrayList<String>(110000);
		while (scan.hasNext()) {
			words.add(scan.next());
		}
		scan.close();
		Collections.shuffle(words);
		PrintWriter pw = new PrintWriter("shuffleddictionary.txt");
		for (String word : words)
			pw.println(word);
		pw.close();

	}
}
