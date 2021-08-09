package Trie;

public class TrieTest {

	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.insert("PI");
		trie.insert("PIE");
		trie.insert("POW");
		trie.insert("POP");
		
		System.out.println(trie.contains("PI"));
		System.out.println(trie.contains("PIES"));
		
		trie.delete("PIZ");
		System.out.println(trie.contains("PI"));
		trie.insert("PI");
		System.out.println(trie.contains("PI"));
	}

}
