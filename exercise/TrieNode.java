package exercise;
import java.util.*;

public class TrieNode {
	private Map<Character, TrieNode> childNodes = new HashMap<>();
	private boolean isLastChar;
	
	Map<Character, TrieNode> getChildNodes() {
		return this.childNodes;
	}
	
	boolean getIsLastChar() {
		return this.isLastChar;
	}
	
	void setIsLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
	}
}


