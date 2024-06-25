class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        
        for (int i = 0; i < n; i++) {
            char party = senate.charAt(i);
            if (party == 'R') radiant.offer(i);
            else dire.offer(i);
        }
        
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();
            
            if (rIndex < dIndex) {
                radiant.offer(rIndex + n); // The next round for this radiant senator
            } else {
                dire.offer(dIndex + n); // The next round for this dire senator
            }
        }
        
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}