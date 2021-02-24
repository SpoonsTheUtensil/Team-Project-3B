package morseCodeEncoder;

public class Encoder {
	
	public static String encode(String inputToEncode, TreeNode root) {
		TreeNode current = root;
		String tempStr = "";
		String result = "";
		Character currLetter;
		
		for (int i = 0; i < inputToEncode.length(); i++) {
			currLetter = inputToEncode.charAt(i);
			result += treeContains(current, currLetter, tempStr);
		}
		return result;
	}
	
	/*public static String treeContains(TreeNode root, Character letter, String tempStr) {
		if (root.data == letter) {
			return tempStr + " ";
		} else {
			if (root.left != null) {
				System.out.println("data: " + root.data);
				return treeContains(root.left, letter, tempStr + ".");
			}
			if (root.right != null) {
				System.out.println("data: " + root.data);
				return treeContains(root.right, letter, tempStr + "-");
			}
			return tempStr;
		}
	}	*/
	public static String treeContains(TreeNode root, Character target, String result) {
		System.out.println(result);
		
		if (root.left != null) {
			System.out.println(root.data);
			System.out.println(root.left.data);
			System.out.println(root.right.data);
			result += ".";
			return treeContains(root.left, target, result);
			}
		if (root.data == target) {
			return result + " ";
		}
		if (root.right != null) {
			System.out.println(root.data);
			System.out.println(root.left.data);
			System.out.println(root.right.data);
			result += "-";
			return treeContains(root.right, target, result);
			}
		return result;
	}
}
