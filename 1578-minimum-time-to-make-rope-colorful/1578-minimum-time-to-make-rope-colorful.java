class Solution {
    public int minCost(String colors, int[] A) {
        int len=A.length;int i=0;int res=0;
        while(i<len-1){
            int sum=0;int max=0;boolean rep=false;
            while(i<len-1&&colors.charAt(i)==colors.charAt(i+1)){
                // System.out.print(i);
                sum+=A[i];
                // System.out.print(sum+" ");
                max=Math.max(max,A[i]);i++;
                rep=true;
            }
            
            if(rep){sum+=A[i]; max=Math.max(max,A[i]);}
            // System.out.print(sum+" ");
            res=res+(sum-max);i++;
        }
        return res;
    }
}