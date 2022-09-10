class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] frequencyArr = new int[128];   
            for(int i = 0;i<s.length();i++){
                frequencyArr[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(frequencyArr);
            // System.out.print(key+" ");
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key,tempList);
        }
        return new LinkedList<>(map.values());
    }
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     List<List<String>> res=new ArrayList<>();
    //     boolean []used = new boolean[strs.length];
    //     for(int i=0;i<strs.length;i++){
    //         List<String> temp =new ArrayList<>();
    //         if(used[i]==false){
    //             for(int j=i;j<strs.length;j++){
    //                 // if(used[j]==false){
    //                     if(isAnagram(strs[i],strs[j])){
    //                         temp.add(strs[j]);
    //                         used[j]=true;
    //                     }
    //                 // }
    //             }
    //         }
    //         if(temp.size()>0)res.add(temp);
    //     }
    //     return res;
    // }
    // public boolean isAnagram(String s, String t) {
    //     int arr[]= new int [26];
    //     for(int i=0;i<s.length();i++){
    //         arr[s.charAt(i)-'a']++;
    //     }
    //     for(int i=0;i<t.length();i++){
    //         arr[t.charAt(i)-'a']--;
    //         // if(arr[t.charAt(i)-'a']<0)return false;
    //     }
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]!=0)return false;
    //     }
    //     // System.out.print(Arrays.toString(arr));
    //     return true;
    // }
}