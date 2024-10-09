class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        long total = 0;
        int target = skill[0] + skill[n - 1];  
        for (int i = 0; i < n / 2; i++) {
            int c = skill[i] + skill[n - 1 - i];
            if (c != target) {
                return -1;  
            }
            total += (long) skill[i] * skill[n - 1 - i];
        }
        
        return total;  
    }
}