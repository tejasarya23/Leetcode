class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len=s.length();int res[]=new int[queries.length];
        int ps[]=new int[len];int sum=0;
        int ml[]=new int[len];
        int mr[]=new int[len];
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='*')sum++;
            ps[i]=sum;
        }
        int l=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='|'){
                l=i;
            }
            ml[i]=l;
        }
        int r=0;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)=='|'){
                r=i;
            }
            mr[i]=r;
        }
        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==queries[i][1]){
                res[i]=0;continue;
            }
            int lp=mr[queries[i][0]];
            int rp=ml[queries[i][1]];
            res[i]=Math.max(0,ps[rp]-ps[lp]);
        }
        System.out.print(Arrays.toString(mr));
        return res;
    }
}