import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Launch {

	public static boolean EmptyLine(String line) {
		return line.length() <= 1;
	}

	public static String getName(String line) {
		line = line.substring(0,line.indexOf('.'));
		try {
			line = line.substring(0,line.lastIndexOf(" "));
		}
		catch (StringIndexOutOfBoundsException siobe) {
			System.out.println(line+" failed to convert!");
		}
		return line;
	}

	public static int NumDefs(String line) {
		int num = 0, n = 0;
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			try {
				num = Integer.parseInt(String.valueOf(c));
				n++;
			}
			catch (NumberFormatException nfe) {
				System.out.print("");
			}
		}
		return Math.max(n, 1);
	}

	public static int getNextNumberIndex(String line, int pos) {
		for (int i = pos; i < line.length(); i++) {
			try {
				int num = Integer.parseInt(String.valueOf(line.charAt(i)));
				return i;
			}
			catch (NumberFormatException nfe) {
				System.out.print("");
			}
		}
		return line.length() - 1;
	}

	public static String getDef(int t, String line) {
		if (NumDefs(line) == 1) {
			try {
				line = line.substring(line.indexOf('.')+1,line.indexOf('['));
			}
			catch (StringIndexOutOfBoundsException siobe) {
				line = line.substring(line.indexOf('.')+1);
			}
		}
		else {
			String target = Integer.toString(t);
			line = line.substring(line.indexOf(target)+1,getNextNumberIndex(line,line.indexOf(target)+1));
		}
		return line;
	}

	public static void main(String[] args) throws Exception {

		HashTable Dictionary = new HashTable(72320);

		File dic = new File("dic.txt");
		Scanner reader = new Scanner(dic);

		while (reader.hasNextLine()) {
			String data = reader.nextLine();
			if (!EmptyLine(data)) {
				for (int i = 1; i < NumDefs(data); i++) {
					Dictionary.Insert(getName(data),getDef(i,data));
				}
			}
		}

		reader.close();

		// Menu
		Scanner kb = new Scanner(System.in);
		int choice;
		String word;
		do {
			System.out.println("----------Dictionary Menu----------");
			System.out.println("0 - Exit");
			System.out.println("1 - Word Lookup");
			System.out.println("2 - Add an entry");
			System.out.println("3 - Remove an entry");
			System.out.println("4 - Edit an entry");
			System.out.println("-----------------------------------");
			System.out.println("Enter your choice:");

			try {
				choice = Integer.parseInt(kb.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("Incorrect input! Try again.");
				choice = 5;
			}

			switch (choice) {
				case 1:
					System.out.println("Enter a word to look up.");
					word = kb.nextLine();
					Dictionary.Lookup(word);
					break;
				case 2:
					System.out.println("Enter a word and entry to add.");
					break;
				case 3:
					System.out.println("Enter a word to remove.");
					break;
				case 4:
					System.out.println("Enter a word to edit.");
			}

		} while(choice != 0);

	}
}
