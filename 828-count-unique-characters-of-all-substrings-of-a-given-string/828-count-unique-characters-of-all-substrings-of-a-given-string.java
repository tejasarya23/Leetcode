class Solution {
     public int uniqueLetterString(String s) {
        
        int sum = 0, curr = 0, n = s.length();
        
        int[] last = new int[26];
        int[] prev = new int[26];
        
        Arrays.fill(last,-1);
        Arrays.fill(prev,-1);
        
        char[] chars = s.toCharArray();
        for(int i=0;i<n;i++) {
            char c = chars[i];
            // curr = curr + q - r + 1 , where
            // q = i - lastIndex - 1
            // r  = lastIndex - previndex
            curr += (i - last[c-65] - 1) - (last[c-65] - prev[c-65]) + 1;
            prev[c-65] = last[c-65];
            last[c-65] = i;
            sum += curr;
        }
        
        return sum;
    }
}