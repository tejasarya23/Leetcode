class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> cur = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= N; ++i) {
            List<Integer> cur2 = new ArrayList<>();
            for (int x : cur) {
                int y = x % 10;
                if (y + K < 10)
                    cur2.add(x * 10 + y + K);
                if (K > 0 && y - K >= 0)
                    cur2.add(x * 10 + y - K);
            }
            cur = cur2;
        }
        return cur.stream().mapToInt(j->j).toArray();
    }
    // public int[] numsSameConsecDiff(int n, int k) {
    //     List<Integer> list = new ArrayList<>();
    //     int start=1;int index=0;
    //     int end=9-k;boolean swit=true;
    //     // System.out.print(end);
    //     for(int i = start ;i<=end;i++){
    //         String str="";swit=true;int cur=i;
    //         for(int j=0;j<n;j++){
    //             str+=cur;
    //             if(swit){cur+=k;swit=false;}
    //             else {cur-=k;swit=true;}
    //         }
    //         // System.out.print(str+" ");
    //         list.add(Integer.parseInt(str));
    //     }
    //     if(k!=0){
    //         for(int i = k ;i<=9;i++){
    //             String str="";swit=false;int cur=i;
    //             for(int j=0;j<n;j++){
    //                 str+=cur;
    //                 if(swit){cur+=k;swit=false;}
    //                 else {cur-=k;swit=true;}
    //             }
    //             // System.out.print(str+" ");
    //             list.add(Integer.parseInt(str));
    //         }
    //     }
    //     int[] array = new int[list.size()];
    //     for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
    //     return array;
    // }
}