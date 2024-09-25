class Solution {
    class TrieNode {
        TrieNode[] children; 
        int count; 
        
        TrieNode() {
            children = new TrieNode[26];  
            count = 0;
        }
    }

    class Trie {
        TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a'; 
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.count++;  
            }
        }
        int getPrefixScore(String word) {
            TrieNode node = root;
            int score = 0;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    break;  
                }
                node = node.children[index];
                score += node.count;  
            }
            return score;
        }
    }
    public int[] sumPrefixScores(String[] words) {
         Trie trie = new Trie();
        
        // Insert all words into the trie
        for (String word : words) {
            trie.insert(word);
        }
      
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = trie.getPrefixScore(words[i]);
        }
        
        return result;
    }
}