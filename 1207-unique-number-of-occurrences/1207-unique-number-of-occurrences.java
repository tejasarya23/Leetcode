class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num : arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        Set<Integer> st = new HashSet<>();
        for(var freq: mp.values()){
            if(st.contains(freq)){
                return false;
            }else{
                st.add(freq);
            }
        }
        return true;
    }
}