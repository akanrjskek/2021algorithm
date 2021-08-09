package exercise;

public class TrieTest {
	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.insert("hello1");
		trie.insert("hello");
		System.out.println(trie.contains("hello1"));
		trie.delete("hello1");
		System.out.println(trie.contains("hello"));
		
	}
}
