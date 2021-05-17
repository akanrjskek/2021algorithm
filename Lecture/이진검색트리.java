package Lecture;

class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
		}
	}
	Node root;
	public void makeTree(int a[]) {
		root = makeTreeR(a, 0, a.length-1);
	}
	
	public Node makeTreeR(int a[], int start, int end) {
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node newNode = new Node(a[mid]);
		newNode.left = makeTreeR(a, start, mid - 1);
		newNode.right = makeTreeR(a, mid + 1, end);
		return newNode;
	}
	
	public void searchTree(Node node, int find) {
		if(node.data > find) {
<<<<<<< HEAD
			System.out.println(find + " is less than " + node.data);
=======
			System.out.println(find + " is lower than " + node.data);
>>>>>>> a481ff5fdadf7b0722ab2ced9d26052a2cb93e45
			searchTree(node.left, find);
		}
		
		else if(node.data < find) {
			System.out.println(find + " is higher than " + node.data);
			searchTree(node.right, find);
		}
		
		else {
			System.out.println(find + " find!");
		}
	}
}
public class 이진검색트리 {

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		
		Tree tree = new Tree();
		tree.makeTree(a);
<<<<<<< HEAD
		tree.searchTree(tree.root, 4);
=======
		tree.searchTree(tree.root, 2);
>>>>>>> a481ff5fdadf7b0722ab2ced9d26052a2cb93e45
	}

}
