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
		root = makeTreeR(a, 0, a.length - 1);
	}
	
	public Node makeTreeR(int a[], int start, int end) {
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node newnode = new Node(a[mid]);
		newnode.left = makeTreeR(a, start, mid - 1);
		newnode.right = makeTreeR(a, mid + 1, end);
		return newnode;
	}
	
	public void searchTree(Node node, int value) {
		if(node.data > value) {
			System.out.println(value + " is less than " + node.data);
			searchTree(node.left, value);
		}
		else if(node.data < value) {
			System.out.println(value + " is bigger than " + node.data);
			searchTree(node.right, value);
		}
		else {
			System.out.println("data find!");
		}
	
	}
}
public class 이진검색트리 {

	public static void main(String[] args) {
		int a[] = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = (i+1) * 2;
		}
		Tree tree = new Tree();
		tree.makeTree(a);
		tree.searchTree(tree.root, a[2]);
	}

}
