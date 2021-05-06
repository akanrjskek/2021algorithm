package Lecture;

class Tree{
	public class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	Node root;
	public void makeTree(int a[]) {
		root = makeBTreeR(a,0,a.length-1);
	}
	
	public Node makeBTreeR(int a[], int start, int end) {
		if(start > end) return null;
		
		int mid = (start + end) / 2;
		Node node = new Node(a[mid]);
		node.left = makeBTreeR(a, start, mid - 1);
		node.right = makeBTreeR(a, mid + 1, end);
		return node;
	}
	
	public void searchBTree(Node node, int find) {
		if(node.data > find) {
			System.out.println("Data is smaller than " + node.data);
			searchBTree(node.left,find);
		}
		else if(node.data < find) {
			System.out.println("Data is bigger than " + node.data);
			searchBTree(node.right,find);
		}
		else {
			System.out.println("Find Data!");
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
		tree.searchBTree(tree.root,4);
	}

}
