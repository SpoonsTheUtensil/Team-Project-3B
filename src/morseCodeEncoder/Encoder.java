package morseCodeEncoder;

public class Encoder {
	
	public static String encode(String toEncode, TreeNode root) {
		TreeNode current = root;
		String str = "";
		String result = "";
		char currLetter;
		
		for (int i = 0; i < toEncode.length(); i++) {
			currLetter = toEncode.charAt(i);
			result = treeContains(current, currLetter, str);
		}
		return result.toString();
		
	}
	
	public static String treeContains(TreeNode root, char letter, String str) {
		if (root.data == null) {
			return str;
		} else {
			if (root.left.data != null) {
				return treeContains(root.left, letter, str);
			}
			if (root.right.data != null) {
				return treeContains(root.right, letter, str);
			}
			return str;
		}
	}	
}
