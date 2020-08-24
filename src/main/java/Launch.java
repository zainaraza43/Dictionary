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
		String word, definition, newDef;
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

					System.out.println("Enter a word to look up:");
					word = kb.nextLine();
					Dictionary.Lookup(word);

					break;

				case 2:

					System.out.println("Enter a word to add the definition of:");
					word = kb.nextLine();
					word = Character.toString(word.charAt(0)).toUpperCase() + word.substring(1).toLowerCase() + " ";

					System.out.println("Enter the definition of the word you just entered:");
					definition = kb.nextLine();
					definition = " "+definition+".";

					Dictionary.Insert(word,definition);

					break;

				case 3:

					System.out.println("Enter a word to remove:");
					word = kb.nextLine();
					Dictionary.Lookup(word);

					if (Dictionary.doesExist(word)) {
						System.out.println("Enter the number of the definition you want removed:");
						try {
							definition = Dictionary.IndexDefinition(word,Integer.parseInt(kb.nextLine()));
							Dictionary.Remove(word,definition);
							System.out.println("Successfully removed ("+word+","+definition+") ! ");
						} catch(NumberFormatException e) {
							System.out.println("Incorrect input! Try again.");
						}
					}

					break;

				case 4:

					System.out.println("Enter a word to edit:");
					word = kb.nextLine();
					Dictionary.Lookup(word);

					if (Dictionary.doesExist(word)) {
						System.out.println("Enter the number of the definition you want edited:");
						try {
							definition = Dictionary.IndexDefinition(word,Integer.parseInt(kb.nextLine()));
							System.out.println("Enter a new definition in place of the one you selected:");
							newDef = kb.nextLine();
							newDef = " "+newDef+".";
							Dictionary.Edit(word,definition,newDef);
							System.out.println("Successfully changed: "+"("+definition+")"+" -> "+"("+newDef+")");
						} catch(NumberFormatException e) {
							System.out.println("Incorrect input! Try again.");
						}
					}

					break;

			}

		} while(choice != 0);

	}
}
