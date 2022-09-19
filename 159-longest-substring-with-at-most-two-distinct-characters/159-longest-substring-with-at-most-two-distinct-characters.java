class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int k=2;
        Map<Character,Integer> map = new HashMap<>();
        int i=0;int len=s.length();
        int j=0;int max=0;
        while(j<len){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            
            while(map.size()>k){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                if(map.get(s.charAt(i))==0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            // System.out.print(map+" i= "+i+" j= "+j+" || ");
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}