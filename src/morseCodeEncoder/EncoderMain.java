package morseCodeEncoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EncoderMain {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Creates a file object
		File morseCodeCodex = new File("Morse_Code.txt");
		//BuildTree(morseCodeCodex);
		TreeNode root = BuildTree(morseCodeCodex);
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("What is the string you would like to encode?");
		String inputToParse = userInput.next();
		System.out.println(Encoder.encode(inputToParse, root));
		userInput.close();
		
		//testTreeOrder(root);
	}
	public static void testTreeOrder(TreeNode current) {      
        if (current != null) {
            testTreeOrder(current.left);
            System.out.print(current.data + " ");  
            testTreeOrder(current.right);
        }
	}
	
	public static TreeNode BuildTree(File codex) throws FileNotFoundException{
		
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
		fileReader.close();
		return root;
	}
}
