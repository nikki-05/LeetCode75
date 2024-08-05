class Solution {
     private Map<String, Map<String, Double>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
         build(equations, values);
        
        // Evaluate each query
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String num = query.get(0);
            String den = query.get(1);
            results[i] = evaluateQuery(num, den);
        }
        
        return results;
    }
    
    private void build(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];
            
            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            graph.get(A).put(B, value);
            graph.get(B).put(A, 1.0 / value);
        }
    }
    
    private double evaluateQuery(String num, String den) {
        if (!graph.containsKey(num) || !graph.containsKey(den)) {
            return -1.0;
        }
        if (num.equals(den)) {
            return 1.0;
        }
        Set<String> visited = new HashSet<>();
        return dfs(num, den, 1.0, visited);
    }
    
    private double dfs(String current, String target, double product, Set<String> visited) {
        visited.add(current);
        
        Map<String, Double> neighbors = graph.get(current);
        if (neighbors.containsKey(target)) {
            return product * neighbors.get(target);
        }
        
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), target, product * neighbor.getValue(), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        
        return -1.0;
    }
}