class Solution {
    public int characterReplacement(String s, int k) {
        int len= s.length();
        int start=0;
        int max=0;int maxocrfreq=0;
        int freq[]= new int[26];
        for(int end=0;end<len;end++){
            char c = s.charAt(end);
            freq[c-'A']++;
            maxocrfreq=Math.max(maxocrfreq,freq[c-'A']);
            if(end-start+1-maxocrfreq>k){
                freq[s.charAt(start)-'A']--;
                start++;
            }
            else max=Math.max(max,end-start+1);
        }
        return max;
    }
}