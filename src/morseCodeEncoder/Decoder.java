package morseCodeEncoder;

public class Decoder {

	// Decode a given string from encoder
	public static String decode(String inputToDecode, TreeNode root) {
		String[] words = inputToDecode.trim().split(" ");
		String out = "";
		
		for (int i = 0; i < words.length; i++) {
			out += find(words[i], root);
		}
		
		return out;
	}
	
	// Find the given input to decode
	private static Character find(String inputToDecode, TreeNode root) {
		
		// Base case
		if(inputToDecode.isEmpty()) // if reached target
			return root.data;
		
		char c = inputToDecode.charAt(0);
		
		// Go left
		if(c == '.') 
			return find(inputToDecode.substring(1), root.left);
		
		// Go right
		else 
			return find(inputToDecode.substring(1), root.right);
	}

}