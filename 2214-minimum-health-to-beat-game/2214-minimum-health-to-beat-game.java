class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int len=damage.length;
        long sum=0;int max=0;
        for(int i=0;i<len;i++){
            sum+=damage[i];
            max=Math.max(max,damage[i]);
        }
        long res=0;
        if(max>=armor){
            res=sum-armor;
        }else{
            res=sum-max;
        }
        return res+1;
    }
}