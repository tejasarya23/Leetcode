class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> mp = new HashMap<>();
        long count=0;
        for(int i=0;i<time.length;i++){
            mp.put(time[i]%60,mp.getOrDefault(time[i]%60,0)+1);
        }
        // System.out.print(mp);
        for(var key : mp.keySet()){
            if(key<30&&mp.containsKey(60-key)){
                count+=mp.get(key)*mp.get(60-key);
            }else if(key==30||key==0){
                int num=mp.get(key);
                if(num%2==0){
                    count+=(num/2)*(num-1);
                }else{
                    count+=(num)*(num-1)/2;
                }
            }
        }
        return (int)count;
    }
}