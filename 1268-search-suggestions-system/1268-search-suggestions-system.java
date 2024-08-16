class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        List<String> suggestions = new ArrayList<>();
    }
    
    private TrieNode root = new TrieNode();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
      Arrays.sort(products);
        
        // Build the Trie
        for (String product : products) {
            insertProduct(product);
        }
        
        // Search for each prefix of the search word
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for (char c : searchWord.toCharArray()) {
            if (node != null) {
                node = node.children.get(c);
            }
            if (node == null) {
                result.add(new ArrayList<>());
            } else {
                result.add(new ArrayList<>(node.suggestions));
            }
        }
        
        return result;
    }
    
    private void insertProduct(String product) {
        TrieNode node = root;
        for (char c : product.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            // Insert the product into the suggestions list
            if (node.suggestions.size() < 3) {
                node.suggestions.add(product);
            }
        }  
    }
}