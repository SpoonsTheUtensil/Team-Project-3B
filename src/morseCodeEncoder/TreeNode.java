package morseCodeEncoder;

public class TreeNode {
	
	// Data fields
	public Character data;
    public TreeNode left;
	public TreeNode right;
    
    // Constructors
    public TreeNode(Character value) { data = value; }
    public TreeNode(Character value, TreeNode leftChild, TreeNode rightChild) {
        data = value;
        left = leftChild;
        right = rightChild;
    }
}
