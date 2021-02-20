package morseCodeEncoder;

public class Encoder {
	
	public static String encode(String inputToEncode, TreeNode root) {
		TreeNode current = root;
		String tempStr = "";
		String result = "";
		char currLetter;
		
		for (int i = 0; i < inputToEncode.length(); i++) {
			currLetter = inputToEncode.charAt(i);
			result = treeContains(current, currLetter, tempStr);
		}
		return result;
	}
	
	public static String treeContains(TreeNode root, char letter, String tempStr) {
		if (root.data == null) {
			return tempStr;
		} else {
			if (root.left.data != null) {
				return treeContains(root.left, letter, tempStr + ".");
			}
			if (root.right.data != null) {
				return treeContains(root.right, letter, tempStr + "-");
			}
			return tempStr;
		}
	}	
}
