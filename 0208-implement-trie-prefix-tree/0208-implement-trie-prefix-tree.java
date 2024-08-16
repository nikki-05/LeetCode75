class Trie {
      private class TrieNode {
        // Each node has an array of children nodes and a boolean flag to mark the end of a word
        TrieNode[] children;
        boolean isend;

        public TrieNode() {
            // Assuming only lowercase English letters
            children = new TrieNode[26];
            isend = false;
        }
    }

    // Root node of the trie
    private TrieNode root;

    public Trie() {
          root = new TrieNode();
    }
        
    
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isend = true;
        
    }
    
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isend;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;

        
    }
        private TrieNode searchNode(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
        }  

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */