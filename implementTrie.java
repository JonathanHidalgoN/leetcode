import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Trie {

  private class TrieNode {
    public Map<Character, TrieNode> node;

    public TrieNode() {
      node = new HashMap<>();
    }
  }

  private Set<String> wordsSet;

  private TrieNode node;

  public Trie() {
    wordsSet = new HashSet<>();
    node = new TrieNode();
  }

  public void insert(String word) {

    if (word == null || word.equals("")) {
      return;
    }

    wordsSet.add(word);
    TrieNode currentNode = node;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (!currentNode.node.containsKey(currentChar)) {
        TrieNode nextNewNode = new TrieNode();
        currentNode.node.put(currentChar, nextNewNode);
      }
      currentNode = currentNode.node.get(currentChar);
    }
  }

  public boolean search(String word) {

    if (word == null || word.equals("")) {
      return false;
    }

    return wordsSet.contains(word);
  }

  public boolean startsWith(String prefix) {

    if (prefix == null || prefix.equals("")) {
      return false;
    }

    TrieNode currentNode = node;

    for (int i = 0; i < prefix.length(); i++) {
      char currentChar = prefix.charAt(i);
      boolean isLast = i == prefix.length() - 1;
      if (currentNode.node.containsKey(currentChar)) {
        if (isLast) {
          return true;
        } else {
          currentNode = currentNode.node.get(currentChar);
        }
      } else {
        return false;
      }
    }
    return false;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
