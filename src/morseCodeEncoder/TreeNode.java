package morseCodeEncoder;

public class TreeNode {
	
	// Data fields
	public String data;
    public TreeNode left;
	public TreeNode right;
    
    // Constructors
    public TreeNode(String value) { data = value; }
    public TreeNode(String value, TreeNode leftChild, TreeNode rightChild) {
        data = value;
        left = leftChild;
        right = rightChild;
    }
}
