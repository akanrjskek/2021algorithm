package exercise;
import java.util.*;

public class Trie {
	private TrieNode rootNode;
	
	Trie(){
		rootNode = new TrieNode();
	}
	
	void insert(String word) {
		TrieNode thisNode = this.rootNode;
		for(int i = 0; i < word.length(); ++i) {
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i),c -> new TrieNode() );			
		}
		thisNode.setIsLastChar(true);
	}
	
	boolean contains(String word) {
		TrieNode thisNode = this.rootNode;
		for(int i = 0; i < word.length(); ++i) {
			TrieNode node = thisNode.getChildNodes().get(word.charAt(i));
			if(node == null) return false;
			
			thisNode = node;
		}
		
		return thisNode.getIsLastChar();
	}

	void delete(String word) {
		delete(this.rootNode, word, 0);
	}
	
	private void delete(TrieNode node, String word, int index) {
		char c = word.charAt(index);
		
		if(!node.getChildNodes().containsKey(c)) {
			throw new Error("존재하지 않는 단어입니다.");
		}
		
		TrieNode childNode = node.getChildNodes().get(c);
		index++;
		
		if(index == word.length()) {
			if(!childNode.getIsLastChar()) {
				throw new Error("존재하지 않는 단어입니다.");
			}
			
			childNode.setIsLastChar(false);
			if(childNode.getChildNodes().isEmpty()) {
				node.getChildNodes().remove(c);
			}
		}
		else {
			delete(childNode, word, index);
			
			if(!childNode.getIsLastChar() && childNode.getChildNodes().isEmpty()) {
				node.getChildNodes().remove(c);
			}
		}
	}
	
	
	
}


