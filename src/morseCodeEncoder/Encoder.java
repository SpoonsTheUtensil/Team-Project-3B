package morseCodeEncoder;

public class Encoder {
	
	//Encode String
	public static String encode(String inputToEncode, TreeNode root) {
		TreeNode current = root;
		String tempStr = "";
		String result = "";
		Character currLetter;
		
		// For each character in String call treeContains to encode to morse code
		for (int i = 0; i < inputToEncode.length(); i++) {
			currLetter = inputToEncode.charAt(i);
			result += treeContains(current, currLetter, tempStr) + " ";
		}
		return result.trim();
	}
	
	// Find the target in the tree and return the morse code
	private static String treeContains(TreeNode root, Character target, String result) {
		
		// Base case
		if(root == null)
			return null;
		
		// Base case
		if(root.data != null && target.equals(root.data))
			return result;
	
		// Go left
		String childResult = treeContains(root.left, target, result + ".");
		
		// Go right
		if(childResult == null)
			 childResult = treeContains(root.right, target, result + "-");
		
		return childResult;
			
	}
}