import java.io.FileNotFoundException;

public class SpellcheckTester {
	public static void main(String args[]) {
		/* Implemented using Hash Set */
		System.out.println("Using a hash set \n");
		Runtime runtime = Runtime.getRuntime();
		long startMemory = runtime.totalMemory() - runtime.freeMemory();
		long startTime = System.currentTimeMillis();
		Spellchecker sc;
		try {
			sc = new Spellchecker("dictionary.txt", true);
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary is not in the right place; should not be in src folder.");
			return;
		}
		long postInitTime = System.currentTimeMillis();
		long endMemory = runtime.totalMemory() - runtime.freeMemory();
		long bytesUsed = endMemory - startMemory;
		String usedString;
		if (bytesUsed < 1000)
			usedString = bytesUsed + " bytes";
		else if (bytesUsed < 1000000) {
			double kbUsed = ((double) bytesUsed) / 1000.0;
			usedString = kbUsed + " KB";
		} else {
			double mbUsed = ((double) bytesUsed) / 1000000.0;
			usedString = mbUsed + " MB";
		}
		System.out.println("Total memory used for the dictionary: " + usedString);
		try {
			sc.findErrors("big.txt", "errors1.txt", true);
		} catch (FileNotFoundException e) {
			System.out.println("The big.txt is not in the right place; should not be in src folder.");
		}
		long postFindTime = System.currentTimeMillis();

		System.out.println("Total time used was " + (postFindTime - startTime) + " milliseconds.");
		System.out.println((postInitTime - startTime) + " milliseconds were used in preprocessing");
		System.out.println((postFindTime - postInitTime) + " milliseconds were used to find the errors");

		/* Implemented using BST */
		System.out.println("Using a binary search tree \n");
		sc = null;
		startMemory = runtime.totalMemory() - runtime.freeMemory();
		startTime = System.currentTimeMillis();
		try {
			sc = new Spellchecker("shuffleddictionary.txt", false);
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary is not in the right place; should not be in src folder.");
			return;
		}
		postInitTime = System.currentTimeMillis();
		endMemory = runtime.totalMemory() - runtime.freeMemory();
		bytesUsed = endMemory - startMemory;
		if (bytesUsed < 1000)
			usedString = bytesUsed + " bytes";
		else if (bytesUsed < 1000000) {
			double kbUsed = ((double) bytesUsed) / 1000.0;
			usedString = kbUsed + " KB";
		} else {
			double mbUsed = ((double) bytesUsed) / 1000000.0;
			usedString = mbUsed + " MB";
		}
		System.out.println("Total memory used for the dictionary: " + usedString);
		try {
			sc.findErrors("big.txt", "errors2.txt", false);
		} catch (FileNotFoundException e) {
			System.out.println("The big.txt is not in the right place; should not be in src folder.");
		}
		postFindTime = System.currentTimeMillis();

		System.out.println("Total time used was " + (postFindTime - startTime) + " milliseconds.");
		System.out.println((postInitTime - startTime) + " milliseconds were used in preprocessing");
		System.out.println((postFindTime - postInitTime) + " milliseconds were used to find the errors");
	}
}
