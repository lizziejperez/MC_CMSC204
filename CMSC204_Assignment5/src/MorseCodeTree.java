import java.util.ArrayList;

/**
 * Morse Code Translation Tree
 * @author Elizabeth Perez
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	TreeNode<String> root;
	
	/**
	 * Creates a MorseCodeTree
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * Returns the MorseCodeTree's root
	 */
	public TreeNode<String> getRoot() {
		return root;
	}
	
	/**
	 * Sets the root to a given node
	 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	/**
	 * Inserts a TreeNode
	 */
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}
	
	/**
	 * Adds a node to the tree
	 */
	public void addNode(TreeNode<String> rootNode, String code, String letter) {
		TreeNode<String> node = rootNode;
		
		for(int i = 0; i < code.length(); i++) {
			if(code.charAt(i) == '.') {
				node = node.getLeftChild();
			}
			
			if(code.charAt(i) == '-') {
				node = node.getRightChild();
			}
		}
		
		node = new TreeNode<String>(letter);
	}
	
	/**
	 * Gets the letter given the code
	 */
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	
	/**
	 * Gets the data of the node corresponding to the code
	 */
	public String fetchNode(TreeNode<String> rootNode, String code) {
		TreeNode<String> node = rootNode;
		
		for(int i = 0; i < code.length(); i++) {
			if(code.charAt(i) == '.') {
				node = node.getLeftChild();
			}
			
			if(code.charAt(i) == '-') {
				node = node.getRightChild();
			}
		}
		
		return node.getData();
	}
	
	/**
	 * Throws an UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> delete(String data) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Throws an UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> update() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Builds the Morse code tree
	 */
	public void buildTree() {
		root = new TreeNode<String>(" ");
		
		
		insert(".","e");
		insert("-","t");
		
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-.-.","c");
		insert("-..-","x");
		insert("-.--","y");
		insert("--.-","q");
		insert("--..","z");
	}
	
	/**
	 * Returns an ArrayList of the items in the tree in inorder traversal
	 */
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		return list;
	}
	
	/**
	 * Recursive method to put the contents of the tree in an ArrayList in LNR
	 */
	public void LNRoutputTraversal(TreeNode<String> rootNode, ArrayList<String> list) {
		if(rootNode.getLeftChild() != null) {
			LNRoutputTraversal(rootNode.getLeftChild(), list);
		}
		
		list.add(rootNode.getData());
		
		if(rootNode.getRightChild() != null) {
			LNRoutputTraversal(rootNode.getRightChild(), list);
		}
	}
	
}
