package morseCodeEncoder

public class Decoder {

	// decode a given string
	public static String decode(String inputToDecode, TreeNode root) {
		String[] words = inputToDecode.trim().split(" ");
		String out = "";
		for (int i = 0; i < words.length; i++) {
			out += find(words[i], root);
		}
		
		return out;
	}
	
	// find the given input to decode
	private static Character find(String inputToDecode, TreeNode root) {
		if(inputToDecode.isEmpty()) // if reached target
			return root.data;
		
		char c = inputToDecode.charAt(0);
		
		if(c == '.') // go to left
			return find(inputToDecode.substring(1), root.left);
		else // go to right
			return find(inputToDecode.substring(1), root.right);
	}

}