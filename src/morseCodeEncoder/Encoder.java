public class Encoder {
	
	// encode
	public static String encode(String inputToEncode, TreeNode root) {
		TreeNode current = root;
		String tempStr = "";
		String result = "";
		Character currLetter;
		
		// for each character
		for (int i = 0; i < inputToEncode.length(); i++) {
			currLetter = inputToEncode.charAt(i);
			result += treeContains(current, currLetter, tempStr) + " ";
		}
		return result.trim();
	}
	
	// find the target in the tree and return the morse code
	private static String treeContains(TreeNode root, Character target, String result) {
		if(root == null)
			return null;
		
		if(root.data != null && target.equals(root.data))
			return result;
		
		String childResult = treeContains(root.left, target, result + ".");
		if(childResult == null)
			 childResult = treeContains(root.right, target, result + "-");
		
		return childResult;
			
	}
}