package BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Tree {
	public static StringBuilder sb = new StringBuilder();

	class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	Node root;

	public void makeTree(int[] a) {
		root = makeTreeR(a, 0, a.length - 1);
	}

	public Node makeTreeR(int[] a, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node newNode = new Node(a[mid]);
		newNode.left = makeTreeR(a, start, mid - 1);
		newNode.right = makeTreeR(a, mid + 1, end);
		return newNode;
	}

	public void searchTree(Node node, int find) {
		if (node.data == find) {
			sb.append(1 + " ");
		} else if (node.data < find) {
			if (node.left == null) {
				sb.append(0 + " ");
			} else {
				searchTree(node.right, find);
			}
		} else {
			if (node.right == null) {
				sb.append(0 + " ");
			} else {
				searchTree(node.left, find);
			}
		}
	}
}

public class 숫자카드 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[] nCard = new int[N];
		for (int i = 0; i < nCard.length; ++i) {
			nCard[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nCard);
		st = new StringTokenizer(bf.readLine());

		Tree tree = new Tree();
		tree.makeTree(nCard);
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		System.out.println(M);
		for (int i = 0; i < M; ++i) {
			int input = Integer.parseInt(st.nextToken());
			tree.searchTree(tree.root, input);
		}

		System.out.println(Tree.sb);

	}

}