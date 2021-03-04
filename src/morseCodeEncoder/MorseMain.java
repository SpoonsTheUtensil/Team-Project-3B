package morseCodeEncoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseMain {

	public static void main(String[] args) throws FileNotFoundException {

		// Creates a file object
		File morseCodeCodex = new File("Morse_Code.txt");
		TreeNode root = buildTree(morseCodeCodex);

		// Read input string
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter input string: ");
		String input = scanner.nextLine();

		// Encode input String
		String encoded = Encoder.encode(input, root);
		System.out.println("Encoded: " + encoded);

		// Decode the encoded string
		System.out.println("Decoded: " + Decoder.decode(encoded, root));

		// Close scanner
		scanner.close();
	}

	// Read from morse code file to build tree
	public static TreeNode buildTree(File codex) throws FileNotFoundException {

		FileInputStream fileToRead = new FileInputStream(codex);
		Scanner fileReader = new Scanner(fileToRead);
		TreeNode root = new TreeNode(null, null, null);

		
		while (fileReader.hasNext()) {
			String token = fileReader.nextLine();
			token = token.substring(0);
			TreeNode current = root;
			
			for (int i = 0; i < token.length(); i++) {
				
				if (token.substring(i, i + 1).equals(".")) {
					if (current.left == null) {
						current.left = new TreeNode(null);
					}
					current = current.left;
				} 
				
				else if (token.substring(i, i + 1).equals("-")) {
					if (current.right == null) {
						current.right = new TreeNode(null);
					}
					current = current.right;
				}
			}
			current.data = token.charAt(0);
		}
		
		// Close file reader
		fileReader.close();
		return root;
	}
}