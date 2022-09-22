class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count = 0;
        for (int t : time) {
            if(t % 60 == 0) {
                count += remainders[0];
            } else {
                count += remainders[60 - t % 60]; // how many previous nums can i match with
            }
            
            remainders[t % 60]++; // add for future nums to use
        }
        
        return count;
        
    }
}