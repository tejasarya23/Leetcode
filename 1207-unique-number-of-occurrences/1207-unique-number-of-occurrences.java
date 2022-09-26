class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int num : arr) {
            count[num + 1000]++;
        }
        for (int i = 0; i < count.length; i++) {
            int num = count[i];
            while (num > 0 && num != count[num]) {
                count[i] = count[num];
                count[num] = num;
                num = count[i];
            }
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}

// class Solution {
//     public boolean uniqueOccurrences(int[] arr) {
//         Map<Integer,Integer> mp = new HashMap<>();
//         for(int num : arr){
//             mp.put(num,mp.getOrDefault(num,0)+1);
//         }
//         Set<Integer> st = new HashSet<>();
//         for(var freq: mp.values()){
//             if(st.contains(freq)){
//                 return false;
//             }else{
//                 st.add(freq);
//             }
//         }
//         return true;
//     }
// }