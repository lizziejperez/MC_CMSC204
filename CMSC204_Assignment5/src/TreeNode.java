/**
 * Nodes for a Tree
 * @author Elizabeth Perez
 *
 */
public class TreeNode<T> {
	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	/**
	 * Creates a TreeNode
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		leftChild = rightChild = null;
	}
	
	/**
	 * Copies a TreeNode
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		data = node.getData();
		
	}
	
	/**
	 * Returns the TreeNode's data
	 * @return data
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Returns the TreeNode's right child
	 * @return rightChild
	 */
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	/**
	 * Returns the TreeNode's left child
	 * @return leftChild
	 */
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
}
