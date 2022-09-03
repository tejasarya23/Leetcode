class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        
        List<Character>[] bucket = new List[s.length() + 1];
        
        for (char key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            
            bucket[count].add(key);
        }
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = s.length(); i > 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        builder.append(c);
                    }
                }
            }
        }
        
        return builder.toString();
    }
}
// class Solution {
//     public String frequencySort(String s) {
//         HashMap<Character,Integer> mp = new HashMap<>();
//         for(int i=0;i<s.length();i++){
//             mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
//         }
//         // System.out.print(mp);
//         TreeMap<Integer , ArrayList<Character>> tree = new TreeMap<>(Collections.reverseOrder());
        
//         for(var key : mp.keySet()){
//             ArrayList<Character> temp = tree.get(mp.get(key));
//             if(temp==null){
//                 temp = new ArrayList<Character>();
//                 temp.add(key);
//                 tree.put(mp.get(key),temp);
//             }else{
//                 temp.add(key);
//             }
//         }
//         String ans = "";
//         for(int i:tree.keySet()){
//             for(int j=0 ; j<tree.get(i).size() ; j++){
//                 char ch = tree.get(i).get(j);
//                 for(int k=0 ; k<i ; k++){
//                     ans=ans+ch;
//                 }
//             }
//         }
//         return ans;
//     }
// }