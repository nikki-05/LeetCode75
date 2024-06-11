class Solution {
    public boolean uniqueOccurrences(int[] arr) {
         Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Check if the count of occurrences is unique
        Set<Integer> occurrenceSet = new HashSet<>(countMap.values());
        return occurrenceSet.size() == countMap.size();
        
    }
}